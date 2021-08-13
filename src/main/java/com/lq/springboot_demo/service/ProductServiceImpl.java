package com.lq.springboot_demo.service;

import com.lq.springboot_demo.entity.Product;
import com.lq.springboot_demo.entity.request.ProductRequest;
import com.lq.springboot_demo.entity.request.UpdateProductRequest;
import com.lq.springboot_demo.mapper.ProduceMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProduceMapper produceMapper;

    @Override
    public String insertProduct(ProductRequest request) {
        List<String> productName = produceMapper.queryProductName();
        for (String s : productName) {
            if(request.getProductName().equals(s)){
                return "该产品名称已存在";
            }

        }
        Product product = new Product();
        BeanUtils.copyProperties(request,product);
        product.setId(UUID.randomUUID().toString().replaceAll("-",""));
        product.setCreateTime(new Date());
        product.setIsDelete(Boolean.FALSE);
        produceMapper.insert(product);
        return "添加成功";
    }

    @Override
    public List<Product> queryByUserId(String userId) {
        List<Product> products = produceMapper.queryByUserId(userId);
        return products;
    }

    @Override
    public String updateProduct(UpdateProductRequest request) {

        Product product = produceMapper.queryById(request.getId());
        if(StringUtils.isEmpty(product)){
            return "没有该产品";
        }
        produceMapper.updateProduct(request);

        return "修改成功";
    }
}
