package br.com.hospital.core

import br.com.hospital.core.adapters.AddressAdapter
import br.com.hospital.core.command.PatientCommand
import br.com.hospital.core.entity.Patient
import br.com.hospital.core.exception.AddressNotFoundException
import br.com.hospital.core.exception.PatientNotFoundException
import br.com.hospital.core.repository.PatientRepository
import br.com.hospital.core.usecase.PatientUseCase
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class PatientManagementUseCaseImpl(
    private val patientRepository: PatientRepository,
    private val addressAdapter: AddressAdapter
) : PatientUseCase {

    override fun getAll(): List<Patient> = patientRepository.getAll()

    override fun getById(id: String): Patient {
        patientRepository.findPatient(id)?.let {
            return it
        } ?: throw PatientNotFoundException()
    }

    override fun create(patient: PatientCommand): Patient {
        runCatching {
            val address = addressAdapter.getByPostalCode(patient.postalCode) ?: throw AddressNotFoundException()
            return patientRepository.create(
                Patient(
                    id = UUID.randomUUID(),
                    person = patient.person,
                    address = address,
                    active = true,
                    occupation = patient.occupation,
                    heathPlan = patient.heathPlan,
                    registrationDate = Instant.now(),
                    updatedAt = Instant.now()
                )
            )
        }.getOrThrow()
    }

    override fun update(id: String): Patient {
        patientRepository.findPatient(id)?.let {
            return patientRepository.create(it)
        } ?: throw PatientNotFoundException()
    }

    private fun PatientRepository.findPatient(id: String): Patient? = this.getById(id)

}