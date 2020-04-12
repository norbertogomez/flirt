package flirt.shared.infrastructure.rabbitmq

import com.rabbitmq.client.Channel
import org.springframework.beans.factory.annotation.Autowired
import flirt.shared.domain.queue.QueueChannelManager
import flirt.shared.domain.queue.QueueConnection

class RabbitMQQueueChannelManager: QueueChannelManager {
    @Autowired
    lateinit var queueConnection: QueueConnection

    override fun create(queueName: String): Channel {
        val connection = queueConnection.connect()
        val channel = connection.createChannel(false)
        channel.queueDeclare(queueName, true, false, false, null)

        return channel
    }
}