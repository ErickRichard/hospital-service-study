package br.com.hospital.infra.repository.schema

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean

@DynamoDbBean
data class PersonDbBean(
    @get:DynamoDbAttribute("name")
    var name: String = "",
    @get:DynamoDbAttribute("document")
    var document: String = "",
    @get:DynamoDbAttribute("email")
    var email: String = "",
    @get:DynamoDbAttribute("phone")
    var phone: Int = 0,
    @get:DynamoDbAttribute("birth_date")
    var birthDate: Long = 0L,
    @get:DynamoDbAttribute("nationality")
    var nationality: String = "",
    @get:DynamoDbAttribute("sex")
    var sex: Boolean = false,
)