package com.modity.dao;

import com.modity.entity.Cargo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Repository
public class CargoDao extends BaseDao {

    public boolean addCargo(Cargo cargo){
        getSession().save(cargo);
        return true;
    }

    public List findCargoList(String hql){
        return getSession().createQuery(hql).list();
    }

    public Cargo findCargo(int i){
        return getSession().get(Cargo.class,i);
    }
}
