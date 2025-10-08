package br.com.hospital.infra.repository

import br.com.hospital.core.entity.Patient
import br.com.hospital.core.repository.PatientRepository
import br.com.hospital.infra.repository.extension.toPatient
import br.com.hospital.infra.repository.extension.toPatientEntity
import br.com.hospital.infra.repository.schema.PatientDbBean
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest

@Repository
class DynamoPatientRepository(
    private val dynamoDbEnhancedClient: DynamoDbEnhancedClient
) : PatientRepository {

    private val patientTable: DynamoDbTable<PatientDbBean>
        get() = dynamoDbEnhancedClient.table(
            TABLE_NAME,
            TableSchema.fromBean(PatientDbBean::class.java)
        )

    override fun create(patient: Patient): Patient {
        run {
            patientTable.putItem(patient.toPatientEntity())
            return patient
        }
    }

    override fun getById(id: String): Patient? {
        val results = patientTable.query(
            QueryEnhancedRequest.builder()
                .queryConditional(
                    QueryConditional.keyEqualTo(
                        Key.builder()
                            .partitionValue(id)
                            .build()
                    )
                ).build()
        )
        return results.items().firstOrNull()?.toPatient()
    }

    override fun getAll(): List<Patient> = patientTable.scan().items().map {
        it.toPatient()
    }

    companion object {
        const val TABLE_NAME = "patient"
    }
}