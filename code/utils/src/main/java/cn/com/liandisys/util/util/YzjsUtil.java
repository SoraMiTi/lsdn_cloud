package cn.com.liandisys.util.util;

/**
 * 因子计算工具类
 * @author wangyang2
 *
 */
public class YzjsUtil {

    /**
     * 本地发供电程度清洁度因子局部权重1
     */
    private static double bdfgdcdqjdyzweight1 = 0.547;

    /**
     * 本地发供电程度清洁度因子局部权重2
     */
    private static double bdfgdcdqjdyzweight2 = 0.286;

    /**
     * 本地发供电程度清洁度因子局部权重3
     */
    private static double bdfgdcdqjdyzweight3 = 0.167;

    /**
     * 外来供电结构清洁度因子局部权重1
     */
    private static double wlgdjgqjdyzweight1 = 0.75;

    /**
     * 外来供电结构清洁度因子局部权重2
     */
    private static double wlgdjgqjdyzweight2 = 0.25;

    /**
     * 本地供电结构清洁度因子局部权重1
     */
    private static double bdgdjgqjdyzweight1 = 0.67;

    /**
     * 本地供电结构清洁度因子局部权重2
     */
    private static double bdgdjgqjdyzweight2 = 0.33;

    /**
     * 外地供电中特高压接入因子局部权重1    
     */
    private static double wdgdtgyjryzweight1 = 0.67;

    /**
     * 外地供电中特高压接入因子局部权重2
     */
    private static double wdgdtgyjryzweight2 = 0.33;

    /**
     * 微电网接入因子局部权重1
     */
    private static double wdwjryzweight1 = 0.286;

    /**
     * 微电网接入因子局部权重2
     */
    private static double wdwjryzweight2 = 0.547;

    /**
     * 微电网接入因子局部权重3
     */
    private static double wdwjryzweight3 = 0.167;

    /**
     * 峰时段电价
     */
    private static double fengdj = 0.617;

    /**
     * 谷时段电价
     */
    private static double gudj = 0.307;

    //2.4新能源接入因子
    /**
     * 0.101	2.4.1太阳能发电量占比（正向）
     */
    private static double tynfdlzb = 0.101;

    /**
     * 0.205	2.4.2风能发电量占比（正向）
     */
    private static double fnfdlzb = 0.205;

    /**
     * 0.07	2.4.3生物质发电量占比（正向）
     */
    private static double swzfdlzb = 0.07;

    /**
     * 0.106	2.4.4核能发电量占比（正向）
     */
    private static double hnfdlzb = 0.106;

    /**
     * 0.066	2.4.5地热能发电量占比（正向）
     */
    private static double drnfdlzb = 0.066;

    /**
     * 0.066	2.4.6潮汐能发电量占比（正向）
     */
    private static double cxnfdlzb = 0.066;

    /**
     * 0.385	2.4.7水电发电量占比（正向）
     */
    private static double sdfdlzb = 0.385;

    /**
     * O22
     */
    private static double o22 = 0.1;

    //2.5本地能源置换因子
    /**
     * 0.5	2.5.1本地发电量置换额占比（正向）
     */
    private static double bdfdlzhezb = 0.5;

    /**
     * 0.5	2.5.2本地供热机组电量占比(正向)
     */
    private static double bdgrjzdlzb = 0.5;

    //3.1
    /**
     * 机组一次调频能力（正向）
     */
    private static double jz_yctpnl = 0.112;

    /**
     * 机组AGC能力（正向）
     */
    private static double jz_agcnl = 0.336;

    /**
     * 机组AVC能力（正向）
     */
    private static double jz_avcnl = 0.336;

    /**
     * 机组进相、滞相能力（正向）
     */
    private static double jz_jxzxnl = 0.217;

    //3.2
    /**
     * 0.33	3.2.1机组跳闸率（正向）
     */
    public static double jz_tzl = 0.33;

    /**
     *  0.37	3.2.2机组技术管理水平（正向）
     */
    public static double jz_jsglsp = 0.37;

    /**
     *  0.3	3.2.3机组强迫停运率参数（正向）
     */
    public static double jz_qptylcs = 0.3;

    //3.3机组应急能力因子
    /**
     * 0.222	3.3.1RB指数（正向）
     */
    public static double rbzs = 0.222;

    /**
     *  0.667	3.3.2具备黑启动能力（正向）
     */
    public static double jbhqdnl = 0.667;

    /**
     * 0.111	3.3.3机组稳态性能指数（正向）
     */
    public static double jz_wtxnzs = 0.111;

    /**
     * Q41
     */
    public static double q41 = 100;

