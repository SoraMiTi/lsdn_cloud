package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.yctp.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.yctp.YctpDetailJdbcDao;
import cn.com.liandisys.util.util.DateUtil;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("yctpDetailJdbcDao")
@Transactional(readOnly = true)
public class YctpDetailJdbcDaoImpl extends JdbcUtil implements YctpDetailJdbcDao {

    /**
     * 查询一次调频详细台账数据
     * @param pageable
     * @param yctpId
     * @return
     */
    @SuppressWarnings("unchecked")
    public Page<Map<String, Object>> search(Pageable pageable, String yctpId) {
        
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append("    SELECT  ");
        sql.append("      ID, ");
        sql.append("      YCTP_ID,  ");
        sql.append("      TO_CHAR(DATA_TIME,'"+ DateUtil.FORMAT_DATE_TIME_ORACLE_MILLI+"') DATA_TIME,  ");
        sql.append("      HZ, ");
        sql.append("      YG, ");
        sql.append("      QSY,  ");
        sql.append("      QJY ");
        sql.append("    FROM O_KH_YCTP_DETAIL ");
        sql.append("    WHERE 1=1 ");
        if(StringUtil.isNotNullOrBlank(yctpId)){
            sql.append("    AND YCTP_ID = ? ");
            param.add(yctpId);
        }

        return (Page<Map<String, Object>>) getPaginationDatasSafety(sql.toString(), param.toArray(), pageable);
    }

    /**
     * 查询一次调频曲线图(秒)数据
     * @param yctpId
     * @return
     */
    public List<Map<String, Object>> findSecLinesData(String yctpId) {

        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
//        sql.append("    SELECT ");
//        sql.append("      TO_CHAR(DATA_TIME,'hh24:mi:ss') AS TIMESECOND, ");
//        sql.append("      AVG(hz) HZ  ");
//        sql.append("    FROM O_KH_YCTP_DETAIL  ");
//        sql.append("    WHERE 1=1  ");
//        if(StringUtil.isNotNullOrBlank(yctpId)){
//            sql.append("    AND YCTP_ID = ?  ");
//            param.add(yctpId);
//        }
//        sql.append("    GROUP BY DATA_TIME ");
//        sql.append("    ORDER BY DATA_TIME ");
        
        sql.append("    WITH YCTP_DATA AS ");
        sql.append("      (SELECT ");
        sql.append("        TO_CHAR(DATA_TIME,'yyyy-MM-dd hh24:mi:ss') AS TIMESECOND,  ");
        sql.append("        HZ  ");
        sql.append("      FROM O_KH_YCTP_DETAIL ");
        sql.append("      WHERE 1=1 ");
        if(StringUtil.isNotNullOrBlank(yctpId)){
            sql.append("      AND YCTP_ID = ? ");
            param.add(yctpId);
        }
        sql.append("      ) ");
        sql.append("    SELECT  ");
        sql.append("      TIMESECOND, ");
        sql.append("      AVG(HZ) HZ ");
        sql.append("    FROM YCTP_DATA  ");
        sql.append("    GROUP BY TIMESECOND ");
        sql.append("    ORDER BY TIMESECOND ASC ");
        
        return jdbcTemplate.queryForList(sql.toString(), param.toArray());
    }
    
    /**
	 * 抓取机组一次调频详细数据
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getGenYctpDetail(String yctpId) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" SELECT ID,YCTP_ID,HZ, ");
		sql.append(" YG,QSY,QJY,SJPC, ");
		sql.append(" TO_CHAR(DATA_TIME,'yyyy-MM-dd hh24:mi:ss.ff') AS DATA_TIME ");
		sql.append(" FROM O_KH_YCTP_DETAIL ");
		sql.append(" WHERE 1=1  ");
		 if(StringUtil.isNotNullOrBlank(yctpId)){
           sql.append("      AND YCTP_ID = ? ");
           param.add(yctpId);
       }
		sql.append(" ORDER BY SJPC ASC ");
//        sql.append(" WITH BASE_DATA AS ");
//        sql.append("   ( ");
//        sql.append("   SELECT TO_CHAR(DATA_TIME,'yyyy-MM-dd hh24:mi:ss') TIMESECOND, ");
//        sql.append("     NVL(AVG(HZ),0) HZ, ");
//        sql.append("     NVL(AVG(YG),0) YG, ");
//        sql.append("     NVL(AVG(QSY),0) QSY, ");
//        sql.append("     NVL(AVG(QJY),0) QJY ");
//        sql.append("   FROM O_KH_YCTP_DETAIL ");
//        sql.append("   WHERE 1     =1 ");
//        sql.append("   AND ROWNUM > 0 AND ROWNUM <100 ");
//        if(StringUtil.isNotNullOrBlank(yctpId)){
//            sql.append("      AND YCTP_ID = ? ");
//            param.add(yctpId);
//        }
//        sql.append("   GROUP BY TO_CHAR(DATA_TIME,'yyyy-MM-dd hh24:mi:ss') ");
//        sql.append("   ORDER BY TO_CHAR(DATA_TIME,'yyyy-MM-dd hh24:mi:ss') ASC ");
//        sql.append("   ) ");
////        sql.append("   ,MIN_TIME AS ");
////        sql.append("   ( SELECT TIMESECOND AS MIN_TIMESECOND FROM BASE_DATA WHERE ROWNUM = 1 ");
////        sql.append("   ) ");
//        sql.append(" SELECT BASE.TIMESECOND, ");
//        sql.append("     BASE.HZ, ");
//        sql.append("     BASE.YG, ");
//        sql.append("     BASE.QSY, ");
//        sql.append("     BASE.QJY ");
//        sql.append("     ,ROWNUM MISTIMING ");
////        sql.append("     ,CEIL((TO_DATE(BASE.TIMESECOND,'yyyy-MM-dd hh24:mi:ss') - ");
////        sql.append("        TO_DATE(MINTIME.MIN_TIMESECOND,'yyyy-MM-dd hh24:mi:ss')) * 24 * 60 * 60) AS MISTIMING ");
//        sql.append(" FROM BASE_DATA BASE ");
////        sql.append("   ,MIN_TIME MINTIME ");
		
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

}
