package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.base;

import java.util.List;
import java.util.Map;

public interface EntryWrwPlantJdbcDao {
	
	/**
     * 查找表中包含所有年份
     */
    public List<Map<String, Object>> getOptions();
	
	//按年查找硫分
	public List<Map<String, Object>> findLfByYear(String year);
	
	//按年查找灰分
	public List<Map<String, Object>> findHfByYear(String year);

}
