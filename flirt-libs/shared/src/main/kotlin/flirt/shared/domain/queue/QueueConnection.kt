package flirt.shared.domain.queue

import org.springframework.amqp.rabbit.connection.Connection
import org.springframework.amqp.rabbit.connection.ConnectionFactory

interface QueueConnection {
    fun factory(): ConnectionFactory
    fun connect(): Connection
}