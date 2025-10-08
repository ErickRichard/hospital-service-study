package br.com.hospital.core.usecase

import br.com.hospital.core.command.PatientCommand
import br.com.hospital.core.entity.Patient

interface PatientUseCase {
    fun getAll(): List<Patient>
    fun getById(id: String): Patient
    fun create(patient: PatientCommand): Patient
    fun update(id: String): Patient
}