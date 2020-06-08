package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.base;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryWrwPlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 电厂月度数据表，单表维护，不做统计的Dao
 *
 * @author b_fangzheng
 */
public interface EntryWrwPlantDao extends JpaRepository<EntryWrwPlantEntity, String>, JpaSpecificationExecutor<EntryWrwPlantEntity> {

    /**
     * 根据时间和电厂ID查询当前数据是否已经存在
     * @param year
     * @param plantId
     * @return
     */
    @Query("select A.id from EntryWrwPlantEntity A where to_char(A.dataTime,'yyyy') = ?1 and A.plantId = ?2 ")
    List<EntryWrwPlantEntity> findByPlantAndYear(String year, String plantId);
}
