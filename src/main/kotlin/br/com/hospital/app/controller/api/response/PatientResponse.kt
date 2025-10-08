package br.com.hospital.app.controller.api.response

import java.util.*

data class PatientResponse(
    val registration: UUID,
    val person: PersonResponse
)
