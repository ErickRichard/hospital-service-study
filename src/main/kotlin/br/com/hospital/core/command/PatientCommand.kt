package br.com.hospital.core.command

import br.com.hospital.core.entity.HealthPlanType
import br.com.hospital.core.entity.Person

data class PatientCommand(
    val person: Person,
    val postalCode: String,
    val occupation: String,
    val heathPlan: HealthPlanType,
)