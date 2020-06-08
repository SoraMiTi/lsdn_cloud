package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.yctp;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.yctp.KhYctpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * O_KH_YCTP的Dao
 *
 * @author b_wuxl
 */
public interface YctpDao extends JpaRepository<KhYctpEntity, String>, JpaSpecificationExecutor<KhYctpEntity> {
}
