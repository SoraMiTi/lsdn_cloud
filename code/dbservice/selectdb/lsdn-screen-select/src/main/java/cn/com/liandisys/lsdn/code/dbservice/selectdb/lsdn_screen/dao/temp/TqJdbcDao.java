package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.temp;

import java.util.List;
import java.util.Map;

/**
 * 光伏台区展示临时用接口
 * @author b_fangzheng
 *
 */
public interface TqJdbcDao {

    /**
     * 获取光伏台区基本数据
     * @return
     */
    List<Map<String, Object>> getPvtqData();

}
