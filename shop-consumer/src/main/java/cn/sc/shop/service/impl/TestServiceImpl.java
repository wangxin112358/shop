package cn.sc.shop.service.impl;

import cn.sc.shop.service.TestService;
import cn.sc.shop.service.TestDubboProviderService;
import cn.sc.shop.utils.JsonUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by wx on 2020/11/2.
 * 测试业务逻辑
 */
//@Component("testDbService")
//@Service(timeout = 60000,interfaceClass = TestService.class)
@org.springframework.stereotype.Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private SqlSession sqlSession;

    private final String MAPPER_NAMESPACE = "cn.sc.shop.provider.mapper.TestMapper";

    @Reference//dubbo注解(url = "dubbo://127.0.0.1:2181")
    private TestDubboProviderService testDubboProviderService;

    /**
     * 测试查询数据库方法
     */
    @Override
    public String testList(){
        List<Map> list = sqlSession.selectList(MAPPER_NAMESPACE+".selectTest");
        String jsonList = JsonUtil.objectToJson(list);
        System.out.println("-----"+list.size());
        return jsonList;
    }

    /**
     * 测试查询dubbo生产者方法
     */
    @Override
    public String say() {

        return testDubboProviderService.sayHello();
    }
}
