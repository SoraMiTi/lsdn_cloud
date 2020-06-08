package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj.LspjZhpjJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 综合评价表 操作表：O_L_LSPJ_ZHPJ
 * 
 * @author luwl
 *
 */
@Repository("lspjZhpjJdbcDao")
public class LspjZhpjJdbcDaoImpl extends JdbcUtil implements LspjZhpjJdbcDao {

	/**
	 * 拼接查询最新数据时间的sql 使用时，参数中需要添加flag
	 * 
	 * @return
	 */
	private String lastTime() {
		StringBuffer sql = new StringBuffer();
		sql.append(" AND TO_CHAR(ZHPJ.DATA_TIME,'YYYY-MM')= ");
		sql.append(" (SELECT TO_CHAR(MAX(DATA_TIME),'YYYY-MM') FROM  ");
		sql.append(Const.LOCAL_LSDN_SCHEMA + ".O_L_LSPJ_ZHPJ WHERE  ");
		sql.append(" FLAG=? ) ");
		return sql.toString();
	}

	/**
	 * 查询电科院(全部)数据
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getDkyList() {
		// sql查询结果
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ZHPJ.* ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSPJ_ZHPJ ZHPJ ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ZHPJ.FLAG=? ");
		param.add(Const.COMM_CODE.DKY_FLAG);
		sql.append(lastTime());
		param.add(Const.COMM_CODE.DKY_FLAG);
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 查询集团数据 jtId is null 查询所有集团数据 jtId is not null 查询单个集团数据
	 * 
	 * @param jtId
	 *            集团id
	 * @return
	 */
	public List<Map<String, Object>> getJtList(String jtId) {
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ZHPJ.* ,");
		sql.append(" B.NAME AS \"name\" ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA + ".B_BASE_GROUP B ");
		sql.append(" JOIN  " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSPJ_ZHPJ ZHPJ ");
		sql.append(" ON ZHPJ.SSJT=B.ID ");
		sql.append(" WHERE 1=1 ");
		if (StringUtil.isNotNullOrBlank(jtId)&&!"0".equals(jtId)) {
			sql.append(" AND ZHPJ.SSJT=? ");
			param.add(jtId);
		}
		sql.append(" AND ZHPJ.FLAG=? ");
		param.add(Const.COMM_CODE.JITUAN_FLAG);
		sql.append(lastTime());
		param.add(Const.COMM_CODE.JITUAN_FLAG);
		sql.append(" ORDER BY B.ID ASC ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 查询电厂数据 plantId is null && jtId is null 查询所有电厂 plantId is not null 查询单个电厂
	 * jtId is not null 查询单个集团下所有电厂 jtId is not null && plantId is not null
	 * 查询单个集团下的单个电厂
	 * 
	 * @param plantId
	 *            电厂id
	 * @param jtId
	 *            集团id
	 * @return
	 */
	public List<Map<String, Object>> getDcList(String plantId, String jtId) {
		// sql查询结果
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		// id如果为空 查询全部集团,如果不为空，则查询集团下的电厂数据
		sql.append(" SELECT ZHPJ.*,");
		sql.append(" PLANT.SHORT_NAME AS \"name\" ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA
				+ ".G_BASE_PLANT PLANT ");
		sql.append(" JOIN " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSPJ_ZHPJ ZHPJ ");
		sql.append(" ON ZHPJ.PLANT_ID=PLANT.ID ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ZHPJ.FLAG=? ");
		param.add(Const.COMM_CODE.DIANCHANG_FLAG);
		// 如果传来的集团id不为空 则查询单个集团下的电厂
		if (StringUtil.isNotNullOrBlank(jtId)&&!"0".equals(jtId)) {
			sql.append(" AND PLANT.SSJT = ? ");
			param.add(jtId);
		}
		// 如果传来的电厂id不为空 则查询单个电厂
		if (StringUtil.isNotNullOrBlank(plantId)&&!"0".equals(plantId)) {
			sql.append(" AND PLANT.ID = ? ");
			param.add(plantId);
		}
		//投运状态为 已投运
		sql.append(" AND PLANT.TYZT = ? ");
		param.add(Const.COMM_CODE.TYZT_YES);
		sql.append(lastTime());
		param.add(Const.COMM_CODE.DIANCHANG_FLAG);
		sql.append(" ORDER BY PLANT.SHORT_NAME ASC ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 查询机组数据 genId is not null 查询单个机组数据 plantId is not null 查询单个电厂下所有机组数据 genId
	 * is null && plantId is null 查询所有机组 genId is not null && plantId is not
	 * null 查询单个电厂下单个机组数据
	 * 
	 * @param genId
	 *            机组id
	 * @param plantId
	 *            电厂id
	 * @return
	 */
	public List<Map<String, Object>> getJzList(String genId, String plantId) {
		// sql查询结果
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ZHPJ.*, ");
		sql.append(" GEN.NAME AS \"name\" ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA
				+ ".G_BASE_GENERATOR GEN ");
		sql.append(" JOIN " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSPJ_ZHPJ ZHPJ ");
		sql.append(" ON ZHPJ.GEN_ID=GEN.ID ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ZHPJ.FLAG= ? ");
		param.add(Const.COMM_CODE.JIZU_FLAG);
		//判断是否查询单个机组
		if(StringUtil.isNotNullOrBlank(genId)&&!"0".equals(genId)){
			sql.append(" AND GEN.ID = ? ");
			param.add(genId);
		}
		//判断是否查询电厂
		if(StringUtil.isNotNullOrBlank(plantId)&&!"0".equals(plantId)){
			sql.append(" AND GEN.PLANT_ID = ? ");
			param.add(plantId);
		}
		//投运状态为 已投运
		sql.append(" AND GEN.TYZT = ? ");
		param.add(Const.COMM_CODE.TYZT_YES);
		//最新数据
		sql.append(lastTime());
		param.add(Const.COMM_CODE.JIZU_FLAG);
		sql.append(" ORDER BY GEN.NAME ASC ");
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}


	/**
	 * 获取技术的环保指标数据
	 * 
	 * @param plantType
	 *            电厂类型 燃煤/燃机
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getHBZBByPlantType(String plantType) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" 	PLANT.ID AS PLANTNO, ");
		sql.append(" 	PLANT.SHORT_NAME AS SHORTNAME, ");
		sql.append(" 	TRUNC(AVG(SUBSTR(ZHPJ.LSZB,4)),3) JZHBZB ");
		sql.append(" FROM LSDN.O_L_LSPJ_ZHPJ ZHPJ ");
		sql.append(" INNER JOIN LSDN.G_BASE_PLANT PLANT ");
		sql.append(" 	ON ZHPJ.PLANT_ID=PLANT.ID ");
		sql.append(" WHERE ZHPJ.MONTH>0 ");
		sql.append(" 	AND ZHPJ.FLAG=2 ");
		sql.append("   AND PLANT.TYPE=?");
		//投运状态为 已投运
		sql.append(" AND PLANT.TYZT = ? ");
		sql.append(" GROUP BY PLANT.ID, PLANT.SHORT_NAME ");
		sql.append(" ORDER BY PLANT.SHORT_NAME ASC  ");
		return jdbcTemplate.queryForList(sql.toString(),
				new Object[] { plantType,Const.COMM_CODE.TYZT_YES});
	}

	/**
	 * 根据 时间范围查询集团的AVG(LSZB)
	 * 
	 * @param flag
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<Map<String, Object>> getJiTuanLszbByTime(String startTime,
			String endTime) {
		StringBuffer sql = new StringBuffer();
		List<Object> param=new ArrayList<Object>();
		sql.append(" WITH BASE_ZHPJ AS( ");
		sql.append("   SELECT SSJT,LSZB FROM " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSPJ_ZHPJ ZHPJ ");
		sql.append("   WHERE 1=1 ");
		sql.append("   AND TO_CHAR(ZHPJ.DATA_TIME,'YYYY-MM-DD') >= ? ");
		sql.append("   AND TO_CHAR(ZHPJ.DATA_TIME,'YYYY-MM-DD') <= ? ");
		param.add(startTime);
		param.add(endTime);
		sql.append(" ) ");
		sql.append(" SELECT ");
		sql.append(" G.NAME AS \"name\", ");
		sql.append("   NVL(ROUND(AVG(SUBSTR(ZHPJ.LSZB,4)),4),0) AS \"value\" ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA + ".B_BASE_GROUP G ");
		sql.append(" LEFT JOIN BASE_ZHPJ ZHPJ ");
		sql.append(" ON ZHPJ.SSJT   =G.ID ");
		sql.append(" GROUP BY G.NAME ");
		sql.append(" ORDER BY NVL(ROUND(AVG(SUBSTR(ZHPJ.LSZB,4)),4),0) DESC ");
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}

	/**
	 * 根据 时间范围查询电厂的AVG(LSZB)
	 * 
	 * @param flag
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<Map<String, Object>> getDianChangLszbByTime(String startTime,
			String endTime) {
		StringBuffer sql = new StringBuffer();
		List<Object> param=new ArrayList<Object>();
		sql.append(" WITH BASE_ZHPJ AS( ");
		sql.append("   SELECT * FROM  " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSPJ_ZHPJ ZHPJ ");
		sql.append("   WHERE 1                                   =1 ");
		sql.append(" AND TO_CHAR(ZHPJ.DATA_TIME,'YYYY-MM-DD') >= ? ");
		sql.append(" AND TO_CHAR(ZHPJ.DATA_TIME,'YYYY-MM-DD') <= ? ");
		param.add(startTime);
		param.add(endTime);
		sql.append(" ) ");
		sql.append(" SELECT ");
		sql.append(" PLANT.SHORT_NAME AS \"name\", ");
		sql.append("   NVL(ROUND(AVG(SUBSTR(ZHPJ.LSZB,4)),4),0) AS \"value\" ");
		sql.append("   FROM " + Const.LOCAL_LSDN_SCHEMA + ".G_BASE_PLANT PLANT ");
		sql.append(" LEFT JOIN BASE_ZHPJ ZHPJ ");
		sql.append(" ON ZHPJ.PLANT_ID                          =PLANT.ID ");
		sql.append(" WHERE 1=1 ");
		//TODO 当前只查询燃煤燃机电厂
		sql.append(" AND PLANT.TYPE IN (?,?) ");
		param.add(Const.COMM_CODE.DYLX_RM);
		param.add(Const.COMM_CODE.DYLX_RJ);
		//投运状态为 已投运
		sql.append(" AND PLANT.TYZT = ? ");
		param.add(Const.COMM_CODE.TYZT_YES);
		sql.append(" GROUP BY PLANT.SHORT_NAME ");
		sql.append(" ORDER BY NVL(ROUND(AVG(SUBSTR(ZHPJ.LSZB,4)),4),0) DESC ");
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}

}
