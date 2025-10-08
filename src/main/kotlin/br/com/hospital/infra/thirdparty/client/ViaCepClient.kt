package br.com.hospital.infra.thirdparty.client

import br.com.hospital.infra.thirdparty.api.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(name = "viaCep", url = "https://viacep.com.br")
fun interface ViaCepClient {
    @GetMapping("/ws/{postalCode}/json/")
    fun getPostalCode(@PathVariable postalCode: String): AddressResponse
}