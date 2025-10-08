package br.com.hospital.core.exception

class PatientNotFoundException : RuntimeException(Error.PATIENT_NOT_FOUND_EXCEPTION.name)