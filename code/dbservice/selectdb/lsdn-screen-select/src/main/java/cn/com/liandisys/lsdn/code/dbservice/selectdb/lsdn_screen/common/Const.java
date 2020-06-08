package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common;

/**
 * 常量定义
 * 
 * @author DYQ
 */
public class Const {

	/** 基础路径 */
	public static String BASE_PATH = "";

	/** 平台默认ID */
	public static final String DEFAULT_PLATFORM_ID = "1";
	
	public static final String DKY_ID = "1";

	/** 系统参数-基础公用代码 */
	public static final String SYS_PARAM_BASE_CODE = "baseCode";

	/** 本地数据库 DB模式名 */
	public static String LOCAL_LSDN_SCHEMA = "LSDN";
//	public static String LOCAL_LSDN_SCHEMA = "LSDN_DKY";

	/** 公用代码 */
	public static final class COMM_CODE {

		/** 是否公用代码 */
		public static final String CODE_SF = "yesOrNo";

		/** 是 */
		public static final String CODE_SF_Y = "Y";

		/** 否 */
		public static final String CODE_SF_N = "N";

		/** 请假单状态公用代码 */
		public static final String CODE_IOFFICE_LEAVETYPE = "iofficeLeaveType";

		/** 请假单状态公用代码 */
		public static final String CODE_IOFFICE_ISINNERPRO = "iofficeIsInnerPro";

		/** 请假单状态公用代码 */
		public static final String CODE_IOFFICE_LEAVESTATUS = "iofficeLeaveStatus";

		/** 新建 */
		public static final String CODE_IOFFICE_LEAVESTATUS_NEW = "NEW";

		/** 进行中 */
		public static final String CODE_IOFFICE_LEAVESTATUS_DOING = "DOING";

		/** 完成 */
		public static final String CODE_IOFFICE_LEAVESTATUS_FINISH = "FINISH";

		/** 驳回 */
		public static final String CODE_IOFFICE_LEAVESTATUS_BACK = "BACK";

		/** 设备投运状态 父节点 : tyzt */
		public static final String TYZT_PARENT = "tyzt";
		/** 设备投运状态:已投运 */
		public static final String TYZT_YES = "1";
		/** 设备投运状态:未投运 */
		public static final String TYZT_NO = "0";
		
		/** 设备运行状态 父节点 : runStatus */
		public static final String RUN_STATUS_PARENT = "runStatus";
		/** 设备运行状态:运行中 */
		public static final String RUN_STATUS_YES = "1";
		/** 设备运行状态:未运行 */
		public static final String RUN_STATUS_NO = "0";
		
		/** 组织类型：全部（电科院）:0 */
		public static final String DKY_FLAG = "0";
		/** 组织类型：集团 :1 */
		public static final String JITUAN_FLAG = "1";
		/** 组织类型：电厂 :2 */
		public static final String DIANCHANG_FLAG = "2";
		/** 组织类型：机组 :3 */
		public static final String JIZU_FLAG = "3";
		
		/** 机组燃料类型：燃煤：1 */
		public static final String JIZU_TYPE_RM = "1";
		/** 机组燃料类型：燃汽：2 */
		public static final String JIZU_TYPE_RQ = "2";
		/** 机组燃料类型：燃油：3 */
		public static final String JIZU_TYPE_RY = "3";
		
		/** 设备树层次级别  全部 ：0  */
		public static final String TREE_LEVEL_TOTAL = "0";
		/** 设备树层次级别  电厂 ：1  */
		public static final String TREE_LEVEL_PLANT = "1";
		/** 设备树层次级别  机组 ：2  */
		public static final String TREE_LEVEL_GEN = "2";

	    /** 组织结构列表获取级别  电科院: 1 */
	    public static final String LEVEL_DKY = "1";
	    /** 组织结构列表获取级别  集团: 2 */
	    public static final String LEVEL_GROUP = "2";
	    /** 组织结构列表获取级别  电厂: 3 */
	    public static final String LEVEL_PLANT = "3";
		
		/** 公共代码:公告发布状态 */		
		public static final String NOTICE_TYPE = "noticeType";
		/** 公告发布状态:已发布 */
		public static final String NOTICE_TYPE_YES = "1";
		/** 公告发布状态:未发布 */
		public static final String NOTICE_TYPE_NO = "2";
		
		/** 公共代码:电源类型  */
		public static final String DYLX = "dylx";
		/** 电源类型:燃煤  */
        public static final String DYLX_RM = "1";
        /** 电源类型:燃机  */
        public static final String DYLX_RJ = "2";
        /** 电源类型:光伏  */
        public static final String DYLX_GF = "3";
        /** 电源类型:风电  */
        public static final String DYLX_FD = "4";
        /** 电源类型:虚拟  */
        public static final String DYLX_XN = "5";
        /** 电源类型:其他  */
        public static final String DYLX_OTHER = "6";
		
