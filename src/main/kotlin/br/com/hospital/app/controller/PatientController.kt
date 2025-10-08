package br.com.hospital.app.controller

import br.com.hospital.app.controller.api.request.PatientRequest
import br.com.hospital.app.controller.api.response.PatientResponse
import br.com.hospital.app.controller.spec.PatientSpec
import br.com.hospital.app.extensions.toEmployee
import br.com.hospital.app.extensions.toPatientResponse
import br.com.hospital.core.usecase.PatientUseCase
import org.springframework.web.bind.annotation.RestController

@RestController
class PatientController(
    private val patientUseCase: PatientUseCase
) : PatientSpec {
    override fun getAll(): List<PatientResponse> = patientUseCase.getAll().map { it.toPatientResponse() }

    override fun getById(id: String): PatientResponse = patientUseCase.getById(id).toPatientResponse()

    override fun create(patientRequest: PatientRequest): PatientResponse =
        patientUseCase.create(patientRequest.toEmployee()).toPatientResponse()

    override fun update(id: String): PatientResponse {
        TODO("Not yet implemented")
    }

    override fun remove(id: String): PatientResponse {
        TODO("Not yet implemented")
    }
}