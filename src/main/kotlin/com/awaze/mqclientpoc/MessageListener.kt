package com.awaze.mqclientpoc

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

import jakarta.jms.JMSException

import jakarta.jms.Message

import jakarta.jms.TextMessage

@Component
class MessageListener {

    @JmsListener(destination = "AWZ.RESVMGR.BOK.TEST")
    @Throws(JMSException::class)
    fun receive(message: Message) {
        val textMessage: TextMessage = message as TextMessage
        println(
            "### AWZ.RESVMGR.BOK.TEST received message response : {} with correlation id: {}" +
                    textMessage.getText()
        )
// current error IBM MQ call failed with compcode '2' ('MQCC_FAILED') reason '2538' ('MQRC_HOST_NOT_AVAILABLE')
    }
}