    /**
     * 本地发供电程度清洁度因子计算方法
     * @param powerGenerationbyCoal 本地发电结构煤发电量（万千瓦）
     * @param powerGenerationbyOil 本地发电结构油发电量（万千瓦）
     * @param powerGenerationbyNaturalGas 本地发电结构天然气发电量（万千瓦）
     * @param powerGenerationbyWind 本地发电结构风电发电量（万千瓦）
     * @param powerGenerationbySolar 本地发电结构太阳能发电量（万千瓦）
     * @param powerGenerationbyBiomass 本地发电结构生物质发电量（万千瓦）
     * @param powerGenerationbyOthers 本地发电结构其他发电量（万千瓦）
     * @param powerGenerationbyNewEnergy 新能源发电量（亿千瓦时）
     * @param powerGenerationinCompanyArea 公司经营区域发电量（亿千瓦时）
     * @param lastyearstynfdzb 上一年太阳能发电量占比
     * @param lastyearpowerGenerationbySolar 上一年太阳能发电量
     * @param lastyearsfnfdzb 上一年风能发电占比
     * @param lastyearspowerGenerationbyWind 上一年风电发电量
     * @param abandonedPowerofRenewableEnergy 公司经营区域可再生能源弃电量
     * @return double 本地发供电程度清洁度因子结果
     */
    public static double bdfgdcdqjdyz(double powerGenerationbyCoal, double powerGenerationbyOil,
            double powerGenerationbyNaturalGas, double powerGenerationbyWind, double powerGenerationbySolar,
            double powerGenerationbyBiomass, double powerGenerationbyOthers, double powerGenerationbyNewEnergy,
            double powerGenerationinCompanyArea, double lastyearstynfdzb, double lastyearpowerGenerationbySolar,
            double lastyearsfnfdzb, double lastyearspowerGenerationbyWind, double abandonedPowerofRenewableEnergy) {

        //清洁能源总装机量
        double sumCleanEnergyPowerGeneration =
                powerGenerationbyNaturalGas + powerGenerationbyWind + powerGenerationbySolar + powerGenerationbyBiomass;
        //全部装机量
        double sumAllPowerGeneration =
                powerGenerationbyCoal + powerGenerationbyOil + sumCleanEnergyPowerGeneration + powerGenerationbyOthers;
        //1.1.1清洁能源装机容量比例（正向）
        double proportionofCleanEnergyInstalledcapacity = sumCleanEnergyPowerGeneration / sumAllPowerGeneration;
        //1.1.2清洁能源发电量占比（正向）
        double proportionofCleanEnergyPowerGeneration = powerGenerationbyNewEnergy / powerGenerationinCompanyArea;
        //2.4.1太阳能发电量占比
        double tynfdzb = YzjsUtil.tynfdzb(lastyearstynfdzb, powerGenerationbySolar, lastyearpowerGenerationbySolar);
        //2.4.2风能发电量占比
        double fnfdzb = YzjsUtil.fnfdzb(lastyearsfnfdzb, powerGenerationbyWind, lastyearspowerGenerationbyWind);
        //1.1.3清洁能源发电弃电率（负向）
        double positiveabandonedPowerofCleanEnergy =
                tynfdzb / (tynfdzb + fnfdzb) * 0.1 + abandonedPowerofRenewableEnergy * fnfdzb / (tynfdzb + fnfdzb);
        double result =
                bdfgdcdqjdyzweight1 * proportionofCleanEnergyInstalledcapacity + bdfgdcdqjdyzweight2
                        * proportionofCleanEnergyPowerGeneration + bdfgdcdqjdyzweight3
                        * (1 - positiveabandonedPowerofCleanEnergy);
        return result;
    }

    /**
     * 2.4.1太阳能发电量占比（正向）(以下上一年都指计算年份的上一年,当年指计算的年份)(0.1)
     * (TODO 参数由上一年太阳能发电量占比结果，上一年太阳能发电量（本地发电结构下）和当年太阳能发电量构成)
     * 最初年份数据设定为0.1 （参照excel）
     * @param lastyearstynfdzb 上一年太阳能发电量占比结果
     * @param powerGenerationbySolar 当年太阳能发电量
     * @param lastyearspowerGenerationbySolar 上一年太阳能发电量
     * @return double 太阳能发电量占比
     */
    public static double tynfdzb(double lastyearstynfdzb, double powerGenerationbySolar,
            double lastyearspowerGenerationbySolar) {

        double result =
                lastyearstynfdzb
                        * ((powerGenerationbySolar - lastyearspowerGenerationbySolar) / lastyearspowerGenerationbySolar + 1);
        return result;
    }

    /**
     * 2.4.2风能发电量占比（正向）(以下上一年都指计算年份的上一年,当年指计算的年份)
     * (TODO 参数由上一年风能发电量占比结果，上一年风能发电量（本地发电结构下）和当年风能发电量构成)
     * 最初年份的数据 = 最初年份风能发电量 / 最初年份太阳能发电量*最初年份太阳能发电量占比  (请单独计算)
     * @param lastyearsfnfdzb 上一年风能发电量占比
     * @param powerGenerationbyWind 当年风能发电量
     * @param lastyearspowerGenerationbyWind 上一年风能发电量
     * @return double 风能发电量占比
     */
    public static double fnfdzb(double lastyearsfnfdzb, double powerGenerationbyWind,
            double lastyearspowerGenerationbyWind) {

        double result =
                lastyearsfnfdzb
                        * ((powerGenerationbyWind - lastyearspowerGenerationbyWind) / lastyearspowerGenerationbyWind + 1);
        return result;
    }

    /**
     * 1.2外来供电结构清洁度因子
     * @param kqsjgdl 跨区实际购电量
     * @param wlqjnyfdqdl 外来清洁能源发电弃电率（负向）(TODO 所有年份均直接为0，但此处暂时作为参数保留)
     * @return double 外来供电结构清洁度因子
     */
    public static double wlgdjgqjdyz(double kqsjgdl, double wlqjnyfdqdl) {

        //调入电量中清洁能源电量数(TODO 此处以2014年乘的系数为准，2013,2012年系数各不相同，等待调查确认修改)
        double drdlzxqjnydls = kqsjgdl * 0.3;
        double result = wlgdjgqjdyzweight1 * (drdlzxqjnydls / kqsjgdl) + wlgdjgqjdyzweight2 * (1 - wlqjnyfdqdl);
        return result;
    }

