package cn.sc.shop.service.impl;

import cn.sc.shop.service.TestDubboProviderService;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * Created by wx on 2020/11/2.
 * dubbo生产者service
 */

@org.springframework.stereotype.Service("testDubboProviderService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = TestDubboProviderService.class)
@Slf4j
public class TestDubboProviderServiceImpl implements TestDubboProviderService {
    @Override
    public String sayHello() {

        return "hello dubbo，I‘m provider";
    }
}