		/** 公共代码:厂站类型  */
		public static final String CZLX = "czlx";
		/** 厂站类型:变电站  */
        public static final String CZLX_BDZ = "1";
        /** 厂站类型:火电站  */
        public static final String CZLX_HDZ = "2";
        /** 厂站类型:风电站  */
        public static final String CZLX_FDZ = "3";
        /** 厂站类型:光电站  */
        public static final String CZLX_GDZ = "4";
        /** 厂站类型:虚拟站  */
        public static final String CZLX_XNZ = "5";
        
        /** 公共代码:机组级别  */
        public static final String GEN_LEVEL = "genLevel";
        /** 机组级别:300MW以下  */
        public static final String GEN_LEVEL_0_300 = "1";
        /** 机组级别:300-600MW  */
        public static final String GEN_LEVEL_300_600 = "2";
        /** 机组级别:600-100MW  */
        public static final String GEN_LEVEL_600_1000 = "3";
        /** 机组级别:1000MW以上  */
        public static final String GEN_LEVEL_1000_X = "4";
		
	}
	
	/**
	 * 标准参数设定
	 * @author b_fangzheng
	 *
	 */
	public static final class BASE_STANDARD {
	    
	    /** 限值标准功能ID-SO2 */
        public static final String FUNCTION_ID_SO2 = "1001";
        /** 限值标准功能ID-NOx */
        public static final String FUNCTION_ID_NOX = "1002";
        /** 限值标准功能ID-PM */
        public static final String FUNCTION_ID_PM = "1003";
        /** 限值标准功能ID-发电煤耗 */
        public static final String FUNCTION_ID_FDMH = "1004";
        /** 限值标准功能ID-供电煤耗 */
        public static final String FUNCTION_ID_GDMH = "1005";
	    /** 标准参数设定功能编号 ： 煤耗录入时间设定编号 ： 1006 */
	    public static final String FUNCTION_ID_COAL_ENTRY = "1006";
	    
	}
	
	/** 需要特殊处理的权重数据 */
	public static final class QUANZHONG {
		/** 进、滞相调节/供电能耗/环保指标 */
		public static final String[] QUANZHONG_SPECIAL = { "JZJXZXTJNL_YZ", "JZGDNH_YZ", "JZHBZB_YZ" };
		
		/** 进、滞相调节:JZJXZXTJNL_YZ 数据分类 */
		public static final String[] JZJXZXTJNL_YZ_TYPE = { "进相调节能力", "滞相调节能力" };
		
		/** 供电能耗:JZGDNH_YZ 数据 类型/单位 */
		public static final String[] JZGDNH_YZ_TYPE = { "供电煤耗", "厂用电率", "发电用水率" };
		
		/** 供电能耗:JZGDNH_YZ 数据单位 11对应 */
		public static final String[] JZGDNH_YZ_TYPE_UNIT = { "g/kWh", "%", "t/kWh" };
		
		/** 环保指标:JZHBZB_YZ 数据分类 */
		public static final String[] JZHBZB_YZ_TYPE = { "烟尘排放率", "二氧化硫排放率", "氮氧化物排放率" };
		
		/** 绿电评价-综合评价-都市绿色评价-二级权重 */
		public static final String[] ZBLV2 = { "绿色供应", "安全发展", "绿色消费", "政策支持" };
		
		/** 绿色供应下子权重 */
		public static final String[] LSGYSTR = { "本地发电结构清洁度因子", "外来供电结构清洁度因子", "本地火电机组运行清洁度因子", "外地供电中特高压接入因子", "微电网接入因子",
	            "储能系统接入因子", "新能源接入因子", "本地能源置换因子" };
		
		/** 安全发展下子权重 */
		public static final String[] AQFZSTR = { "机组安全性因子", "机组可靠性因子", "机组应急能力因子", "电网电压合格目标差异率", "电网供电可靠率", "电网频率不合格时间目标差异率",
	            "电网热稳定程度", "电网电压稳定程度", "发电机组负荷率", "技术监督质量评价因子", "AGC影响因子", "AVC影响因子", "一次调频响应因子" };
		
		/** 绿色消费下子权重*/
		public static final String[] LSXFSTR = { "综合线损率", "电耗在单位GDP中能耗占比", "电力消费弹性系数因子", "以电代煤因子", "以电代油因子", "以电代气因子",
	            "能耗中电耗占比", "需求侧让电量占比", "用户参与调峰调频容量占总调峰调频容量比例", "分时电价及尖峰电价行业电量在社会总电量中的占比", "售电商绿色电力认购电量占比" };

