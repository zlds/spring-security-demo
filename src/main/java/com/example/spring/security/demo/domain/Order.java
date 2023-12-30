package com.example.spring.security.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hanchaowei
 * @date 2023/12/30
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Long id;
	private String owner;
	private String details;
	private String status;

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", owner='" + owner + '\'' +
				", details='" + details + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
