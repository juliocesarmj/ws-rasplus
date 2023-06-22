package com.br.rasplus.integration;

import com.br.rasplus.dto.wsraspay.CustomerDto;
import com.br.rasplus.dto.wsraspay.OrderDto;
import com.br.rasplus.dto.wsraspay.Payment;

public interface WsRaspayIntegration {

    CustomerDto createCustomer(CustomerDto dto);

    OrderDto createOrder(OrderDto dto);

    Boolean isProcessPayment(Payment payment);
}
