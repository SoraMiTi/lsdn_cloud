package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.index.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.index.IndexJdbcDao;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.index.IndexEntity;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BS_HOME_INDEX jdbc接口层
 * @author MrLu
 *
 */
@Repository("indexJdbcDao")
public class IndexJdbcDaoImpl extends JdbcUtil implements IndexJdbcDao {
	
	/**
	 * 根据电厂和指标类型获取机组数据
	 * @param type
	 * @param plantId
	 * @return
	 */
	public List<IndexEntity> findGenIndexByPlantId(String type, String plantId){
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		List<IndexEntity> list=null;
		sql.append(" SELECT ");
		sql.append(" HOME.ID, ");
		sql.append(" HOME.CODE, ");
		sql.append(" HOME.NAME, ");
		sql.append(" HOME.UNIT, ");
		sql.append(" HOME.VALUE, ");
		sql.append(" HOME.TYPE, ");
		sql.append(" HOME.COMMENTS, ");
		sql.append(" HOME.UPDATE_TIME ");
		sql.append(" FROM BS_HOME_INDEX HOME ");
		sql.append(" JOIN G_BASE_GENERATOR GEN ");
		sql.append(" ON HOME.CODE     = GEN.ID ");
		sql.append(" WHERE 1          =1 ");
		if(StringUtil.isNotNullOrBlank(type)){
			sql.append(" AND HOME.TYPE    = ? ");
			param.add(type);
		}
		if(StringUtil.isNotNullOrBlank(plantId)){
			sql.append(" AND GEN.PLANT_ID = ? ");
			param.add(plantId);
		}
		sql.append(" ORDER BY GEN.ORDER_ID ASC ");
		try{
            list = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<IndexEntity>(IndexEntity.class));
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return list;
	}

	/**
	 * 根据电厂查询机组深度调峰数据
	 * @param plantId
	 * @return
	 */
	public List<Map<String, Object>> getJzsdtf(String plantId) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" WITH BASE AS ");
		sql.append("   (SELECT GEN.NAME    AS GEN_NAME, ");
		sql.append("     NVL(HOME.VALUE,0) AS VALUE, ");
		sql.append("     HOME.TYPE, ");
		sql.append("     GEN.ORDER_ID ");
		sql.append("   FROM G_BASE_GENERATOR GEN ");
		sql.append("   LEFT JOIN BS_HOME_INDEX HOME ");
		sql.append("   ON GEN.ID        =HOME.CODE ");
		sql.append("   AND HOME.TYPE   IN ('jzSdtf_type1','jzSdtf_type2') ");
		sql.append("   WHERE 1          =1 ");
		if(StringUtil.isNotNullOrBlank(plantId)){
			sql.append(" AND GEN.PLANT_ID = ? ");
			param.add(plantId);
		}
		sql.append("   ) ");
		sql.append(" SELECT * ");
		sql.append(" FROM BASE PIVOT(MAX(VALUE) FOR TYPE IN ('jzSdtf_type1' AS VALUE1,'jzSdtf_type2' AS VALUE2)) ");
		sql.append(" ORDER BY ORDER_ID ASC ");
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}
	
}
