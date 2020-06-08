package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.controller.generator.coalEntry;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.coalEntry.CoalEntryDao;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coalEntry")
public class CoalEntryController {

    @Autowired
    private CoalEntryDao coalEntryDao;

    @DeleteMapping("/deleteByGdmh/{gdmh}")
    @Transactional
    @LcnTransaction
    public void deleteByGdmh(@PathVariable("gdmh") Double gdmh){
        coalEntryDao.deleteByGdmh(gdmh);
    }

    @DeleteMapping("/deleteByFdmh/{fdmh}")
    @Transactional
    @LcnTransaction
    public void deleteByFdmh(@PathVariable("fdmh") Double fdmh){
        coalEntryDao.deleteByFdmh(fdmh);
    }
}
