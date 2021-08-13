package com.lq.springboot_demo.mapper;

import com.lq.springboot_demo.entity.Product;
import com.lq.springboot_demo.entity.request.UpdateCountRequest;
import com.lq.springboot_demo.entity.request.UpdateProductRequest;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface ProduceMapper extends BaseMapper<Product> {

    /**
     * 根据用户id查询产品
     */
    List<Product> queryByUserId(String userId);

    /**
     * 查询产品名称
     */
    List<String> queryProductName();

    /**
     *
     * 根据主键id查询 产品
     * @param id
     * @return
     */

    Product queryById(String id);

    /**
     * 修改产品
     * @param request
     * @return
     */
   void updateProduct(UpdateProductRequest request);

    /**
     * 下单完数量减一
     * @param request
     */
   void updateCount(Product request);

}
