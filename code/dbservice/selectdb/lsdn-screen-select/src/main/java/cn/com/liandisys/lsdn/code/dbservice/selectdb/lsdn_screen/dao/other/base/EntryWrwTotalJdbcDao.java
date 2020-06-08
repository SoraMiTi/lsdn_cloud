package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.base;

import java.util.List;
import java.util.Map;

public interface EntryWrwTotalJdbcDao {

	
	/**
     * 装机容量、发电量、燃煤量的关系曲线
     */
    public List<Map<String, Object>> getTotalLine();
	
	/**
     * 燃煤硫分的曲线图
     */
    public List<Map<String, Object>> searchLFLine();
	
	/**
     * 燃煤灰分的曲线图
     */
    public List<Map<String, Object>> searchHFLine();
	
}
