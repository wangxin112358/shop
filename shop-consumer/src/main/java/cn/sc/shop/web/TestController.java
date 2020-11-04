package cn.sc.shop.web;


import cn.sc.shop.redis.RedisUtil;
import cn.sc.shop.service.impl.TestServiceImpl;

import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/testConsumer")
public class TestController {

    @Autowired
    private TestServiceImpl testService;


    @Resource
    private RedisUtil redisUtil;
    /**
     * 测试方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/testMethod", method ={RequestMethod.POST ,RequestMethod.GET })
    @ResponseBody
    public String test(HttpServletRequest request){
        String response = testService.testList();
        return response;
    }

    /**
     * dubbo消费者方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/dubboConsumer", method ={RequestMethod.POST ,RequestMethod.GET })
    @ResponseBody
    public String dubboConsumer(HttpServletRequest request){
        String response = testService.say();
        if(StringUtils.isBlank(response)){
            response = "not visit provider";//没有访问到生产者
        }else{
            response = response+",visit success";//访问到生成者成功
        }
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
