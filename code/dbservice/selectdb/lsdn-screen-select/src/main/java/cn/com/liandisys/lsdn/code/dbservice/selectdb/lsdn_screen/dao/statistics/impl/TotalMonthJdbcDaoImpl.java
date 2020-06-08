package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.TotalMonthJdbcDao;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.vo.source.STotalMonthVo;
import cn.com.liandisys.util.util.DateUtil;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 全网实时统计数据
 * 
 * @author b_fangzheng
 */
@Repository("totalMonthJdbcDao")
public class TotalMonthJdbcDaoImpl extends JdbcUtil implements
		TotalMonthJdbcDao {

	/**
	 * 获取date的年的第一天到当前天的减排量
	 * @param date
	 * @return
	 */
	public Map<String,Object> getJplByDate(Date date){
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" SELECT SUM(SD_SO2_EMISSIONS+HD_SO2_EMISSIONS) AS SO2_JPL,	 ");
		sql.append("   SUM(SD_NOX_EMISSIONS     +HD_NOX_EMISSIONS) AS NOX_JPL, ");
		sql.append("   SUM(SD_PM_EMISSIONS      +HD_PM_EMISSIONS)  AS PM_JPL ");
		sql.append("      FROM " + Const.LOCAL_LSDN_SCHEMA + ".S_TOTAL_MONTH  ");
		sql.append(" WHERE YEAR =TO_CHAR(?,'YYYY') ");
		param.add(date);
		sql.append(" AND MONTH IN ");
		sql.append("   (SELECT TO_CHAR(ROWNUM,'FM00') MM ");
		sql.append("   FROM DUAL ");
		sql.append("     CONNECT BY ROWNUM <=TO_CHAR(?,'MM') ");
		param.add(date);
		sql.append("   ) ");
		sql.append(" GROUP BY YEAR ");
		return jdbcTemplate.queryForMap(sql.toString(),param.toArray());
	}
	/**
	 * 获取每个月各种排放量和减排量
	 * @return
	 */
	public List<Map<String,Object>> getEmissionsAndJpl(){
		StringBuffer sql = new StringBuffer();
		sql.append(" WITH MONTH_TABLE AS ");					
		sql.append("   (SELECT TO_CHAR(ROWNUM,'FM00') MM ");
		sql.append(" FROM DUAL CONNECT BY ROWNUM <= 12 ");
		sql.append("   ), ");
		sql.append("   BASE AS ");
		sql.append("   (SELECT HD_SO2_EMISSIONS, ");
		sql.append("     HD_NOX_EMISSIONS, ");
		sql.append("     HD_PM_EMISSIONS, ");
		sql.append("     GDMH, ");
		sql.append("     HD_CO2_JPL, ");
		sql.append("     GD_CO2_JPL, ");
		sql.append("     FD_CO2_JPL, ");
		sql.append("     SD_CO2_JPL, ");
		sql.append("     FBS_CO2_JPL, ");
		sql.append("     SLG_CO2_JPL, ");
		sql.append("     XNDC_CO2_JPL, ");
		sql.append("     MONTH ");
		sql.append("      FROM " + Const.LOCAL_LSDN_SCHEMA + ".S_TOTAL_MONTH  ");
		sql.append("   WHERE YEAR = TO_CHAR(SYSDATE,'yyyy') ");
		sql.append("   ) ");
		sql.append(" SELECT M.MM, ");
		sql.append("   NVL(HD_SO2_EMISSIONS, 0) AS HD_SO2_EMISSIONS , ");
		sql.append("   NVL(HD_NOX_EMISSIONS, 0) AS HD_NOX_EMISSIONS , ");
		sql.append("   NVL(HD_PM_EMISSIONS, 0)  AS HD_PM_EMISSIONS , ");
		sql.append("   NVL(GDMH, 0)             AS GDMH , ");
		sql.append("   NVL(HD_CO2_JPL, 0)/10000       AS HD_CO2_JPL , ");
		sql.append("   NVL(GD_CO2_JPL, 0)/10000       AS GD_CO2_JPL , ");
		sql.append("   NVL(FD_CO2_JPL, 0)/10000       AS FD_CO2_JPL , ");
		sql.append("   NVL(SD_CO2_JPL, 0)/10000       AS SD_CO2_JPL , ");
		sql.append("   NVL(FBS_CO2_JPL, 0)/10000      AS FBS_CO2_JPL , ");
		sql.append("   NVL(SLG_CO2_JPL, 0)/10000      AS SLG_CO2_JPL , ");
		sql.append("   NVL(XNDC_CO2_JPL, 0)/10000     AS XNDC_CO2_JPL ");
		sql.append(" FROM MONTH_TABLE M ");
		sql.append(" LEFT JOIN BASE B ");
		sql.append(" ON M.MM=B.MONTH ");
		sql.append(" ORDER BY M.MM ");
		return jdbcTemplate.queryForList(sql.toString()); 
	}

	/**
	 * 查询今年到当前时间的(SO2/NOX/烟尘)减排量和上一年到当前时间的(SO2/NOX/烟尘)减排量和同比
	 * 
	 * @param date
	 * @return
	 */
	public List<Map<String, Object>> getEmissionsRateByDate(String date) {

		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append("    WITH THISYEAR AS ");
		sql.append("      (SELECT  ");
		sql.append("        NVL(SUM(SD_SO2_EMISSIONS),0) THISSO2, ");
		sql.append("        NVL(SUM(SD_NOX_EMISSIONS),0) THISNOX, ");
		sql.append("        NVL(SUM(SD_PM_EMISSIONS),0) THISPM  ");
		sql.append("      FROM " + Const.LOCAL_LSDN_SCHEMA + ".S_TOTAL_MONTH  ");
		sql.append("      WHERE YEAR = TO_CHAR(TO_DATE( ? ,'"
				+ DateUtil.FORMAT_DATE_TIME_ORACLE + "'),'YYYY') ");
		param.add(date);
		sql.append("      ), ");
		sql.append("      LASTYEAR AS  ");
		sql.append("      (SELECT  ");
		sql.append("        NVL(SUM(SD_SO2_EMISSIONS),0) LASTSO2, ");
		sql.append("        NVL(SUM(SD_NOX_EMISSIONS),0) LASTNOX, ");
		sql.append("        NVL(SUM(SD_PM_EMISSIONS),0) LASTPM  ");
		sql.append("      FROM " + Const.LOCAL_LSDN_SCHEMA + ".S_TOTAL_MONTH  ");
		sql.append("      WHERE YEAR = TO_CHAR(ADD_MONTHS(TO_DATE( ? ,'"
				+ DateUtil.FORMAT_DATE_TIME_ORACLE + "'),-12),'YYYY') ");
		param.add(date);
		sql.append("      )  ");
		sql.append("    SELECT ");
		sql.append("      THISSO2,  ");
		sql.append("      THISNOX,  ");
		sql.append("      THISPM,  ");
		sql.append("      LASTSO2,  ");
		sql.append("      LASTNOX,  ");
		sql.append("      LASTPM,  ");
		sql.append("      CASE ");
		sql.append("        WHEN THISSO2 > 0 AND LASTSO2 = 0 THEN -1 ");
		sql.append("        WHEN THISSO2 = 0 AND LASTSO2 = 0 THEN 0  ");
		sql.append("        ELSE THISSO2/LASTSO2-1 ");
		sql.append("        END SO2RATE, ");
		sql.append("      CASE ");
		sql.append("        WHEN THISNOX > 0 AND LASTNOX = 0 THEN -1 ");
		sql.append("        WHEN THISNOX = 0 AND LASTNOX = 0 THEN 0 ");
		sql.append("        ELSE THISNOX/LASTNOX-1 ");
		sql.append("      END NOXRATE, ");
		sql.append("      CASE ");
		sql.append("        WHEN THISPM > 0 AND LASTPM = 0 THEN -1 ");
		sql.append("        WHEN THISPM = 0 AND LASTPM = 0 THEN 0 ");
		sql.append("        ELSE THISPM/LASTPM-1 ");
		sql.append("      END PMRATE ");
		sql.append("    FROM THISYEAR,LASTYEAR ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 全上海的平均SO2、NOX、烟尘排放浓度和煤耗
	 */
	public List<Map<String, Object>> getEmissionsByMonth() {
		StringBuffer sql = new StringBuffer();
		sql.append("WITH MONTH AS ");
		sql.append("(SELECT TO_CHAR(ROWNUM,'FM00') MM ");
		sql.append("FROM DUAL CONNECT BY ROWNUM <= 12), ");
		sql.append("BASE AS( ");
		sql.append("SELECT ");
		sql.append("SUM(HD_SO2_EMISSIONS) AS HD_SO2_EMISSIONS, ");
		sql.append("SUM(HD_NOX_EMISSIONS) AS HD_NOX_EMISSIONS, ");
		sql.append("SUM(HD_PM_EMISSIONS) AS HD_PM_EMISSIONS, ");
		sql.append("AVG(GDMH) AS GDMH, ");
		sql.append("MONTH ");
		sql.append("FROM S_TOTAL_MONTH WHERE YEAR = '2019' GROUP BY MONTH ");
		sql.append(") ");
		sql.append("SELECT ");
		sql.append("NVL(B.HD_SO2_EMISSIONS,0) AS HD_SO2_EMISSIONS, ");
		sql.append("NVL(B.HD_NOX_EMISSIONS,0) AS HD_NOX_EMISSIONS, ");
		sql.append("NVL(B.HD_PM_EMISSIONS,0) AS HD_PM_EMISSIONS, ");
		sql.append("NVL(B.GDMH,0) AS GDMH, ");
		sql.append("M.MM AS MONTH ");
		sql.append("FROM MONTH M LEFT JOIN BASE B ON M.MM=B.MONTH ");
		sql.append("ORDER BY M.MM ");
		return jdbcTemplate.queryForList(sql.toString());
	}

	/**
	 * 根据年度数据查询充电桩、三联供、虚拟电厂累计数据
	 * 
	 * @param year
	 * @return
	 */
	public List<STotalMonthVo> getTotalByYear(String year) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();

		sql.append("    SELECT  ");
		sql.append("      MM.YEAR                   AS YEAR, ");
		sql.append("      SUM(MM.HD_SO2_EMISSIONS)  AS HD_SO2_EMISSIONS ,  ");
		sql.append("      SUM(MM.HD_NOX_EMISSIONS)  AS HD_NOX_EMISSIONS ,  ");
		sql.append("      SUM(MM.HD_PM_EMISSIONS)   AS HD_PM_EMISSIONS , ");
		sql.append("      SUM(MM.HD_DL)             AS HD_DL , ");
		sql.append("      SUM(MM.HD_CO2_JPL)        AS HD_CO2_JPL ,  ");
		sql.append("      SUM(MM.SO2_CBCS)          AS SO2_CBCS ,  ");
		sql.append("      SUM(MM.NOX_CBCS)          AS NOX_CBCS ,  ");
		sql.append("      SUM(MM.PM_CBCS)           AS PM_CBCS , ");
		sql.append("      SUM(MM.GD_DL)             AS GD_DL , ");
		sql.append("      SUM(MM.GD_CO2_JPL)        AS GD_CO2_JPL ,  ");
		sql.append("      SUM(MM.FD_DL)             AS FD_DL , ");
		sql.append("      SUM(MM.FD_CO2_JPL)        AS FD_CO2_JPL,  ");
		sql.append("      SUM(MM.SD_DL)             AS SD_DL, ");
		sql.append("      SUM(MM.SD_CO2_JPL)        AS SD_CO2_JPL,  ");
		sql.append("      SUM(MM.SD_SO2_EMISSIONS)  AS SD_SO2_EMISSIONS,  ");
		sql.append("      SUM(MM.SD_NOX_EMISSIONS)  AS SD_NOX_EMISSIONS,  ");
		sql.append("      SUM(MM.SD_PM_EMISSIONS)   AS SD_PM_EMISSIONS, ");
		sql.append("      SUM(MM.FBS_DL)            AS FBS_DL,  ");
		sql.append("      SUM(MM.FBS_CO2_JPL)       AS FBS_CO2_JPL, ");
		sql.append("      SUM(MM.CDZ_DL)            AS CDZ_DL,  ");
		sql.append("      SUM(MM.CDZ_SAVE_QY)       AS CDZ_SAVE_QY , ");
		sql.append("      AVG(MM.SLG_NYXL_AVG)      AS SLG_NYXL_AVG ,  ");
		sql.append("      SUM(MM.SLG_SAVE_DL)       AS SLG_SAVE_DL, ");
		sql.append("      SUM(MM.SLG_SAVE_CB)       AS SLG_SAVE_CB, ");
		sql.append("      SUM(MM.SLG_CO2_JPL)       AS SLG_CO2_JPL, ");
		sql.append("      SUM(MM.XNDC_SAVE_DL)      AS XNDC_SAVE_DL,  ");
		sql.append("      SUM(MM.XNDC_SAVE_CB)      AS XNDC_SAVE_CB,  ");
		sql.append("      SUM(MM.XNDC_CO2_JPL)      AS XNDC_CO2_JPL,  ");
		sql.append("      SUM(MM.TFJX_TC)           AS TFJX_TC, ");
		sql.append("      SUM(MM.TFJX_XYSC_AVG)     AS TFJX_XYSC_AVG, ");
		sql.append("      SUM(MM.YCTP_TC_TYPE1)     AS YCTP_TC_TYPE1, ");
		sql.append("      SUM(MM.YCTP_TC_TYPE2)     AS YCTP_TC_TYPE2, ");
		sql.append("      SUM(MM.AGCXN_TC_TYPE1)    AS AGCXN_TC_TYPE1,  ");
		sql.append("      SUM(MM.AGCXN_TC_TYPE2)    AS AGCXN_TC_TYPE2, ");
		sql.append("      SUM(MM.MH_CBCS)           AS MH_CBCS ");
		sql.append("    FROM " + Const.LOCAL_LSDN_SCHEMA
				+ ".S_TOTAL_MONTH MM  ");
		sql.append("    WHERE 1=1  ");
		if (StringUtil.isNotNullOrBlank(year)) {
			sql.append("      AND MM.YEAR = ? ");
			param.add(year);
		}
		sql.append("    GROUP BY MM.YEAR ");
		sql.append("    ORDER BY MM.YEAR ");

		return jdbcTemplate.query(sql.toString(), param.toArray(),
				new BeanPropertyRowMapper<STotalMonthVo>(STotalMonthVo.class));
	}

	/**
	 * 查询月度统计数据
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public List<STotalMonthVo> getMonthData(String year, String month) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();

		sql.append(" SELECT ");
		sql.append("   MM.ID, ");
		sql.append("   MM.YEAR, ");
		sql.append("   MM.MONTH, ");
		sql.append("   MM.HD_SO2_EMISSIONS, ");
		sql.append("   MM.HD_NOX_EMISSIONS, ");
		sql.append("   MM.HD_PM_EMISSIONS, ");
		sql.append("   MM.HD_DL, ");
		sql.append("   MM.HD_CO2_JPL, ");
		sql.append("   MM.SO2_CBCS, ");
		sql.append("   MM.NOX_CBCS, ");
		sql.append("   MM.PM_CBCS, ");
		sql.append("   MM.GD_DL, ");
		sql.append("   MM.GD_CO2_JPL, ");
		sql.append("   MM.FD_DL, ");
		sql.append("   MM.FD_CO2_JPL, ");
		sql.append("   MM.SD_DL, ");
		sql.append("   MM.SD_CO2_JPL, ");
		sql.append("   MM.SD_SO2_EMISSIONS, ");
		sql.append("   MM.SD_NOX_EMISSIONS, ");
		sql.append("   MM.SD_PM_EMISSIONS, ");
		sql.append("   MM.FBS_DL, ");
		sql.append("   MM.FBS_CO2_JPL, ");
		sql.append("   MM.CDZ_DL, ");
		sql.append("   MM.CDZ_SAVE_QY, ");
		sql.append("   MM.SLG_NYXL_AVG, ");
		sql.append("   MM.SLG_SAVE_DL, ");
		sql.append("   MM.SLG_SAVE_CB, ");
		sql.append("   MM.SLG_CO2_JPL, ");
		sql.append("   MM.XNDC_SAVE_DL, ");
		sql.append("   MM.XNDC_SAVE_CB, ");
		sql.append("   MM.XNDC_CO2_JPL, ");
		sql.append("   MM.TFJX_TC, ");
		sql.append("   MM.TFJX_XYSC_AVG, ");
		sql.append("   MM.YCTP_TC_TYPE1, ");
		sql.append("   MM.YCTP_TC_TYPE2, ");
		sql.append("   MM.AGCXN_TC_TYPE1, ");
		sql.append("   MM.AGCXN_TC_TYPE2, ");
		sql.append("   MM.MH_CBCS ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA + ".S_TOTAL_MONTH MM ");
		sql.append(" WHERE 1=1 ");
		if (StringUtil.isNotNullOrBlank(year)) {
			sql.append("   AND MM.YEAR = ? ");
			param.add(year);
		}
		if (StringUtil.isNotNullOrBlank(month)) {
			sql.append("   AND MM.MONTH = ? ");
			param.add(month);
		}
		sql.append(" ORDER BY MM.YEAR, MM.MONTH ");

		return jdbcTemplate.query(sql.toString(), param.toArray(),
				new BeanPropertyRowMapper<STotalMonthVo>(STotalMonthVo.class));
	}
	
	/**
	 * 获取清洁能源占比
	 * @param date
	 * @return
	 */
	public List<Map<String,Object>> getCleanEnergyGenerationRatio(String date){
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append("WITH MONTH AS ");
		sql.append("  (SELECT TO_CHAR(ROWNUM,'FM00') MM FROM DUAL CONNECT BY ROWNUM <= 12 ");
		sql.append("  ), ");
		sql.append("  BASE AS ");
		sql.append("  (SELECT MONTH, ");
		sql.append("    NVL((GD_DL+FD_DL+SD_DL+FBS_DL),0) AS QJNYFDL, ");
		sql.append("    NVL((GD_DL+FD_DL+SD_DL+FBS_DL+HD_DL),0) AS ALLFDL ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA + ".S_TOTAL_MONTH  ");
		sql.append("      WHERE YEAR = TO_CHAR(TO_DATE( ? ,'"
				+ DateUtil.FORMAT_DATE_TIME_ORACLE + "'),'YYYY') ");
		param.add(date);
		sql.append("  ) ");
		sql.append("SELECT MM, ");
		sql.append("  NVL(ROUND(");
		sql.append("  CASE ");
		sql.append("    WHEN ALLFDL =0 ");
		sql.append("    THEN 0 ");
		sql.append("    ELSE (B.QJNYFDL/ALLFDL)*100         ");
		sql.append("  END,2),0) AS ZB                       ");
		sql.append("FROM MONTH M ");
		sql.append("LEFT JOIN BASE B ");
		sql.append("ON M.MM=B.MONTH ");
		sql.append("ORDER BY M.MM ASC ");
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}
	/**
	 * 清洁能源减排统计
	 */
	public List<Map<String, Object>> getCleanEnergyEmissionStatistics(String date) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append("WITH MONTH AS ");
		sql.append("  (SELECT TO_CHAR(ROWNUM,'FM00') MM  ");
		sql.append("  FROM DUAL CONNECT BY ROWNUM <= 12  ");
		sql.append("  ), ");
		sql.append("  BASE AS  ");
		sql.append("  (SELECT MONTH, ");
		sql.append("    SUM(NVL(GD_DL,0)+NVL(FD_DL,0)+NVL(SD_DL,0)+NVL(FBS_DL,0)) AS DL ");
		sql.append("  FROM LSDN.S_TOTAL_MONTH  ");
		sql.append("      WHERE YEAR = TO_CHAR(TO_DATE( ? ,'"
				+ DateUtil.FORMAT_DATE_TIME_ORACLE + "'),'YYYY') ");
		param.add(date);
		sql.append("  GROUP BY MONTH ");
		sql.append("  )  ");
		sql.append("SELECT M.MM, ");
		sql.append("  NVL(B.DL,0) AS DL  ");
		sql.append("FROM MONTH M ");
		sql.append("LEFT JOIN BASE B ");
		sql.append("ON M.MM=B.MONTH  ");
		sql.append("ORDER BY M.MM ASC  ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}
	
}
