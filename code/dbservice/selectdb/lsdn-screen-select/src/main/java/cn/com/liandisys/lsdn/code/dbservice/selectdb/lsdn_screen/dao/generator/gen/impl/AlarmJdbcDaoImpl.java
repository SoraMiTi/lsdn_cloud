package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen.AlarmJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 机组告警数据表
 * @author b_fangzheng
 *
 */
@Repository("alarmJdbcDao")
public class AlarmJdbcDaoImpl extends JdbcUtil implements AlarmJdbcDao {

    /**
     * 根据时间查询和电厂【超标小时数】 时间段类型下所有机组各指标超标小时数，电厂为空时查询全网数据
     * 
     * @param plantId 电厂编号
     * @param startTime 统计超标开始时间
     * @param endTime 统计超标结束时间
     * @return
     */
    public List<Map<String, Object>> getOverStandard(String plantId, Date startTime, Date endTime) {
        List<Object> param = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(" WITH BASE AS ( ");
        sql.append("   SELECT ");
        sql.append("     ID, GEN_ID, TYPE, START_TIME, ");
        sql.append("     NVL(END_TIME, SYSTIMESTAMP) END_TIME, ");
        sql.append("     DURATION ");
        sql.append("   FROM G_REAL_GEN_ALARM ), ");
        sql.append(" OUTSIDE AS ( ");
        sql.append("   SELECT ");
        sql.append("     TYPE, ");
        sql.append("     GEN_ID, ");
        sql.append("     NVL(ROUND(SUM(DURATION/60),2),0) AS DURATION_VAL ");
        sql.append("   FROM BASE ");
        sql.append("   WHERE 1=1 ");
        sql.append("    AND START_TIME >= ? "); // START_TIME
        param.add(startTime);
        sql.append("    AND END_TIME <= ? ");   // END_TIME
        param.add(endTime);
        sql.append("   GROUP BY TYPE, GEN_ID ");
        sql.append(" ), ");
        sql.append(" LFT AS ( ");
        sql.append("   SELECT ");
        sql.append("   TYPE, ");
        sql.append("     GEN_ID, ");
        sql.append("     SUM(((END_TIME + 0) - (?+0)) * 24) DURATION_VAL "); // START_TIME 
        param.add(startTime);
        sql.append("   FROM BASE ");
        sql.append("   WHERE 1=1 ");
        sql.append("     AND START_TIME <= ? "); // START_TIME 
        param.add(startTime);
        sql.append("     AND END_TIME >= ? ");   // START_TIME 
        param.add(startTime);
        sql.append("     AND END_TIME <= ? ");   // END_TIME 
        param.add(endTime);
        sql.append("   GROUP BY TYPE, GEN_ID ");
        sql.append(" ), ");
        sql.append(" RGHT AS ( ");
        sql.append("   SELECT ");
        sql.append("   TYPE, ");
        sql.append("     GEN_ID, ");
        sql.append("     SUM(((?+0) - (START_TIME + 0)) * 24) DURATION_VAL "); // END_TIME   +0用于转date
        param.add(endTime);
        sql.append("   FROM BASE ");
        sql.append("   WHERE 1=1 ");
        sql.append("     AND START_TIME >= ? ");    // START_TIME
        param.add(startTime);
        sql.append("     AND START_TIME <= ? ");  // END_TIME
        param.add(endTime);
        sql.append("     AND END_TIME >= ? ");    // END_TIME
        param.add(endTime);
        sql.append("   GROUP BY TYPE, GEN_ID ");
        sql.append(" ), ");
        sql.append(" INSIDE AS ( ");
        sql.append("   SELECT ");
        sql.append("     TYPE, ");
        sql.append("     GEN_ID, ");
        sql.append("     SUM(((?+0) - (?+0)) * 24) DURATION_VAL ");  // END_TIME - START_TIME 
        param.add(endTime);
        param.add(startTime);
        sql.append("   FROM BASE ");
        sql.append("   WHERE 1=1 ");
        sql.append("     AND START_TIME <= ? ");  // START_TIME 
        param.add(startTime);
        sql.append("     AND END_TIME >= ? ");  //  END_TIME
        param.add(endTime);
        sql.append("   GROUP BY TYPE, GEN_ID ");
        sql.append(" ), ");
        sql.append(" TOTAL AS ( ");
        sql.append("   SELECT ");
        sql.append("     TYPE, GEN_ID, DURATION_VAL ");
        sql.append("   FROM OUTSIDE ");
        sql.append("   UNION ALL ");
        sql.append("   SELECT ");
        sql.append("     TYPE, GEN_ID, DURATION_VAL ");
        sql.append("   FROM INSIDE ");
        sql.append("   UNION ALL ");
        sql.append("   SELECT ");
        sql.append("     TYPE, GEN_ID, DURATION_VAL ");
        sql.append("   FROM LFT ");
        sql.append("   UNION ALL ");
        sql.append("   SELECT ");
        sql.append("     TYPE, GEN_ID, DURATION_VAL ");
        sql.append("   FROM RGHT), ");
        sql.append(" STA AS ( ");
        sql.append("   SELECT ");
        sql.append("     TYPE, ");
        sql.append("     GEN_ID, ");
        sql.append("     ROUND(NVL(SUM(DURATION_VAL),0),2) DURATION_VAL ");
        sql.append("   FROM TOTAL ");
        sql.append("   GROUP BY TYPE, GEN_ID), ");
        sql.append(" LINE AS ( ");
        sql.append("   SELECT ");
        sql.append("     STA.TYPE, ");
        sql.append("     STA.GEN_ID GEN_ID, ");
        sql.append("     GEN.NAME GEN_NAME, ");
        sql.append("     PLANT.ID PLANT_ID, ");
        sql.append("     PLANT.SHORT_NAME PLANT_NAME, ");
        sql.append("     ROUND(NVL(STA.DURATION_VAL,0),2) DURATION_VAL ");
        sql.append("   FROM G_BASE_GENERATOR GEN ");
        sql.append("   LEFT JOIN G_BASE_PLANT PLANT ");
        sql.append("     ON GEN.PLANT_ID = PLANT.ID ");
        sql.append("   JOIN STA ON GEN.ID = STA.GEN_ID ");
        sql.append("   WHERE 1=1 ");
        if(StringUtil.isNotNullOrBlank(plantId)) {
            sql.append("     AND PLANT_ID = ? ");
            param.add(plantId);
        }
        sql.append(" ) ");
        sql.append(" SELECT * ");
        sql.append(" FROM LINE ");
        sql.append(" PIVOT (MAX(DURATION_VAL) FOR TYPE IN ('1' AS SO2, '2' AS NOX, '3' AS PM, '4' AS COAL)) ");
        sql.append(" WHERE GEN_ID IS NOT NULL AND PLANT_NAME IS NOT NULL ");
        sql.append(" ORDER BY PLANT_NAME DESC, GEN_NAME ASC ");
        
        return jdbcTemplate.queryForList(sql.toString(), param.toArray());
    }
}
