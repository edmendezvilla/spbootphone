package com.example.emphone.service

import com.example.emphone.dto.RepairDto
import com.example.emphone.entity.Repair
import com.example.emphone.mapper.RepairMapper
import com.example.emphone.repository.RepairRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class RepairService {

    @Autowired
    lateinit var repairRepository: RepairRepository

    // Obtener todas las reparaciones
    fun getAllRepair(): List<RepairDto> {
        val repairs = repairRepository.findAll()
        return repairs.map { RepairMapper.toDto(it) } // Mapeo a DTO
    }

    // Crear una nueva reparación
    fun save(repairDto: RepairDto): RepairDto {
        val repair = RepairMapper.toEntity(repairDto) // Mapeo de DTO a entidad
        val savedRepair = repairRepository.save(repair)
        return RepairMapper.toDto(savedRepair) // Mapeo de vuelta a DTO
    }

    // Obtener una reparación por ID
    fun getRepairById(id: Long): RepairDto {
        val repair = repairRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Repair not found with id $id") }
        return RepairMapper.toDto(repair) // Mapeo de entidad a DTO
    }

    // Actualizar una reparación completa
    fun updateRepair(id: Long, repairDto: RepairDto): RepairDto {
        val repair = repairRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Repair not found with id $id") }

        // Usar las propiedades correctas de la entidad
        repair.brand = repairDto.brand
        repair.repairstation = repairDto.repairstation
        repair.flaw = repairDto.flaw

        // Convertir lastAssignment de String a LocalDate si no es nulo
        repair.lastAssignment = repairDto.lastAssignment?.let {
            LocalDate.parse(it, DateTimeFormatter.ISO_DATE) // Asumiendo que la fecha viene en formato "yyyy-MM-dd"
        }

        val updatedRepair = repairRepository.save(repair)
        return RepairMapper.toDto(updatedRepair)
    }

    // Actualizar parcialmente la marca de una reparación
    fun updateRepairBrand(id: Long, repairDto: RepairDto): RepairDto {
        val repair = repairRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Repair not found with id $id") }
        repair.brand = repairDto.brand // Solo actualizamos la marca
        val updatedRepair = repairRepository.save(repair)
        return RepairMapper.toDto(updatedRepair)
    }

    // Eliminar una reparación
    fun deleteRepair(id: Long) {
        val repair = repairRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Repair not found with id $id") }
        repairRepository.delete(repair)
    }
}
