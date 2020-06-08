package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service;


import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryCoalEntity;

import java.util.List;

public interface CoalEntryService {

    List<EntryCoalEntity> getByYear(String year);

    EntryCoalEntity findById(String id);

    List<EntryCoalEntity> getByPlantId(String plantId);

    void  delete(Double gdmh,Double fdmh);
}
