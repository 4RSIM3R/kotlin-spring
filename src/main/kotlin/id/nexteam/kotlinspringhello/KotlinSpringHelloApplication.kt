package id.nexteam.kotlinspringhello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringHelloApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringHelloApplication>(*args)
}
