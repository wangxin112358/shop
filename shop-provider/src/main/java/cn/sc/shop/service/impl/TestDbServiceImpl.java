package cn.sc.shop.service.impl;

import cn.sc.shop.service.TestDbService;

import cn.sc.shop.utils.JsonUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

/**
 * Created by wx on 2020/11/2.
 * 测试业务逻辑
 */

@com.alibaba.dubbo.config.annotation.Service(interfaceClass = TestDbService.class)
@org.springframework.stereotype.Service("testDbService")
public class TestDbServiceImpl implements TestDbService {

    @Autowired
    private SqlSession sqlSession;

    private final String MAPPER_NAMESPACE = "cn.sc.shop.mapper.TestMapper";

    @Override
    public String testList(){
        List<Map> list = sqlSession.selectList(MAPPER_NAMESPACE+".selectTest");
        String jsonList = JsonUtil.objectToJson(list);
        System.out.println("-----"+list.size());
        return jsonList;
    }
}
