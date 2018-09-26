package com.mmall.service.Impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther 李明浩
 * @date 9/26/2018 5:22 PM
 */
@Service("iProductService")
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    public ServerResponse saveOrUpdateProduct(Product product){
        if(product != null){
            if(StringUtils.isNotBlank(product.getSubImages())){
                //在数据库中存放的时候以逗号分隔
                String[] subImagesArray = product.getSubImages().split(",");
                if(subImagesArray.length > 0){
                    product.setMainImage(subImagesArray[0]);
                }
            }
            if(product.getId() != null){
                int updateCount = productMapper.updateByPrimaryKey(product);
                if(updateCount > 0){
                    return ServerResponse.createBySuccess("产品更新成功");
                }
                return ServerResponse.createByErrorMessage("产品更新失败");
            }else {
                int rowCount = productMapper.insert(product);
                if (rowCount > 0){
                    return ServerResponse.createBySuccess("产品新增成功");
                }
                return ServerResponse.createByErrorMessage("产品新增失败");
            }
        }else {
            return ServerResponse.createByErrorMessage("产品参数不正确");
        }
    }
}
