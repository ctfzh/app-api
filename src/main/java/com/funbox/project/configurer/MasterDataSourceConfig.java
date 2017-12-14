package com.funbox.project.configurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.funbox.project.adapter.PerformanceInterceptor;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages=MasterDataSourceConfig.MAPPER_PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
	static final String MAPPER_PACKAGE = "com.funbox.project.dao.mysql";
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driverClassName}")
	private String driverClass;
	
	@Bean(name = "masterDataSource")
	@Primary
	public DataSource masterDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }
	
	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(masterDataSource);

		//配置分页插件，详情请查阅官方文档
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
		properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
		properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
		pageHelper.setProperties(properties);

		//添加插件
		sessionFactory.setPlugins(new Interceptor[] { pageHelper,new PerformanceInterceptor()});

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return sessionFactory.getObject();
	}
	
	/**
	 * 初始化分页插件<br/>
	 *
	 * @return Interceptor
	 */
	public Interceptor pageHelperInit() {
		Properties p = new Properties();
		p.setProperty("dialect", "mysql");
		p.setProperty("reasonable", "true");
		//p.setProperty("mappers", "tk.mybatis.mapper.common.Mapper,learn.zxl.boot.util.mybatis.provider.DemoProvider");
		p.setProperty("pageSizeZero", "false");
		p.setProperty("reasonable", "true");
		Interceptor interceptor = new PageHelper();
		interceptor.setProperties(p);
		return interceptor;
	}
}
