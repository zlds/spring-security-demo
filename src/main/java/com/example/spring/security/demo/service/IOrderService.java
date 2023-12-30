package com.example.spring.security.demo.service;

import com.example.spring.security.demo.domain.Order;

/**
 * @author: hanchaowei
 * @date 2023/12/30
 * @description:
 */

public interface IOrderService {

	/**
	 * 根据订单id获取订单信息
	 * @param orderId
	 * @return
	 */
	public Order getOrderById(Long orderId);

	/**
	 * 取消订单
	 * @param orderId
	 */
	public void cancelOrder(Long orderId);


	/**
	 * 更新订单状态
	 * @param orderId
	 * @param status
	 */
	public void updateOrderStatus(Long orderId, String status);
}
