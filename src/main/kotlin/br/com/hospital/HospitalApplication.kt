package br.com.hospital

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class HospitalApplication

fun main(args: Array<String>) {
	runApplication<HospitalApplication>(*args)
}
