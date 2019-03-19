package com.netease.salessystem.controller;

import com.netease.salessystem.common.JsonResult;
import com.netease.salessystem.domain.SaleContent;
import com.netease.salessystem.domain.ShoppingCartItem;
import com.netease.salessystem.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author:626hp
 * @date:2019/3/11
 * @description:
 */
@Controller
@RequestMapping("/api/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping("/list_bought")
    @ResponseBody
    public JsonResult list(@RequestParam Integer buyerId) {
        return JsonResult.create().addResult(buyerService.list(buyerId));
    }

    @RequestMapping("/list_unbought")
    @ResponseBody
    public JsonResult listUnbought(@RequestParam Integer buyerId) {
        return JsonResult.create().addResult(buyerService.listUnbought(buyerId));
    }

    @RequestMapping(value = "/add_shoppingcart_item", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addShoppingCartItem(@RequestBody SaleContent saleContent, @RequestParam Integer buyerId, @RequestParam Integer num) {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setBuyerId(buyerId);
        shoppingCartItem.setNum(num);
        shoppingCartItem.setSaleContent(saleContent);
        buyerService.addShoppingCartItem(shoppingCartItem);
        return JsonResult.create();
    }

    @RequestMapping("/select_shoppingcart_item")
    @ResponseBody
    public JsonResult selectShoppingCartItem(@RequestParam Integer productId) {
        return JsonResult.create().addResult(buyerService.select(productId));
    }

    @RequestMapping("/list_shoppingcart_item")
    @ResponseBody
    public JsonResult listShoppingCartItem(Integer buyerId) {
        return JsonResult.create().addResult(buyerService.listShoppingCartItem(buyerId));
    }

}
