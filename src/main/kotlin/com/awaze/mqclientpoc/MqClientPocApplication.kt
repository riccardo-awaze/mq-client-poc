package com.awaze.mqclientpoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jms.annotation.EnableJms

@SpringBootApplication
@EnableJms
class MqClientPocApplication

fun main(args: Array<String>) {
	runApplication<MqClientPocApplication>(*args)
}
