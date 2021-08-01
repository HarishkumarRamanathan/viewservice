package com.example.view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class viewModel {
	private String OrderName;
	private int qty;
	private double amount;
	private String transactionId;
	private String paymentStatus;
}
