package com.dbs.web.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.BuyOrder;
import com.dbs.web.beans.SellOrder;
import com.dbs.web.services.BuyOrderService;
import com.dbs.web.services.SellOrderService;

@RestController
@CrossOrigin
@RequestMapping("/sellOrder")
public class SellOrderRestController {
	
	@Autowired
	private SellOrderService sellService;
	
	@PostMapping
    public ResponseEntity<Map<String, String>> insertBuyOrder(@RequestBody SellOrder sellOrder)
    {
        boolean s=this.sellService.insertSellOrder(sellOrder);
        Map<String,String> map=new HashMap<>();
        if(s==true)
        {
            
            //System.out.println("if block");
            map.put("message", "success");
            return  ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(map);
        }
        //System.out.println("outside");
        map.put("message","Unsuccessful");
        return  ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(map);
    }


}
