package service.impl;

import model.Post;
import service.WagePayment;

public class CleanerWagePayment implements WagePayment {

    @Override
    public double payment(Post post) {
        int workHours = (Integer)post.getProperty("workHours");
        double hourWage = (Double)post.getProperty("hourWage");
        return workHours * hourWage;
    }
}
