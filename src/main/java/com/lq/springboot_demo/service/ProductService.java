package com.lq.springboot_demo.service;

import com.lq.springboot_demo.entity.Product;
import com.lq.springboot_demo.entity.request.ProductRequest;
import com.lq.springboot_demo.entity.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {


    String insertProduct(ProductRequest request);

    /**
     * 查询一个用户下有多少个产品
     * @param userId
     * @return
     */
    List<Product> queryByUserId(String userId);

    /**
     *
     * @param request
     * @return
     */

    String updateProduct(UpdateProductRequest request);
}
