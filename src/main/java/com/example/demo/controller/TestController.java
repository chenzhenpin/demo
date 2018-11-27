package com.example.demo.controller;

import com.example.demo.VO.Goods;
import com.example.demo.VO.GoodsItem;
import com.example.demo.VO.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/goods")
    @ResponseBody
    public Result<Goods> getGoods(){
        Result<Goods> result=new Result<Goods>();
        List<Goods> goodsList = new ArrayList<Goods>();

        Goods goods1=new Goods();
        goods1.setTypeId("123456");
        goods1.setIsLink(false);
        goods1.setTypeName("药品类");
        goods1.setSrc("../../static/img/logo.png");
        goods1.setStatus(false);
        goods1.setIsLink(false);

        Goods goods2=new Goods();
        goods2.setTypeId("123457");
        goods2.setIsLink(false);
        goods2.setTypeName("药品类");
        goods2.setIsLink(true);

        Goods goods3=new Goods();
        goods3.setTypeId("123456");
        goods3.setIsLink(true);
        goods3.setTypeName("药品类");
        goods3.setSrc("../../static/img/logo.png");
        goods3.setIsLink(false);
        goods3.setStatus(false);

        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        result.setMsg(goodsList);
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
    @PostMapping("/goods")
    @ResponseBody
    public Result<String> saveGoods( @RequestBody List<Goods> goodsList){

        Result<String> result=new Result<String>();
        System.out.println(goodsList);
        return result;
    }

    @GetMapping("/goodsItem/{goodsId}")
    @ResponseBody
    public Result<GoodsItem> goodsItem(@PathVariable("goodsId") String goodsId){
        System.out.println(goodsId);
        Result<GoodsItem> result=new Result<GoodsItem>();
        List<GoodsItem> goodsItemList = new ArrayList<GoodsItem>();

        GoodsItem goodsItem = new GoodsItem();
        goodsItem.setGoodsId("12345671");
        goodsItem.setGoodsName("物品一");
        goodsItem.setSysNumber("3");
        goodsItem.setCheckNumber("3");
        goodsItem.setStatus(false);

        GoodsItem goodsItem2 = new GoodsItem();
        goodsItem2.setGoodsId("12345672");
        goodsItem2.setGoodsName("物品二");
        goodsItem2.setSysNumber("3");
        goodsItem2.setCheckNumber("3");
        goodsItem2.setStatus(true);

        GoodsItem goodsItem3 = new GoodsItem();
        goodsItem3.setGoodsId("12345673");
        goodsItem3.setGoodsName("物品三");
        goodsItem3.setSysNumber("3");
        goodsItem3.setCheckNumber("3");
        goodsItem3.setStatus(false);

        GoodsItem goodsItem4 = new GoodsItem();
        goodsItem4.setGoodsId("12345674");
        goodsItem4.setGoodsName("物品四");
        goodsItem4.setSysNumber("2");
        goodsItem4.setCheckNumber("3");
        goodsItem4.setStatus(true);

        goodsItemList.add(goodsItem);
        goodsItemList.add(goodsItem2);
        goodsItemList.add(goodsItem3);
        goodsItemList.add(goodsItem4);

        result.setMsg(goodsItemList);
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping("/goodsItem")
    @ResponseBody
    public Result<String> saveGoodsItem( @RequestBody List<GoodsItem> goodsList){

        Result<String> result=new Result<String>();
        System.out.println(goodsList);
        return result;
    }


}
