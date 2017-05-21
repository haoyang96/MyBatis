package com.movie.score.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.movie.score.mapper.MovieMapper;
import com.movie.score.model.MovieModel;
import com.movie.score.test.TestMovie;
import com.movie.util.SessionFactory;

/**
 * 
 * 基于junit测试方法 单元测试
 *
 */
public class TestMovie {

	Logger logger;

	/**
	 * 加载Log4j配置文件
	 * 
	 */
	@Before
	public void getLogger() {
		try {
			DOMConfigurator.configure("src/log4j.xml");
			logger = Logger.getLogger(TestMovie.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试addMovie()方法
	 * 
	 */
	//@Test
	public void addStudent() {
		// 电影信息添加
		SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		MovieMapper mapper = session.getMapper(MovieMapper.class);
		MovieModel movieModel = new MovieModel("name", "dir", "actor", "lan", "type", "dis", "2014-02-14", "key",
				"sour", "10");
		mapper.addMovie(movieModel);
		session.commit();
		session.close();
		logger.info("电影" + movieModel.getMovie_name() + "添加成功!");

	}

	/**
	 * 测试delMovieById()方法
	 * 
	 */
	//@Test
	public void delStudentById() {
		// 根据id删除电影信息
		int id = 19;
		SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		MovieMapper mapper = session.getMapper(MovieMapper.class);
		mapper.delMovieById(id);
		session.commit();
		session.close();
		logger.info("编号为" + id + "的电影刪除成功!");

	}

	/**
	 * 测试updateMovie()方法
	 * 
	 */
	//@Test
	public void updateStudentById() {
		// 可以改动电影类型、关键词、电影资源、评分，其余默认是不可改动的
		int id = 20;
		SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		MovieMapper mapper = session.getMapper(MovieMapper.class);
		MovieModel movieModel = new MovieModel("name", "dir", "lan", "type");
		mapper.updateMovie(movieModel, id);
		session.commit();
		session.close();
		logger.info("编号为" + id + "的电影信息更新成功!");

	}

	/**
	 * 测试findMovieById()方法
	 * 
	 */
	@Test
	public void findStudentById() {
		// 根据id查询单部电影信息
		int id = 1;
		SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		MovieMapper mapper = session.getMapper(MovieMapper.class);
		session.commit();
		System.out.println(mapper.findMovieById(id));
		session.close();
		logger.info("编号为" + id + "的电影查询成功!");
	}

	/**
	 * 测试findMovies()方法
	 * 
	 */
	@Test
	public void findStudents() {
		// 查询所有的电影信息
		SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		MovieMapper mapper = session.getMapper(MovieMapper.class);
		session.commit();
		System.out.println(mapper.findMovies());
		session.close();
		logger.info("全部电影信息查询成功!");
	}

}
