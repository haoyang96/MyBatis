package com.movie.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author 杨浩
 * 
 * @version 1.0
 *
 */
public class SessionFactory {

	/**
	 * 创建session的实例
	 * 
	 * @return session
	 */
	public static SqlSessionFactory getSessionFactory() {
		String resource = "conf.xml";
		InputStream is = SessionFactory.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		return sessionFactory;
	}
}
