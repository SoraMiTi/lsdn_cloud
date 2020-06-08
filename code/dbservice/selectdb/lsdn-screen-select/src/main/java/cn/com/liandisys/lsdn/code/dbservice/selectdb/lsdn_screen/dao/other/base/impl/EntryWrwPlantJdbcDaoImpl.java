package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.base.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.base.EntryWrwPlantJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository("oBEntryWrwPlantJdbcDao")
public class EntryWrwPlantJdbcDaoImpl extends JdbcUtil implements EntryWrwPlantJdbcDao {

	//电厂月度统计表
	private String dataTableName = Const.LOCAL_LSDN_SCHEMA + ".O_B_ENTRY_WRW_PLANT";
	// 电厂台账表
    private String plantTableName = Const.LOCAL_LSDN_SCHEMA + ".G_BASE_PLANT";
	
	/**
     * 查找表中包含所有年份
     */
	@Override
    public List<Map<String, Object>> getOptions() {

        StringBuffer sb = new StringBuffer();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //拼接sql语句
        sb.append("select distinct to_char(DATA_TIME,'yyyy') YEAR from "+dataTableName+" order by to_char(DATA_TIME,'yyyy')");
        list = jdbcTemplate.queryForList(sb.toString());
        return list;
    }
	
	
	/**
     * 按年查找硫分
     */
	@Override
    public List<Map<String, Object>> findLfByYear(String year) {

        StringBuffer sb = new StringBuffer();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //拼接sql语句
        sb.append("SELECT  D.RMLF AS RMLF, P.SHORT_NAME AS PLANTNAME");
        sb.append(" FROM");
        sb.append(" (select round(avg(RMLF),2) RMLF , PLANT_ID from "+dataTableName);
        sb.append(" WHERE ");
        sb.append(" to_char(DATA_TIME,'yyyy') = '");
        sb.append(year);
        sb.append("' GROUP BY PLANT_ID ) D ");
        sb.append(" LEFT JOIN "+plantTableName+" P ON P.ID = D.PLANT_ID ");
        list = jdbcTemplate.queryForList(sb.toString());
        return list;
    }
	
	/**
     * 按年查找灰分
     */
	@Override
    public List<Map<String, Object>> findHfByYear(String year) {

		StringBuffer sb = new StringBuffer();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //拼接sql语句
        sb.append("SELECT  D.RMHF AS RMHF, P.SHORT_NAME AS PLANTNAME");
        sb.append(" FROM");
        sb.append(" (select round(avg(RMHF),2) RMHF , PLANT_ID from "+dataTableName);
        sb.append(" WHERE ");
        sb.append(" to_char(DATA_TIME,'yyyy') = '");
        sb.append(year);
        sb.append("' GROUP BY PLANT_ID ) D ");
        sb.append(" LEFT JOIN "+plantTableName+" P ON P.ID = D.PLANT_ID ");
        list = jdbcTemplate.queryForList(sb.toString());
        return list;
    }
	
}
