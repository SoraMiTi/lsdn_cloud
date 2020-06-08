package cn.com.liandisys.lsdn.code.model.lsdn_screen.vo.source;


/**
 * S_TOTAL_MONTH
 *
 * @author b_fangzheng
 */
public class STotalMonthVo {

    /**
     * 标识
     */
    private String id;

    /**
     * 年度
     */
    private String year;

    /**
     * 月份
     */
    private String month;

    /**
     * 火电(机组)累计SO？排放量
     */
    private Long hdSo2Emissions;

    /**
     * 火电(机组)累计NOx排放量
     */
    private Long hdNoxEmissions;

    /**
     * 火电(机组)累计PM排放量
     */
    private Long hdPmEmissions;

    /**
     * 火电(机组)累计发电量
     */
    private Long hdDl;

    /**
     * 火电(低煤耗机组)累计减排CO？
     */
    private Long hdCo2Jpl;

    /**
     * 火电(机组)SO？排放超标累计次数
     */
    private Long so2Cbcs;

    /**
     * 火电(机组)NOx排放超标累计次数
     */
    private Long noxCbcs;

    /**
     * 火电(机组)PM排放超标累计次数
     */
    private Long pmCbcs;

    /**
     * 光电累计发电量
     */
    private Long gdDl;

    /**
     * 光电累计减排CO？
     */
    private Long gdCo2Jpl;

    /**
     * 风电累计发电量
     */
    private Long fdDl;

    /**
     * 风电累计减排CO？
     */
    private Long fdCo2Jpl;

    /**
     * 水电累计发电量
     */
    private Long sdDl;

    /**
     * 水电累计减排CO？
     */
    private Long sdCo2Jpl;

    /**
     * 水电累计减排SO？
     */
    private Long sdSo2Emissions;

    /**
     * 水电累计减排NOx
     */
    private Long sdNoxEmissions;

    /**
     * 水电累计减排PM
     */
    private Long sdPmEmissions;

    /**
     * 分布式能源累计发电量
     */
    private Long fbsDl;

    /**
     * 分布式能源累计减排CO？
     */
    private Long fbsCo2Jpl;

    /**
     * 充电桩累计充电量  月内累计
     */
    private Long cdzDl;

    /**
     * 充电桩积累节约汽油量  月内累计
     */
    private Long cdzSaveQy;

    /**
     * 三联供平均能源效率
     */
    private Long slgNyxlAvg;

    /**
     * 三联供累计节约电量
     */
    private Long slgSaveDl;

    /**
     * 三联供累计节约成本
     */
    private Long slgSaveCb;

    /**
     * 三联供累计减排CO？
     */
    private Long slgCo2Jpl;

    /**
     * 虚拟电厂累计节约电量
     */
    private Long xndcSaveDl;

    /**
     * 虚拟电厂累计节约成本
     */
    private Long xndcSaveCb;

    /**
     * 虚拟电厂累计减排CO？
     */
    private Long xndcCo2Jpl;

    /**
     * 调峰机组累计调峰台次
     */
    private Long tfjxTc;

    /**
     * 调峰机组平均响应时间
     */
    private Long tfjxXyscAvg;

    /**
     * 一次调频分类1累计台次  参考：0.4＞DX？？≥0.5 null6＞DX？？≥0.3 null7＞DX？？≥0.35
     */
    private Long yctpTcType1;

    /**
     * 一次调频分类2累计台次  参考：DX？？≥0.4 null6 null7
     */
    private Long yctpTcType2;

    /**
     * AGC性能范围分类1累计台次  参考：1.0 ＞ S ≥ 0.5
     */
    private Long agcxnTcType1;

    /**
     * AGC性能范围分类2累计台次  参考：1.5 ＞ S ≥ 1.0
     */
    private Long agcxnTcType2;

    /**
     * 火电(燃煤机组)MH排放超标累计次数
     */
    private Long mhCbcs;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getYear() {

        return year;
    }

    public void setYear(String year) {

        this.year = year;
    }

    public String getMonth() {

        return month;
    }

    public void setMonth(String month) {

        this.month = month;
    }

    public Long getHdSo2Emissions() {

        return hdSo2Emissions;
    }

    public void setHdSo2Emissions(Long hdSo2Emissions) {

        this.hdSo2Emissions = hdSo2Emissions;
    }

    public Long getHdNoxEmissions() {

        return hdNoxEmissions;
    }

    public void setHdNoxEmissions(Long hdNoxEmissions) {

        this.hdNoxEmissions = hdNoxEmissions;
    }

    public Long getHdPmEmissions() {

        return hdPmEmissions;
    }

    public void setHdPmEmissions(Long hdPmEmissions) {

        this.hdPmEmissions = hdPmEmissions;
    }

    public Long getHdDl() {

        return hdDl;
    }

    public void setHdDl(Long hdDl) {

        this.hdDl = hdDl;
    }

    public Long getHdCo2Jpl() {

        return hdCo2Jpl;
    }

    public void setHdCo2Jpl(Long hdCo2Jpl) {

        this.hdCo2Jpl = hdCo2Jpl;
    }

    public Long getSo2Cbcs() {

        return so2Cbcs;
    }

    public void setSo2Cbcs(Long so2Cbcs) {

        this.so2Cbcs = so2Cbcs;
    }

    public Long getNoxCbcs() {

        return noxCbcs;
    }

    public void setNoxCbcs(Long noxCbcs) {

        this.noxCbcs = noxCbcs;
    }

    public Long getPmCbcs() {

        return pmCbcs;
    }

