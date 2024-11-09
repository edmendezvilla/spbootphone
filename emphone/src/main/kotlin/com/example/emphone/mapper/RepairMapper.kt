package com.example.emphone.mapper

import com.example.emphone.dto.RepairDto
import com.example.emphone.entity.Repair
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
object RepairMapper {

    // Función para mapear RepairDto a Repair (entidad)
    fun toEntity(repairDto: RepairDto): Repair {
        val repair = Repair()

        repair.brand = repairDto.brand
        repair.flaw = repairDto.flaw

        // Convertir lastAssignment de String a LocalDate
        repair.lastAssignment = if (repairDto.lastAssignment != null) {
            LocalDate.parse(repairDto.lastAssignment, DateTimeFormatter.ISO_DATE) // Asumiendo que la fecha viene en formato "yyyy-MM-dd"
        } else {
            null
        }

        return repair
    }

    // Función para mapear Repair (entidad) a RepairDto
    fun toDto(repair: Repair): RepairDto {
        val repairDto = RepairDto()

        repairDto.brand = repair.brand
        repairDto.flaw = repair.flaw

        // Convertir lastAssignment de LocalDate a String
        repairDto.lastAssignment = repair.lastAssignment?.toString() // Convertir de LocalDate a String

        return repairDto
    }
}
