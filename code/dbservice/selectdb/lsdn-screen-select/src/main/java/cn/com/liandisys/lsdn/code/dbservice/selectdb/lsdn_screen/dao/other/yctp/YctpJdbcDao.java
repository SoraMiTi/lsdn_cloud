package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.yctp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 专项考核-一次调频
 * @author b_wuxl
 *
 */
public interface YctpJdbcDao {

    /**
     * 查询一次调频数据
     * @param pageable
     * @param plantId 
     * @param genId 
     * @param startTime 
     * @param endTime 
     * @return
     */
    Page<Map<String, Object>> search(Pageable pageable, String plantId, String genId, Timestamp startTime, Timestamp endTime);

    /**
     * 查询一次调频台账数据
     * @param pageable
     * @param startTime
     * @param endTime
     * @return
     */
    Page<Map<String, Object>> searchByMonth(Pageable pageable, Timestamp startTime, Timestamp endTime);
    
    /**
     * 抓取机组一次调频数据
     * @param plantId
     * @param genId
     * @return
     */
    List<Map<String, Object>> getGenYctp(String startTime,String endTime,String plantId,String genId,String isShow);

}
