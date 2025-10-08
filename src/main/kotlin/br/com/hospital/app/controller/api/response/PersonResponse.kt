package br.com.hospital.app.controller.api.response

import java.time.LocalDate

data class PersonResponse(
    val name: String,
    val email: String,
    val phone: Int,
    val document: String,
    val birthDate: LocalDate,
)
