package cn.com.liandisys.util.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public abstract class JdbcUtil {
    
    /** 本地数据源（读写） jdbcTemplate */
    @Resource(name = "jdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    
    /**
     * 分页查询方法
     * 
     * @param sql 查询语句
     * @param pageable 分页对象
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Page<? extends Object> getPaginationDatas(String sql, Pageable pageable) {

        Page<? extends Object> pageList = null;
        if (null != pageable) {
            // 查询数据总量
            String countSql = "select count(*) from (" + sql + ")";
            Integer total = jdbcTemplate.queryForObject(countSql, Integer.class);
            // 拼装排序信息
            Sort sort = pageable.getSort();
            String sortStr = "";
            if (null != sort) {
                sortStr = " order by ";
                Iterator<Order> orders = sort.iterator();
                while (orders.hasNext()) {
                    Order o = orders.next();
                    sortStr += o.getProperty() + " " + o.getDirection();
                    if (orders.hasNext()) {
                        sortStr += ", ";
                    }
                }
            }
            // 页码
            int num = pageable.getPageNumber();
            // 每页数据条数
            int size = pageable.getPageSize();
            // 需要查询的最大数据条数
            int last = 0;
            if (total > (num + 1) * size) {
                last = (num + 1) * size;
            } else {
                last = total;
            }
            // 拼接查询语句
            String pageSql = "select * from (select A.*, rownum rn from (" + sql + sortStr + ") A where rownum <= "
                    + last + ") where rn > " + num * size;
            List<Map<String, Object>> content = jdbcTemplate.queryForList(pageSql);
            pageList = new PageImpl(content, pageable, total);
        } else {
            List<Map<String, Object>> content = jdbcTemplate.queryForList(sql);
            pageList = new PageImpl(content, pageable, 0L);
        }
        return pageList;
    }

    /**
     * 分页查询方法
     * 
     * @param sql 查询语句
     * @param params 占位符参数
     * @param pageable 分页对象
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Page<? extends Object> getPaginationDatasSafety(String sql, Object[] params, Pageable pageable) {

        Page<? extends Object> pageList = null;
        if (null != pageable) {
            // 查询数据总量
            String countSql = "select count(*) COUNT from (" + sql + ")";
            Integer total = jdbcTemplate.queryForObject(countSql, params, Integer.class);
            // 拼装排序信息
            Sort sort = pageable.getSort();
            String sortStr = "";
            if (null != sort) {
                sortStr = " order by ";
                Iterator<Order> orders = sort.iterator();
                while (orders.hasNext()) {
                    Order o = orders.next();
                    sortStr += o.getProperty() + " " + o.getDirection();
                    if (orders.hasNext()) {
                        sortStr += ", ";
                    }
                }
            }
            // 页码
            int num = pageable.getPageNumber();
            // 每页数据条数
            int size = pageable.getPageSize();
            // 需要查询的最大数据条数
            int last = 0;
            if (total > (num + 1) * size) {
                last = (num + 1) * size;
            } else {
                last = total;
            }
            // 拼接查询语句
            String pageSql = "select * from (select A.*, rownum rn from (" + sql + sortStr + ") A where rownum <= "
                    + last + ") where rn > " + num * size;
            List<Map<String, Object>> content = jdbcTemplate.queryForList(pageSql, params);
            pageList = new PageImpl(content, pageable, total);
        } else {
            List<Map<String, Object>> content = jdbcTemplate.queryForList(sql, params);
            pageList = new PageImpl(content, pageable, 0L);
        }
        return pageList;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Map<String,Object> getPaginationDatasSafetyNew(String sql, Object[] params, Pageable pageable) {
    	Map map = new HashMap<String, Object>();
        Page<? extends Object> pageList = null;
        if (null != pageable) {
            // 查询数据总量
            String countSql = "select count(*) COUNT from (" + sql + ")";
            Integer total = jdbcTemplate.queryForObject(countSql, params, Integer.class);
            // 拼装排序信息
            Sort sort = pageable.getSort();
            String sortStr = "";
            if (null != sort) {
                sortStr = " order by ";
                Iterator<Order> orders = sort.iterator();
                while (orders.hasNext()) {
                    Order o = orders.next();
                    sortStr += o.getProperty() + " " + o.getDirection();
                    if (orders.hasNext()) {
                        sortStr += ", ";
                    }
                }
            }
            // 页码
            int num = pageable.getPageNumber();
            // 每页数据条数
            int size = pageable.getPageSize();
            // 需要查询的最大数据条数
            int last = 0;
            if (total > (num + 1) * size) {
                last = (num + 1) * size;
            } else {
                last = total;
            }
            // 拼接查询语句
            String pageSql = "select * from (select A.*, rownum rn from (" + sql + sortStr + ") A where rownum <= "
                    + last + ") where rn > " + num * size;
            List<Map<String, Object>> content = jdbcTemplate.queryForList(pageSql, params);
            pageList = new PageImpl(content, pageable, total);
            map.put("total", total);
        } else {
            List<Map<String, Object>> content = jdbcTemplate.queryForList(sql, params);
            pageList = new PageImpl(content, pageable, 0L);
            map.put("total", 0L);
        }
        map.put("data", pageList);
        return map;
    }
    
}
