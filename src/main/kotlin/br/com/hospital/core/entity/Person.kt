package br.com.hospital.core.entity

import java.time.LocalDate

data class Person(
    val name: String,
    val document: String,
    val email: String,
    val phone: Int,
    val birthDate: LocalDate,
    val nationality: String,
    val sex: Boolean,
)
