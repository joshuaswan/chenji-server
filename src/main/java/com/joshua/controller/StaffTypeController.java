package com.joshua.controller;

import com.joshua.entity.StaffType;
import com.joshua.server.StaffTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by joshua on 2018-04-18.
 * 用户类型增删改控制器
 */

@Controller
@RequestMapping(path = "/staffType")
public class StaffTypeController {

    private static Logger logger = LoggerFactory.getLogger(StaffTypeController.class);

    @Autowired
    private StaffTypeRepository staffTypeRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<StaffType> getAllMeasureUnit(){
        return staffTypeRepository.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addGoodsType(@RequestBody StaffType staffType){
        staffTypeRepository.save(staffType);
        return "OK";
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteGoodsType(@RequestParam Integer id){
        StaffType staffType = staffTypeRepository.findById(id);
        staffTypeRepository.delete(staffType);
        return "OK";
    }


}
