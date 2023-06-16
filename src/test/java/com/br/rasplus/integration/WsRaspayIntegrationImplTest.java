package com.br.rasplus.integration;

import com.br.rasplus.dto.wsraspay.CustomerDto;
import com.br.rasplus.dto.wsraspay.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class WsRaspayIntegrationImplTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;

    @Test
    void createCustomerWhenDtoOk() {
        CustomerDto dto = new CustomerDto(null,
                "julio ", "moraes", "96924350089", "teste@teste");
        wsRaspayIntegration.createCustomer(dto);
    }

    @Test
    void createOrderWhenDtoOk() {
        OrderDto dto = new OrderDto(null, "MONTH22", "648c8f139a241c1a7db037f0", BigDecimal.ZERO);
        wsRaspayIntegration.createOrder(dto);
        //orderId 648c993c9a241c1a7db037f5
        //customerId 648c8f139a241c1a7db037f0
    }
}
