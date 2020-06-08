package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.group;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BaseGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * T_01002_发电集团台账的Dao
 *
 * @author b_wuxl
 */
public interface GroupDao extends JpaRepository<BaseGroupEntity, String>, JpaSpecificationExecutor<BaseGroupEntity> {

//    BaseGroupEntity findByNameAndIdNot(String name, String id);
}
