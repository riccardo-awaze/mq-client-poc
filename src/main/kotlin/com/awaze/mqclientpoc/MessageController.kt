package com.awaze.mqclientpoc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Profile("dev")
@RestController
@RequestMapping("/messages")
class MessageController {
    @Autowired
    private val jmsTemplate: JmsTemplate? = null
    @PostMapping
    fun addMessage(@RequestBody message: String?): ResponseEntity<String> {
        println(message!!)
        jmsTemplate!!.convertAndSend("DEV.QUEUE.1", message!!)
        return ResponseEntity(message, HttpStatus.CREATED)
    }
}
