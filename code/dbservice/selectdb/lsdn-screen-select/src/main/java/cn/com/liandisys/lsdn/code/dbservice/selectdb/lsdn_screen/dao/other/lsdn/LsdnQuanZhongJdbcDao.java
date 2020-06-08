package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lsdn;

import java.util.List;
import java.util.Map;

/**
 * O_L_LSDN_QUANZHOGN
 * @author luwl
 *
 */
public interface LsdnQuanZhongJdbcDao {
	/**
	 * 获取页面中E-Charts图的外面两圈
	 * @param id 权重ID
	 * @param type 权重类型
	 * @param isParent 是否是父权重
	 * @return
	 */
	List<Map<String, Object>> getQuanZhong(String id,boolean isParent,String type);
	
}
