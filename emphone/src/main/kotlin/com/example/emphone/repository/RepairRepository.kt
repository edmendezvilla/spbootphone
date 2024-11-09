package com.example.emphone.repository

import com.example.emphone.entity.Repair
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface RepairRepository : JpaRepository<Repair, Long> {
}
