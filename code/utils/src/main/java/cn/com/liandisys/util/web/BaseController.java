package cn.com.liandisys.util.web;

import cn.com.liandisys.idev.modules.common.Constants;
import cn.com.liandisys.idev.modules.exception.BusinessException;
import cn.com.liandisys.idev.modules.shiro.SecurityService;
import cn.com.liandisys.idev.modules.utils.CustomPropertiesEditor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import cn.com.liandisys.util.result.ResponseInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Controller基类
 * 
 * @author DYQ
 */
public abstract class BaseController {

    /** 平台code */
    public static final String APP_CONFIG_SYSTEM = "appConfigSystem";

    /** 平台权限标识 */
    public static final String PERMISSION_PLATFORM = "platform_";

    /** 系统code */
    public static final String LSDN_SYSTEM = "lsdn";

    /** 统权限标识 */
    public static final String PERMISSION_LSDN = "lsdn_";

    /** 统一管理权限 */
    public static final String PERMISSION_MANAGER = "manage";

    /** 统一查看权限 */
    public static final String PERMISSION_VIEW = "view";

    /** 操作成功返回结果 */
    public static final String SUCCESS = "success";

    /** 操作失败返回结果 */
    public static final String ERROR = "error";

    @Autowired
    protected SecurityService securityService;

    /**
     * 全局数据处理
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        // binder.registerCustomEditor(Date.class, new CustomDateEditor(
        // new SimpleDateFormat(DateTime.DATE_FORMAT_DATEONLY), true));
        binder.registerCustomEditor(Boolean.class,
                new CustomBooleanEditor(Constants.AVAILABLE, Constants.UNAVAILABLE, true));
        binder.registerCustomEditor(String.class, new CustomPropertiesEditor());
    }

    /**
     * 全局异常处理
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    protected String ExceptionHandler(BusinessException e) {

        ResponseInfo res = new ResponseInfo(e.getMessage());
        return convertToJsonData(res);
    }

    /**
     * 将对象合集转换为json字符串
     * 
     * @param list
     * @return
     */
    protected String convertToJsonData(Object list) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            // mapper.setDateFormat(new
            // SimpleDateFormat(DateTime.DATE_FORMAT_DATEONLY));
            String liststr = mapper.writeValueAsString(list);
            return liststr;
        } catch (JsonProcessingException jsone) {
            throw new RuntimeException(jsone);
        }
    }

    /**
     * 转换json字符串到对象集合
     * 
     * @param json
     * @param parametrized
     * @param parameterClasses
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    protected <U, S extends Collection<U>> S convertJsonStringToObjects(String json, Class<S> parametrized,
            Class<U> parameterClasses) throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        // mapper.setDateFormat(new SimpleDateFormat(DateTime.DATE_FORMAT_DATEONLY));
        JavaType javaType =
                mapper.getTypeFactory().constructParametrizedType(parametrized, parametrized, parameterClasses);
        S collection = mapper.readValue(json, javaType);
        return collection;
    }

    /**
     * 转换json字符串到对象
     * 
     * @param json
     * @param parameterClass
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    protected <T> T convertJsonStringToObject(String json, Class<T> parameterClass)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        T object = mapper.readValue(json, parameterClass);
        return object;
    }

    /**
     * 分页信息获取
     * 
     * @param page
     * @param size
     * @param sort
     * @return
     */
    @ModelAttribute("pageRequest")
    public PageRequest getPageRequest(
            @RequestParam(value = "page", required = false, defaultValue = "1") String page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") String size,
            @ModelAttribute("sort") Sort sort) {

        if (StringUtils.hasText(page) && StringUtils.hasText(size)) {
            // 页码从0开始
//            PageRequest pageable = new PageRequest(Integer.parseInt(page) - 1, Integer.parseInt(size), sort);
            return  PageRequest.of(Integer.parseInt(page) - 1, Integer.parseInt(size), sort);
        }
        return null;
    }

    /**
     * 排序信息获取
     * 
     * @param sort
     * @param order
     * @return
     */
    @ModelAttribute("sort")
    public Sort getSort(@RequestParam(value = "sort", required = false, defaultValue = "") String[] sort,
            @RequestParam(value = "order", required = false, defaultValue = "descending") String[] order) {

        List<Order> sortList = new ArrayList<Order>();
        for (int i = 0; i < sort.length; i++) {
            String sortField = sort[i];
            String orderFiled = order.length < sort.length ? order[0] : order[i];
            if (StringUtils.hasText(sortField) && StringUtils.hasText(orderFiled)) {
                Direction direction = "descending".equals(orderFiled) ? Direction.DESC : Direction.ASC;
                Order o = new Order(direction, sort[i]);
                sortList.add(o);
            }
        }
        if (!sortList.isEmpty()) {
//            Sort sorts = new Sort(sortList);
            return Sort.by(sortList);
        }
        return null;
    }

}
