package com.modity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品类
 * Created by Administrator on 2017/11/6.
 */
@Entity
@Table(name="tb_cargo")
public class Cargo implements Serializable {

    private int cno;
    private String cname;
    private double cprice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ctime;
    private String cproducer;
    private int cstate;
    private String curl;

    private Indent indent;

    public Cargo() {
    }

    public Cargo(int cno, String cname, double cprice, Date ctime, String cproducer, int cstate, String curl) {
        this.cno = cno;
        this.cname = cname;
        this.cprice = cprice;
        this.ctime = ctime;
        this.cproducer = cproducer;
        this.cstate = cstate;
        this.curl = curl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getCproducer() {
        return cproducer;
    }

    public void setCproducer(String cproducer) {
        this.cproducer = cproducer;
    }

    public int getCstate() {
        return cstate;
    }

    public void setCstate(int cstate) {
        this.cstate = cstate;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="cino")
    public Indent getIndent() {
        return indent;
    }

    public void setIndent(Indent indent) {
        this.indent = indent;
    }
}