    /**
     * 本地供电结构清洁度因子
     * @param ycpfl 单位烟尘排放率：（克/千瓦时）W58、
     * @param so2pfl 单位二氧化硫加权值：（克/千瓦时）W57
     * @param noxpfl 单位氮氧化物加权值：（克/千瓦时）W56
     * @param ycpflOfThisYear 当年单位电量烟尘排放率（克/千瓦时）W110
     * @param ycpflOfLastYear 去年单位电量烟尘排放率（克/千瓦时）W110
     * @param ycpflOfTwoYearsago 前年单位电量烟尘排放率（克/千瓦时）W110
     * @param so2pflOfThisYear 当年单位电量二氧化硫排放率（克/千瓦时）W109
     * @param so2pflOfLastYear 去年单位电量二氧化硫排放率（克/千瓦时）W109
     * @param so2pflOfTwoYearsago 前年单位电量二氧化硫排放率（克/千瓦时）W109
     * @param noxpflOfThisYear 当年单位电量氮氧化物排放率（克/千瓦时）W108
     * @param noxpflOfLastYear 去年单位电量氮氧化物排放率（克/千瓦时）W108
     * @param noxpflOfTwoYearsago 前年单位电量氮氧化物排放率（克/千瓦时）W108
     * @param gdmh 供电煤耗：（克标煤/千瓦时）W61
     * @param cydl 厂用电率：（%）W60
     * @param gdsh 发电用水率：（吨/千瓦时）W59
     * @return double 本地供电结构清洁度因子结果值
     */
    public static double bdgdqjdyz(double ycpfl, double so2pfl, double noxpfl, double ycpflOfThisYear,
            double ycpflOfLastYear, double ycpflOfTwoYearsago, double so2pflOfThisYear, double so2pflOfLastYear,
            double so2pflOfTwoYearsago, double noxpflOfThisYear, double noxpflOfLastYear, double noxpflOfTwoYearsago,
            double gdmh, double cydl, double gdsh) {

        //直线纵截距(表格中均默认100，直接使用100)
        double zxzjj = 100;
        //烟尘90分门槛值
        double ycscore90 = (ycpflOfThisYear + ycpflOfLastYear + ycpflOfTwoYearsago) / 3;
        //烟尘直线斜率K
        double yczxxlK = (90 - 100) / ycscore90;
        //烟尘0分边界值（负向）
        double ycscore0 = (-zxzjj) / yczxxlK;
        double ycscore;
        if (ycpfl > ycscore0) {
            ycscore = 0;
        } else {
            ycscore = 100 + ycpfl * yczxxlK;
        }
        //二氧化硫部分，同烟尘，不在详细注释 
        double so2score90 = (so2pflOfThisYear + so2pflOfLastYear + so2pflOfTwoYearsago) / 3;
        double so2zxxlK = (90 - 100) / so2score90;
        double so2score0 = (-zxzjj) / so2zxxlK;
        double so2score;
        if (so2pfl > so2score0) {
            so2score = 0;
        } else {
            so2score = 100 + so2pfl * so2zxxlK;
        }
        //氮氧化物部分，同烟尘，不在详细注释 
        double noxscore90 = (noxpflOfThisYear + noxpflOfLastYear + noxpflOfTwoYearsago) / 3;
        double noxzxxlK = (90 - 100) / noxscore90;
        double noxscore0 = (-zxzjj) / noxzxxlK;
        double noxscore;
        if (noxpfl > noxscore0) {
            noxscore = 0;
        } else {
            noxscore = 100 + noxpfl * noxzxxlK;
        }
        //1.3.1机组环保指标（元/克）
        double jzhbzb = (ycscore + so2score + noxscore) / 3;
        //供电煤耗部分
        //excel上说明：陈博士直接给出的国家标准
        //double gdmhscore90 = 300;//未使用，暂时保留
        double gdmhzxxlK = -43.8 / 10;
        //供电煤耗直线纵截距
        double gdmhzxzjx = 90 - 300 * gdmhzxxlK;
        //double gdmhscore0 = (-gdmhzxzjx) / gdmhzxxlK;//未使用，暂时保留
        double gdmhscore;
        if (gdmh > gdmhzxzjx) {
            gdmhscore = 0;
        } else {
            gdmhscore = gdmhzxxlK * gdmh + gdmhzxzjx;
        }
        //厂用电率部分
        //cydl改成小数表示
        cydl = cydl / 100;
        //excel上说明：陈博士给出的微信内容
        double cydlscore90 = 0.0517;
        double cydlhzxxlK = (60 - 100) / cydlscore90;
        //double cydlscore0 = (-zxzjj) / cydlhzxxlK;//未使用，暂时保留
        double cydlscore;
        if (cydl > zxzjj) {
            cydlscore = 0;
        } else {
            cydlscore = cydlhzxxlK * cydl + 100;
        }
        //供电水耗部分
        //excel上说明：陈博士给出的微信内容
        double gdshscore90 = 0.00092;
        double gdshhzxxlK = (60 - 100) / gdshscore90;
        //double gdshscore0 = (-zxzjj) / gdshhzxxlK;//未使用，暂时保留
        double gdshscore;
        if (gdsh > zxzjj) {
            gdshscore = 0;
        } else {
            gdshscore = gdshhzxxlK * gdsh + 100;
        }
        //1.3.2机组供电能耗（负向）（元/千瓦时）
        double gdnh = 0.5 * gdmhscore + 0.25 * cydlscore + 0.25 * gdshscore;
        double result = bdgdjgqjdyzweight1 * (jzhbzb / 100) + bdgdjgqjdyzweight2 * (gdnh / 100);
        return result;
    }

