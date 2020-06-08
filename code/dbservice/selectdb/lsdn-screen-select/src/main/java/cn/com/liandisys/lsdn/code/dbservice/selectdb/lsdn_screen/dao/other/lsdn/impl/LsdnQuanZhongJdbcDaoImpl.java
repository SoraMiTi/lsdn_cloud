package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lsdn.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lsdn.LsdnQuanZhongJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * O_L_LSDN_QUANZHONG
 * 权重表
 * @author luwl
 *
 */
@Repository("lsdnQuanZhongJdbcDao")
public class LsdnQuanZhongJdbcDaoImpl extends JdbcUtil implements
		LsdnQuanZhongJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 获取绿色评价页面中E-Charts图的外面两圈
	 * 
	 * @param type
	 * @param parentid
	 * @return
	 */
	public List<Map<String, Object>> getQuanZhong(String id, boolean isParent, String type) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" SELECT ");
		sql.append(" ID ,");
		sql.append(" NAME ,");
		sql.append(" PARENTID ,");
		sql.append(" VALUE_JB ,");
		sql.append(" VALUE_QJ ,");
		sql.append(" TYPE ,");
		sql.append(" YINZI ,");
		sql.append(" SHORT_NAME ,");
		sql.append(" DISPLAY_QJ ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSDN_QUANZHONG ");
		sql.append(" where type = ? ");
		param.add(type);
		// id为空,且不是父类===查询所有子类
		if (StringUtil.isNullOrBlank(id) && !isParent) {
			sql.append(" AND PARENTID IS NOT NULL ");
		} else if (StringUtil.isNullOrBlank(id) && isParent) {
			// id为空,且是父类======查询所有父类
			sql.append(" AND PARENTID IS NULL ");
		} else if (StringUtil.isNotNullOrBlank(id) && !isParent) {
			// id不为空,且不为父类========查询单个子类
			sql.append(" AND ID =? ");
			param.add(id);
		} else if (StringUtil.isNotNullOrBlank(id) && isParent) {
			// id不为空,且为父类========查询父类下所有子类
			sql.append(" AND PARENTID =? ");
			param.add(id);
		}
		sql.append(" ORDER BY ID ASC ");
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}

}
