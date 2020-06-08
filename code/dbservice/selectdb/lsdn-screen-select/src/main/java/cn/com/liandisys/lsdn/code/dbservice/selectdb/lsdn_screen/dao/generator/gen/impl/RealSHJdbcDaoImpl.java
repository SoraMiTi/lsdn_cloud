package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen.RealSHJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * G_REAL_SHANGHAI dao层实现类
 * @author MrLu
 *
 */
@Repository("realSHJdbcDao")
public class RealSHJdbcDaoImpl extends JdbcUtil implements RealSHJdbcDao {
	
	 /**
	  * 获取最新的一条出力数据
	  * @return
	  */
	 public Map<String,Object> getRealLoad(){
		 StringBuffer sql = new StringBuffer();
		 sql.append(" SELECT ");
		 sql.append(" LOCAL_LOAD as HDLOAD, ");
		 sql.append(" OUTSIDE_WATER_LOAD as WLLOAD, ");
		 sql.append(" WIND_LOAD as FDLOAD, ");
		 sql.append(" PHOTOVOLTAIC_LOAD as GFLOAD, ");
		 sql.append(" DIS_PHOTOVOLTAIC_LOAD as FBSLOAD, ");
		 sql.append(" WATER_FX, ");
		 sql.append(" WATER_NQ, ");
		 sql.append(" WATER_FJ, ");
		 sql.append(" WATER_HX ");
		 sql.append(" FROM "+ Const.LOCAL_LSDN_SCHEMA+".G_REAL_SHANGHAI   ");
		 sql.append(" WHERE INSERT_TIME =    ");
		 sql.append("   (SELECT MAX(INSERT_TIME) ");
		 sql.append("   FROM "+Const.LOCAL_LSDN_SCHEMA+".G_REAL_SHANGHAI ");
		 sql.append("   ) ");
		 return jdbcTemplate.queryForMap(sql.toString());
	 }

}
