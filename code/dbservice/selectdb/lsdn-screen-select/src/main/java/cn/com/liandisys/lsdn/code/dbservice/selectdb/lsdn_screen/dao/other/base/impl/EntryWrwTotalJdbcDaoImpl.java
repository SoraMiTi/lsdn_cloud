package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.base.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.base.EntryWrwTotalJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository("oBEntryWrwTotalJdbcDao")
public class EntryWrwTotalJdbcDaoImpl extends JdbcUtil implements EntryWrwTotalJdbcDao {
	
	//全网月度统计表
	private String dataTableName = Const.LOCAL_LSDN_SCHEMA + ".O_B_ENTRY_WRW_TOTAL";
	
	/**
     * 装机容量、发电量、燃煤量的关系曲线
     */
	@Override
    public List<Map<String, Object>> getTotalLine() {

        StringBuffer sb = new StringBuffer();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //拼接sql语句
        sb.append(" select round(SUM(ZJRL),2) ZJRL, round(SUM(LJDL),2) LJDL,");
        sb.append(" round(SUM(RML),2) RML, round(avg(GDMH),2) GDMH, ");
        sb.append(" to_char(DATA_TIME,'yyyy') YEAR from "+dataTableName);
        sb.append(" GROUP BY to_char(DATA_TIME,'yyyy') ");
        sb.append(" order by to_char(DATA_TIME,'yyyy') ");
        list = jdbcTemplate.queryForList(sb.toString());
        return list;
    }
	
	/**
     * 燃煤硫分的曲线图
     */
	@Override
    public List<Map<String, Object>> searchLFLine() {

        StringBuffer sb = new StringBuffer();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //拼接sql语句
        sb.append("select round(avg(RMLF),2) RMLF, ");
        sb.append(" to_char(DATA_TIME,'yyyy') YEAR");
        sb.append(" from "+dataTableName);
        sb.append(" GROUP BY to_char(DATA_TIME,'yyyy') ");
        sb.append(" order by to_char(DATA_TIME,'yyyy') ");
        list = jdbcTemplate.queryForList(sb.toString());
        return list;
    }
	
	/**
     * 燃煤灰分的曲线图
     */
	@Override
    public List<Map<String, Object>> searchHFLine() {

        StringBuffer sb = new StringBuffer();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //拼接sql语句
        sb.append("select round(avg(RMHF),2) RMHF, ");
        sb.append(" to_char(DATA_TIME,'yyyy') YEAR");
        sb.append(" from "+dataTableName);
        sb.append(" GROUP BY to_char(DATA_TIME,'yyyy') ");
        sb.append(" order by to_char(DATA_TIME,'yyyy') ");
        list = jdbcTemplate.queryForList(sb.toString());
        return list;
    }
	
}
