package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen.GenJdbcDao;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BaseGeneratorEntity;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 机组台账表
 * @author b_fangzheng
 *
 */
@Repository("genJdbcDao")
public class GenJdbcDaoImpl extends JdbcUtil implements GenJdbcDao {
    /**
     * 抓取机组下拉列表数据
     * @param plantId
     * @return
     */
    public List<BaseGeneratorEntity> getGenByPlant(String plantId) {
       List<BaseGeneratorEntity> data = new ArrayList<BaseGeneratorEntity>();
       StringBuffer sql = new StringBuffer();
       List<Object> param = new ArrayList<Object>();
       
       sql.append(" SELECT ");
       sql.append("   * ");
       sql.append(" FROM "+ Const.LOCAL_LSDN_SCHEMA+".G_BASE_GENERATOR ");
       sql.append(" WHERE 1=1 ");
       sql.append("   AND TYZT = ? ");
       param.add(Const.COMM_CODE.TYZT_YES);
       if(StringUtil.isNotNullOrBlank(plantId)) {
           sql.append("   AND PLANT_ID = ? ");
           param.add(plantId);
       }
       sql.append(" ORDER BY ORDER_ID ");
       
       try {
           data = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<BaseGeneratorEntity>(BaseGeneratorEntity.class));
       } catch (Exception e) {
//           new LogbackException("封装电厂下机组数据出错！");
       }
       return data;
    }
}
