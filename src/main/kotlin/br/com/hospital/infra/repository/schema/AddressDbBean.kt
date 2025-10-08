package br.com.hospital.infra.repository.schema

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean

@DynamoDbBean
data class AddressDbBean(
    @get:DynamoDbAttribute("name")
    var name: String = "",
    @get:DynamoDbAttribute("postal_code")
    var postalCode: String = "",
    @get:DynamoDbAttribute("state")
    var state: String = "",
    @get:DynamoDbAttribute("neighborhood")
    var neighborhood: String = "",
    @get:DynamoDbAttribute("uf")
    var uf: String = "",
    @get:DynamoDbAttribute("complement")
    var complement: String = ""
)