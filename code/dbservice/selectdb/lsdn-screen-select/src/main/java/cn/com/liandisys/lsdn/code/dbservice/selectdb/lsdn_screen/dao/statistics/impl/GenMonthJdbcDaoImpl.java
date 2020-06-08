package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.GenMonthJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 各机组月统计表
 * @author b_fangzheng
 *
 */
@Repository("genMonthJdbcDao")
public class GenMonthJdbcDaoImpl extends JdbcUtil implements GenMonthJdbcDao {

    /**
     * 从机组月统计表中获取年报列表数据
     * @param plantId
     * @param year
     * @return
     */
    public List<Map<String, Object>> getYearReport(String plantId, String year) {
        List<Object> param = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        
        sql.append(" WITH DATETIME AS ");
        sql.append("   (SELECT ? || '-' || LPAD(LEVEL, 2, 0) DATA_TIME ");
        param.add(year);
        sql.append("   FROM DUAL ");
        sql.append("     CONNECT BY LEVEL < 13 ");
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
        sql.append("     TO_CHAR(T.DATA_TIME, 'yyyy-MM') DATA_TIME ");
        // TODO  为了查询效率，从月表中取数据
        sql.append("   FROM S_GEN_MONTH T ");
        sql.append("   WHERE 1=1 ");
        sql.append("     AND TO_CHAR(T.DATA_TIME, 'yyyy') = ? ");
        param.add(year);
        if(StringUtil.isNotNullOrBlank(plantId)) {
            sql.append("     AND T.PLANT_ID = ? ");
            param.add(plantId);
        }
        sql.append("   GROUP BY TO_CHAR(T.DATA_TIME, 'yyyy-MM') ");
        sql.append(" ), ");
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


    /**
     * 在机组表中统计电厂下各机组该年的平均煤耗
     * @param plantId
     * @param year
     * @return
     */
    public List<Map<String, Object>> getStaGenByYear(String plantId, String year) {
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append(" WITH BASEDATA AS ( ");
        sql.append("   SELECT ");
        sql.append("     ID, ");
        sql.append("     NAME, ");
        sql.append("     PLANT_ID ");
        sql.append("   FROM G_BASE_GENERATOR ");
        sql.append("   WHERE 1=1 ");
        sql.append("     AND TYZT = ? ");
        param.add(Const.COMM_CODE.TYZT_YES);
        if(StringUtil.isNotNullOrBlank(plantId)) {
            sql.append("     AND PLANT_ID = ? ");
            param.add(plantId);
        }
        sql.append(" ), ");
        sql.append(" REALDATA AS ( ");
        sql.append("   SELECT ");
        sql.append("     GEN_ID, ");
        sql.append("     AVG(GDMH) GDMH ");
        sql.append("   FROM S_GEN_MONTH MON ");
        sql.append("   WHERE 1=1 ");
        if(StringUtil.isNotNullOrBlank(year)) {
            sql.append("     AND YEAR = ? ");
            param.add(year);
        }
        if(StringUtil.isNotNullOrBlank(plantId)) {
            sql.append("     AND PLANT_ID = ? ");
            param.add(plantId);
        }
        sql.append("   GROUP BY GEN_ID ");
        sql.append(" ) ");
        sql.append(" SELECT ");
        sql.append("   BASEDATA.NAME, ");
        sql.append("   ROUND(NVL(REALDATA.GDMH,0),2) GDMH ");
        sql.append(" FROM BASEDATA ");
        sql.append(" LEFT JOIN REALDATA ");
        sql.append("   ON BASEDATA.ID = REALDATA.GEN_ID ");
        sql.append(" ORDER BY BASEDATA.PLANT_ID, BASEDATA.NAME ");
        
        return jdbcTemplate.queryForList(sql.toString(), param.toArray());
    }

    /**
     * 统计全网各电厂该年的平均煤耗
     * @param year
     * @return
     */
    public List<Map<String, Object>> getStaPlantByYear(String year) {
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append(" WITH BASEDATA AS ( ");
        sql.append("   SELECT ");
        sql.append("     ID, ");
        sql.append("     SHORT_NAME, ");
        sql.append("     SSJT ");
        sql.append("   FROM G_BASE_PLANT ");
        sql.append("   WHERE 1=1 ");
        sql.append("   AND (TYPE = ? OR TYPE = ?) ");
        param.add(Const.COMM_CODE.DYLX_RM);
        param.add(Const.COMM_CODE.DYLX_RJ);
        sql.append("   AND TYZT = ? ");
        param.add(Const.COMM_CODE.TYZT_YES);
        sql.append(" ), ");
        sql.append(" REALDATA AS ( ");
        sql.append("   SELECT ");
        sql.append("     PLANT_ID, ");
        sql.append("     AVG(GDMH) GDMH ");
        sql.append("   FROM S_GEN_MONTH MON ");
        sql.append("   WHERE 1=1 ");
        sql.append("     AND YEAR = ? ");
        param.add(year);
        sql.append("   GROUP BY PLANT_ID ");
        sql.append(" ) ");
        sql.append(" SELECT ");
        sql.append("   BASEDATA.SHORT_NAME NAME, ");
        sql.append("   ROUND(NVL(REALDATA.GDMH,0),2) GDMH ");
        sql.append(" FROM BASEDATA ");
        sql.append(" LEFT JOIN REALDATA ");
        sql.append("   ON BASEDATA.ID = REALDATA.PLANT_ID ");
        sql.append(" ORDER BY BASEDATA.SSJT, BASEDATA.SHORT_NAME ");
        
        return jdbcTemplate.queryForList(sql.toString(), param.toArray());
    }
    
    /**
     * 根据设备查询【设备该年各月煤耗对比情况】
     * @param year
     * @param plantId
     * @param genId
     * @return
     */
    public List<Map<String, Object>> getStaMonthByYear(String year, String plantId, String genId) {
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append(" WITH DATETIME AS( ");
        sql.append("   SELECT ? || '-' || LPAD(LEVEL, 2, 0) DATA_TIME ");
        param.add(year);
        sql.append("   FROM DUAL CONNECT BY LEVEL < 13 ");
        sql.append(" ), ");
        sql.append(" BASEDATA AS ( ");
        sql.append("   SELECT ");
        sql.append("     TO_CHAR(DATA_TIME,'yyyy-MM') DATA_TIME, ");
        sql.append("     AVG(GDMH) GDMH ");
        sql.append("   FROM S_GEN_MONTH MON ");
        sql.append("   WHERE 1=1 ");
        if(StringUtil.isNotNullOrBlank(plantId)) {
            sql.append("     AND MON.PLANT_ID = ? ");
            param.add(plantId);
        }
        if(StringUtil.isNotNullOrBlank(genId)) {
            sql.append("     AND MON.GEN_ID = ? ");
            param.add(genId);
        }
        sql.append("     AND MON.YEAR = ? ");
        param.add(year);
        sql.append("   GROUP BY TO_CHAR(DATA_TIME,'yyyy-MM') ");
        sql.append(" ) ");
        sql.append(" SELECT ");
        sql.append("   DATETIME.DATA_TIME, ");
        sql.append("   ROUND(NVL(GDMH, 0),2) GDMH ");
        sql.append(" FROM DATETIME ");
        sql.append(" LEFT JOIN BASEDATA ");
        sql.append("   ON BASEDATA.DATA_TIME = DATETIME.DATA_TIME ");
        sql.append(" ORDER BY DATETIME.DATA_TIME ASC ");
        
        return jdbcTemplate.queryForList(sql.toString(), param.toArray());
    }
    
    /**
     * 根据电厂id获取so2，nox，pm，煤耗的排放量
     * @param plantId
     * @return
     */
    public List<Map<String,Object>> getEmissionsByPlantId(String plantId){
    	StringBuffer sql = new StringBuffer();
    	 sql.append("WITH MONTH AS ");
    	 sql.append("(SELECT TO_CHAR(ROWNUM,'FM00') MM ");
    	 sql.append("FROM DUAL CONNECT BY ROWNUM <= 12), ");
    	 sql.append("BASE AS( ");
    	 sql.append(" SELECT ");
    	 sql.append(" SUM(SO2_EMISSIONS) AS SO2_EMISSIONS, ");
    	 sql.append(" SUM(NOX_EMISSIONS) AS NOX_EMISSIONS, ");
    	 sql.append(" SUM(PM_EMISSIONS) AS PM_EMISSIONS, ");
    	 sql.append(" AVG(GDMH) AS GDMH, ");
    	 sql.append(" PLANT_ID,MONTH ");
    	 sql.append(" FROM S_GEN_MONTH WHERE PLANT_ID = ? ");
    	 sql.append(" AND YEAR = '2019' GROUP BY PLANT_ID, MONTH ");
    	 sql.append(") ");
    	 sql.append("SELECT ");
    	 sql.append("NVL(B.SO2_EMISSIONS,0) AS SO2_EMISSIONS, ");
    	 sql.append("NVL(B.NOX_EMISSIONS,0) AS NOX_EMISSIONS, ");
    	 sql.append("NVL(B.PM_EMISSIONS,0) AS PM_EMISSIONS, ");
    	 sql.append("NVL(B.GDMH,0) AS GDMH, ");
    	 sql.append("M.MM AS MONTH ");
    	 sql.append("FROM MONTH M LEFT JOIN BASE B ON M.MM=B.MONTH ");
    	 sql.append("ORDER BY M.MM ");
    	return jdbcTemplate.queryForList(sql.toString(),new Object[]{plantId});
    }
}
