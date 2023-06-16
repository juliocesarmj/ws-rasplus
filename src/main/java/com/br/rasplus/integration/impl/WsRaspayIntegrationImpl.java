package com.br.rasplus.integration.impl;

import com.br.rasplus.dto.wsraspay.CustomerDto;
import com.br.rasplus.dto.wsraspay.OrderDto;
import com.br.rasplus.dto.wsraspay.Payment;
import com.br.rasplus.integration.WsRaspayIntegration;
import com.br.rasplus.service.exceptions.RestClientException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.module.ResolutionException;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private static final String CREATE_CUSTOMER_URL = "http://localhost:8081/ws-raspay/v1/customer";
    private static final String CREATE_ORDER_URL = "http://localhost:8081/ws-raspay/v1/order";

    private final HttpHeaders headers;
    private final RestTemplate restTemplate;

    public WsRaspayIntegrationImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.headers = getHttpHeaders();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        HttpEntity<CustomerDto> request = new HttpEntity<>(dto, this.headers);
        try {
            ResponseEntity<CustomerDto> response = restTemplate
                    .exchange(CREATE_CUSTOMER_URL, HttpMethod.POST, request, CustomerDto.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new RestClientException("Erro ao criar customer: " + e.getMessage());
        }
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        HttpEntity<OrderDto> request = new HttpEntity<>(dto, this.headers);

        try {
            ResponseEntity<OrderDto> response = restTemplate.exchange(CREATE_ORDER_URL, HttpMethod.POST, request, OrderDto.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new RestClientException("Erro ao criar order: " + e.getMessage());
        }
    }

    @Override
    public boolean isProcessPaymeny(Payment payment) {
        return false;
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credentials = "rasmooplus:r@sm00";
        String base64 = new String(Base64.encodeBase64(credentials.getBytes()));
        headers.add("Authorization", "Basic " + base64);
        return headers;
    }
}
