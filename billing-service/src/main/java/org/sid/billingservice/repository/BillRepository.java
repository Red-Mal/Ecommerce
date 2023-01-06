package org.sid.billingservice.repository;

import org.sid.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BillRepository extends JpaRepository<Bill,Long> {
    Collection<Bill> findBillsByCustomerId(Long customerId);

}
