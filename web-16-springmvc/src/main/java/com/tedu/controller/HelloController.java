package com.tedu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.pojo.Emp;
import com.tedu.pojo.User;

/**
* @author 作者：Fiona
* @version 创建时间：2019年9月17日 下午4:03:34
* @description 描述：
*/
@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("HelloController.hello()");
		return "home";
	}
	/*
	 * 1.springmvc参数绑定
	 * 基本数据类型参数绑定
	 */
	@RequestMapping("/testParam1")
	public String testParam1(String name,Integer age,String addr){
		System.out.println("name+"+name);
		System.out.println("age+"+age);
		System.out.println("addr+"+addr);
		return "home";
	}
	
	/*
	 * 2.springmvc参数绑定
	 * 包装数据类型参数绑定
	 */
	@RequestMapping("/testParam2")
	public String testParam1(User user){
		System.out.println(user);
		return "home";
	}
	
	
	@RequestMapping("/testParam3")
	public String testParam3(String name, String job,Double sal ){
		System.out.println("name"+name);
		System.out.println("job"+job);
		System.out.println("sal"+sal);
		
		return "home";
		
	}
	
	

	@RequestMapping("/testParam4")
	public String testParam4(Emp emp){
		System.out.println(emp);
		
		return "home";
	}
	

	@RequestMapping("/testParam5")
	//date=2018/07/09%2015:15:03
	//导包的时候注意util
	public String testParam5(Date date){
		System.out.println(date);
		return "home";
	}
	/* 自定义日期转换格式 */
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder (ServletRequestDataBinder binder){
		binder.registerCustomEditor(java.util.Date.class, 
			 new CustomDateEditor(
					 new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true)
		);
	}
	
	@RequestMapping("/testForward")
	public String testForward(){
		System.out.println("HelloController.testForward()");
		//将请求转发到/hello
		return "forward:/hello";
		
	}
	
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("HelloController.testRedirect()");
		return "redirect:/hello";
	}
	
	@RequestMapping("/testGet")
	public String testGet(String username,String[] like){
		System.out.println(username);
		System.out.println(Arrays.toString(like));
		return "home";
	}
	
	@RequestMapping("/testPost")
	public String testPost(String username,String[] like){
		System.out.println(username);
		System.out.println(Arrays.toString(like));
		return "home";
	}
	/* 响应数据(Model和Json)  */
	@RequestMapping("/testModel1")
	public String testModel1(Model model){
		User u1 = new User("杭州",14,"北京");
		model.addAttribute("u1", u1);
		return "home";
	}
	 
	@RequestMapping("/testModel2")
	public String testModel2(Model model){
		
		List list = new ArrayList();
		list.add(new User("杭州",14,"北京"));
		list.add(new User("李志刚",14,"北京"));
		list.add(new User("王姐",30,"北京"));
		
		model.addAttribute("list", list);
		
		return "home";
	}
	 
	 
		@RequestMapping("/testModel3")
		public String testModel3(Model model){
			return "home";
		}
		
		
		@RequestMapping("/testModel4")
		public String testModel4(Model model){
			return "home";
		}
		
		//测试响应Json
		@RequestMapping("/testJson1")
		@ResponseBody
		public User testJson1(){
			User u1 = new User("杭州",14,"北京");
			return u1;
			
		}
		
		@RequestMapping("/testJson2")
		@ResponseBody
		public List testJson2(){
			//模拟查询所有用户,将所有用户信息封装到List<User>集合中
			List list = new ArrayList();
			list.add( new User("张三", 18, "北京") );
			list.add( new User("李四", 20, "上海") );
			list.add( new User("王五", 22, "广州") );
			
			//将所有用户的List<User>集合以JSON格式响应
			return list;
		}

}
