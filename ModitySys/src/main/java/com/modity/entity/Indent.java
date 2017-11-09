package com.modity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 购物车订单处理类 一
 * Created by Administrator on 2017/11/7.
 */
@Entity
@Table(name="tb_indent")
public class Indent implements Serializable {

    private int ino;
    private long inum=new Date().getTime();//订单号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date itime = new Date();//订单日期
    private int ipay=0;//订单状态 1：支付，0：未支付


    public Indent() {
    }

    public Indent(int ino, long inum, Date itime, int ipay) {
        this.ino = ino;
        this.inum = inum;
        this.itime = itime;
        this.ipay = ipay;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIno() {
        return ino;
    }

    public void setIno(int ino) {
        this.ino = ino;
    }

    @Column(columnDefinition = "date")
    public Date getItime() {
        return itime;
    }

    public void setItime(Date itime) {
        this.itime = itime;
    }

    public int getIpay() {
        return ipay;
    }

    public void setIpay(int ipay) {
        this.ipay = ipay;
    }

    public long getInum() {
        return inum;
    }

    public void setInum(long inum) {
        this.inum = inum;
    }
}
