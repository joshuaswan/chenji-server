package com.joshua.controller;

import com.joshua.entity.GoodsType;
import com.joshua.entity.MeasureUnit;
import com.joshua.server.MeasureUnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(path = "api/measureUnit")
public class MeasureUnitController {

    private static Logger logger = LoggerFactory.getLogger(MeasureUnitController.class);

    @Autowired
    private MeasureUnitRepository measureUnitRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<MeasureUnit> getAllMeasureUnit(){
        return measureUnitRepository.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addGoodsType(@RequestBody MeasureUnit measureUnit){
        measureUnitRepository.save(measureUnit);
        return "OK";
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteGoodsType(@RequestParam Integer id){
        MeasureUnit measureUnit = measureUnitRepository.findById(id);
        measureUnitRepository.delete(measureUnit);
        return "OK";
    }


}
