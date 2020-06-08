package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * 各机组实时统计数据
 * 
 * @author b_fangzheng
 */
public interface GenRealJdbcDao {

	/**
     * 抓取机组实时统计数据（最新一条）
     * @param genId 机组Id  如果有机组Id，则获取该机组最新一条数据,如果没有机组Id,则获取所有机组最新数据
     * @return
     */
    List<Map<String, Object>> getGenRealSta(String genId);
	
	/**
     * 抓取机组跳闸数据
     * @param plantId
     * @param genId
     * @return
     */
	Page<Map<String, Object>> getGenRealAccIdent(String startTime,String endTime,String plantId,String genId,Pageable pageable);
	
}
