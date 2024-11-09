package com.example.emphone.controller

import com.example.emphone.dto.CustomerDto
import com.example.emphone.entity.Customer
import com.example.emphone.service.CustomerService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService  // Servicio específico para Customer

    @GetMapping
    fun getCustomers(): List<Customer> {
        return customerService.getCustomers()  // Obtener lista de clientes
    }

    @PostMapping
    fun save(@RequestBody @Valid customerDto: CustomerDto): Customer {
        return customerService.save(customerDto)  // Guardar un cliente
    }
}

