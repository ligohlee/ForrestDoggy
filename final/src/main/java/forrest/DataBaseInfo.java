package forrest;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
public class DataBaseInfo {
	@Bean	//스프링에 필요한 객체를 생성한다.'
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) 
			 throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}	 
}
