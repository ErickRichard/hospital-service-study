package br.com.hospital.core.entity

import java.time.Instant
import java.util.*

data class Patient(
    val id: UUID,
    val person: Person,
    val address: Address,
    val active: Boolean = false,
    val occupation: String,
    val heathPlan: HealthPlanType,
    val registrationDate: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now(),
)