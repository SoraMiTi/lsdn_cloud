package cn.com.liandisys.util;

/**
 * 系统字符处理
 */
public  class CommonConst {
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

}
