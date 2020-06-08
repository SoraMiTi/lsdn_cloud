package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.yctp;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.yctp.KhYctpDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * 考核-一次调频-相关机组数据的Dao
 *
 * @author b_wuxl
 */
public interface YctpDetailDao extends JpaRepository<KhYctpDetailEntity, String>, JpaSpecificationExecutor<KhYctpDetailEntity> {
}
