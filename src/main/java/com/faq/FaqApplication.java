package com.faq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.faq.mapper") // 这个配置和上面的mapper配置中@Mapper 相互作用才能正常读到mapper
public class FaqApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaqApplication.class, args);
	}


}
