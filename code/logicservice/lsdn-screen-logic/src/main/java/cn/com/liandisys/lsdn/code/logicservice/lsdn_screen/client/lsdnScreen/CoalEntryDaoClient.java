package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryCoalEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "lsdn-screen-select/coalEntryDao",contextId = "coalEntryDaoClient")
public interface CoalEntryDaoClient extends ClientFace{

    @RequestMapping(value = "/search/getByYear",method = RequestMethod.GET)
    CollectionModel<EntryCoalEntity> getByYear(@RequestParam("year")String year);

    @RequestMapping(value = "/search/getByPlantId",method = RequestMethod.GET)
    CollectionModel<EntryCoalEntity> getByPlantId(@RequestParam("plantId")String plantId);
}
