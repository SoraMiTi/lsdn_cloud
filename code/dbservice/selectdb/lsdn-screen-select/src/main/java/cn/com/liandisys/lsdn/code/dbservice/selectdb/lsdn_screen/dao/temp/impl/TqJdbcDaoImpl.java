package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.temp.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.temp.TqJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 光伏台区展示临时用接口
 * @author b_fangzheng
 *
 */
@Repository("tqJdbcDao")
public class TqJdbcDaoImpl extends JdbcUtil implements TqJdbcDao {

    /**
     * 获取光伏台区基本数据
     * @return
     */
    public List<Map<String, Object>> getPvtqData() {
        StringBuffer sql = new StringBuffer();
        
        sql.append(" SELECT ");
        sql.append("   TQ_ID PVID, ");
        sql.append("   ADDRESS NAME, ");
        sql.append("   LNG, ");
        sql.append("   LAT, ");
        sql.append("   '1' DIRECTION, ");
        sql.append("   COMPANY_ID, ");
        sql.append("   TO_CHAR(GF_BWSJ,'yyyy') year, ");
        sql.append("   PMS_COMPANY_ID ");
        sql.append(" FROM B_BASE_PMS_GFTQ ");
        sql.append(" WHERE GF_BWSJ IS NOT NULL ");
        sql.append(" ORDER BY TO_CHAR(GF_BWSJ,'yyyy') ASC ");
//        sql.append(" SELECT ");
//        sql.append("   TQ_ID PVID, ");
//        sql.append("   ADDRESS NAME, ");
//        sql.append("   PB.LNG, ");
//        sql.append("   PB.LAT, ");
//        sql.append("   '1' DIRECTION, ");
//        sql.append("   COMP.COMPANY_ID ");
//        sql.append(" FROM P_TEMP_PMS_TQ TQ ");
//        sql.append(" JOIN P_ZNYC_PDBYQ PB ");
//        sql.append("   ON PB.SBID = TQ.SBID ");
//        sql.append(" JOIN P_TEMP_PMS_COMPANY COMP ");
//        sql.append("   ON COMP.PMS_ID = PB.YXDW ");
//        sql.append(" ORDER BY COMPANY_ID ASC ");
        
        return jdbcTemplate.queryForList(sql.toString());
        
    }
}
