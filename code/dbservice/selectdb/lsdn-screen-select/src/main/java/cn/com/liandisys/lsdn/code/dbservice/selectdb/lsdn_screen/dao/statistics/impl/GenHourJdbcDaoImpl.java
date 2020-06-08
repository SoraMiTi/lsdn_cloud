package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.GenHourJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 各机组小时统计表
 * 
 * @author b_fangzheng
 *
 */
@Repository("genHourJdbcDao")
public class GenHourJdbcDaoImpl extends JdbcUtil implements GenHourJdbcDao {

	/**
	 * 根据时间段和电厂，在小时统计表中分组统计电厂下所有机组相关数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @param plantId
	 * @return
	 */
	public List<Map<String, Object>> staSGenHourOrderByGen(Date startTime,
			Date endTime, String plantId) {
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" WITH GENBASE AS ( ");
		sql.append("   SELECT ");
		sql.append("     ID, ");
		sql.append("     NAME, ");
		sql.append("     ORDER_ID ");
		sql.append("   FROM G_BASE_GENERATOR ");
		sql.append("   WHERE 1=1 ");
		sql.append("   AND PLANT_ID = ? ");
		param.add(plantId);
		sql.append(" ), ");
		sql.append(" GENREAL AS ( ");
		sql.append(" SELECT ");
		sql.append("   GEN_ID, ");
		sql.append("   SUM(SO2_EMISSIONS) SO2_EMISSIONS, ");
		sql.append("   SUM(NOX_EMISSIONS) NOX_EMISSIONS, ");
		sql.append("   SUM(PM_EMISSIONS) PM_EMISSIONS, ");
		sql.append("   AVG(SO2_CONVERT_OUT) SO2_CONVERT_OUT, ");
		sql.append("   AVG(NOX_CONVERT_OUT) NOX_CONVERT_OUT, ");
		sql.append("   AVG(PM_CONVERT_OUT) PM_CONVERT_OUT, ");
		sql.append("   AVG(SUP_POWER) SUP_POWER, ");
		// sql.append("   AVG(GDMH) GDMH, ");
		sql.append("   AVG(DECODE(GDMH,0,NULL,GDMH)) GDMH, ");
		sql.append("   AVG(SO2_EMISSIONS_RATE) SO2_EMISSIONS_RATE, ");
		sql.append("   AVG(NOX_EMISSIONS_RATE) NOX_EMISSIONS_RATE, ");
		sql.append("   AVG(PM_EMISSIONS_RATE) PM_EMISSIONS_RATE ");
		sql.append(" FROM S_GEN_HOUR ");
		sql.append(" WHERE 1=1 ");
		sql.append("   AND DATA_TIME > = ? ");
		param.add(startTime);
		sql.append("   AND DATA_TIME <= ? ");
		param.add(endTime);
		sql.append("   AND PLANT_ID = ? ");
		param.add(plantId);
		sql.append(" GROUP BY GEN_ID) ");
		sql.append(" SELECT ");
		sql.append("   GENBASE.ID, ");
		sql.append("   GENBASE.NAME, ");
		sql.append("   ROUND(NVL(SO2_EMISSIONS,0),2) SO2_EMISSIONS, ");
		sql.append("   ROUND(NVL(NOX_EMISSIONS,0),2) NOX_EMISSIONS, ");
		sql.append("   ROUND(NVL(PM_EMISSIONS,0),2) PM_EMISSIONS, ");
		sql.append("   ROUND(NVL(SO2_CONVERT_OUT,0),2) SO2_CONVERT_OUT, ");
		sql.append("   ROUND(NVL(NOX_CONVERT_OUT,0),2) NOX_CONVERT_OUT, ");
		sql.append("   ROUND(NVL(PM_CONVERT_OUT,0),2) PM_CONVERT_OUT, ");
		sql.append("   ROUND(NVL(SUP_POWER,0),2) SUP_POWER, ");
		sql.append("   ROUND(NVL(GDMH,0),2) GDMH, ");
		sql.append("   ROUND(NVL(SO2_EMISSIONS_RATE,0),2) SO2_EMISSIONS_RATE, ");
		sql.append("   ROUND(NVL(NOX_EMISSIONS_RATE,0),2) NOX_EMISSIONS_RATE, ");
		sql.append("   ROUND(NVL(PM_EMISSIONS_RATE,0),2) PM_EMISSIONS_RATE ");
		sql.append(" FROM GENBASE ");
		sql.append(" LEFT JOIN GENREAL ");
		sql.append("   ON GENBASE.ID = GENREAL.GEN_ID ");
		sql.append(" ORDER BY GENBASE.ORDER_ID ASC ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 根据时间段，在小时统计表中分组统计所有电厂相关数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @param plantId
	 * @return
	 */
	public List<Map<String, Object>> staSGenHourOrderByPlant(Date startTime,
			Date endTime) {

		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" WITH GENREAL AS ");
		sql.append("   (SELECT GEN_ID, ");
		sql.append("     PLANT_ID, ");
		sql.append("     SUM(SO2_EMISSIONS) SO2_EMISSIONS, ");
		sql.append("     SUM(NOX_EMISSIONS) NOX_EMISSIONS, ");
		sql.append("     SUM(PM_EMISSIONS) PM_EMISSIONS, ");
		sql.append("     AVG(SO2_CONVERT_OUT) SO2_CONVERT_OUT, ");
		sql.append("     AVG(NOX_CONVERT_OUT) NOX_CONVERT_OUT, ");
		sql.append("     AVG(PM_CONVERT_OUT) PM_CONVERT_OUT, ");
		sql.append("     AVG(SUP_POWER) SUP_POWER, ");
		sql.append("     AVG(DECODE(GDMH,0,NULL,GDMH)) GDMH, ");
		sql.append("     AVG(SO2_EMISSIONS_RATE) SO2_EMISSIONS_RATE, ");
		sql.append("     AVG(NOX_EMISSIONS_RATE) NOX_EMISSIONS_RATE, ");
		sql.append("     AVG(PM_EMISSIONS_RATE) PM_EMISSIONS_RATE ");
		sql.append("   FROM S_GEN_HOUR ");
		sql.append("   WHERE 1        =1 ");
		sql.append(" 	AND DATA_TIME > = ? ");
		param.add(startTime);
		sql.append(" 	AND DATA_TIME <= ? ");
		param.add(endTime);
		sql.append("   GROUP BY GEN_ID, ");
		sql.append("     PLANT_ID ");
		sql.append("   ), ");
		sql.append("   PLANTREAL AS ");
		sql.append("   (SELECT PLANT_ID, ");
		sql.append("     ROUND(NVL(SUM(SO2_EMISSIONS),0),2) SO2_EMISSIONS, ");
		sql.append("     ROUND(NVL(SUM(NOX_EMISSIONS),0),2) NOX_EMISSIONS, ");
		sql.append("     ROUND(NVL(SUM(PM_EMISSIONS),0),2) PM_EMISSIONS, ");
		sql.append("     ROUND(NVL(AVG(SO2_CONVERT_OUT),0),2) SO2_CONVERT_OUT, ");
		sql.append("     ROUND(NVL(AVG(NOX_CONVERT_OUT),0),2) NOX_CONVERT_OUT, ");
		sql.append("     ROUND(NVL(AVG(PM_CONVERT_OUT),0),2) PM_CONVERT_OUT, ");
		sql.append("     ROUND(NVL(AVG(SUP_POWER),0),2) SUP_POWER, ");
		sql.append("     ROUND(NVL(AVG(GDMH),0),2) GDMH, ");
		sql.append("     ROUND(NVL(AVG(SO2_EMISSIONS_RATE),0),2) SO2_EMISSIONS_RATE, ");
		sql.append("     ROUND(NVL(AVG(NOX_EMISSIONS_RATE),0),2) NOX_EMISSIONS_RATE, ");
		sql.append("     ROUND(NVL(AVG(PM_EMISSIONS_RATE),0),2) PM_EMISSIONS_RATE ");
		sql.append("   FROM GENREAL ");
		sql.append("   WHERE 1 =1 ");
		sql.append("   GROUP BY PLANT_ID ");
		sql.append("   ) ");
		sql.append(" SELECT ");
		sql.append("   PLANT.ID, ");
		sql.append("   PLANT.SHORT_NAME AS NAME, ");
		sql.append("   PLANTREAL.* ");
		sql.append(" FROM G_BASE_PLANT PLANT ");
		sql.append(" LEFT JOIN PLANTREAL ");
		sql.append(" ON PLANT.ID     = PLANTREAL.PLANT_ID ");
		sql.append(" WHERE 1         =1 ");
		sql.append(" AND (PLANT.TYPE = ? ");
		sql.append(" OR PLANT.TYPE   =? ) ");
		param.add(Const.COMM_CODE.DYLX_RM);
		param.add(Const.COMM_CODE.DYLX_RJ);
		sql.append(" ORDER BY PLANT.PLANT_ORDER ASC ");

		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 根据时间查询设备排放数据，电厂和机组全为空时，查询全网数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @param plantId
	 * @param genId
	 * @return
	 */
	public List<Map<String, Object>> getStaHourList(Date startTime,
			Date endTime, String plantId, String genId) {
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" WITH BASE AS ( ");
		sql.append("   SELECT TO_CHAR(DATA_TIME, 'yyyy-MM-dd hh24') DATA_TIME, ");
		sql.append(" TO_CHAR(DATA_TIME, 'hh24')||'时' HOUR_TIME, ");
		sql.append("   SO2_CONVERT_OUT, ");
		sql.append("   NOX_CONVERT_OUT, ");
		sql.append("   PM_CONVERT_OUT, ");
		sql.append("   GDMH, ");
		sql.append("   SO2_EMISSIONS_RATE, ");
		sql.append("   NOX_EMISSIONS_RATE, ");
		sql.append("   PM_EMISSIONS_RATE ");
		sql.append("   FROM S_GEN_HOUR ");
		sql.append("   WHERE 1=1 ");
		sql.append("    AND DATA_TIME >= ? ");
		param.add(startTime);
		sql.append("    AND DATA_TIME <= ? ");
		param.add(endTime);
		if (StringUtil.isNotNullOrBlank(plantId)) {
			sql.append("     AND PLANT_ID = ? ");
			param.add(plantId);
		}
		if (StringUtil.isNotNullOrBlank(genId)) {
			sql.append("     AND GEN_ID = ? ");
			param.add(genId);
		}
		sql.append(" ) ");
		sql.append(" SELECT ");
		sql.append("   DATA_TIME, ");
		sql.append("   HOUR_TIME,  ");
		sql.append("   ROUND(NVL(AVG(SO2_CONVERT_OUT), 0), 2) SO2_CONVERT_OUT, ");
		sql.append("   ROUND(NVL(AVG(NOX_CONVERT_OUT), 0), 2) NOX_CONVERT_OUT, ");
		sql.append("   ROUND(NVL(AVG(PM_CONVERT_OUT), 0), 2) PM_CONVERT_OUT, ");
		sql.append("   ROUND(NVL(AVG(DECODE(GDMH,0,NULL,GDMH)) , 0), 2) GDMH, ");
		sql.append("   ROUND(NVL(AVG(SO2_EMISSIONS_RATE), 0), 2) SO2_EMISSIONS_RATE, ");
		sql.append("   ROUND(NVL(AVG(NOX_EMISSIONS_RATE), 0), 2) NOX_EMISSIONS_RATE, ");
		sql.append("   ROUND(NVL(AVG(PM_EMISSIONS_RATE), 0), 2) PM_EMISSIONS_RATE ");
		sql.append(" FROM BASE ");
		sql.append(" WHERE 1=1 ");
		sql.append(" GROUP BY DATA_TIME,HOUR_TIME ");
		sql.append(" ORDER BY DATA_TIME,HOUR_TIME ASC ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 根据时间查询设备电厂下机组排放量
	 * 
	 * @param startTime
	 * @param endTime
	 * @param plantId
	 * @return
	 */
	public List<Map<String, Object>> getCoalByPlantId(Date startTime,
			Date endTime, String plantId) {
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" WITH TIME_BASE AS ");
		sql.append("   (SELECT TO_CHAR(DATA_TIME, 'yyyy-MM-DD HH24') DATA_TIME ");
		sql.append("   FROM S_GEN_HOUR ");
		sql.append("   WHERE 1        =1 ");
		sql.append("   AND DATA_TIME    >= ? ");
		param.add(startTime);
		sql.append("   AND DATA_TIME    <= ? ");
		param.add(endTime);
		sql.append("   AND PLANT_ID = ? ");
		param.add(plantId);
		sql.append("   ), ");
		sql.append("   DATA_BASE AS ");
		sql.append("   (SELECT TO_CHAR(DATA_TIME, 'YYYY-MM-DD HH24') DATA_TIME, ");
		sql.append("     GEN_ID, ");
		sql.append("     GDMH ");
		sql.append("   FROM S_GEN_HOUR ");
		sql.append("   WHERE 1        =1 ");
		sql.append("   AND DATA_TIME    >= ? ");
		param.add(startTime);
		sql.append("   AND DATA_TIME    <= ? ");
		param.add(endTime);
		sql.append("   AND PLANT_ID = ? ");
		param.add(plantId);
		sql.append("   ) ");
		sql.append(" SELECT TI.DATA_TIME, ");
		sql.append("   DA.GEN_ID, ");
		sql.append("   ROUND(NVL(AVG(DECODE(DA.GDMH,0,NULL,DA.GDMH)) , 0), 2) GDMH ");
		sql.append(" FROM TIME_BASE TI ");
		sql.append(" LEFT JOIN DATA_BASE DA ");
		sql.append(" ON TI.DATA_TIME=DA.DATA_TIME ");
		sql.append(" WHERE 1        =1 ");
		sql.append(" GROUP BY TI.DATA_TIME, ");
		sql.append("   DA.GEN_ID ");
		sql.append(" ORDER BY DATA_TIME ASC ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 从机组小时表中获取日报列表数据
	 * 
	 * @param plantId
	 * @param day
	 * @return
	 */
	public List<Map<String, Object>> getDayReport(String plantId, String day) {
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();

		sql.append(" WITH DATETIME AS ");
		sql.append("   (SELECT ? || ' ' || LPAD(LEVEL-1, 2, 0) DATA_TIME ");
		param.add(day);
		sql.append("   FROM DUAL ");
		sql.append("     CONNECT BY LEVEL < 25), ");
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
		sql.append("     TO_CHAR(T.DATA_TIME, 'yyyy-MM-dd hh24') DATA_TIME ");
		sql.append("   FROM S_GEN_HOUR T ");
		sql.append("   WHERE 1=1 ");
		sql.append("     AND TO_CHAR(T.DATA_TIME, 'yyyy-MM-dd') = ? ");
		param.add(day);
		if (StringUtil.isNotNullOrBlank(plantId)) {
			sql.append("     AND T.PLANT_ID = ? ");
			param.add(plantId);
		}
		sql.append("   GROUP BY TO_CHAR(T.DATA_TIME, 'yyyy-MM-dd hh24') ");
		sql.append("   ), ");
		sql.append(" DATALIST AS ( ");
		sql.append("   SELECT ");
		sql.append("     (SUBSTR(DATETIME.DATA_TIME, 11) || ':00 - ' || LPAD(SUBSTR(DATETIME.DATA_TIME,11)+1 ,2, 0)||':00') DATA_TIME, ");
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
		sql.append("  ORDER BY DATETIME.DATA_TIME ASC ");
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
	 * 根据时间查询【时间段各集团发电平均煤耗和累计发电量】
	 * 
	 * @param startTime
	 *            时间格式 yyyy
	 * @param endTime
	 *            时间格式 yyyy
	 * @return
	 */
	public List<Map<String, Object>> staByGroup(String startTime, String endTime) {
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();

		sql.append(" WITH BASEDATA AS ( ");
		sql.append("   SELECT ");
		sql.append("    GEN.ID, ");
		sql.append("    GEN.NAME, ");
		sql.append("    GEN.RATED_CAPACITY, ");
		sql.append("    GEN.PLANT_ID, ");
		sql.append("    PLANT.SSJT ");
		sql.append("   FROM G_BASE_GENERATOR GEN ");
		sql.append("   JOIN G_BASE_PLANT PLANT ");
		sql.append("     ON GEN.PLANT_ID = PLANT.ID ");
		sql.append(" ), ");
		sql.append(" REALDATA AS ( ");
		sql.append("   SELECT ");
		sql.append("     GEN_ID, ");
		sql.append("    SUM(LJDL) LJDL, ");
		sql.append("    AVG(GDMH) GDMH, ");
		sql.append("    AVG(SUP_POWER) SUP_POWER ");
		sql.append("   FROM S_GEN_HOUR ");
		sql.append("   WHERE 1=1 ");
		sql.append("     AND SUP_POWER > 2 ");
		sql.append("     AND GDMH > 0 ");
		sql.append("     AND TO_CHAR(DATA_TIME,'yyyy') >= ? ");
		param.add(startTime);
		sql.append("     AND TO_CHAR(DATA_TIME,'yyyy') <= ? ");
		param.add(endTime);
		sql.append("   GROUP BY GEN_ID ");
		sql.append(" ), ");
		sql.append(" STA AS ( ");
		sql.append("   SELECT ");
		sql.append("     BASEDATA.SSJT, ");
		sql.append("     SUM(LJDL) LJDL, ");
		sql.append("     AVG(GDMH) GDMH, ");
		sql.append("     AVG(SUP_POWER) SUP_POWER ");
		sql.append("   FROM BASEDATA ");
		sql.append("   JOIN REALDATA ");
		sql.append("     ON REALDATA.GEN_ID = BASEDATA.ID ");
		sql.append("   GROUP BY SSJT ");
		sql.append(" ) ");
		sql.append(" SELECT ");
		sql.append("   GRO.ID, ");
		sql.append("   GRO.NAME, ");
		sql.append("   ROUND(NVL(STA.LJDL,0),2) LJDL, ");
		sql.append("   ROUND(NVL(STA.GDMH,0),2) GDMH, ");
		sql.append("   ROUND(NVL(STA.SUP_POWER,0),2) SUP_POWER ");
		sql.append(" FROM STA ");
		sql.append(" RIGHT JOIN B_BASE_GROUP GRO ");
		sql.append("   ON GRO.ID = STA.SSJT ");

		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 根据时间查询【时间段各容量等级机组发电平均煤耗和累计发电量】
	 * 
	 * @param startTime
	 *            时间格式 yyyy
	 * @param endTime
	 *            时间格式 yyyy
	 * @return
	 */
	public List<Map<String, Object>> staByCapacity(String startTime, String endTime) {
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();

		sql.append(" WITH BASEDATA AS ( ");
		sql.append("   SELECT ");
		sql.append("     GEN.ID, GEN.NAME, GEN.RATED_CAPACITY, GEN.PLANT_ID, ");
		sql.append("     CASE WHEN RATED_CAPACITY >= 0 AND  RATED_CAPACITY <300 THEN '0' ");
		sql.append("         WHEN RATED_CAPACITY >= 300 AND  RATED_CAPACITY <600 THEN '1' ");
		sql.append("         WHEN RATED_CAPACITY >= 600 AND  RATED_CAPACITY <1000 THEN '2' ");
		sql.append("         WHEN RATED_CAPACITY >= 1000 THEN '3' ");
		sql.append("     END LEV ");
		sql.append("   FROM G_BASE_GENERATOR GEN), ");
		sql.append(" REALDATA AS ( ");
		sql.append("   SELECT ");
		sql.append("     GEN_ID, SUM(LJDL) LJDL, AVG(GDMH) GDMH, AVG(SUP_POWER) SUP_POWER ");
		sql.append("   FROM S_GEN_HOUR ");
		sql.append("   WHERE 1=1 ");
		sql.append("     AND SUP_POWER > 2 ");
		sql.append("     AND GDMH > 0 ");
		sql.append("     AND TO_CHAR(DATA_TIME,'yyyy') >= ? ");
		param.add(startTime);
		sql.append("     AND TO_CHAR(DATA_TIME,'yyyy') <= ? ");
		param.add(endTime);
		sql.append("   GROUP BY GEN_ID ");
		sql.append(" ) ");
		sql.append(" SELECT ");
		sql.append("   CASE LEV ");
		sql.append("     WHEN '0' THEN '300MW以下' ");
		sql.append("     WHEN '1' THEN '300-600MW' ");
		sql.append("     WHEN '2' THEN '600-1000MW' ");
		sql.append("     WHEN '3' THEN '1000MW以上' ");
		sql.append("   END NAME, ");
		sql.append("   ROUND(NVL(SUM(LJDL),0),2) LJDL, ");
		sql.append("   ROUND(NVL(AVG(GDMH),0),2) GDMH, ");
		sql.append("   ROUND(NVL(AVG(SUP_POWER),0),2) SUP_POWER ");
		sql.append(" FROM BASEDATA ");
		sql.append(" LEFT JOIN REALDATA ");
		sql.append("   ON REALDATA.GEN_ID = BASEDATA.ID ");
		sql.append(" WHERE LEV IS NOT NULL ");
		sql.append(" GROUP BY LEV ");
		sql.append(" ORDER BY LEV ");

		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}
}
