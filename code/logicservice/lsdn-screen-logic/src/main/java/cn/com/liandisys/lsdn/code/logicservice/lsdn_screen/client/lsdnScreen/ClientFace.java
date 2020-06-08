package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryCoalEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
public interface ClientFace {

    @RequestMapping(value="{id}",method = RequestMethod.GET)
    EntityModel<EntryCoalEntity> findById(@PathVariable("id")String id);

    @RequestMapping(value="{id}",method = RequestMethod.POST)
    EntityModel<EntryCoalEntity> add(@PathVariable("id")String id);

    @RequestMapping(value="{id}",method = RequestMethod.PATCH)
    EntityModel<EntryCoalEntity> update(@PathVariable("id")String id);

    @RequestMapping(value="{id}",method = RequestMethod.DELETE)
    EntityModel<EntryCoalEntity> delete(@PathVariable("id")String id);

}
