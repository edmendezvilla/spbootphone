package com.example.emphone.mapper

import com.example.emphone.dto.CustomerDto
import com.example.emphone.entity.Customer

object CustomerMapper {

    // Función para mapear CustomerDto a Customer (entidad)
    fun toEntity(customerDto: CustomerDto): Customer {
        return Customer().apply {
            brand = customerDto.brand
            model = customerDto.model
            damage =  customerDto.damage
        }
    }

    // Función para mapear Customer (entidad) a CustomerDto
    fun toDto(customer: Customer): CustomerDto {
        return CustomerDto().apply {
            brand = customer.brand
            model = customer.model
            damage = customer.damage.toString()
        }
    }
}

