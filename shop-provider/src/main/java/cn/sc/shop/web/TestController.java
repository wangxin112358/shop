package cn.sc.shop.web;

import cn.sc.shop.redis.RedisUtil;
import cn.sc.shop.service.TestDubboProviderService;
import cn.sc.shop.service.impl.TestDbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wx on 2020/11/1.
 * 测试跳转
 */
@Controller
@RequestMapping("/testProvider")
public class TestController {

    @Autowired
    private TestDbServiceImpl testDbService;

    @Autowired
    private TestDubboProviderService testDubboProviderService;
    @Resource
    private  RedisUtil redisUtil;

    /**
     * 测试方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/testMethod", method ={RequestMethod.POST ,RequestMethod.GET })
    @ResponseBody
    public String test(HttpServletRequest request){
       String response = testDbService.testList();
        return response;
    }

    /**
     * dubbo生产者方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/dubboProvider", method = RequestMethod.POST)
    @ResponseBody
    public String dubboProvider(HttpServletRequest request){
        String response = testDubboProviderService.sayHello();
        return response;
    }

    /**
     * dubbo生产者方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/testRedis", method = RequestMethod.POST)
    @ResponseBody
    public String testRedis(HttpServletRequest request){
        redisUtil.set("aa","男神");
       String response = (String) redisUtil.get("aa");      //print 男神
        return response;
    }




}
