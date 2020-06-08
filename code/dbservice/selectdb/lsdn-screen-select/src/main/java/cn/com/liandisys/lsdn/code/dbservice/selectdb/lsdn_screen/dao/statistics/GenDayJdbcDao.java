package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics;

import java.util.List;
import java.util.Map;


/**
 * 各机组日统计表
 * @author b_fangzheng
 *
 */
public interface GenDayJdbcDao {

    /**
     * 从机组日统计表中获取月报列表数据
     * @param plantId
     * @param month
     * @return
     */
    List<Map<String, Object>> getMonthReport(String plantId, String month);
    
}
