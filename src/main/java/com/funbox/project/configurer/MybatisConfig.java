package com.funbox.project.configurer;

import com.funbox.project.core.MyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class MybatisConfig {
	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		//basePackage 必须存在，org.mybatis.spring.mapper.MapperScannerConfigurer 中在属性设置好之后，会校验属性basePackage不为空
		mapperScannerConfigurer.setBasePackage("com.funbox.project.dao");
		//标记接口，继承该接口的接口，在MapperScannerConfigurer#setMarkerInterface时，会自动注册到通用Mapper
		//如果此项不配置，自定义的接口不会生效
		mapperScannerConfigurer.setMarkerInterface(MyMapper.class);
		return mapperScannerConfigurer;
	}
}
