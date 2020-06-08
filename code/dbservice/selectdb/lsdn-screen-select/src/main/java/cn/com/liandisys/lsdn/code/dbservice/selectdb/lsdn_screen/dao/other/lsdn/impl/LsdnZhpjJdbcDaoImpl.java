package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lsdn.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lsdn.LsdnZhpjJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * O_L_LSDN_ZHPJ
 * 
 * @author MrLu
 *
 */
@Repository("lsdnZhpjJdbcDao")
public class LsdnZhpjJdbcDaoImpl extends JdbcUtil implements LsdnZhpjJdbcDao {

	//获取其中一条数据
	public List<Map<String, Object>> getOne() {
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ZHPJ.* ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSDN_ZHPJ ZHPJ ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

}
