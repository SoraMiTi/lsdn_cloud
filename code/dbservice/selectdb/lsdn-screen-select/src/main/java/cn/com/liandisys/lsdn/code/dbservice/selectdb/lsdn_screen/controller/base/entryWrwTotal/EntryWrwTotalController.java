package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.controller.base.entryWrwTotal;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.base.entryWrwTotal.EntryWrwTotalDao;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryWrwTotalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entryWrwTotalDao")
public class EntryWrwTotalController {

    @Autowired
    private EntryWrwTotalDao entryWrwTotalDao;

    @GetMapping("/findByYear/{year}")
    public List<String> findByYear(@PathVariable("year") String year) {
        return entryWrwTotalDao.findByYear(year);
    }

    @GetMapping("/findAllOrderByYear")
    public List<EntryWrwTotalEntity> findAllOrderByYear() {
        return entryWrwTotalDao.findAllOrderByYear();
    }

    @GetMapping("/findById")
    public EntryWrwTotalEntity findById(String id) {
        Optional<EntryWrwTotalEntity> entity = entryWrwTotalDao.findById(id);
        if (entity == null) {
            return null;
        }
        return entity.get();
    }


}
