package br.com.hospital.infra.repository.schema

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class StaffDBBean(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("registration")
    var registration: String = "",
    @get:DynamoDbAttribute("person")
    var person: PersonDbBean = PersonDbBean(),
    @get:DynamoDbAttribute("address")
    var address: AddressDbBean = AddressDbBean(),
    @get:DynamoDbAttribute("department")
    var department: String = "",
    @get:DynamoDbAttribute("active")
    var active: Boolean = false,
    @get:DynamoDbAttribute("registration_date")
    var registrationDate: Long = 0L,
    @get:DynamoDbAttribute("updated_at")
    var updatedAt: Long = 0L,
)