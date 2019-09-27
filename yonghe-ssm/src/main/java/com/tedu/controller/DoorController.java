package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

@Controller
public class DoorController {
	/** 通过自动装配从spring容器中获取DoorMapper接口
	 * 的子类实例，赋值给dao */
	@Autowired 
	private DoorMapper dao;
	
	/** 1、查询所有门店信息 */
	@RequestMapping("/doorList")
	public String doorList( Model model ) {
		//调用dao的findAll方法查询所有门店信息
		List<Door> list = dao.findAll();
		//将门店对象集合存入Model中
		model.addAttribute( "list", list );
		//转向door_list.jsp，遍历并显示所有门店信息
		return "door_list";
	}
	
	/** 2.新增门店信息 */
	@RequestMapping("/doorAdd")
	public String doorAdd( Door door ) {
		//调用dao的addDoor方法添加门店信息
		dao.addDoor( door );
		//新增成功后跳转回门店列表页面，显示最新列表
		return "forward:/doorList";
	}
	
	/** 3.根据id删除门店信息 */
	@RequestMapping("/doorDelete")
	public String doorDelete( Integer id ) {
		dao.deleteById( id );
		//删除成功后跳转回门店列表页面，显示最新列表
		return "forward:/doorList";
	}
	
	/** 4、根据id查询门店信息, 将门店信息带到门店修改页面 */
	@RequestMapping("/doorInfo")
	public String doorInfo( Integer id, Model model ) {
		//根据id查询门店信息
		Door door = dao.findById( id );
		//将门店对象存入Model中
		model.addAttribute( "door", door );
		//转向门店修改页面, 进行数据的回显
		return "door_update";
	}
	
	/** 5、根据id修改门店信息 */
	@RequestMapping("/doorUpdate")
	public String doorUpdate( Door door ) {
		dao.updateById( door );
		//修改成功后跳转回门店列表页面，显示最新列表
		return "forward:/doorList";
	}
	
	
	
	
	/** 通用的页面跳转方法
	 * 		举例：当浏览器访问 ../index 时, 此时{pageName}中
	 * 		的 pageName的值就是index，方法上的pageName
	 * 		参数的值，也是index， 方法里，return的 pageName
	 * 		的值也是index
	 * 		因此，在访问jsp时，只要通过 /文件名，最后return的
	 * 		也是 文件名，就会到 /WEB-INF/pages/文件名.jsp
	 */
	@RequestMapping("/{pageName}")
	public String toPage(@PathVariable String pageName ) {
		return pageName;
	}
}









