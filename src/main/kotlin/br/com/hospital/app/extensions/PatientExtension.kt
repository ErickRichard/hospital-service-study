package br.com.hospital.app.extensions

import br.com.hospital.app.controller.api.request.PatientRequest
import br.com.hospital.app.controller.api.request.PersonRequest
import br.com.hospital.app.controller.api.response.PatientResponse
import br.com.hospital.app.controller.api.response.PersonResponse
import br.com.hospital.core.command.PatientCommand
import br.com.hospital.core.entity.HealthPlanType
import br.com.hospital.core.entity.Patient
import br.com.hospital.core.entity.Person

fun PatientRequest.toEmployee() = PatientCommand(
    person = person.toPerson(),
    postalCode = postalCode,
    occupation = occupation,
    heathPlan = HealthPlanType.valueOf(heathPlan)
)

fun PersonRequest.toPerson() = Person(
    name = name,
    document = document,
    email = email,
    phone = phone,
    birthDate = birthDate,
    nationality = nationality,
    sex = sex
)

fun Patient.toPatientResponse() = PatientResponse(
    registration = id,
    person = person.toPersonResponse()
)

fun Person.toPersonResponse() = PersonResponse(
    name = name,
    email = email,
    phone = phone,
    document = document,
    birthDate = birthDate
)