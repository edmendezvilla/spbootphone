package com.example.emphone.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class Repair {

    @Id
    var id: Long? = null

    var brand: String? = null
    var flaw: String? = null
    var lastAssignment: LocalDate? = null
    var repairstation: String? = null  // Si esta propiedad también existe en el DTO y en la entidad
}
