package br.com.hospital.core.adapters

import br.com.hospital.core.entity.Address

fun interface AddressAdapter {
    fun getByPostalCode(postalCode: String): Address?
}