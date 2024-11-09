package com.example.emphone.service

import com.example.emphone.dto.CustomerDto
import com.example.emphone.entity.Customer
import com.example.emphone.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    // Obtener todos los clientes
    fun getCustomers(): List<Customer> {
        return customerRepository.findAll()  // Esto devolverá todos los clientes de la base de datos
    }

    // Guardar un cliente
    fun save(customerDto: CustomerDto): Customer {
        val customer = Customer()  // Aquí deberías mapear el DTO a la entidad Customer
        customer.brand = customerDto.brand
        customer.model = customerDto.model
        customer.damage = customerDto.damage
        return customerRepository.save(customer)
    }
}
