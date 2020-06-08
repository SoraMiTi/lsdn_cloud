package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.controller.base.baseStandard;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.base.baseStandard.BaseStandardDao;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.base.BaseStandardEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 排放限值台账数据 Dao
 * 
 * @author b_huyh
 */
@RestController
@RequestMapping("/baseStandardDao")
public class BaseStandardController {

    @Autowired
    private BaseStandardDao baseStandardDao;

    private static  final Logger logger = LoggerFactory.getLogger(BaseStandardController.class);

    /**
     * 根据功能id查询
     * 
     * @param functionId
     * @return
     */
    @GetMapping("/findByFunctionId/{functionId}")
    public BaseStandardEntity findByFunctionId(@PathVariable("functionId") String functionId){
        BaseStandardEntity baseStandard = baseStandardDao.findByFunctionId(functionId);
        logger.info("value:",baseStandard.getId());
        return  baseStandard;
    }
}
