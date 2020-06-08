package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.plant;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BaseSubstationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * T_O1003_厂站台账数据的Dao
 *
 * @author b_wuxl
 */
public interface SubstationDao extends JpaRepository<BaseSubstationEntity, String>, JpaSpecificationExecutor<BaseSubstationEntity> {
}
