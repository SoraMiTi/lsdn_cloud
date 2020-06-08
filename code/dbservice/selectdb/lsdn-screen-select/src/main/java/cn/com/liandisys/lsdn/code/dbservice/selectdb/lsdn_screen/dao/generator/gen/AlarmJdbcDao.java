package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 机组告警数据表
 * @author b_fangzheng
 *
 */
public interface AlarmJdbcDao {

    /**
     * 根据时间查询和电厂【超标小时数】 时间段类型下所有机组各指标超标小时数，电厂为空时查询全网数据
     * 
     * @param plantId 电厂编号
     * @param startTime 统计超标开始时间
     * @param endTime 统计超标结束时间
     * @return
     */
    List<Map<String, Object>> getOverStandard(String plantId, Date startTime, Date endTime);

}
