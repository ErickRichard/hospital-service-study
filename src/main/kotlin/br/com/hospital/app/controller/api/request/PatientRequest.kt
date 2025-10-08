package br.com.hospital.app.controller.api.request

data class PatientRequest(
    val person: PersonRequest,
    val postalCode: String,
    val occupation: String,
    val heathPlan: String,
)
