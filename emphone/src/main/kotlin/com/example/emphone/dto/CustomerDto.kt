package com.example.emphone.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

// DTO para Customer
class CustomerDto {

    @NotNull(message = "Brand is required")
    @NotBlank(message = "Brand is required")
    var brand: String? = null

    @NotNull(message = "Model is required")
    @NotBlank(message = "Model is required")
    var model: String? = null

    @NotNull(message = "Damage is required")
    @NotBlank(message = "Damage is required")
    var damage: String? = null  // Cambio a String? para permitir que sea null
}


