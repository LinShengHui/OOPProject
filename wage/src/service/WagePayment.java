package service;

import model.Post;

/**
 * 抽象的结算接口
 */
public interface WagePayment {

    /**
     * 抽象算法
     * @param post
     */
    double payment(Post post);
}
