package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj;

import java.util.List;
import java.util.Map;

/**
 * 综合评价表 操作表：O_L_LSPJ_ZHPJ
 * 
 * @author luwl
 *
 */
public interface LspjZhpjJdbcDao {

	// /** 获取最新的指标时间 */
	// String getLatestNY();

	/**
	 * 查询电科院(全部)数据
	 * 
	 * @return
	 */
	List<Map<String, Object>> getDkyList();

	/**
	 * 查询集团数据
	 * 
	 * @param jtId
	 *            集团id 查询全部(is null)/查询单个( is not null)
	 * @return
	 */
	List<Map<String, Object>> getJtList(String jtId);

	/**
	 * 查询电厂数据
	 * plantId is not null						查询单个电厂 
	 * jtId is not null 						查询单个集团下所有电厂 
	 * jtId is null && plantId is null    		查询所有电厂
	 * jtId is not null && plantId is not null  查询单个集团下的单个电厂
	 * 
	 * @param plantId
	 *            电厂id
	 * @param jtId
	 * 			 集团id
	 * @return
	 */
	List<Map<String, Object>> getDcList(String plantId, String jtId);

	/**
	 * 查询机组数据
	 * genId is not null 查询单个机组数据 
	 * plantId is not null 查询单个电厂下所有机组数据
	 * genId is null && plantId is null 查询所有机组
	 * genId is not null && plantId is not null 查询单个电厂下单个机组数据
	 * @param genId
	 *            机组id
	 * @param plantId
	 * 			  电厂id
	 * @return
	 */
	List<Map<String, Object>> getJzList(String genId, String plantId);

	/**
	 * 获取技术的环保指标数据
	 * 
	 * @param genType
	 *            机组的燃料类型
	 * @return
	 */
	List<Map<String, Object>> getHBZBByPlantType(String plantType);

	/**
	 * 根据 时间范围查询集团的AVG(LSZB)
	 * 
	 * @param flag
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String, Object>> getJiTuanLszbByTime(String startTime,
			String endTime);

	/**
	 * 根据 时间范围查询电厂的AVG(LSZB)
	 * 
	 * @param flag
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String, Object>> getDianChangLszbByTime(String startTime,
			String endTime);
}
