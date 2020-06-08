package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.index;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.index.IndexEntity;

import java.util.List;
import java.util.Map;


/**
 * BS_HOME_INDEX jdbc接口层
 * @author MrLu
 *
 */
public interface IndexJdbcDao {
	
	/**
	 * 根据电厂和指标类型获取机组数据
	 * @param type
	 * @param plantId
	 * @return
	 */
	List<IndexEntity> findGenIndexByPlantId(String type, String plantId);

	/**
	 * 根据电厂查询机组深度调峰数据
	 * @param plantId
	 * @return
	 */
	List<Map<String, Object>> getJzsdtf(String plantId);
}
