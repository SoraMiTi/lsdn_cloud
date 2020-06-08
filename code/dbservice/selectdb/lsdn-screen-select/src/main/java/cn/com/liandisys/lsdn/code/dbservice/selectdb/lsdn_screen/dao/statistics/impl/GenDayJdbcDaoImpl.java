package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.GenDayJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 各机组日统计表
 * @author b_fangzheng
 *
 */
@Repository("genDayJdbcDao")
public class GenDayJdbcDaoImpl extends JdbcUtil implements GenDayJdbcDao {
    
    /**
     * 从机组日统计表中获取月报列表数据
     * @param plantId
     * @param month
     * @return
     */
    public List<Map<String, Object>> getMonthReport(String plantId, String month) {
        List<Object> param = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        
        sql.append(" WITH DATETIME AS ");
        sql.append("   (SELECT ? || '-' || LPAD(LEVEL, 2, 0) DATA_TIME ");
        param.add(month);
        sql.append("   FROM DUAL ");
        sql.append("     CONNECT BY LEVEL < ((SELECT ");
        sql.append("       TO_NUMBER(SUBSTR(LAST_DAY(TO_DATE(?,'yyyy-MM')),  0, 2)) ");
        param.add(month);
        sql.append("       FROM DUAL) + 1) ");
        sql.append("   ), ");
        sql.append(" BASEDATA AS ");
        sql.append("   (SELECT ROUND((SUM(T.SO2_EMISSIONS)),2) SO2_EMISSIONS, ");
        sql.append("     ROUND((SUM(T.NOX_EMISSIONS)),2) NOX_EMISSIONS, ");
        sql.append("     ROUND((SUM(T.PM_EMISSIONS)),2) PM_EMISSIONS, ");
        sql.append("     ROUND(AVG(T.SO2_EMISSIONS_RATE),2) SO2_EMISSIONS_RATE, ");
        sql.append("     ROUND(AVG(T.NOX_EMISSIONS_RATE),2) NOX_EMISSIONS_RATE, ");
        sql.append("     ROUND(AVG(T.PM_EMISSIONS_RATE),2) PM_EMISSIONS_RATE, ");
        sql.append("     ROUND(AVG(T.SO2_CONVERT_OUT),2) SO2_CONVERT_OUT, ");
        sql.append("     ROUND(AVG(T.NOX_CONVERT_OUT),2) NOX_CONVERT_OUT, ");
        sql.append("     ROUND(AVG(T.PM_CONVERT_OUT),2) PM_CONVERT_OUT, ");
        sql.append("     TO_CHAR(T.DATA_TIME, 'yyyy-MM-dd') DATA_TIME ");
        // TODO  为了查询效率，从日表中取数据
        sql.append("   FROM S_GEN_DAY T ");
        sql.append("   WHERE 1=1 ");
        sql.append("     AND TO_CHAR(T.DATA_TIME, 'yyyy-MM') = ? ");
        param.add(month);
        if(StringUtil.isNotNullOrBlank(plantId)) {
            sql.append("     AND T.PLANT_ID = ? ");
            param.add(plantId);
        }
        sql.append("   GROUP BY TO_CHAR(T.DATA_TIME, 'yyyy-MM-dd') ");
        sql.append("   ), ");
        sql.append(" DATALIST AS ( ");
        sql.append("   SELECT ");
        sql.append("     DATETIME.DATA_TIME DATA_TIME, ");
        sql.append("     NVL(BASEDATA.SO2_EMISSIONS,0) SO2_EMISSIONS, ");
        sql.append("     NVL(BASEDATA.NOX_EMISSIONS,0) NOX_EMISSIONS, ");
        sql.append("     NVL(BASEDATA.PM_EMISSIONS,0) PM_EMISSIONS, ");
        sql.append("     NVL(BASEDATA.SO2_EMISSIONS_RATE,0) SO2_EMISSIONS_RATE, ");
        sql.append("     NVL(BASEDATA.NOX_EMISSIONS_RATE,0) NOX_EMISSIONS_RATE, ");
        sql.append("     NVL(BASEDATA.PM_EMISSIONS_RATE,0) PM_EMISSIONS_RATE, ");
        sql.append("     NVL(BASEDATA.SO2_CONVERT_OUT,0) SO2_CONVERT_OUT, ");
        sql.append("     NVL(BASEDATA.NOX_CONVERT_OUT,0) NOX_CONVERT_OUT, ");
        sql.append("     NVL(BASEDATA.PM_CONVERT_OUT,0) PM_CONVERT_OUT ");
        sql.append("   FROM DATETIME ");
        sql.append("   LEFT JOIN BASEDATA ");
        sql.append("     ON DATETIME.DATA_TIME = BASEDATA.DATA_TIME ");
        sql.append("   ORDER BY DATETIME.DATA_TIME ASC ");
        sql.append(" ) ");
        sql.append(" SELECT ");
        sql.append("   '合计' NAME, ");
        sql.append("   TO_CHAR(SUM(SO2_EMISSIONS)) SO2_EMISSIONS, ");
        sql.append("   TO_CHAR(SUM(NOX_EMISSIONS)) NOX_EMISSIONS, ");
        sql.append("   TO_CHAR(SUM(PM_EMISSIONS)) PM_EMISSIONS, ");
        sql.append("   '-' SO2_EMISSIONS_RATE, ");
        sql.append("   '-' NOX_EMISSIONS_RATE, ");
        sql.append("   '-' PM_EMISSIONS_RATE, ");
        sql.append("   '-' SO2_CONVERT_OUT, ");
        sql.append("   '-' NOX_CONVERT_OUT, ");
        sql.append("   '-' PM_CONVERT_OUT ");
        sql.append(" FROM DATALIST ");
        sql.append(" UNION ALL ");
        sql.append(" SELECT ");
        sql.append("   '最大值' NAME, ");
        sql.append("   TO_CHAR(MAX(SO2_EMISSIONS)) SO2_EMISSIONS, ");
        sql.append("   TO_CHAR(MAX(NOX_EMISSIONS)) NOX_EMISSIONS, ");
        sql.append("   TO_CHAR(MAX(PM_EMISSIONS)) PM_EMISSIONS, ");
        sql.append("   TO_CHAR(MAX(SO2_EMISSIONS_RATE)) SO2_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(MAX(NOX_EMISSIONS_RATE)) NOX_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(MAX(PM_EMISSIONS_RATE)) PM_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(MAX(SO2_CONVERT_OUT)) SO2_CONVERT_OUT, ");
        sql.append("   TO_CHAR(MAX(NOX_CONVERT_OUT)) NOX_CONVERT_OUT, ");
        sql.append("   TO_CHAR(MAX(PM_CONVERT_OUT)) PM_CONVERT_OUT ");
        sql.append(" FROM DATALIST ");
        sql.append(" UNION ALL ");
        sql.append(" SELECT ");
        sql.append("   '最小值' NAME, ");
        sql.append("   TO_CHAR(MIN(SO2_EMISSIONS)) SO2_EMISSIONS, ");
        sql.append("   TO_CHAR(MIN(NOX_EMISSIONS)) NOX_EMISSIONS, ");
        sql.append("   TO_CHAR(MIN(PM_EMISSIONS)) PM_EMISSIONS, ");
        sql.append("   TO_CHAR(MIN(SO2_EMISSIONS_RATE)) SO2_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(MIN(NOX_EMISSIONS_RATE)) NOX_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(MIN(PM_EMISSIONS_RATE)) PM_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(MIN(SO2_CONVERT_OUT)) SO2_CONVERT_OUT, ");
        sql.append("   TO_CHAR(MIN(NOX_CONVERT_OUT)) NOX_CONVERT_OUT, ");
        sql.append("   TO_CHAR(MIN(PM_CONVERT_OUT)) PM_CONVERT_OUT ");
        sql.append(" FROM DATALIST ");
        sql.append(" UNION ALL ");
        sql.append(" SELECT ");
        sql.append("   '平均值' NAME, ");
        sql.append("   TO_CHAR(ROUND(AVG(SO2_EMISSIONS),2)) SO2_EMISSIONS, ");
        sql.append("   TO_CHAR(ROUND(AVG(NOX_EMISSIONS),2)) NOX_EMISSIONS, ");
        sql.append("   TO_CHAR(ROUND(AVG(PM_EMISSIONS),2)) PM_EMISSIONS, ");
        sql.append("   TO_CHAR(ROUND(AVG(SO2_EMISSIONS_RATE),2)) SO2_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(ROUND(AVG(NOX_EMISSIONS_RATE),2)) NOX_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(ROUND(AVG(PM_EMISSIONS_RATE),2)) PM_EMISSIONS_RATE, ");
        sql.append("   TO_CHAR(ROUND(AVG(SO2_CONVERT_OUT),2)) SO2_CONVERT_OUT, ");
        sql.append("   TO_CHAR(ROUND(AVG(NOX_CONVERT_OUT),2)) NOX_CONVERT_OUT, ");
        sql.append("   TO_CHAR(ROUND(AVG(PM_CONVERT_OUT),2)) PM_CONVERT_OUT ");
        sql.append(" FROM DATALIST ");
        sql.append(" UNION ALL ");
        sql.append(" SELECT ");
        sql.append("   DATA_TIME NAME, ");
        sql.append("   DECODE(SO2_EMISSIONS,0,'-',SO2_EMISSIONS) SO2_EMISSIONS, ");
        sql.append("   DECODE(NOX_EMISSIONS,0,'-',NOX_EMISSIONS) NOX_EMISSIONS, ");
        sql.append("   DECODE(PM_EMISSIONS,0,'-',PM_EMISSIONS) PM_EMISSIONS, ");
        sql.append("   DECODE(SO2_EMISSIONS_RATE,0,'-',SO2_EMISSIONS_RATE) SO2_EMISSIONS_RATE, ");
        sql.append("   DECODE(NOX_EMISSIONS_RATE,0,'-',NOX_EMISSIONS_RATE) NOX_EMISSIONS_RATE, ");
        sql.append("   DECODE(PM_EMISSIONS_RATE,0,'-',PM_EMISSIONS_RATE) PM_EMISSIONS_RATE, ");
        sql.append("   DECODE(SO2_CONVERT_OUT,0,'-',SO2_CONVERT_OUT) SO2_CONVERT_OUT, ");
        sql.append("   DECODE(NOX_CONVERT_OUT,0,'-',NOX_CONVERT_OUT) NOX_CONVERT_OUT, ");
        sql.append("   DECODE(PM_CONVERT_OUT,0,'-',PM_CONVERT_OUT) PM_CONVERT_OUT ");
        sql.append(" FROM DATALIST ");

        
        return jdbcTemplate.queryForList(sql.toString(), param.toArray());
    }
}
