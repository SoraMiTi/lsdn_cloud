package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.controller;

import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.CoalEntryService;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryCoalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coalEntry")
public class CoalEntryController {

    @Autowired
    private CoalEntryService coalEntryService;

    @GetMapping("/getByYear/{year}")
    public List<EntryCoalEntity> getByYear(@PathVariable("year")String year){
        return coalEntryService.getByYear(year);
    }

    @GetMapping("/{id}")
    public EntryCoalEntity findById(@PathVariable("id")String id){
        return coalEntryService.findById(id);
    }

    @DeleteMapping("deleteBy/{gdmh}/{fdmh}")
    public void delete(@PathVariable("gdmh")Double gdmh,@PathVariable("fdmh")Double fdmh){
        coalEntryService.delete(new Double(gdmh),new Double(fdmh));
    }

    @GetMapping("/getByPlantId/{plantId}")
    public List<EntryCoalEntity> getPlantId(@PathVariable("plantId")String plantId){
        return coalEntryService.getByPlantId(plantId);
    }


}
