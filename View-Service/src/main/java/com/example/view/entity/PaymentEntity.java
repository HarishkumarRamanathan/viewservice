package com.example.view.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {

	private Long paymentId;
	private String paymentStatus;
	private String transactionId;
	private Long orderId;
	private double amount;
}
