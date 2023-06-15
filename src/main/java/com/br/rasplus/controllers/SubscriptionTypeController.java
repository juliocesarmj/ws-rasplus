package com.br.rasplus.controllers;

import com.br.rasplus.dto.SubscriptionTypeDTO;
import com.br.rasplus.model.SubscriptionType;
import com.br.rasplus.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

    @Autowired
    @Lazy
    private SubscriptionTypeService subscriptionTypeService;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {
        return ResponseEntity.ok(subscriptionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionTypeService.findById(id));
    }

    @PostMapping("/new-subscription-type")
    public ResponseEntity<SubscriptionType> create(@Valid @RequestBody SubscriptionTypeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.create(dto));
    }
    
    @PutMapping("/update-subscription-type")
    public ResponseEntity<SubscriptionType> update(@RequestBody SubscriptionTypeDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubscriptionType> deleteById(@PathVariable Long id) {
        subscriptionTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
