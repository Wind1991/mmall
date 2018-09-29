package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * @auther 李明浩
 * @date 9/26/2018 5:22 PM
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);
    ServerResponse setSaleStatus(Integer productId,Integer status);
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
    ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize);
    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,Integer pageNum,Integer pageSize);
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);
}
