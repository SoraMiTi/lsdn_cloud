package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen;

import java.util.Map;

/**
 * G_REAL_SHANGHAI dao层接口类
 * @author MrLu
 *
 */
public interface RealSHJdbcDao {
	
	
	/**
	  * 获取最新的一条出力数据
	  * @return
	  */
	 Map<String,Object> getRealLoad();

}