    /**2.1外地供电中特高压接入因子*/

    /**
     * 外地供电中特高压接入因子
     * @param kqsjgdl 跨区实际购电量
     * @param qshydl 全社会用电量
     * @param kssjdrdl 跨省实际调入电量
     * @param kssjzlgdl 跨省实际直流购电量
     * @return double 外地供电中特高压接入因子结果值
     */
    public static double wdgdtgyjryz(double kqsjgdl, double qshydl, double kssjdrdl, double kssjzlgdl) {

        //2.1.1接入电量占比（？正向）
        double jrdlzb = kqsjgdl / qshydl;
        //跨直流购电量
        double kzlgdl = kssjzlgdl / kssjdrdl * kqsjgdl;
        //2.1.2直流接入电量占比（？正向）
        double zldlzb = kzlgdl / qshydl;
        double result = wdgdtgyjryzweight1 * jrdlzb + wdgdtgyjryzweight2 * zldlzb;
        return result;
    }

    /**
     * 微电网接入因子
     * @param bwfbsdyzjrl 并网分布式电源装机容量
     * @param powerGenerationbyCoal 本地发电结构煤发电量（万千瓦）
     * @param powerGenerationbyOil 本地发电结构油发电量（万千瓦）
     * @param powerGenerationbyNaturalGas 本地发电结构天然气发电量（万千瓦）
     * @param powerGenerationbyWind 本地发电结构风电发电量（万千瓦）
     * @param powerGenerationbySolar 本地发电结构太阳能发电量（万千瓦）
     * @param powerGenerationbyBiomass 本地发电结构生物质发电量（万千瓦）
     * @param powerGenerationbyOthers 本地发电结构其他发电量（万千瓦）
     * @return double 微电网接入因子结果值
     */
    public static double wdwjryz(double bwfbsdyzjrl, double powerGenerationbyCoal, double powerGenerationbyOil,
            double powerGenerationbyNaturalGas, double powerGenerationbyWind, double powerGenerationbySolar,
            double powerGenerationbyBiomass, double powerGenerationbyOthers) {

        //全部装机量
        double sumAllPowerGeneration =
                powerGenerationbyCoal + powerGenerationbyOil + powerGenerationbyNaturalGas + powerGenerationbyWind
                        + powerGenerationbySolar + powerGenerationbyBiomass + powerGenerationbyOthers;
        //2.2.1并网容量占比（正向）
        double bwrlzb = bwfbsdyzjrl / sumAllPowerGeneration;
        double result = wdwjryzweight1 * bwrlzb + wdwjryzweight2 * 0 + wdwjryzweight3 * 0;
        return result;
    }

    /**
     * 2.3储能系统接入因子
     * @return 0 (TODO 表格中直接0，待论证)
     */
    public static double cnxtjryz() {

        return 0;
    }

    /**
     * 2.4新能源接入因子???
     * q22
     * @param   j46 太阳能前年(数据清单!J46)
     * @param   k46 太阳能去年(数据清单!K46)
     * @param   l46 太阳能今年(数据清单!L46)
     * q23
     * @param   j45 风电前年 (数据清单!J45)
     * @param   k45 风电能去年 (数据清单!K45)
     * @param   l45 风电能今年 (数据清单!L45) 
     * q5
     * @param l18 跨区实际购电量今年(数据清单!L18)
     * @return 新能源接入因子
     */
    public static double xnyjryz(double j46, double k46, double l46, double j45, double k45, double l45, double l18) {

        double o23 = (j45 / j46) * o22;
        double q5 = (l18 * 0.3) / l18;
        double sum1 = (o22 * ((k46 - j46) / j46 + 1)) * ((l46 - k46) / k46 + 1);
        double sum2 = (o23 * ((k45 - j45) / j45 + 1)) * ((l45 - k45) / k45 + 1);
        double sum3 = (q5 - sum2 - sum1) / 5;
        return tynfdlzb * sum1 + fnfdlzb * sum2 + swzfdlzb * sum3 + hnfdlzb * sum3 + drnfdlzb * sum3 + cxnfdlzb * sum3
                + sdfdlzb * sum3;
    }

    /**
     * 2.5本地能源置换因子
     *  ???
     * @param l65 发电权交易电量今年 (数据清单!l65)
     * @param l60 公司经营区域发电量 (数据清单!l60) 
     * @param  x3  装机容量（万千瓦）(电厂数据'!X3)
     * @param  w3  装机容量（万千瓦）(电厂数据'!W3)
     * @return 本地能源置换因子
     * */
    public static double bdnyzhyz(double l65, double l60, double x3, double w3) {

        double q29 = l65 / l60;
        double q30 = x3 / w3;
        return bdfdlzhezb * q29 + bdgrjzdlzb * q30;
    }

