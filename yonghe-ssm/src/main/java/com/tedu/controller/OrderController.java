package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Door;
import com.tedu.pojo.Order;

@Controller
public class OrderController {
	/* 通过自动装配从spring容器中获取OrderMapper接口的
	 * 		子类实例，并赋值给dao */
	@Autowired
	private OrderMapper dao;
	@Autowired
	private DoorMapper doorMapper;
	
	/** 1、查询所有订单信息 */
	@RequestMapping("/orderList")
	public String orderList( Model model ) {
		//查询所有门店信息，返回List<Door>集合
		List<Door> dList = doorMapper.findAll();
		//将门店集合存入Model中
		model.addAttribute("dList", dList );
		//查询所有订单信息，返回List<Order>集合
		List<Order> oList = dao.findAll();
		//将订单集合存入Model中
		model.addAttribute("oList", oList);
		return "order_list";
	}
	
	/** 2、查询所有门店列表，并带到订单新增页面进行显示*/
	@RequestMapping("/toOrderAdd")
	public String toOrderAdd( Model model ) {
		//查询所有门店信息，返回List<Door>集合
		List<Door> dList = doorMapper.findAll();
		//将门店集合存入Model中
		model.addAttribute("dList", dList );
		return "order_add";
	}
	
	/** 2、新增订单信息 */
	@RequestMapping("/orderAdd")
	public String orderAdd( Order order ) {
		//调用dao的addOrder方法完成新增订单
		dao.addOrder( order );
		return "forward:/orderList";
	}
	/** 3、根据id删除订单信息 */
	@RequestMapping("/orderDelete")
	public String orderDelete( Integer id ) {
		//调用dao的deleteById方法完成根据id删除订单
		dao.deleteById( id );
		return "forward:/orderList";
	}
	
	/** 4、根据id查询订单信息
	 * 		将查询到的订单信息带到订单修改页面进行回显
	 */
	@RequestMapping("/orderInfo")
	public String orderInfo( Integer id, Model model ) {
		//查询所有门店信息，返回List<Door>集合
		List<Door> dList = doorMapper.findAll();
		//将门店集合存入Model中
		model.addAttribute("dList", dList );
		Order order = dao.findById( id );
		model.addAttribute( "order", order );
		System.out.println( "---------------"+order );
		return "order_update";
	}
	/** 5、根据id修改订单信息 */
	@RequestMapping("/orderUpdate")
	public String orderUpdate( Order order ) {
		dao.updateById( order );
		return "forward:/orderList";
	}
	
	
}










