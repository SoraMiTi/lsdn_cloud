package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BaseGeneratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 机组的Dao
 *
 * @author b_fangzheng
 */
public interface GenDao extends JpaRepository<BaseGeneratorEntity, String>, JpaSpecificationExecutor<BaseGeneratorEntity> {
    
    @Query("select e from BaseGeneratorEntity e where e.tyzt = '1' ")
    public List<BaseGeneratorEntity> findAllAvalibleInfo();

    /**
     * 通过电厂id查询已投运下级设备
     * @param plantId
     * @return
     */
    public List<BaseGeneratorEntity> findByPlantIdAndTyzt(String plantId, String tyzt);
}
