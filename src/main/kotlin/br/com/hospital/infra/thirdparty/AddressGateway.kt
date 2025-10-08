package br.com.hospital.infra.thirdparty

import br.com.hospital.core.adapters.AddressAdapter
import br.com.hospital.core.entity.Address
import br.com.hospital.infra.thirdparty.client.ViaCepClient
import br.com.hospital.infra.thirdparty.mapper.toAddress

class AddressGateway(
    private val viaCepClient: ViaCepClient
) : AddressAdapter {
    override fun getByPostalCode(postalCode: String): Address? {
        with(postalCode) {
            return viaCepClient.getPostalCode(this).toAddress()
        }
    }
}