    /**
    * 3.1机组安全性因子
    * 
    * @param q31  一次调频性能 (电厂数据'!W73)
    * @param q32 AGC性能 (电厂数据'!W71)
    * @param q33 AVC性能 (电厂数据'!W72)
    * @param x34 进相能力 (电厂数据'!W74)
    * @param x35 滞相能力 (电厂数据'!W75)
    * @return 机组安全性因子
    */
    public static double jzaqxyz(double q31, double q32, double q33, double x34, double x35) {

        double sum = x34 * 1 / 2 + x35 * 1 / 2;
        return jz_yctpnl * (q31 / 100) + jz_agcnl * (q32 / 100) + jz_avcnl * (q33 / 100) + jz_jxzxnl * (sum / 100);
    }

    /**
     * 3.2机组可靠性因子
     * 
     * @param  q36 3.2.1机组跳闸率（正向）  (电厂数据'!W77)
     * @param  q37 技术管理水平 (电厂数据'!W83)
     * @param  q38 3.2.3机组强迫停运率参数（正向） (电厂数据'!W76)
     * @return 机组可靠性因子
     * */

    public static double jzkkxyz(double q36, double q37, double q38) {

        return jz_tzl * (q36 / 100) + jz_jsglsp * (q37 / 100) + jz_qptylcs * (q38 / 10);
    }

    /**
     * 3.3机组应急能力因子
     * 
     * @param  q39  机组RB指数 (电厂数据'!W78)
     * @param  q40 黑启动能力 (电厂数据'!W79)
     * @return 机组应急能力因子
     * */

    public static double jzyjnlyz(double q39, double q40) {

        return rbzs * (q39 / 100) + jbhqdnl * (q40 / 100) + jz_wtxnzs * (q41 / 100);
    }

    /**
     * 4.1电网电压合格率（正向）
     * @param h42 考核点电压合格率 今年 (数据清单!L78)
     * @return 电网电压合格率（正向）
     * */

    public static double dwdyhgl(double h42) {

        return h42 / 100;
    }

    /**
     * 4.2电网供电可靠率（正向）
     * @param h43 供电可靠率今年 (数据清单!L107)
     * @return 电网供电可靠率（正向）
     * */

    public static double dwgdkkl(double h43) {

        return h43 / 100;
    }

    /**
     * 4.3电网频率不合格时间目标差异率（负向）
     * @return (1 - 0)电网频率不合格时间目标差异率（负向）
     * */
    public static double dwplbhgsjmbcyl() {

        return (1 - 0);
    }

    /**
     * 4.4电网热稳定程度（正向）
     * @param h45  电网热稳绝对贡献度加权值 (电厂数据'!W65)
     * @return 电网热稳定程度（正向）
     * */
    public static double dwrwdcd(double h45) {

        return h45 / 100;
    }

    /**
     * 4.5电网电压稳定度（正向）
     * @param h46 电网电压稳定绝对贡献度加权值 (电厂数据'!W66)
     * @return 电网电压稳定度（正向）
     * */
    public static double dwdywdd(double h46) {

        return h46 / 100;
    }

    /**
     *   5.1峰谷差率（%）（负向）
     * @param h47 峰谷差率今年 (数据清单!L108)
     * @return   峰谷差率（%）（负向）
     * */
    public static double fgcl(double h47) {

        return 1 - (h47 / 100);
    }

    /**
     * 5.2技术监督质量评价因子（正向）
     * @return 100 / 100 技术监督质量评价因子（正向）
     * */
    public static double jsjdzlpjyz() {

        return 100 / 100;
    }

    /**    5.4发电机组负荷率（正向）
    * @param h49  赋权后数据 (电厂数据'!W90)
    * @return    发电机组负荷率（正向）
    * */

    public static double fdjzfhl(double h49) {

        return h49;
    }

    /**    5.5一次调频响应因子（正向）
     * @param h50 一次调频响应 (电厂数据'!W82)
     * @return    一次调频响应因子（正向）
     * */
    public static double yctpxyyz(double h50) {

        return h50 / 100;
    }

    /**  5.6AGC影响因子（正向）
     * @param h51 AGC响应 (电厂数据'!W80)
     * @return    AGC影响因子（正向）
     * */
    public static double agcxyyz(double h51) {

        return h51 / 100;
    }

    /**  5.7AVC影响因子（正向）
     * @param h52 AVC响应 (电厂数据'!W81)
     * @return    AVC影响因子（正向）
     * */
    public static double avcxyyz(double h52) {

        return h52 / 100;
    }