		public static final String[] ZCZCSTR = { "清洁能源装机容量提升比例", "清洁能源发电量提升比例", "供电煤耗下降率", "单位GDP中电耗下降率", "年度科技投入费用",
	            "环保电价补贴量占比", "分时电价波谷电量占比" };
	}
	
	/** 数据表或代码中用到静态字段定义 */
	public static final class STATIC_DATA {
	    
	    /** 指标评价数据表中 flag 标签定义  机组：0 */
	    public static final String ZBPJ_FLAG_GEN = "0";
	    /** 指标评价数据表中 flag 标签定义  电厂：1 */
	    public static final String ZBPJ_FLAG_PLANT = "1";
	    
	    /** 供热电厂：漕泾热电  电厂ID ：  */
	    public static final String RDC_CJRD_PLANT_ID = "D3B04526564649A5A8868FFAB40DC760";
	    
	    /** 二氧化硫英文标识 */
	    public static final String SO2ENNAME = "SO2";
	    /** 氮氧化物英文标识 */
	    public static final String NOXENNAME = "NOx";
	    /** 烟尘英文标识 */
	    public static final String PMENNAME = "PM";
	    /** 煤耗英文标识 */
	    public static final String MHENNAME = "COAL";
	    
	    /** 权重数据表中  权重中文名称 ：绿色供应（绿色供给）  */
        public static final Object QZ_NAME_LSGY = "绿色供应";
        /** 权重数据表中  权重中文名称 ：安全发展  */
        public static final Object QZ_NAME_AQFZ = "安全发展";
        /** 权重数据表中  权重中文名称 ：绿色消费  */
        public static final Object QZ_NAME_LSXF = "绿色消费";
        /** 权重数据表中  权重中文名称 ：政策支持  */
        public static final Object QZ_NAME_ZCZC = "政策支持";
        
        /** 组织类型：默认查询（DKY） */
		public static final String DKY_DEFAULT = "DKY";
		/** 组织类型：集团 */
		public static final String JITUAN = "JT";
		/** 组织类型：电厂 */
		public static final String DIANCHANG = "DC";
		/** 组织类型：机组 */
		public static final String JIZU = "JZ";
		
		
		/**绿色评价-综合评价-电厂绿色排名默认查询年份*/
		public static final String LSPJ_DCPSPM_YEAR="2015";
		
		/**限值：实时出力/实时负荷/供电功率(SUP_POWER/DATA_VALUE)*/
		public static final String LIMIT_SUP_POWER_MIN="2";
		
		/**限值：煤耗最小(FDMH/GDMH/COAL)*/
		public static final String LIMIT_COAL_MIN="200";
        
	}
	
	/** 一次调频曲线相关参数 */
	public static final class YCTP_LINES {
	    
        public static final String SEC_LINES = "secLines";
        public static final String LINES = "lines";
        public static final int PRE_NEXTTIME = 60;
        public static final int PRE_NEXT = 60;
        
	}
	/** 抓取时间间隔  */
	public static final class GRAB_INTERVAL{
	    /** 电厂实时统计数据抓取时间间隔 ：单位  分钟*/
	    public static final long S_PLANT_REAL_TIME_INTERVAL = 60;
	    /** 全网实时统计数据抓取时间间隔 ：单位  分钟 */
	    public static final long S_TOTAL_REAL_TIME_INTERVAL = 60;
	    /** 供电分区实时统计数据抓取间隔  ：单位  分钟 */
	    public static final long GDFQ_REAL_TIME_INTERVAL = 60;
	    /** 发电机实时数据抓取时间间隔 ：单位  分钟 */
	    public static final long G_REAL_GEN_TIME_INTERVAL = 60;
	    /** 机组绿色安全得分统计时间间隔 ：单位  分钟 */
	    public static final long M_SCORE_LSAQ_TIME_INTERVAL = 60;
	}
	/** 接口报错信息，页面标码  */
    public static final class ERROR_CONTROLLER {

    	/** 新大屏接口服务    源页面Controller编码 */
        public static final String SOURCE_CONTROLLER = "00-";
        
        /** 新大屏接口服务    源页面Controller编码-新 */
        public static final String NEW_SOURCE_CONTROLLER = "01-";

    }
    /** 进博会专项 */
    public static final class JBHZX{
    	/** 本地数据库 DB模式名 */
//        public static String LOCAL_JBHZX_SCHEMA = "JBHZX";
    	public static String LOCAL_JBHZX_SCHEMA = "JBHZX_DKY";
        /** 公用代码 */
        public static final class COMM_CODE {
        	/** 投运状态-已投运 */
        	public static final String TYZT_Y = "1";
        	/** 投运状态-未投运 */
        	public static final String TYZT_N = "0";
        	/** 运行状态-已运行 */
        	public static final String RUN_STATUS_Y = "1";
        	/** 运行状态-未运行*/
        	public static final String RUN_STATUS_N = "0";
        }
    }
}
