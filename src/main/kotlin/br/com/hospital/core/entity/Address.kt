package br.com.hospital.core.entity

data class Address(
    val postalCode: String,
    val name: String,
    val complement: String,
    val neighborhood: String,
    val uf: String,
    val state: String,
)