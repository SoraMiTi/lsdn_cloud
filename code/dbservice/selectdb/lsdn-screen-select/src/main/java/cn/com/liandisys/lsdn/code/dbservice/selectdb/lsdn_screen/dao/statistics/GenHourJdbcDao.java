package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 各机组小时统计表
 * @author b_fangzheng
 *
 */
public interface GenHourJdbcDao {

    /**
     * 根据时间段和电厂，在小时统计表中分组统计电厂下所有机组相关数据
     * @param startTime
     * @param endTime
     * @param plantId
     * @return
     */
    List<Map<String, Object>> staSGenHourOrderByGen(Date startTime, Date endTime, String plantId);

    /**
     * 根据时间段，在小时统计表中分组统计所有电厂相关数据
     * @param startTime
     * @param endTime
     * @param plantId
     * @return
     */
    List<Map<String, Object>> staSGenHourOrderByPlant(Date startTime, Date endTime);

    /**
     * 根据时间查询设备排放数据，电厂和机组全为空时，查询全网数据
     * @param startTime
     * @param endTime
     * @param plantId
     * @param genId
     * @return
     */
    List<Map<String, Object>> getStaHourList(Date startTime, Date endTime, String plantId, String genId);
    
    /**
     * 根据时间查询设备电厂下机组排放量
     * @param startTime
     * @param endTime
     * @param plantId
     * @return
     */
    List<Map<String, Object>> getCoalByPlantId(Date startTime, Date endTime, String plantId);

    /**
     * 从机组小时表中获取日报列表数据
     * @param plantId
     * @param day
     * @return
     */
    List<Map<String, Object>> getDayReport(String plantId, String day);
    
    
    
    
    
    // TODO  煤耗页面部分
    /**
     * 根据时间查询【时间段各集团发电平均煤耗和累计发电量】
     * 
     * @param startTime 时间格式  yyyy
     * @param endTime 时间格式 yyyy
     * @return
     */
    List<Map<String, Object>> staByGroup(String startTime, String endTime);
    
    /**
     * 根据时间查询【时间段各容量等级机组发电平均煤耗和累计发电量】
     * 
     * @param startTime 时间格式  yyyy
     * @param endTime 时间格式 yyyy
     * @return
     */
    List<Map<String, Object>> staByCapacity(String startTime, String endTime);

    
}
