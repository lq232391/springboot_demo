package com.lq.springboot_demo.mapper;

import com.lq.springboot_demo.entity.OrderProduct;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface OrderProductMapper extends BaseMapper<OrderProduct> {

}
