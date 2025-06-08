package com.evvyoumbi.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

    // Custom query methods can be added here if needed
    // For example, to find by customerId:
    // List<FraudCheckHistory> findByCustomerId(Integer customerId);
}
