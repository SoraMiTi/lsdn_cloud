package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.yctp.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.yctp.YctpJdbcDao;
import cn.com.liandisys.util.util.DateUtil;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 专项考核-一次调频
 * @author b_wuxl
 *
 */
@Repository("yctpJdbcDao")
public class YctpJdbcDaoImpl extends JdbcUtil implements YctpJdbcDao {

    /**
     * 查询一次调频数据
     * @param pageable
     * @param plantId
     * @param genId
     * @param startTime
     * @param endTime
     * @return
     */
    @SuppressWarnings("unchecked")
    public Page<Map<String, Object>> search(Pageable pageable, String plantId, String genId, Timestamp startTime, Timestamp endTime) {
        
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append("    WITH PLANT AS ");
        sql.append("      (SELECT * ");
        sql.append("      FROM G_BASE_PLANT ");
        sql.append("      WHERE TYZT = '"+ Const.COMM_CODE.TYZT_YES+"'  ");
        if(StringUtil.isNotNullOrBlank(plantId)){
            sql.append("      AND ID = ?  ");
            param.add(plantId);
        }
        sql.append("      ),  ");
        sql.append("      GEN AS  ");
        sql.append("      (SELECT * ");
        sql.append("      FROM G_BASE_GENERATOR ");
        sql.append("      WHERE TYZT = '"+Const.COMM_CODE.TYZT_YES+"'  ");
        if(StringUtil.isNotNullOrBlank(genId)){
            sql.append("      AND ID = ?  ");
            param.add(genId);
        }
        sql.append("      ) ");
        sql.append("    SELECT ");
        sql.append("      YCTP.ID, ");
        sql.append("      PLANT.SHORT_NAME PLANT_NAME, ");
        sql.append("      GEN.NAME GEN_NAME, ");
        sql.append("      GEN_ID,  ");
        sql.append("      TO_CHAR(START_TIME,'"+ DateUtil.FORMAT_DATE_TIME_ORACLE+"') START_TIME,  ");
        sql.append("      TO_CHAR(END_TIME,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') END_TIME,  ");
        sql.append("      TO_CHAR(RECOVERY_TIME,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') RECOVERY_TIME,  ");
        sql.append("      QSY, ");
        sql.append("      QJY, ");
        sql.append("      DX,  ");
        sql.append("      PJ,  ");
        sql.append("      HGL, ");
        sql.append("      XYZB15,  ");
        sql.append("      XYZB30,  ");
        sql.append("      XYSC50,  ");
        sql.append("      XYSC75,  ");
        sql.append("      XYSC90 ");
        sql.append("    FROM O_KH_YCTP YCTP ");
        sql.append("    JOIN GEN  ");
        sql.append("    ON GEN.ID = YCTP.GEN_ID  ");
        sql.append("    JOIN PLANT ");
        sql.append("    ON PLANT.ID = GEN.PLANT_ID ");
        sql.append("    WHERE 1 = 1  ");
        if(startTime != null){            
            sql.append("    AND YCTP.START_TIME >= ? ");
            param.add(startTime);
        }
        if(endTime != null){            
            sql.append("    AND YCTP.END_TIME <= ? ");
            param.add(endTime);
        }

        return (Page<Map<String, Object>>) getPaginationDatasSafety(sql.toString(), param.toArray(), pageable);
    }

