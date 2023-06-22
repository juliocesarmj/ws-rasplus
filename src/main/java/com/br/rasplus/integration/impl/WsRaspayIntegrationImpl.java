package com.br.rasplus.integration.impl;

import com.br.rasplus.dto.wsraspay.CustomerDto;
import com.br.rasplus.dto.wsraspay.OrderDto;
import com.br.rasplus.dto.wsraspay.Payment;
import com.br.rasplus.integration.WsRaspayIntegration;
import com.br.rasplus.service.exceptions.RestClientException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    @Value("${webservices.raspay.host}")
    private String raspayHost;

    @Value("${webservices.raspay.v1.customer}")
    private String customerUrl;

    @Value("${webservices.raspay.v1.order}")
    private String orderUrl;

    @Value("${webservices.raspay.v1.payment}")
    private String paymentUrl;
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
                    .exchange(this.raspayHost + this.customerUrl, HttpMethod.POST, request, CustomerDto.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new RestClientException("Erro ao criar customer: " + e.getMessage());
        }
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        HttpEntity<OrderDto> request = new HttpEntity<>(dto, this.headers);

        try {
            ResponseEntity<OrderDto> response = restTemplate.exchange(this.raspayHost + this.orderUrl, HttpMethod.POST, request, OrderDto.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new RestClientException("Erro ao criar order: " + e.getMessage());
        }
    }

    @Override
    public Boolean isProcessPayment(Payment payment) {
        HttpEntity<Payment> request = new HttpEntity<>(payment, this.headers);

        try {
            ResponseEntity<Boolean> response = restTemplate.exchange(this.raspayHost + this.paymentUrl, HttpMethod.POST, request, Boolean.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new RestClientException("Erro ao realizar o pagamento: " + e.getMessage());
        }
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credentials = "rasmooplus:r@sm00";
        String base64 = new String(Base64.encodeBase64(credentials.getBytes()));
        headers.add("Authorization", "Basic " + base64);
        return headers;
    }
}
