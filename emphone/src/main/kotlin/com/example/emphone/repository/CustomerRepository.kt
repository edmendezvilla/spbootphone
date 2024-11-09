package com.example.emphone.repository

import com.example.emphone.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface CustomerRepository : JpaRepository<Customer, Long> {
}