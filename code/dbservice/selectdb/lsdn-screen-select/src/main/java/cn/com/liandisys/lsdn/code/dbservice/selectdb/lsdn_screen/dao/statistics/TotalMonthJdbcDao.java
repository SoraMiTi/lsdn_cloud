package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.vo.source.STotalMonthVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 全网月度数据统计数据表
 * 
 * @author b_fangzheng
 *
 */
public interface TotalMonthJdbcDao {

	/**
	 * 获取date的年的第一天到当前天的减排量
	 * 
	 * @param date
	 * @return
	 */
	Map<String, Object> getJplByDate(Date date);

	/**
	 * 获取每个月各种排放量和减排量
	 * 
	 * @return
	 */
	List<Map<String, Object>> getEmissionsAndJpl();

	/**
	 * 查询今年到当前时间的(SO2/NOX/烟尘)减排量和上一年到当前时间的(SO2/NOX/烟尘)减排量和同比
	 * 
	 * @param date
	 * @return
	 */
	List<Map<String, Object>> getEmissionsRateByDate(String date);

	/**
	 * 全上海的平均SO2、NOX、烟尘排放浓度和煤耗
	 */
	List<Map<String, Object>> getEmissionsByMonth();

	/**
	 * 根据年度数据查询充电桩、三联供、虚拟电厂累计数据
	 * 
	 * @param year
	 * @return
	 */
	List<STotalMonthVo> getTotalByYear(String year);

	/**
	 * 查询月度统计数据
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	List<STotalMonthVo> getMonthData(String year, String month);

	/**
	 * 获取清洁能源占比
	 * 
	 * @param date
	 * @return
	 */
	List<Map<String, Object>> getCleanEnergyGenerationRatio(String date);

	/**
	 * 获取清洁能源减排统计
	 * 
	 * @param date
	 * @return
	 */
	List<Map<String, Object>> getCleanEnergyEmissionStatistics(String date);

}
