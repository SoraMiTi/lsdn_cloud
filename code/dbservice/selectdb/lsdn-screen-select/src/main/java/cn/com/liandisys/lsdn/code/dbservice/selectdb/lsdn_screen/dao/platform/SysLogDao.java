package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.platform;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.platform.SysLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * 系统日志的Dao
 * 
 * @author DYQ
 */
public interface SysLogDao extends JpaRepository<SysLogEntity, String>, JpaSpecificationExecutor<SysLogEntity> {

}
