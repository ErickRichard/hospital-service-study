package br.com.hospital.infra.thirdparty.mapper

import br.com.hospital.core.entity.Address
import br.com.hospital.infra.thirdparty.api.response.AddressResponse

fun AddressResponse.toAddress() = Address(
    postalCode = postalCode,
    name = address,
    complement = complement,
    neighborhood = neighborhood,
    uf = uf,
    state = state
)