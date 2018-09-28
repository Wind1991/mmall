package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * @auther 李明浩
 * @date 9/26/2018 9:17 AM
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryname, Integer parentId);
    ServerResponse updateCategoryName(String categoryName,Integer categoryId);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
