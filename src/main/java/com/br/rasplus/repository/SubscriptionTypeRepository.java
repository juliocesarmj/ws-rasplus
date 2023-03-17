package com.br.rasplus.repository;

import com.br.rasplus.model.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {
}