    /**
     * 查询一次调频台账数据
     * @param pageable
     * @param startTime
     * @param endTime
     * @return
     */
    @SuppressWarnings("unchecked")
    public Page<Map<String, Object>> searchByMonth(Pageable pageable, Timestamp startTime, Timestamp endTime) {

        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append("    WITH PLANTANDGEN AS   ");
        sql.append("      (SELECT GEN.ID GENID,   ");
        sql.append("        PLANT.SHORT_NAME PLANT_NAME,   ");
        sql.append("        GEN.NAME GEN_NAME  ");
        sql.append("      FROM G_BASE_GENERATOR GEN   ");
        sql.append("      JOIN G_BASE_PLANT PLANT   ");
        sql.append("      ON GEN.PLANT_ID = PLANT.ID  ");
        sql.append("      WHERE GEN.TYZT  = '"+Const.COMM_CODE.TYZT_YES+"'   ");
        sql.append("      )   ");
        sql.append("    SELECT  ");
        sql.append("      PLANTANDGEN.PLANT_NAME,  ");
        sql.append("      PLANTANDGEN.GEN_NAME,  ");
        sql.append("      TO_CHAR(START_TIME,'"+DateUtil.FORMAT_DATE_TIME_14+"')            AS DATE_TIME,  ");
        sql.append("      TO_CHAR(START_TIME,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"')      AS YCTP_TIME, ");
        sql.append("      TO_CHAR(MAX(START_TIME),'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') AS START_TIME,  ");
        sql.append("      TO_CHAR(MAX(END_TIME),'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"')   AS END_TIME,  ");
        sql.append("      SUM(  ");
        sql.append("      CASE  ");
        sql.append("        WHEN YCTP.DX>0  ");
        sql.append("        THEN 1  ");
        sql.append("        ELSE 0  ");
        sql.append("      END) AS DX,   ");
        sql.append("      SUM(  ");
        sql.append("      CASE  ");
        sql.append("        WHEN YCTP.DX>0.6  ");
        sql.append("        THEN 1  ");
        sql.append("        ELSE 0  ");
        sql.append("      END) AS HGS   ");
        sql.append("    FROM O_KH_YCTP YCTP   ");
        sql.append("    JOIN PLANTANDGEN  ");
        sql.append("    ON YCTP.GEN_ID = PLANTANDGEN.GENID  ");
        sql.append("    WHERE 1=1   ");
        sql.append("    AND YCTP.DX   IS NOT NULL   ");
        if(startTime != null && endTime != null){            
            sql.append("    AND YCTP.START_TIME BETWEEN ? AND ?  ");
            param.add(startTime);
            param.add(endTime);
        }
        sql.append("    GROUP BY  ");
        sql.append("      PLANTANDGEN.PLANT_NAME,  ");
        sql.append("      PLANTANDGEN.GEN_NAME,  ");
        sql.append("      YCTP.START_TIME   ");
        
        return (Page<Map<String, Object>>) getPaginationDatasSafety(sql.toString(), param.toArray(), pageable);
    }
    
    
    /**
	 * 抓取机组一次调频数据
	 * 
	 * @param plantId
	 * @param genId
	 * @return
	 */
	public List<Map<String, Object>> getGenYctp(String startTime,
			String endTime, String plantId, String genId,String isShow) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" SELECT YCTP.ID      AS YCTP_ID, ");
		sql.append("   PLANT.SHORT_NAME  AS PLANT_NAME, ");
		sql.append("   GEN.NAME          AS GEN_NAME, ");
		sql.append("   PLANT.ID AS PLANT_ID, ");
		sql.append("   GEN.ID AS GEN_ID, ");
		sql.append("   NVL(GEN.RATED_CAPACITY ,0) AS RATED_CAPACITY, ");
		sql.append("   NVL(YCTP.XYZB15 ,0) AS XYZB15 , ");
		sql.append("   NVL(YCTP.XYZB30 ,0) AS XYZB30 , ");
		sql.append("   NVL(YCTP.QSY ,0)    AS SJJF , ");
		sql.append("   NVL(YCTP.QJY ,0)    AS LLJF , ");
		sql.append("   NVL(YCTP.DX,0)      AS DX, ");
		sql.append("   NVL(YCTP.HGL ,0)    AS HGL , ");
		sql.append("   NVL(YCTP.XYSC50 ,0) AS XYSC50 , ");
		sql.append("   NVL(YCTP.XYSC75 ,0) AS XYSC75 , ");
		sql.append("   NVL(YCTP.XYSC90 ,0) AS XYSC90 ");
		sql.append(" FROM O_KH_YCTP YCTP ");
		sql.append(" JOIN G_BASE_GENERATOR GEN ");
		sql.append(" ON YCTP.GEN_ID=GEN.ID ");
		sql.append(" JOIN G_BASE_PLANT PLANT ");
		sql.append(" ON GEN.PLANT_ID = PLANT.ID ");
		sql.append(" WHERE 1=1 ");
		if (StringUtil.isNotNullOrBlank(plantId)) {
			sql.append(" AND PLANT.ID = ? ");
			param.add(plantId);
		}
		if (StringUtil.isNotNullOrBlank(genId)) {
			sql.append(" AND GEN.ID = ? ");
			param.add(genId);
		}
		if(StringUtil.isNotNullOrBlank(isShow)){
			sql.append(" AND YCTP.DEFAULT_SHOW = ? ");
			param.add(isShow);
		}
		if (StringUtil.isNotNullOrBlank(startTime)) {
			sql.append(" AND TO_CHAR(YCTP.START_TIME ,'yyyy-MM') >= ? ");
			param.add(startTime);
		}
		if (StringUtil.isNotNullOrBlank(endTime)) {
			sql.append(" AND TO_CHAR(YCTP.END_TIME ,'yyyy-MM') <= ? ");
			param.add(endTime);
		}
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

}
