package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.agc.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.agc.AgcXyJdbcDao;
import cn.com.liandisys.util.util.DateUtil;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("agcXyJdbcDao")
public class AgcXyJdbcDaoImpl extends JdbcUtil implements AgcXyJdbcDao {

    /**
     * 分页查询AGC响应数据
     * @param pageable
     * @param plantId
     * @param genId
     * @param startTime
     * @param endTime
     * @return
     */
    @SuppressWarnings("unchecked")
    public Page<Map<String, Object>> search(Pageable pageable, String plantId, String genId, Timestamp startTime,
            Timestamp endTime) {
        
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append("    WITH PLANT AS ");
        sql.append("      (SELECT * ");
        sql.append("      FROM G_BASE_PLANT ");
        sql.append("      WHERE TYZT = '"+ Const.COMM_CODE.TYZT_YES+"'  ");
        if(StringUtil.isNotNullOrBlank(plantId)){
            sql.append("      AND ID = ?  ");
            param.add(plantId);
        }
        sql.append("      ),  ");
        sql.append("      GEN AS  ");
        sql.append("      (SELECT * ");
        sql.append("      FROM G_BASE_GENERATOR ");
        sql.append("      WHERE TYZT = '"+Const.COMM_CODE.TYZT_YES+"'  ");
        if(StringUtil.isNotNullOrBlank(genId)){
            sql.append("      AND ID = ?  ");
            param.add(genId);
        }
        sql.append("      ) ");
        sql.append("    SELECT ");
        sql.append("      XY.ID,  ");
        sql.append("      PLANT.SHORT_NAME PLANT_NAME, ");
        sql.append("      GEN.NAME GEN_NAME, ");
        sql.append("      GEN_ID,  ");
        sql.append("      P0,  ");
        sql.append("      P1,  ");
        sql.append("      P1H, ");
        sql.append("      P1L, ");
        sql.append("      DT,  ");
        sql.append("      TO_CHAR(START_TIME,'"+ DateUtil.FORMAT_DATE_TIME_ORACLE+"') START_TIME,  ");
        sql.append("      TO_CHAR(T2,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') T2,  ");
        sql.append("      TO_CHAR(T3,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') T3,  ");
        sql.append("      TO_CHAR(T4,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') T4,  ");
        sql.append("      TO_CHAR(T5,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') T5,  ");
        sql.append("      TO_CHAR(T6,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') T6,  ");
        sql.append("      ALRR,  ");
        sql.append("      LRT, ");
        sql.append("      TO_CHAR(CREATE_TIME,'"+DateUtil.FORMAT_DATE_TIME_ORACLE+"') CREATE_TIME  ");
        sql.append("    FROM O_KH_AGC_XY XY  ");
        sql.append("    JOIN GEN  ");
        sql.append("    ON GEN.ID = XY.GEN_ID  ");
        sql.append("    JOIN PLANT ");
        sql.append("    ON PLANT.ID = GEN.PLANT_ID ");
        sql.append("    WHERE 1 = 1  ");
        if(startTime != null){            
            sql.append("    AND XY.START_TIME >= ? ");
            param.add(startTime);
        }
        if(endTime != null){            
            sql.append("    AND XY.START_TIME <= ? ");
            param.add(endTime);
        }

        return (Page<Map<String, Object>>) getPaginationDatasSafety(sql.toString(), param.toArray(), pageable);
    }

}
