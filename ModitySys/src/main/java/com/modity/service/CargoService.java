package com.modity.service;

import com.modity.dao.CargoDao;
import com.modity.entity.Cargo;
import com.modity.entity.Indent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品服务层
 * Created by Administrator on 2017/11/6.
 */
@Service("cargoService")
@Transactional(propagation = Propagation.REQUIRED)
public class CargoService {

    @Resource(name="cargoDao")
    private CargoDao cargoDao;

    //添加商品
    public boolean addCargo(Cargo cargo){
        //调用dao层方法
        return cargoDao.addCargo(cargo);
    }

    //查询所有商品
    public List findCargoList(String[] res){
        String hql="from Cargo c where c.cstate=1 ";
        if(res!=null&&res.length>0){
            hql+=" and c.cname like '%"+res[0]+"%' and c.cprice like '%"+res[1]+"%'";
        }
        System.out.println(hql);
        return cargoDao.findCargoList(hql);
    }

    //根据ID查询商品
    public Cargo findCargo(int i){
        return cargoDao.findCargo(i);
    }



    public void setCargoDao(CargoDao cargoDao) {
        this.cargoDao = cargoDao;
    }
}
