package com.lq.springboot_demo;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.lq.springboot_demo.entity.Address;
import com.lq.springboot_demo.entity.Order;
import com.lq.springboot_demo.entity.response.OrderResponse;
import com.lq.springboot_demo.mapper.AddressMapper;
import com.lq.springboot_demo.mapper.OrderMapper;
import com.lq.springboot_demo.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ComponentScan("com.lq.springboot_demo")
@MapperScan(value = {"com.lq.mapper","com.lq.springboot_demo.mapper"})
@EntityScan(basePackages={"com.lq.springboot_demo.entity"})
class SpringbootDemoApplicationTests {

    @Autowired
    private OrderMapper OrderMapper;
    @Resource
    private AddressService addressService;
    @Resource
    private AddressMapper addressMapper;

    @Test
    void contextLoads() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            DateTime dateTime = DateUtil.offsetSecond(new Date(), 15);
            int second = DateUtil.second(dateTime);
            int minute = DateUtil.minute(dateTime);
            int hour = DateUtil.hour(dateTime, true);
            int day = DateUtil.dayOfMonth(dateTime);
            int month = DateUtil.month(dateTime) + 1;
            String cron = second + " " + minute + " " + hour + " " + day + " " + month + " ?";
            System.out.println("指针偏移量" + cron);

        }

    }
    @Test
    public  void testa(){
        Order Order = OrderMapper.selectById("0SLJW6R72DJFECD0P29S1YJPI2BRGT2R");
        System.out.println("aaaaaa"+Order);
    }
    @Test
    public void testAddress(){
        List<Address> addresses = addressService.queryAll("4028829379efc22e0179efc561e30002");
        for (Address address : addresses) {
            System.out.println("4028829379efc22e0179efc561e30002"+address);
        }
    }
    @Test
    public void testUser(){
        List<String> byUserId = addressMapper.findByUserId("1");
        for (String s : byUserId) {
            System.out.println(s);
        }
    }
    @Test
    public void testOrder(){
        Order dwxrpa4U95LGB7K1801F4KHCRNOQRTEB = OrderMapper.selectById("DWXRPA4U95LGB7K1801F4KHCRNOQRTEB");
        System.out.println(dwxrpa4U95LGB7K1801F4KHCRNOQRTEB);
    }
    @Test
    public void testCollection(){
        List<OrderResponse> a972eb7566294a24a165f43a9317b624 = OrderMapper.queryByUserId("123");
        for (OrderResponse OrderResponse : a972eb7566294a24a165f43a9317b624) {
            System.out.println("aaaaaaaaaaaaa"+OrderResponse);
        }
    }

}
