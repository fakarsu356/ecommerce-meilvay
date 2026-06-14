package com.furkan.trendyoliki.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkan.trendyoliki.entity.Orders;
import com.furkan.trendyoliki.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/orders")
    public List<Orders> findAll(){
        return ordersService.findAll();
    }

    @GetMapping("/Orders/{ordersId}")
    public Orders findById( @PathVariable int ordersId){


        return ordersService.findById(ordersId);
    }

    @PostMapping("/orders")
    public Orders save(@RequestBody Orders orders ){
        Orders item =ordersService.save(orders);
        return  item;
    }
    @PutMapping("/orders")
    public Orders update(@RequestBody Orders orders){
        Orders item =ordersService.save(orders);
        return item;

    }
    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable int id){

        ordersService.deleteById(id);
    }

}
