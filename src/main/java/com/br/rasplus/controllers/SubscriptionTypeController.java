package com.br.rasplus.controllers;

import com.br.rasplus.dto.SubscriptionTypeDTO;
import com.br.rasplus.model.SubscriptionType;
import com.br.rasplus.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

    @Autowired
    SubscriptionTypeService subscriptionTypeService;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {
        return ResponseEntity.ok(subscriptionTypeService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionTypeService.findById(id));
    }

    @PostMapping(path = "/new-subscription-type")
    public ResponseEntity<SubscriptionType> create(@RequestBody SubscriptionTypeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.create(dto));
    }
}
