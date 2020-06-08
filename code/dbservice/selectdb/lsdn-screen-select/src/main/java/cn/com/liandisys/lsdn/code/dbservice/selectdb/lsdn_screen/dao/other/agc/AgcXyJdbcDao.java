package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.agc;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.Map;

/**
 * 考核管理-AGC响应DAO
 * @author b_wuxl
 *
 */
public interface AgcXyJdbcDao {

    /**
     * 分页查询AGC响应数据
     * @param pageable
     * @param plantId
     * @param genId
     * @param startTime
     * @param endTime
     * @return
     */
    Page<Map<String, Object>> search(Pageable pageable, String plantId, String genId, Timestamp startTime,
            Timestamp endTime);


}
