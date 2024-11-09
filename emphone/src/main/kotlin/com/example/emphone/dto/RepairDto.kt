package com.example.emphone.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class RepairDto {

    @NotNull(message = "Brand is required")
    @NotBlank(message = "Brand is required")
    var brand: String? = null

    @NotNull(message = "Flaw is required")
    @NotBlank(message = "Flaw is required")
    var flaw: String? = null

    var lastAssignment: String? = null  // Puede ser String o LocalDate, según tu diseño

    var repairstation: String? = null  // Asegúrate de tener las propiedades correctas
}
