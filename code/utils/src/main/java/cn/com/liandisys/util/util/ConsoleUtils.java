package cn.com.liandisys.util.util;

import cn.com.liandisys.idev.modules.common.Constants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 共通方法<br/>
 * 各模块都可用的方法请放入此类中
 * 
 * @author DYQ
 */
public class ConsoleUtils {

    /**
     * 把boolean转为Y，N
     * 
     * @param Avail
     * @return
     */
    public static String setAvailable(boolean Avail) {

        if (Avail) {
            return Constants.AVAILABLE;
        }
        return Constants.UNAVAILABLE;
    }

    /**
     * 把Y，N转为boolean
     * 
     * @param Avail
     * @return
     */
    public static boolean isAvailable(String Avail) {

        if (Avail.equalsIgnoreCase(Constants.AVAILABLE)) {
            return true;
        }
        return false;
    }

    /**
     * 将列表转换为分页的列表
     *
     * @param list 待分页的列表
     * @param pageable 分页信息
     * @return 分页后的列表信息
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Page<? extends Object> convertToPageable(List<? extends Object> list, Pageable pageable) {

        List retList = new ArrayList();
        long len = list.size();
        int startPos = (pageable.getPageNumber()) * pageable.getPageSize();
        for (int i = startPos; i < startPos + pageable.getPageSize(); i++) {
            if (i < len) {
                retList.add(list.get(i));
            }
        }
        Page<? extends Object> pageList = new PageImpl(retList, pageable, len);
        return pageList;
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
    public static <T> T convertJsonStringToObject(String json, Class<T> parameterClass) {

        ObjectMapper mapper = new ObjectMapper();
        T object = null;
        try {
            object = mapper.readValue(json, parameterClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
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
    public static <U, S extends Collection<U>> S convertJsonStringToObjects(String json, Class<S> parametrized,
            Class<U> parameterClasses) {

        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType =
                mapper.getTypeFactory().constructParametrizedType(parametrized, parametrized, parameterClasses);
        S collection = null;
        try {
            collection = mapper.readValue(json, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

}
