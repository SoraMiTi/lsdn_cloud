package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.GenRealJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 各机组实时统计数据
 * 
 * @author MrLu
 *
 */
@Repository("genRealJdbcDao")
public class GenRealJdbcDaoImpl extends JdbcUtil implements GenRealJdbcDao {

	/**
	 * 抓取机组实时统计数据（最新一条）
	 * 
	 * @param genId
	 *            机组Id 如果有机组Id，则获取该机组最新一条数据,如果没有机组Id,则获取所有机组最新数据
	 * @return
	 */
	public List<Map<String, Object>> getGenRealSta(String genId) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" WITH COAL_DATA AS ");
		sql.append("   (SELECT GEN_ID, ");
		sql.append("     GDMH, ");
		sql.append("     DATA_TIME ");
		sql.append("   FROM " + Const.LOCAL_LSDN_SCHEMA
				+ ".G_REAL_GEN_COAL_CONSUMPTION COAL ");
		sql.append("   WHERE COAL.DATA_TIME= ");
		sql.append("     (SELECT MAX(DATA_TIME) ");
		sql.append("     FROM " + Const.LOCAL_LSDN_SCHEMA
				+ ".G_REAL_GEN_COAL_CONSUMPTION ");
		sql.append("     WHERE GEN_ID = COAL.GEN_ID ");
		sql.append("     ) ");
		sql.append("   ) ");
		sql.append(" SELECT EMISSIONS.GEN_ID, ");
		sql.append("   EMISSIONS.SO2_CONVERT_OUT, ");
		sql.append("   EMISSIONS.NOX_CONVERT_OUT, ");
		sql.append("   EMISSIONS.PM_CONVERT_OUT, ");
		sql.append("   ROUND(DECODE(EMISSIONS.DATA_VALUE,0,0,NVL(EMISSIONS.SO2_CONVERT_OUT/EMISSIONS.DATA_VALUE,0)),4) AS SO2_RATE, ");
		sql.append("   ROUND(DECODE(EMISSIONS.DATA_VALUE,0,0,NVL(EMISSIONS.NOX_CONVERT_OUT/EMISSIONS.DATA_VALUE,0)),4) AS NOX_RATE, ");
		sql.append("   ROUND(DECODE(EMISSIONS.DATA_VALUE,0,0,NVL(EMISSIONS.PM_CONVERT_OUT /EMISSIONS.DATA_VALUE,0)),4) AS PM_RATE, ");
		sql.append("   EMISSIONS.SO2_EMISSIONS, ");
		sql.append("   EMISSIONS.NOX_EMISSIONS, ");
		sql.append("   EMISSIONS.PM_EMISSIONS, ");
		sql.append("   EMISSIONS.SO2_RATIO, ");
		sql.append("   EMISSIONS.SO2_CONVERT_IN, ");
		sql.append("   EMISSIONS.NOX_RATIO, ");
		sql.append("   EMISSIONS.NOX_CONVERT_IN, ");
		sql.append("   COAL.GDMH, ");
		sql.append("   EMISSIONS.OUT_MEASURE, ");
		sql.append("   NVL(EMISSIONS.DATA_VALUE,0) DATA_VALUE, ");
		sql.append("   EMISSIONS.DATA_TIME ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA
				+ ".G_REAL_GEN_EMISSIONS EMISSIONS ");
		sql.append(" JOIN COAL_DATA COAL ");
		sql.append(" ON EMISSIONS.GEN_ID     = COAL.GEN_ID ");
		sql.append(" WHERE 1                 =1 ");
		if (StringUtil.isNotNullOrBlank(genId)) {
			sql.append(" AND EMISSIONS.GEN_ID    = ? ");
			param.add(genId);
		}
		sql.append(" AND EMISSIONS.DATA_TIME = ");
		sql.append("   (SELECT MAX(DATA_TIME) ");
		sql.append("   FROM " + Const.LOCAL_LSDN_SCHEMA
				+ ".G_REAL_GEN_EMISSIONS ");
		sql.append("   WHERE GEN_ID =EMISSIONS.GEN_ID ");
		sql.append("   ) ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 抓取机组跳闸数据
	 * 
	 * @param plantId
	 * @param genId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<Map<String, Object>> getGenRealAccIdent(String startTime,
			String endTime, String plantId, String genId,Pageable pageable) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" SELECT ACCIDENT.ID AS ACCIDENT_ID, ");
		sql.append("   TO_CHAR(ACCIDENT.ACC_TIME,'yyyy-MM-dd') AS ACC_DATE, ");
		sql.append("   TO_CHAR(ACCIDENT.ACC_TIME,'HH24:MI') AS ACC_TIME, ");
		sql.append("   PLANT.SHORT_NAME AS PLANT_NAME, ");
		sql.append("   GEN.NAME   AS GEN_NAME, ");
		sql.append("   GEN.RATED_CAPACITY, ");
		sql.append("   ACCIDENT.YYSM ");
		sql.append(" FROM G_REAL_GEN_ACCIDENT ACCIDENT ");
		sql.append(" JOIN G_BASE_GENERATOR GEN ");
		sql.append(" ON ACCIDENT.GEN_ID = GEN.ID ");
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
		if(StringUtil.isNotNullOrBlank(startTime)&&StringUtil.isNotNullOrBlank(endTime)){
			sql.append(" AND TO_CHAR(ACCIDENT.ACC_TIME,'yyyy-MM') BETWEEN ? AND ? ");
			param.add(startTime);
			param.add(endTime);
		}
		sql.append(" ORDER BY ACCIDENT.ACC_TIME ASC ");
		return (Page<Map<String, Object>>) getPaginationDatasSafety(sql.toString(),param.toArray(),
				pageable);
	}

}
