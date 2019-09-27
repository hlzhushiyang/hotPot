package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;


/* 
 * @Controller的作用：
 * (1)标识当前类属于Controller层
 * (2)将当前类的对象的创建交给spring容器
 */
@Controller
public class TestController {
	/*  @Autowired: 自动装配, DoorMapper接口的实现类以及
	 * 		实现类的实例均由框架提供(创建), 创建之后, 会存放在
	 * 		spring容器中, 通过自动装配, 将DoorMapper接口的
	 * 		实现类的实例赋值给 DoorMapper接口的变量 */
	@Autowired 
	DoorMapper dao;
	
	/** 3、测试SSM的运行环境 
	 * 	查询所有门店信息 */
	@RequestMapping("/testssm")
	public String testssm( Model model ) {
		//查询所有门店信息, 返回门店对象集合
		List<Door> list = dao.findAll();
		//将门店集合存入Model中
		model.addAttribute("list", list);
		//转向test.jsp, 取出所有门店并显示
		return "test";
	}
	
	/** 1、测试springmvc的运行环境 */
	@RequestMapping("/testSpringmvc")
	public String testSpringmvc() {
		System.out.println("TestController.testSpringmvc()");
		return "test";
	}
	
	/** 2、测试mybatis运行环境 
	 * @throws Exception */
	/*
	@Test
	public void testMybatis() throws Exception {
		//1.读取mybatis的核心配置文件
		InputStream in = 
			Resources.getResourceAsStream(
				"mybatis/mybatis-config.xml");
		//2.获取SqlSession工厂对象
		SqlSessionFactory fac = 
				new SqlSessionFactoryBuilder().build( in );
		//3.获取SqlSession对象
		SqlSession session = fac.openSession();
		//4.获取DoorMapper接口的子类实例
		DoorMapper dao = session
				.getMapper( DoorMapper.class );
		//5.调用findAll方法查询所有门店信息
		List<Door> list = dao.findAll();
		//6.输出所有门店
		for (Door door : list) {
			System.out.println( door );
		}
	} */
	
	
	
	
	
}






