package com.glls.stock.controller;

import com.glls.common.entity.Order;
import com.glls.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/updateStock",method = RequestMethod.POST)
    Integer updateStock(@RequestBody Order order){
        return stockService.updateStock(order);
    }


    @RequestMapping(value = "/testStock",method = RequestMethod.GET)
    String testStock(){

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "testStock";
    }

}
