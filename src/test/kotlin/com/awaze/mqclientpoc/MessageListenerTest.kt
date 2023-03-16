package com.awaze.mqclientpoc

import jakarta.jms.JMSException
import org.awaitility.Awaitility.await
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jms.core.JmsTemplate
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.FixedHostPortGenericContainer
import org.testcontainers.containers.GenericContainer
import java.util.concurrent.TimeUnit

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@ActiveProfiles("dev")
class MessageListenerTest {

    fun setupMqContainer(): GenericContainer<*>? {
        val environmentVariables = mapOf("LICENSE" to "accept", "MQ_QMGR_NAME" to "QM1")

        val mqContainer = GenericContainer("ibmcom/mq:9.1.5.0-r2").withExposedPorts(1414, 1414)
            .withExtraHost("localhost", "0.0.0.0").withEnv(environmentVariables);

        mqContainer.start()
        val host = mqContainer.host;
        val port = mqContainer.getMappedPort(1414).toString()
        System.setProperty("ibm.mq.connName", "$host($port)");

        return mqContainer;
    }

    private val container = setupMqContainer()

    @Autowired
    private lateinit var jmsTemplate: JmsTemplate

    @Autowired
    private lateinit var messageListener: MessageListener

    @BeforeEach
    fun setup() {
        assertTrue(container!!.isRunning())
    }

    @AfterAll
    fun tearDown() {
        container!!.stop()
    }

    @Test
    @Throws(JMSException::class)
    fun `should receive a message from MQ`() {
        // Given
        assertEquals(0, messageListener.messageCounter);

        // When
        val message = "TEST123"
        jmsTemplate.convertAndSend("DEV.QUEUE.1", message)

        // Then a message response is placed on the response queue
        await().atMost(10, TimeUnit.SECONDS).untilAsserted { assertEquals(1, messageListener.messageCounter); }
    }
}