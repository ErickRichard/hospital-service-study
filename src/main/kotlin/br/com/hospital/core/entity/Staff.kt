package br.com.hospital.core.entity

import java.time.Instant
import java.util.*

data class Staff(
    val registration: UUID,
    val person: Person,
    val address: Address,
    val department: Department,
    val active: Boolean,
    val registrationDate: Instant,
    val updatedAt: Instant,
)