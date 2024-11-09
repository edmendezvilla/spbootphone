package com.example.emphone.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "customer")
class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name= "model")
    var model: String? = null
    var brand: String? = null
    var damage : String? = null

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null
}




