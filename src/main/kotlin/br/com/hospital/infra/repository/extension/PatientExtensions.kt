package br.com.hospital.infra.repository.extension

import br.com.hospital.core.entity.Address
import br.com.hospital.core.entity.HealthPlanType
import br.com.hospital.core.entity.Patient
import br.com.hospital.core.entity.Person
import br.com.hospital.infra.repository.schema.AddressDbBean
import br.com.hospital.infra.repository.schema.PatientDbBean
import br.com.hospital.infra.repository.schema.PersonDbBean
import java.time.Instant
import java.time.LocalDate
import java.util.*

fun Patient.toPatientEntity() = PatientDbBean(
    id = id.toString(),
    person = person.toPersonEntity(),
    address = address.toAddressEntity(),
    active = active,
    occupation = occupation,
    heathPlan = heathPlan.name,
    registrationDate = registrationDate.toEpochMilli(),
    updatedAt = updatedAt.toEpochMilli()
)

fun Person.toPersonEntity() = PersonDbBean(
    name = name,
    email = email,
    phone = phone,
    document = document,
    birthDate = birthDate.toEpochDay(),
    nationality = nationality,
    sex = sex
)

fun Address.toAddressEntity() = AddressDbBean(
    postalCode = postalCode,
    name = name,
    complement = complement,
    neighborhood = neighborhood,
    uf = uf,
    state = state
)

fun PatientDbBean.toPatient() = Patient(
    id = UUID.fromString(id),
    person = person.toPerson(),
    address = address.toAddress(),
    active = active,
    occupation = occupation,
    heathPlan = HealthPlanType.valueOf(heathPlan),
    registrationDate = Instant.ofEpochMilli(registrationDate),
    updatedAt = Instant.ofEpochMilli(updatedAt)
)

fun PersonDbBean.toPerson() = Person(
    name = name,
    email = email,
    phone = phone,
    document = document,
    birthDate = LocalDate.ofEpochDay(birthDate),
    nationality = nationality,
    sex = sex
)

fun AddressDbBean.toAddress() = Address(
    postalCode = postalCode,
    name = name,
    complement = complement,
    neighborhood = neighborhood,
    uf = uf,
    state = state
)