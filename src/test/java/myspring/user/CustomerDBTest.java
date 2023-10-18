package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.service.CustomerService;
import myspring.customer.vo.CustomerVo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:spring-beans-customers.xml")
public class CustomerDBTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	CustomerService customerService;

	@Test
	public void service() {
		CustomerVo customer = customerService.selectCustomerByName("dooly");
		System.out.println(customer);
		
	}
	
	@Test
	public void mapper() {
		CustomerVo customer = customerMapper.selectCustomerByName("gildong");
		System.out.println(customer);
	}
	
	@Test @Disabled
	public void session() {
		CustomerVo customer = sqlSession.selectOne("customerNS.selectUserByName", "dooly");
		System.out.println(customer);
	}
	
	@Test
	public void sqlSessionFactory() {
		System.out.println(sqlSessionFactory.getClass().getName());

	}
	
	@Test
	public void conn() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Product Name :"+ metaData.getDatabaseProductName());
			System.out.println("DB Driver :"+ metaData.getDriverName());
			System.out.println("DB URL :"+ metaData.getURL());
			System.out.println("DB Username :"+ metaData.getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
