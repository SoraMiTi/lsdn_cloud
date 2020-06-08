package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.base;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * O_B_NOTICE的Dao
 *
 * @author b_wuxl
 */
public interface NoticeDao extends JpaRepository<NoticeEntity, String>, JpaSpecificationExecutor<NoticeEntity> {
}
