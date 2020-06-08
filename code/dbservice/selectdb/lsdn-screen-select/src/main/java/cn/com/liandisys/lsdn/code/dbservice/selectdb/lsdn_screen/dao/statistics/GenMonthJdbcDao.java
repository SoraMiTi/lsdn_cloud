package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics;

import java.util.List;
import java.util.Map;

/**
 * 各机组月统计表
 * @author b_fangzheng
 *
 */
public interface GenMonthJdbcDao {

    /**
     * 从机组月统计表中获取年报列表数据
     * @param plantId
     * @param year
     * @return
     */
    List<Map<String, Object>> getYearReport(String plantId, String year);

    /**
     * 在机组表中统计电厂下各机组该年的平均煤耗
     * @param plantId
     * @param thisYear
     * @return
     */
    List<Map<String, Object>> getStaGenByYear(String plantId, String year);

    /**
     * 统计全网各电厂该年的平均煤耗
     * @param thisYear
     * @return
     */
    List<Map<String, Object>> getStaPlantByYear(String year);

    /**
     * 根据设备查询【设备该年各月煤耗对比情况】
     * @param year
     * @param plantId
     * @param genId
     * @return
     */
    List<Map<String, Object>> getStaMonthByYear(String year, String plantId, String genId);
    
    /**
     * 根据电厂id获取so2，nox，pm，煤耗的排放量
     * @param platnId
     * @return
     */
    List<Map<String,Object>> getEmissionsByPlantId(String platnId);
    
}
