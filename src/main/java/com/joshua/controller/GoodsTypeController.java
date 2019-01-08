package com.joshua.controller;

import com.joshua.entity.GoodsType;
import com.joshua.server.GoodsTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 产品类型增删改控制器
 * Created by joshua on 2018-04-16.
 */
@Controller
@RequestMapping(path = "/goodsType")
public class GoodsTypeController {

    private static Logger logger = LoggerFactory.getLogger(GoodsTypeController.class);

    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<GoodsType> getAllGoodsType(){
        return goodsTypeRepository.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addGoodsType(@RequestBody GoodsType goodsType){
        goodsTypeRepository.save(goodsType);
        return "OK";
    }

    @DeleteMapping(path = "delete")
    public @ResponseBody String deleteGoodsType(@RequestParam Integer id){
        GoodsType goodsType = goodsTypeRepository.findById(id);
        goodsTypeRepository.delete(goodsType);
        return "OK";
    }

}
