package com.modity.web;

import com.modity.entity.Carltem;
import com.modity.service.CargoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/7.
 */
@Controller
@RequestMapping("/carAction")
@Scope("prototype")
public class CarAction {

    @Resource(name="cargoService")
    private CargoService cargoService;

    @RequestMapping("/docarItem")
    public String doCarItem(int[] cno,int[] number){
        for (int i=0;i<cno.length;i++){
            System.out.println("商品编号"+cno[i]+"商品数量"+number[i]);
        }
        return "redirect:/shopCar.jsp";
    }


    @RequestMapping("/addCar")
    public String addCar(Carltem carltem, int number, HttpSession session){
        System.out.println(carltem.getCargo().getCno()+carltem.getNumber());
        int pno=carltem.getCargo().getCno();
        int num=carltem.getNumber();
        Map car=(Map)session.getAttribute("car");
        if(car==null){//第一次
            car = new HashMap();
        }
        //判断车上有没有物品
        if(car.containsKey(carltem.getCargo().getCno())){
            Carltem item = (Carltem) car.get(pno);
            item.setNumber(item.getNumber()+num);
        }else{
            Carltem item = new Carltem();
            item.setCargo(cargoService.findCargo(pno));
            item.setNumber(num);
            car.put(pno,item);
        }
        session.setAttribute("car",car);

        return "redirect:/shopCar.jsp";
    }





    public void setCargoService(CargoService cargoService) {
        this.cargoService = cargoService;
    }
}
