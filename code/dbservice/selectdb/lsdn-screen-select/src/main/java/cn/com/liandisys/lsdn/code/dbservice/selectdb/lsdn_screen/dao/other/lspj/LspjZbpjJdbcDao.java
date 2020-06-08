package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj;

import java.util.List;
import java.util.Map;

/**
 * LspjPjGenJdbcDao
 * 操作表O_L_LSPJ_PJ_GEN
 * @author luwl
 *
 */
public interface LspjZbpjJdbcDao {
	
	
	/**
     * 查询火力电厂历史绿色指标排名
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return List<Map<String, Object>>存放数据的列表
     */
    List<Map<String, Object>> queryLszsHistory(String startDate,
			String endDate,String year);
    
    /**
     * 根据电厂id和年份 查询电厂绿色评价数据
     * @param plantId
     * @param year
     * @return
     */
    List<Map<String, Object>> findByPlantIdAndYear(String plantId,String year);

    /**
     * 根据年份统计当年指标评价数据
     * @param year
     * @return
     * @author b_fangzheng
     */
    Map<String, Object> getZbpjStaByYear(String year);

    /**
     * 根据时间和电厂类型获取指标评价数据
     * @param year
     * @param plantType
     * @return
     */
    Map<String, Object> getZbpjStaByYearAndPlantType(String year, String plantType);

    /**
     * 根据年份获取当年电厂指标评价数据（接入容量）
     * @param year
     * @return
     */
    List<Map<String, Object>> getZbpjByYear(String year);

}
