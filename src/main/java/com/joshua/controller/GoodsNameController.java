package com.joshua.controller;

import com.joshua.entity.GoodsName;
import com.joshua.server.GoodsNameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by joshua on 2018-04-16.
 * 产品名称增删改控制器
 */

@Controller
@RequestMapping(path = "api/goodsName")
public class GoodsNameController {

    private static Logger logger = LoggerFactory.getLogger(GoodsNameController.class);

    @Autowired
    private GoodsNameRepository goodsNameRepository;

    /**
     * 获取所有产品名称信息
     * @return
     */
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<GoodsName> getAllGoodsName(){
        return goodsNameRepository.findAll();
    }

    /**
     * 新增产品名称信息
     * @param goodsName
     * @return
     */
    @PostMapping(path = "/add")
    public @ResponseBody String addGoodsName(@RequestBody GoodsName goodsName){
        logger.info("name" + goodsName.toString());
        goodsNameRepository.save(goodsName);
        return "OK";
    }

    /**
     * 删除产品名称信息
     * @param id
     * @return
     */
    @RequestMapping(path = "delete",method = RequestMethod.DELETE)
    public @ResponseBody String deleteGoodsName(@RequestParam Integer id){
        GoodsName goodsName = goodsNameRepository.findById(id);
        goodsNameRepository.delete(goodsName);
        return "OK";
    }
}
