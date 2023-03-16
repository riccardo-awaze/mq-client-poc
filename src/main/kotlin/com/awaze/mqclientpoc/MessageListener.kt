package com.awaze.mqclientpoc

import jakarta.jms.JMSException
import jakarta.jms.Message
import jakarta.jms.TextMessage
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class MessageListener {

    var messageCounter: Int = 0;

    @JmsListener(destination = "\${reservations.queue.name}")
    @Throws(JMSException::class)
    fun receive(message: Message) {
        val textMessage: TextMessage = message as TextMessage
        println("### Received message response : " + textMessage.getText())
        messageCounter++
    }

}