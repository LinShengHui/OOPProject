package model;

import service.WagePayment;

import java.util.HashMap;
import java.util.Map;

public class Post {

    private String postName;

    //动态属性
    private Map<String, Object> properties = new HashMap<String, Object>();

    //结算方式
    private WagePayment wagePayment;

    public void setWagePayment(WagePayment wagePayment) {
        this.wagePayment = wagePayment;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    /**
     * 职位的薪资算法
     */
    public double payment(){
        return wagePayment.payment(this);
    }
}
