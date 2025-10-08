package br.com.hospital.infra.repository.schema

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class PatientDbBean(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("id")
    var id: String = "",
    @get:DynamoDbAttribute("person")
    var person: PersonDbBean = PersonDbBean(),
    @get:DynamoDbAttribute("address")
    var address: AddressDbBean = AddressDbBean(),
    @get:DynamoDbAttribute("active")
    var active: Boolean = false,
    @get:DynamoDbAttribute("occupation")
    var occupation: String = "",
    @get:DynamoDbAttribute("heath_plan")
    var heathPlan: String = "",
    @get:DynamoDbAttribute("registration_date")
    var registrationDate: Long = 0L,
    @get:DynamoDbAttribute("updated_at")
    var updatedAt: Long = 0L,
)