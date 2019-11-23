package cqu.domain;

import java.io.Serializable;

public class ClassData implements Serializable {
    private String teacher;
    private String classId;
    private Integer total;
    private String weChat;
    private String zhangYou;
    private String shoppingCart;

    @Override
    public String toString() {
        return "ClassData{" +
                "teacher='" + teacher + '\'' +
                ", classId='" + classId + '\'' +
                ", total=" + total +
                ", weChat='" + weChat + '\'' +
                ", zhangYou='" + zhangYou + '\'' +
                ", shoppingCart='" + shoppingCart + '\'' +
                '}';
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getZhangYou() {
        return zhangYou;
    }

    public void setZhangYou(String zhangYou) {
        this.zhangYou = zhangYou;
    }

    public String getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(String shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
