package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.controller;

import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.EntryWrwTotalService;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryWrwTotalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entryWrwTotal")
public class EntryWrwTotalController {


    @Autowired
    private EntryWrwTotalService entryWrwTotalService;

    @GetMapping("/findByYear/{year}")
    public List<String> findByYear(@PathVariable("year") String year) {
        return entryWrwTotalService.findByYear(year);
    }

    @GetMapping("/findAllOrderByYear")
    public List<EntryWrwTotalEntity> findAllOrderByYear() {
        return entryWrwTotalService.findAllOrderByYear();
    }

}
