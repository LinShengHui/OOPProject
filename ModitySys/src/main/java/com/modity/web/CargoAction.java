package com.modity.web;

import com.modity.entity.Cargo;
import com.modity.service.CargoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 商品的控制层
 * Created by Administrator on 2017/11/6.
 */
@Controller
@RequestMapping("/cargoAction")
@Scope("prototype")
public class CargoAction {

    @Resource(name="cargoService")
    private CargoService cargoService;

    //添加商品
    @RequestMapping("/addCargo")
    public String addCargo(MultipartFile imgfile, Cargo cargo,HttpSession session){
        if(!imgfile.isEmpty()){
            //获取服务器路径
            String basePath=session.getServletContext().getRealPath("/images");
            String realName=imgfile.getOriginalFilename();//真实上传的文件名
            try {
                imgfile.transferTo(new File(basePath+"/"+realName));
                cargo.setCurl(realName);
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }else{
            cargo.setCurl("");
        }

        if(cargoService.addCargo(cargo)){
            return "redirect:/addCargo.jsp?message=1";
        }else{
            return "redirect:/addCargo.jsp?message=0";
        }

    }

    //异步查询商品获取数据
    @RequestMapping("/findCargoList")
    @ResponseBody
    public List findCargoList(String[] rsg){
       List list = cargoService.findCargoList(rsg);
        return list;
    }

    //查看商品详细信息
    @RequestMapping("/findCargo")
    @ResponseBody
    public Cargo findCargo(int cno){

        return cargoService.findCargo(cno);
    }

    public void setCargoService(CargoService cargoService) {
        this.cargoService = cargoService;
    }
}