    public void setPmCbcs(Long pmCbcs) {

        this.pmCbcs = pmCbcs;
    }

    public Long getGdDl() {

        return gdDl;
    }

    public void setGdDl(Long gdDl) {

        this.gdDl = gdDl;
    }

    public Long getGdCo2Jpl() {

        return gdCo2Jpl;
    }

    public void setGdCo2Jpl(Long gdCo2Jpl) {

        this.gdCo2Jpl = gdCo2Jpl;
    }

    public Long getFdDl() {

        return fdDl;
    }

    public void setFdDl(Long fdDl) {

        this.fdDl = fdDl;
    }

    public Long getFdCo2Jpl() {

        return fdCo2Jpl;
    }

    public void setFdCo2Jpl(Long fdCo2Jpl) {

        this.fdCo2Jpl = fdCo2Jpl;
    }

    public Long getSdDl() {

        return sdDl;
    }

    public void setSdDl(Long sdDl) {

        this.sdDl = sdDl;
    }

    public Long getSdCo2Jpl() {

        return sdCo2Jpl;
    }

    public void setSdCo2Jpl(Long sdCo2Jpl) {

        this.sdCo2Jpl = sdCo2Jpl;
    }

    public Long getSdSo2Emissions() {

        return sdSo2Emissions;
    }

    public void setSdSo2Emissions(Long sdSo2Emissions) {

        this.sdSo2Emissions = sdSo2Emissions;
    }

    public Long getSdNoxEmissions() {

        return sdNoxEmissions;
    }

    public void setSdNoxEmissions(Long sdNoxEmissions) {

        this.sdNoxEmissions = sdNoxEmissions;
    }

    public Long getSdPmEmissions() {

        return sdPmEmissions;
    }

    public void setSdPmEmissions(Long sdPmEmissions) {

        this.sdPmEmissions = sdPmEmissions;
    }

    public Long getFbsDl() {

        return fbsDl;
    }

    public void setFbsDl(Long fbsDl) {

        this.fbsDl = fbsDl;
    }

    public Long getFbsCo2Jpl() {

        return fbsCo2Jpl;
    }

    public void setFbsCo2Jpl(Long fbsCo2Jpl) {

        this.fbsCo2Jpl = fbsCo2Jpl;
    }

    public Long getCdzDl() {

        return cdzDl;
    }

    public void setCdzDl(Long cdzDl) {

        this.cdzDl = cdzDl;
    }

    public Long getCdzSaveQy() {

        return cdzSaveQy;
    }

    public void setCdzSaveQy(Long cdzSaveQy) {

        this.cdzSaveQy = cdzSaveQy;
    }

    public Long getSlgNyxlAvg() {

        return slgNyxlAvg;
    }

    public void setSlgNyxlAvg(Long slgNyxlAvg) {

        this.slgNyxlAvg = slgNyxlAvg;
    }

    public Long getSlgSaveDl() {

        return slgSaveDl;
    }

    public void setSlgSaveDl(Long slgSaveDl) {

        this.slgSaveDl = slgSaveDl;
    }

    public Long getSlgSaveCb() {

        return slgSaveCb;
    }

    public void setSlgSaveCb(Long slgSaveCb) {

        this.slgSaveCb = slgSaveCb;
    }

    public Long getSlgCo2Jpl() {

        return slgCo2Jpl;
    }

    public void setSlgCo2Jpl(Long slgCo2Jpl) {

        this.slgCo2Jpl = slgCo2Jpl;
    }

    public Long getXndcSaveDl() {

        return xndcSaveDl;
    }

    public void setXndcSaveDl(Long xndcSaveDl) {

        this.xndcSaveDl = xndcSaveDl;
    }

    public Long getXndcSaveCb() {

        return xndcSaveCb;
    }

    public void setXndcSaveCb(Long xndcSaveCb) {

        this.xndcSaveCb = xndcSaveCb;
    }

    public Long getXndcCo2Jpl() {

        return xndcCo2Jpl;
    }

    public void setXndcCo2Jpl(Long xndcCo2Jpl) {

        this.xndcCo2Jpl = xndcCo2Jpl;
    }

    public Long getTfjxTc() {

        return tfjxTc;
    }

    public void setTfjxTc(Long tfjxTc) {

        this.tfjxTc = tfjxTc;
    }

    public Long getTfjxXyscAvg() {

        return tfjxXyscAvg;
    }

    public void setTfjxXyscAvg(Long tfjxXyscAvg) {

        this.tfjxXyscAvg = tfjxXyscAvg;
    }

    public Long getYctpTcType1() {

        return yctpTcType1;
    }

    public void setYctpTcType1(Long yctpTcType1) {

        this.yctpTcType1 = yctpTcType1;
    }

    public Long getYctpTcType2() {

        return yctpTcType2;
    }

    public void setYctpTcType2(Long yctpTcType2) {

        this.yctpTcType2 = yctpTcType2;
    }

    public Long getAgcxnTcType1() {

        return agcxnTcType1;
    }

    public void setAgcxnTcType1(Long agcxnTcType1) {

        this.agcxnTcType1 = agcxnTcType1;
    }

    public Long getAgcxnTcType2() {

        return agcxnTcType2;
    }

    public void setAgcxnTcType2(Long agcxnTcType2) {

        this.agcxnTcType2 = agcxnTcType2;
    }

    public Long getMhCbcs() {

        return mhCbcs;
    }

    public void setMhCbcs(Long mhCbcs) {

        this.mhCbcs = mhCbcs;
    }

}
