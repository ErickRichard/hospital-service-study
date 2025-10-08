package br.com.hospital.infra.thirdparty.api.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AddressResponse(
    @JsonProperty("cep")
    val postalCode: String,
    @JsonProperty("logradouro")
    val address: String,
    @JsonProperty("complemento")
    val complement: String,
    @JsonProperty("bairro")
    val neighborhood: String,
    val uf: String,
    @JsonProperty("estado")
    val state: String,
)