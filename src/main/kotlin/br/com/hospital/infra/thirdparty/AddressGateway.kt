package br.com.hospital.infra.thirdparty

import br.com.hospital.core.adapters.AddressAdapter
import br.com.hospital.core.entity.Address
import br.com.hospital.infra.thirdparty.client.ViaCepClient
import br.com.hospital.infra.thirdparty.mapper.toAddress
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Component

@Component
class AddressGateway(
    private val viaCepClient: ViaCepClient
) : AddressAdapter {
    @CircuitBreaker(name = "addressGateway", fallbackMethod = "fallbackResponse")
    override fun getByPostalCode(postalCode: String): Address {
        with(postalCode) {
            return viaCepClient.getPostalCode(this).toAddress()
        }
    }

    fun fallbackResponse(ex: Exception): String {
        return "Fallback acionado devido a: ${ex.message}"
    }
}