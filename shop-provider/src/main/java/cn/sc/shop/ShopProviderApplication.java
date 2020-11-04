package cn.sc.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


//@ComponentScan(value="cn.sc.shop")
@MapperScan("cn.sc.shop.mapper")
@SpringBootApplication
@ImportResource({
		"classpath:/dubbo-provider.xml"
})
public class ShopProviderApplication {

	private static Logger logger  = LoggerFactory.getLogger(ShopProviderApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ShopProviderApplication.class, args);
	}

}
