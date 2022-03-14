package com.greedy.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
	
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "C##REVIEW";
	private static String PASSWORD = "REVIEW";
	
	public static void main(String[] args) {
		
		Environment environment = 
				new Environment("dev"													//환경 정보 이용
								, new JdbcTransactionFactory()							//트랜잭선 매니저 종류 결정
								, new PooledDataSource(DRIVER, URL, USER, PASSWORD));	//Connection pool 사용 유무
		
		Configuration configuration = new Configuration(environment);
		
		configuration.addMapper(Mapper.class);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		
		java.util.Date date = mapper.selectSysdate();
		
		System.out.println(date);
		
		sqlSession.close();
	}
}
