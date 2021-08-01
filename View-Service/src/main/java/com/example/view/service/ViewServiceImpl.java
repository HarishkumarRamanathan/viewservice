package com.example.view.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.view.entity.OrderEntity;
import com.example.view.entity.PaymentEntity;
import com.example.view.model.viewModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ViewServiceImpl implements ViewService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Collection<viewModel> viewOrders() {

		JsonNode jsonNode = restTemplate.getForObject("http://localhost:9001/order/getallorders", JsonNode.class);
		ObjectMapper objectMapper = new ObjectMapper();

		List<OrderEntity> orderEntities = objectMapper.convertValue(jsonNode, new TypeReference<List<OrderEntity>>() {
		});

		List<viewModel> viewModels = new ArrayList<>();

		for (OrderEntity orderEntity : orderEntities) {

			PaymentEntity paymentEntity = restTemplate.getForObject(
					"http://localhost:9002/payment/getbyorderid/%7BorderId%7D?orderId=" + orderEntity.getOrderId(),
					PaymentEntity.class);
			viewModels.add(new viewModel(orderEntity.getOrderName(), orderEntity.getQty(), orderEntity.getAmount(),
					paymentEntity.getTransactionId(), paymentEntity.getPaymentStatus()));

		}
		return viewModels;
	}

}
