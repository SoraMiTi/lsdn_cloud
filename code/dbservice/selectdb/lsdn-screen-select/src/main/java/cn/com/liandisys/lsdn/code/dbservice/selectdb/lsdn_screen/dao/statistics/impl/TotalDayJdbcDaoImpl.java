package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.TotalDayJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import org.springframework.stereotype.Repository;

/**
 * 全网每天数据统计数据表 
 * @author b_fangzheng
 *
 */
@Repository("totalDayJdbcDao")
public class TotalDayJdbcDaoImpl extends JdbcUtil implements TotalDayJdbcDao {
    
}
