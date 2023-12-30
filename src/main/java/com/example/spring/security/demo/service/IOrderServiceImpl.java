package com.example.spring.security.demo.service;

import com.example.spring.security.demo.domain.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/12/30
 * @description:
 */
@Service
public class IOrderServiceImpl implements IOrderService {

	// 模拟的订单数据
	private static final Map<Long, Order> orders = new HashMap<>();

	static {
		// 初始化一些订单数据
		orders.put(1L, new Order(1L, "user1", "Order1 Details", "CREATED"));
		orders.put(2L, new Order(2L, "user2", "Order2 Details", "CREATED"));
		orders.put(3L, new Order(3L, "admin", "Order3 Details", "SHIPPED"));
	}

	// 3个模拟测试方法

	@Override
	// 确保当前用户是订单的所有者或者是管理员可以查看订单
	@PreAuthorize("#orderId == authentication.principal.username or hasRole('ADMIN')")
	public Order getOrderById(Long orderId) {
		return orders.get(orderId);
	}

	@Override
	// 确保只有订单所有者可以取消订单
	@PreAuthorize("#orderId == authentication.principal.username")
	public void cancelOrder(Long orderId) {
		Order order = orders.get(orderId);
		if (order != null) {
			order.setStatus("CANCELLED");
		}
	}

	@Override
	// 只有超级管理员可以修改订单状态
	@PreAuthorize("hasRole('ADMIN')")
	public void updateOrderStatus(Long orderId, String status) {
		Order order = orders.get(orderId);
		if (order != null) {
			order.setStatus(status);
		}
	}
}
