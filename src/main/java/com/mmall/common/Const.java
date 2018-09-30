package com.mmall.common;

import com.google.common.collect.Sets;
import com.mmall.util.PropertiesUtil;
import com.mmall.vo.ProductDetailVo;

import java.util.Set;

/**
 * @auther 李明浩
 * @date 9/21/2018 11:22 AM
 */
//const常量类
public class Const {
    public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String USERNAME ="username";
    public interface Role{
        int ROLE_CUSTOMER = 0;//普通用户
        int ROLE_ADMIN = 1;//管理员
    }

    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }
    //常量类
    public enum ProductStatusEnum{
        ON_SALE(1,"在线");
        private String value;
        private int code;
        ProductStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        public String getValue(){
            return value;
        }
        public int getCode(){
            return code;
        }
    }
}
