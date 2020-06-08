package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics;

import java.util.List;
import java.util.Map;


/**
 * 各电厂实时统计数据
 * 
 * @author b_fangzheng
 */
public interface PlantRealJdbcDao {

    /**
     * 获取电厂最新一条实时统计数据
     * @return
     */
    List<Map<String, Object>> getPlantRealSta(String pantId);
    
    
    /**
     * 查询该月份风电电厂产生的电量
     * @param date 'yyyy-mm'格式
     */
    List<Map<String,Object>> getWindDlByMonth(String date);
    
}
