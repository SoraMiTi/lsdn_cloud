package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.vo.source.STotalRealVo;

import java.sql.Timestamp;


/**
 * 全网实时数据统计数据表
 * 
 * @author b_fangzheng
 *
 */
public interface TotalRealJdbcDao {
	/**
     * 查询全网实时数据统计中最新一条数据
     * （根据统计表统计时间切面间隔取间隔中最新一条数据）
     * @param startTime 
     * @param endTime 
     * @return
     */
    STotalRealVo getTotalRealData(Timestamp startTime, Timestamp endTime);
}
