package cn.com.liandisys.util.util;

import cn.com.liandisys.util.CommonConst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统用字符处理
 * 
 * @author DYQ
 */
public class StringUtil {

	/**
	 * 转换字符串
	 * 
	 * @param obj
	 *            对象
	 * @return 字符串
	 */
	public static String toStr(Object obj) {

		String str = "";
		if (obj != null) {
			str = obj.toString();
		}
		return str;
	}

	/**
	 * object类型数据转换成double
	 * 
	 * @param obj
	 * @param n
	 *            保留小数位数
	 * @return
	 */
	public static Double toDouble(Object obj, Integer n) {
		Double value = toDoubleBase(obj, n);
		if (value == null) {
			value = 0.0;
		}
		return value;
	}

	/**
	 * 二次封装doble转成string
	 * 
	 * @param obj
	 * @param n
	 *            保留小数位数
	 * @return
	 */
	public static String doubleToString(Object obj, Integer n) {
		return toStr(toDoubleBase(obj, n));
	}

	/**
	 * object类型数据转换成double（保留原始类型）
	 * 
	 * @param obj
	 * @param n
	 *            保留小数位数
	 * @return
	 */
	public static Double toDoubleBase(Object obj, Integer n) {
		// double数据保留四位小数
		Double value = null;
		String formatType = "#.";
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				// 根据小数位数拼 0
				formatType = formatType + '0';
			}
			DecimalFormat df = new DecimalFormat(formatType);
			String str = toStr(obj);
			if (StringUtil.isNotNullOrBlank(str)) {
				double d = Double.parseDouble(str);
				String format = df.format(d);
				value = Double.valueOf(format);
			}
		} else {
			System.err.println("小数位数至少为1位");
		}
		return value;
	}

	/**
	 * object类型数据转换成Integer
	 * 
	 * @param obj
	 *            保留小数位数
	 * @return
	 */
	public static Integer toInteger(Object obj) {

		// 监测点编号
		String str = StringUtil.toStr(obj);
		Integer value = 0;
		if (isNotNullOrBlank(str)) {
			try {
				value = Integer.valueOf(str);
			} catch (Exception e) {
				value = 0;
			}
		}
		return value;
	}

	/**
	 * object类型数据转换成Long
	 * 
	 * @param obj
	 * @return
	 */
	public static Long toLong(Object obj) {

		// 监测点编号
		String str = StringUtil.toStr(obj);
		Long value = 0L;
		if (isNotNullOrBlank(str)) {
			try {
				value = Long.valueOf(str);
			} catch (Exception e) {
				value = 0L;
			}
		}
		return value;
	}

	/**
	 * 数字格式化
	 * 
	 * @param d
	 *            位数
	 * @param formatText
	 *            #.000 格式 三位小数
	 * @return 格式 三位小数
	 */
	public static double numFormatter(double d, String formatText) {

		DecimalFormat df = new DecimalFormat(formatText);
		return Double.valueOf(df.format(d));
	}

	/**
	 * 字符太长截取
	 * 
	 * @param value
	 *            字符
	 * @param subLength
	 *            长度
	 * @return 字符太长截取后
	 */
	public static String subString(String value, int subLength) {

		StringBuffer sub = new StringBuffer();
		int length = value.length();
		if (subLength > length) {
			subLength = length;
			sub.append(value.substring(0, subLength));
		} else {
			sub.append(value.substring(0, subLength));
			sub.append("......");
		}
		return sub.toString();
	}

	/**
	 * 判断字符串是否是空或空串
	 * 
	 * @param str
	 *            字符串
	 * @return 是否是空或空串
	 */
	public static boolean isNullOrBlank(String str) {

		return str == null || "".equals(str);
	}

	/**
	 * 判断字符串是否不是空或空串
	 * 
	 * @param str
	 *            字符串
	 * @return 是否不是空或空串
	 */
	public static boolean isNotNullOrBlank(String str) {

		return !isNullOrBlank(str);
	}

	/**
	 * Object转Json
	 * 
	 * @param list
	 * @return
	 */
	public static String convertToJsonData(Object list) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			String liststr = mapper.writeValueAsString(list);
			return liststr;
		} catch (JsonProcessingException jsone) {
			throw new RuntimeException(jsone);
		}
	}

	/**
	 * 对象转Integer
	 * 
	 * @param obj
	 * @return
	 */
	public static Integer objToInt(Object obj) {
		String str = toStr(obj);
		if (!isNullOrBlank(str)) {
			return Integer.parseInt(str);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 将区间按info等分
	 * 
	 * @param start
	 *            开始
	 * @param end
	 *            结束
	 * @param info
	 *            数值
	 * @return 转换值
	 */
	public static List<Integer> divideRange(int start, int end, int info) {

		List<Integer> ls = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			if ((i - start) % info == 0 || i == end)
				ls.add(i);
		}
		return ls;
	}

	/**
	 * 转为小写或者驼峰 带有下划线的字符串转为驼峰字符串
	 * 
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		StringBuilder sb;
		if (param.indexOf("_") != -1) {
			int len = param.length();
			sb = new StringBuilder(len);
			for (int i = 0; i < len; i++) {
				char c = Character.toLowerCase(param.charAt(i));
				if (c == '_') {
					if (++i < len) {
						sb.append(Character.toUpperCase(param.charAt(i)));
					}
				} else {
					sb.append(c);
				}
			}
		} else {
			sb = new StringBuilder(param.toLowerCase());
		}
		return sb.toString();
	}

	/**
	 * 根据额定容量值判定所属范围
	 * 
	 * @param edrl
	 * @return
	 */
	public static String getTypeByEdrl(Double edrl) {

		String type = "";
		if (edrl <= 300.0) {
			type = "1";
		} else if (300.0 < edrl && edrl <= 600.0) {
			type = "2";
		} else if (600.0 < edrl && edrl < 1000.0) {
			type = "3";
		} else if (1000.0 <= edrl) {
			type = "4";
		} else {
			type = "5";
		}
		return type;
	}

	/**
	 * 根据容量类型返回容量范围
	 * 
	 * @param type
	 * @return 返回容量范围
	 */
	public static List<Double> getRlRangeByType(String type) {

		List<Double> range = new ArrayList<Double>();
		Double start = 0.0;
		Double end = 9999999.0;
		if (StringUtil.isNotNullOrBlank(type)) {
			if (CommonConst.COMM_CODE.GEN_LEVEL_0_300.equals(type)) {
				end = 300.0;
			} else if (CommonConst.COMM_CODE.GEN_LEVEL_300_600.equals(type)) {
				start = 300.0;
				end = 600.0;
			} else if (CommonConst.COMM_CODE.GEN_LEVEL_600_1000.equals(type)) {
				start = 600.0;
				end = 1000.0;
			} else if (CommonConst.COMM_CODE.GEN_LEVEL_1000_X.equals(type)) {
				start = 1000.0;
			}
		}
		range.add(start);
		range.add(end);
		return range;
	}
	
	/**
	 * 根据传入的value 判断优良中差
	 * 用于绿色电能中同心圆
	 * @param lszb 数据格式为 “KN=XXX”
	 * @return
	 */
	public static String getGxoflv0Name(String lszb){
		String str="差";
		int level=StringUtil.toInteger(lszb.substring(1,2))-1;
		switch (level) {
		case 0:
			str="差";
			break;
		case 1:
			str="较差";
			break;
		case 2:
			str="一般";
			break;
		case 3:
			str="良好";
			break;
		case 4:
			str="优秀";
			break;
		default:
			str="差";
			break;
		}
		return str;
	}

}
