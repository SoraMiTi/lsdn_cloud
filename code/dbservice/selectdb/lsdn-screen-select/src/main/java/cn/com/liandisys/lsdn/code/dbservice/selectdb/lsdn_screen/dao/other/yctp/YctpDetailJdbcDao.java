package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.yctp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


public interface YctpDetailJdbcDao {

    /**
     * 查询一次调频详细台账数据
     * @param pageable
     * @param yctpId
     * @return
     */
    Page<Map<String, Object>> search(Pageable pageable, String yctpId);

    /**
     * 查询一次调频曲线图(秒)数据
     * @param yctpId
     * @return
     */
    List<Map<String, Object>> findSecLinesData(String yctpId);
    
    
    /**
	 * 抓取机组一次调频详细数据
	 * 
	 * @param plantId
	 * @param genId
	 * @return
	 */
	List<Map<String, Object>> getGenYctpDetail(String yctpId);

}