    /**
     * 分时电价波谷电量占比（负向）
     * 
     * @param avgdj  居民用电平均电价
     * @param maxfh1 当前年最大负荷
     * @param maxfh2 去年最大负荷
     * @param maxfh3 前年最大负荷
     * @param year12 当前上海年用电量（亿kw.h）
     * @param year13 去年上海年用电量（亿kw.h）
     * @param year14 前年上海年用电量（亿kw.h）
     * @return 分时电价波谷电量占比（负向）
     */
    public static double fsdjbgzb(double avgdj, double maxfh1, double maxfh2, double maxfh3, double year12,
            double year13, double year14) {

        //    	//上海年用电量（亿kw.h）2012年
        //    	double year12 = 1353.45;
        //    	//上海年用电量（亿kw.h）2013年
        //    	double year13 = 1410.61;
        //    	//上海年用电量（亿kw.h）2014年
        //    	double year14 = 1369.02;
        //上海日均用电量（亿kw.h）2012年
        double day12 = year12 / 365;
        //上海日均用电量（亿kw.h）2013年
        double day13 = year13 / 365;
        //上海日均用电量（亿kw.h）2014年
        double day14 = year14 / 365;
        //上海平均负荷（亿kw））2012年
        double avgfh12 = day12 / 24 / 2;
        //上海平均负荷（亿kw））2013年
        double avgfh13 = day13 / 24 / 2;
        //上海平均负荷（亿kw））2014年
        double avgfh14 = day14 / 24 / 2;

        double d85 = maxfh1 / (avgfh14 * 10000);
        double c85 = maxfh2 / (avgfh13 * 10000);
        double b85 = maxfh3 / (avgfh12 * 10000);

        //(峰时段电价-谷时段)/居民用电平均电价
        double d81 = (fengdj - gudj) / (avgdj / 1000);
        double tempa = d85 / d81;
        double temp =
                60 / ((tempa + c85 / ((fengdj - gudj) / (avgdj / 1000)) + b85 / ((fengdj - gudj) / (avgdj / 1000))) / 3);
        double tempb = 100 / (60 / temp);
        return tempa > tempb ? 1 : (tempa * temp / 100);
    }

    /**
     * 12.1环保电价补贴量占比（正向）
     * 
     * @return 环保电价补贴量占比（正向）
     */
    public static double hbdjbtlzb() {

        return 0.005 / (0.005 + 0.4593);
    }

    /**
     * 年度科技创新投入度（正向）
     * 
     * @param tr1 当前年度电力科技创新投入(数据清单!L106)
     * @param tr2 去年年度电力科技创新投入
     * @param tr3 前年年度电力科技创新投入
     * @return 年度科技创新投入度（正向）
     */
    public static double ndkjcxtrd(double tr1, double tr2, double tr3) {

        double tempa = tr1;
        double tempb = 100 / (60 / ((tr1 + tr2 + tr3) / 3));
        return tempa > tempb ? 1 : (tempa * (100 / tempb) / 100);
    }

    /**
     * 单位GDP中电耗下降率（正向）
     * 
     * @param dhxjl 万元产值电耗下降率(数据清单!L11)
     * @return 单位GDP中电耗下降率（正向）
     */
    public static double fsdjbgzb(double dhxjl) {

        return Math.abs(dhxjl) / 100;
    }

    /**
     * 10.1供电煤耗下降率（正向）
     * 
     * @param yesteryeargdmh 去年供电煤耗
     * @param yeargdmh 今年供电煤耗
     * @return 供电煤耗下降率（正向）
     */
    public static double gdmhxjl(double yesteryeargdmh, double yeargdmh) {

        return (yesteryeargdmh - yeargdmh) / yesteryeargdmh;
    }

    /**
     * 9.2清洁能源发电量提升比例（正向）
     * 
     * @param yesterXnyfdl 去年新能源发电量
     * @param yearXnyfdl 今年新能源发电量
     * @return 清洁能源发电量提升比例
     */
    public static double qjnytsbl(double yesterXnyfdl, double yearXnyfdl) {

        return (yearXnyfdl - yesterXnyfdl) / yesterXnyfdl;
    }

    /**
     * 9.1清洁能源装机容量提升比例（正向）
     * 
     * @param trq 天然气(今年)
     * @param fd 风电(今年)
     * @param tyn 太阳能(今年)
     * @param swz 生物质(今年)
     * @param trq1 天然气
     * @param fd1 风电
     * @param tyn1 太阳能
     * @param swz1 生物质
     * @return 清洁能源装机容量提升比例（正向）
     */
    public static double qjnyzjrlbl(double trq, double fd, double tyn, double swz, double trq1, double fd1,
            double tyn1, double swz1) {

        double sum = trq + fd + tyn + swz;
        double sum1 = trq1 + fd1 + tyn1 + swz1;
        return (sum - sum1) / sum1;
    }

    /**
     * 8.4售电商绿色电力认购行动占比（正向）
     * 
     * @param kqsjgdl 跨区实际购电量(l18)
     * @param xnyfdl 新能源发电量
     * @param gsfdl 公司经营区域发电量
     * @return 售电商绿色电力认购行动占比（正向）
     */
    public static double lsdlrgzb(double kqsjgdl, double xnyfdl, double gsfdl) {

        double temp = 0.3 * kqsjgdl; //TODO 2014是0.3 13年是0.29？
        return (temp + xnyfdl) / (gsfdl + kqsjgdl);
    }

    /**
     * 8.3分时电价及尖峰电价行业电量在社会总电量中的占比（正向）
     * 
     * @param qshydl 全社会用电量(l8)
     * @param fsdjhydl 分时电价行业电量（居民）(l52)
     * @return 分时电价及尖峰电价行业电量在社会总电量中的占比（正向）
     */
    public static double sqzdlzb(double qshydl, double fsdjhydl) {

        return fsdjhydl / qshydl;
    }

