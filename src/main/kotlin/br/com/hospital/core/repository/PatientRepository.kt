package br.com.hospital.core.repository

import br.com.hospital.core.entity.Patient

interface PatientRepository {
    fun create(patient: Patient): Patient
    fun getById(id: String): Patient?
    fun getAll(): List<Patient>
}