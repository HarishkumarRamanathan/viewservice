package com.example.view.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

	private Long OrderId;
	private String OrderName;
	private int qty;
	private double amount;
}
