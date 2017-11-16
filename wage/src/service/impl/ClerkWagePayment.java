package service.impl;

import model.Post;
import service.WagePayment;

public class ClerkWagePayment implements WagePayment{

    @Override
    public double payment(Post post) {
        return (Double)post.getProperty("wage");
    }
}
