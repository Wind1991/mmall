package com.mmall.controller.protal;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.service.IProductService;
import com.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther 李明浩
 * @date 9/29/2018 3:50 PM
 */
@Controller
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId){
        return iProductService.getProductDetail(productId);
    }
    //用户搜索的时候获取产品结果

    @RequestMapping("list.do")
    @ResponseBody
    //keyword为用户搜索的时候填写的搜索信息
    public ServerResponse<PageInfo> List(@RequestParam(value = "keyword",required = false)String keyword,
                                          @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                          @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                                          @RequestParam(value = "orderBy",defaultValue = "")String orderBy){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }
}
