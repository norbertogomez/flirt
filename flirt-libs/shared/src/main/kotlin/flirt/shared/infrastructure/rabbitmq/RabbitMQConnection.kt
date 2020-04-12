package flirt.shared.infrastructure.rabbitmq

import flirt.shared.domain.queue.QueueConnection
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.Connection
import org.springframework.amqp.rabbit.connection.ConnectionFactory

class RabbitMQConnection(private val host: String) : QueueConnection {
    override fun factory(): ConnectionFactory {
        return CachingConnectionFactory(host)
    }

    override fun connect(): Connection {
        return factory().createConnection()
    }
}
