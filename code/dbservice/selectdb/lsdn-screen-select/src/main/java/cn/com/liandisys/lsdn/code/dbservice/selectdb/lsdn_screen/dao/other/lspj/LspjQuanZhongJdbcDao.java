package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj;

import java.util.List;
import java.util.Map;

/**
 * 绿色评价-绿电评价页面 LdpjJdbcDao
 * 操作表O_L_LSPJ_QUANZHONG
 * @author luwl
 *
 */
public interface LspjQuanZhongJdbcDao {
	/**
	 * 获取页面中E-Charts图的外面两圈
	 * @param id 权重ID
	 * @param type 权重类型
	 * @param isParent 是否是父权重
	 * @return
	 */
	List<Map<String, Object>> getQuanZhong(String id,boolean isParent,String type);

	/**
	 * 获取绿色评价-综合评价-数据收集评价页面 - 电能绿色指数评价权重数据
	 * @return
	 */
    List<Map<String, Object>> getSjsjpjData();
	
}