    /**
     * 8.2用户参与调峰调频容量占总调峰调频容量比例（正向）
     * 
     * @param yhcyrl 用户参与调峰调频容量
     * @param tolrl 总调峰调频容量
     * @return 分时电价及尖峰电价行业电量在社会总电量中的占比（正向）
     */
    public static double yhcyrlToTolrl(double yhcyrl, double tolrl) {

        return yhcyrl / tolrl;
    }

    /**
     * 8.1需求侧让电量占比（正向）
     * 
     * @return 需求侧让电量占比
     */
    public static double xqcrdlzb() {

        return 0;
    }

    /**
     * 7.4能耗中电耗占比（正向）
     * @param tol 能源消耗总量
     * @param qshyl 全社会用电量
     * @param zhxs 综合线损率
     * @return 能耗中电耗占比
     */
    public static double nhTodnzb(double tol, double qshyl, double zhxs) {

        return (qshyl / (1 - zhxs / 100)) * 100000000 * 302.85 / 1000000 / 10000 / tol;
    }

    /**
     * 7.3以电代气因子（万千瓦时）（正向）
     * @param parm1 电热水器替代燃气热水器新增电量
     * @return 以电代气因子（万千瓦时）
     */
    public static double ddqyz(double parm1) {

        return parm1;
    }

    /**
     * 7.2以电代油因子（电动汽车量）（正向）
     * @param lastXnyqcl 新能源汽车保有量（前年）
     * @param yesterXnyqcl 新能源汽车保有量（去年）
     * @param yearXnyqcl 新能源汽车保有量（今年）
     * @return 以电代气因子（万千瓦时）
     */
    public static double yddyyz(double lastXnyqcl, double yesterXnyqcl, double yearXnyqcl) {

        double tempa = yearXnyqcl;
        double tempb = 60 / (yesterXnyqcl + lastXnyqcl + yearXnyqcl) / 3;
        return tempa > tempb ? 1 : (tempa * tempb / 100);
    }

    /**
     * 7.1以电代煤因子（万KW）（正向）
     * @param l102 电能替代煤
     * @return 以电代煤因子（万KW）（正向）
     */
    public static double yddmyz(double l102) {
    	if (l102 == 0.0) {
    		return 0;	
		}
        return l102 > (100 / (60 * l102)) ? 1 : (l102 * 60 / l102 / 100);
    }

    /**
     * 6.1综合线损率（负向）
     * @param zhxsl 综合线损率
     * @return 综合线损率
     */
    public static double zhxsl(double zhxsl) {

        return 1 - zhxsl / 100;
    }

    /**
     * 6.2电耗在单位GDP中能耗占比（正向）
     * @param zhxs 综合线损率
     * @param qshyl 全社会用电量
     * @param tol 能源消耗总量
     * @return 电耗在单位GDP中能耗占比
     */
    public static double dhGDPnhzb(double zhxs, double qshyl, double tol) {

        return (qshyl / (1 - zhxs / 100)) * 100000000 * 302.85 / 1000000 / 10000 / tol;
    }

    /**
     * 6.3电力消费弹性系数因子（正向）
     * @param l21 电力消费弹性指数
     * @return 电力消费弹性系数因子（正向）
     */
    public static double dlxftxxsyz(double l21) {

        return l21;
    }

    /**
     * 1.3.1机组环保指标（元/克）
     * @param ycpflOfThisYear 当年单位电量烟尘排放率（克/千瓦时）W110
     * @param so2pflOfThisYear 当年单位电量二氧化硫排放率（克/千瓦时）W109
     * @param noXpflOfThisYear 当年单位电量氮氧化物排放率（克/千瓦时）W108
     * @return 机组环保指标（元/克）
     */
    public static double jzhbzb(double ycpflOfThisYear, double so2pflOfThisYear, double noXpflOfThisYear) {

        //直线纵截距(表格中均默认100，直接使用100)
        double zxzjj = 100;
        //烟尘90分门槛值   TODO 用实时的替代平均的
        //double ycscore90 = (ycpflOfThisYear + ycpflOfLastYear + ycpflOfTwoYearsago) / 3;
        double ycscore90 = ycpflOfThisYear;
        //烟尘直线斜率K
        double yczxxlK = (90 - 100) / ycscore90;
        //烟尘0分边界值（负向）
        double ycscore0 = (-zxzjj) / yczxxlK;
        double ycscore;
        if (ycpflOfThisYear > ycscore0) {
            ycscore = 0;
        } else {
            ycscore = 100 + ycpflOfThisYear * yczxxlK;
        }
        //二氧化硫部分，同烟尘，不在详细注释  TODO 用实时的替代平均的
        //double SO2score90 = (SO2pflOfThisYear + SO2pflOfLastYear + SO2pflOfTwoYearsago) / 3;
        double so2score90 = so2pflOfThisYear;
        double so2zxxlK = (90 - 100) / so2score90;
        double so2score0 = (-zxzjj) / so2zxxlK;
        double so2score;
        if (so2pflOfThisYear > so2score0) {
            so2score = 0;
        } else {
            so2score = 100 + so2pflOfThisYear * so2zxxlK;
        }
        //氮氧化物部分，同烟尘，不在详细注释  TODO 用实时的替代平均的
        // double NOXscore90 = (NOXpflOfThisYear + NOXpflOfLastYear + NOXpflOfTwoYearsago) / 3;
        double noxscore90 = noXpflOfThisYear;
        double noxzxxlK = (90 - 100) / noxscore90;
        double noxscore0 = (-zxzjj) / noxzxxlK;
        double noxscore;
        if (noXpflOfThisYear > noxscore0) {
            noxscore = 0;
        } else {
            noxscore = 100 + noXpflOfThisYear * noxzxxlK;
        }
        //1.3.1机组环保指标（元/克）
        return (ycscore + so2score + noxscore) / 3 / 100;
    }

