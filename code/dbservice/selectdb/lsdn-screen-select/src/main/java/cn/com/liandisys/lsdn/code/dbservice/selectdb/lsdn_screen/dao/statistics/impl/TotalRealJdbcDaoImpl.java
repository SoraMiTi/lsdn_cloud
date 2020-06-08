package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.TotalRealJdbcDao;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.vo.source.STotalRealVo;
import cn.com.liandisys.util.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 全网实时统计数据
 * 
 * @author b_fangzheng
 */
@Repository("totalRealJdbcDao")
public class TotalRealJdbcDaoImpl extends JdbcUtil implements TotalRealJdbcDao {

	/**
	 * 查询全网实时数据统计中最新一条数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public STotalRealVo getTotalRealData(Timestamp startTime, Timestamp endTime) {

		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" WITH DATAID AS ( ");
		sql.append("   SELECT ID FROM ( ");
		sql.append("     SELECT ID ");
		sql.append("     FROM " + Const.LOCAL_LSDN_SCHEMA + ".S_TOTAL_REAL ");
		sql.append("   WHERE 1=1 ");
		if (startTime != null) {
			sql.append("    AND DATA_TIME >= ? ");
			param.add(startTime);
		}
		if (endTime != null) {
			sql.append("    AND DATA_TIME <= ? ");
			param.add(endTime);
		}
		sql.append("     ORDER BY DATA_TIME DESC ");
		sql.append("   ) ");
		sql.append("   WHERE 1=1 ");
		sql.append("    AND ROWNUM = 1 ");
		sql.append(" ) ");
		sql.append(" SELECT ");
		sql.append("   REALDATA.ID, ");
		sql.append("   REALDATA.PL, ");
		sql.append("   REALDATA.FH, ");
		sql.append("   REALDATA.QJDL, ");
		sql.append("   REALDATA.BDL, ");
		sql.append("   REALDATA.RM_POWER, ");
		sql.append("   REALDATA.RJ_POWER, ");
		sql.append("   REALDATA.GD_POWER, ");
		sql.append("   REALDATA.FD_POWER, ");
		sql.append("   REALDATA.SD_POWER, ");
		sql.append("   REALDATA.DE_POWER, ");
		sql.append("   REALDATA.HD_POWER, ");
		sql.append("   REALDATA.SO2_EMISSIONS, ");
		sql.append("   REALDATA.NOX_EMISSIONS, ");
		sql.append("   REALDATA.PM_EMISSIONS, ");
		sql.append("   REALDATA.GDMH, ");
		sql.append("   REALDATA.FDMH, ");
		sql.append("   REALDATA.SO2_PLANT, ");
		sql.append("   REALDATA.NOX_PLANT, ");
		sql.append("   REALDATA.PM_PLANT, ");
		sql.append("   REALDATA.FDMH_PLANT, ");
		sql.append("   REALDATA.LDPJ_PLANT, ");
		sql.append("   REALDATA.GDMH_PLANT, ");
		sql.append("   REALDATA.GDMH, ");
		sql.append("   REALDATA.FDMH, ");
		sql.append("   REALDATA.PEAK_TYPE1_COUNT, ");
		sql.append("   REALDATA.PEAK_TYPE2_COUNT, ");
		sql.append("   REALDATA.PEAK_TYPE3_COUNT, ");
		sql.append("   REALDATA.PEAK_TYPE4_COUNT, ");
		sql.append("   REALDATA.SO2_EMISSIONS_RATE, ");
		sql.append("   REALDATA.NOX_EMISSIONS_RATE, ");
		sql.append("   REALDATA.PM_EMISSIONS_RATE, ");
		sql.append("   REALDATA.DATA_TIME ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA
				+ ".S_TOTAL_REAL REALDATA ");
		sql.append(" JOIN DATAID ");
		sql.append("   ON DATAID.ID = REALDATA.ID ");

		return jdbcTemplate.queryForObject(sql.toString(), param.toArray(),
				new BeanPropertyRowMapper<STotalRealVo>(STotalRealVo.class));
	}

}
