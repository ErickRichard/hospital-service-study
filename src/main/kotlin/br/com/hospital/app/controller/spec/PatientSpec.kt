package br.com.hospital.app.controller.spec

import br.com.hospital.app.controller.api.request.PatientRequest
import br.com.hospital.app.controller.api.response.PatientResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/patient")
interface PatientSpec {

    @GetMapping("/all")
    fun getAll(): List<PatientResponse>

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): PatientResponse

    @PostMapping
    fun create(@RequestBody patientRequest: PatientRequest): PatientResponse

    @PatchMapping("/{id}")
    fun update(@PathVariable id: String): PatientResponse

    @DeleteMapping("/{id}")
    fun remove(id: String): PatientResponse
}