package br.com.hospital.infra.config

import br.com.hospital.infra.thirdparty.AddressGateway
import br.com.hospital.infra.thirdparty.client.ViaCepClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ThirdPartyConfig {
    @Bean
    fun addressGateway(viaCepClient: ViaCepClient) = AddressGateway(viaCepClient)
}