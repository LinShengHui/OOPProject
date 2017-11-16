package main;

import model.Emp;
import model.Post;
import service.WagePaymentService;

public class Main {

    public static void main(String[] args) {
        Post cleaner = new Post();
        cleaner.setPostName("cleaner");
        cleaner.setProperty("workHours",8);
        cleaner.setProperty("hourWage",10.0);
        Emp emp = new Emp();
        emp.setName("张三");
        emp.setPost(cleaner);
        System.out.println(emp.getName()+" : "+new WagePaymentService(emp).payment());
    }
}
