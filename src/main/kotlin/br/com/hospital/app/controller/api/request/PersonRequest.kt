package br.com.hospital.app.controller.api.request

import java.time.LocalDate

data class PersonRequest(
    val name: String,
    val email: String,
    val phone: Int,
    val document: String,
    val birthDate: LocalDate,
    val nationality: String,
    val sex: Boolean
)
