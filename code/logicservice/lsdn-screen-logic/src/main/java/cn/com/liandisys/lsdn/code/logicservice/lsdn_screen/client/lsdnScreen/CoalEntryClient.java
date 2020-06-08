package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "lsdn-screen-select/coalEntry",contextId = "coalEntryClient")
public interface CoalEntryClient{

    @RequestMapping(value = "/deleteByGdmh/{gdmh}",method=RequestMethod.DELETE)
    EntityModel deleteByGdmh(@PathVariable("gdmh")Double gdmh);

    @RequestMapping(value = "/deleteByFdmh/{fdmh}",method=RequestMethod.DELETE)
    EntityModel deleteByFdmh(@PathVariable("fdmh")Double fdmh);
}