    /**
     * 1.3.2机组供电能耗（负向）（元/千瓦时）
     * @param gdmh 供电煤耗：（克标煤/千瓦时）W61
     * @param cydl 厂用电率：（%）W60
     * @param gdsh 发电用水率：（吨/千瓦时）W59
     * @return 机组供电能耗（负向）
     */
    public static double jzgdnh(double gdmh, double cydl, double gdsh) {

        //直线纵截距(表格中均默认100，直接使用100)
        double zxzjj = 100;
        //        //供电煤耗部分
        //        //excel上说明：陈博士直接给出的国家标准
        //        double gdmhzxxlK = -43.8 / 10;
        //        //供电煤耗直线纵截距
        //        double gdmhzxzjx = 90 - 300 * gdmhzxxlK;
        //        double gdmhscore;
        //        if (gdmh > gdmhzxzjx) {
        //            gdmhscore = 0;
        //        } else {
        //            gdmhscore = gdmhzxxlK * gdmh + gdmhzxzjx;
        //        }
        //供电煤耗部分
        double gdmhscore;
        if (gdmh > 500) {
            gdmhscore = 0;
        } else {
            gdmhscore = -0.41 * gdmh + 208.33;
        }
        //厂用电率部分
        //cydl改成小数表示
        cydl = cydl / 100;
        //excel上说明：陈博士给出的微信内容
        double cydlscore90 = 0.0517;
        double cydlhzxxlK = (60 - 100) / cydlscore90;
        double cydlscore;
        if (cydl > zxzjj) {
            cydlscore = 0;
        } else {
            cydlscore = cydlhzxxlK * cydl + 100;
        }
        //供电水耗部分
        //excel上说明：陈博士给出的微信内容
        double gdshscore90 = 0.00092;
        double gdshhzxxlK = (60 - 100) / gdshscore90;
        double gdshscore;
        if (gdsh > zxzjj) {
            gdshscore = 0;
        } else {
            gdshscore = gdshhzxxlK * gdsh + 100;
        }
        //1.3.2机组供电能耗（负向）（元/千瓦时）
        double gdnh = 0.5 * gdmhscore + 0.25 * cydlscore + 0.25 * gdshscore;
        return gdnh / 100;
    }

    /**
    * 3.1.1机组一次调频能力（正向）
    * 
    * @param q31  一次调频性能 (电厂数据'!W73)
    * @return 机组一次调频能力（正向）
    */
    public static double yctbnl(double q31) {

        return q31 / 100;
    }

    /**
    * 3.1.2机组AGC能力（正向）
    * 
    * @param q32 AGC性能 (电厂数据'!W71)
    * @return 机组AGC能力（正向
    */
    public static double jzAGCnl(double q32) {

        return q32 / 100;
    }

    /**
    * 3.1.3机组AVC能力（正向）
    * 
    * @param q33 机组AVC能力（正向）
    * @return 机组AGC能力（正向
    */
    public static double jzAVCnl(double q33) {

        return q33 / 100;
    }

    /**
    * 3.1.4机组进相、滞相能力（正向）
    * 
    * @param q34 进相调节能力（正向）
    * @param q35 滞相调节能力能力（正向）
    * @return 进相、滞相调节能力
    */
    public static double jzjxnl(double q34, double q35) {

        return (q34 + q35) * 0.5 / 100;
    }

    /**
     * 3.2.1机组跳闸率（正向）
     * 
     * @param  q36 3.2.1机组跳闸率（正向）  (电厂数据'!W77)
     * @return 机组跳闸率（正向）
     * */

    public static double jztzl(double q36) {

        return q36 / 100;
    }

    /**
     * 3.2.2机组技术管理水平（正向）
     * 
     * @param  q37 技术管理水平 (电厂数据'!W83)
     * @return 机组技术管理水平
     * */

    public static double jzjsglsp(double q37) {

        return q37 / 100;
    }

    /**
     * 3.2.3机组强迫停运率参数（正向）
     * 
     * @param  q38 3.2.3机组强迫停运率参数（正向） (电厂数据'!W76)
     * @return 机组强迫停运率参数
     * */

    public static double jzqbtyl(double q38) {

        return q38 / 10;
    }

    /**
     * 3.3.1RB指数（正向）
     * 
     * @param  q39  机组RB指数 (电厂数据'!W78)
     * @return RB指数
     * */

    public static double jzrbzs(double q39) {

        return q39 / 100;
    }

    /**
     * 3.3.2具备黑启动能力（正向）
     * 
     * @param  q40 黑启动能力 (电厂数据'!W79)
     * @return 具备黑启动能力
     * */

    public static double hqdnl(double q40) {

        return q40 / 100;
    }

    /**
     * 3.3.3机组稳态性能指数（正向）
     * 
     * @return 机组稳态性能指数
     * */

    public static double jzwtxnzs() {

        return 1;
    }

}
