package cn.com.liandisys.util.model;

/**
 * 公用代码条目
 * 
 * @author DYQ
 */
public class CommCode {

    /** 值 */
    private String value;

    /** 显示内容 */
    private String text;

    /** 是否选中 */
    private boolean selected;

    public CommCode() {
        super();
    }

    public CommCode(String value, String text) {
        super();
        this.value = value;
        this.text = text;
    }
    
    public CommCode(String value, String text, boolean selected) {
        super();
        this.value = value;
        this.text = text;
        this.selected = selected;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public boolean isSelected() {

        return selected;
    }

    public void setSelected(boolean selected) {

        this.selected = selected;
    }

}
