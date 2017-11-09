package com.modity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/6.
 */
@Entity
@Table(name="tb_userinfo")
public class UserInfo implements Serializable {

    private int ino;
    private String iname;
    private String isex;
    private String iphone;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date itime;
    private String iemalisite;
    private String iurl;

    private User user;

    
    public UserInfo() {
    }

    public UserInfo(int ino, String iname, String isex, String iphone, Date itime, String iemalisite, String iurl) {
        this.ino = ino;
        this.iname = iname;
        this.isex = isex;
        this.iphone = iphone;
        this.itime = itime;
        this.iemalisite = iemalisite;
        this.iurl = iurl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIno() {
        return ino;
    }

    public void setIno(int ino) {
        this.ino = ino;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIsex() {
        return isex;
    }

    public void setIsex(String isex) {
        this.isex = isex;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    @Column(columnDefinition = "date")
    public Date getItime() {
        return itime;
    }

    public void setItime(Date itime) {
        this.itime = itime;
    }

    public String getIemalisite() {
        return iemalisite;
    }

    public void setIemalisite(String iemalisite) {
        this.iemalisite = iemalisite;
    }

    public String getIurl() {
        return iurl;
    }

    public void setIurl(String iurl) {
        this.iurl = iurl;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="iuno")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

