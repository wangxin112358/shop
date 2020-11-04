package cn.sc.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(value="cn.sc.shop")
@MapperScan("cn.sc.shop.mapper")
@SpringBootApplication
@ImportResource({
        "classpath:/dubbo-consumer.xml"
})
public class ShopConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopConsumerApplication.class, args);
    }

}
