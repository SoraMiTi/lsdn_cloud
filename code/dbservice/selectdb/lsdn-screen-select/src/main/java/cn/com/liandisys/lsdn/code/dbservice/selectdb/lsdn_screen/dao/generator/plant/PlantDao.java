package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.plant;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BasePlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 机组的Dao
 *
 * @author b_fangzheng
 */
public interface PlantDao extends JpaRepository<BasePlantEntity, String>, JpaSpecificationExecutor<BasePlantEntity> {
    
    @Query("select e from BasePlantEntity e where e.tyzt = '1' and e.type in ('1', '2') order by e.jt.name ")
    public List<BasePlantEntity> findAllAvalibleInfo();

    /**
     * 通过集团id查询已投运的下级设备
     * @param ssjtId
     * @return
     */
    public List<BasePlantEntity> findBySsjtAndTyzt(String ssjtId, String tyzt);
}
