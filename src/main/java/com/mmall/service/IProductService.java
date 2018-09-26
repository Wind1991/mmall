package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;

/**
 * @auther 李明浩
 * @date 9/26/2018 5:22 PM
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);
}
