package flirt.shared.domain.queue

import com.rabbitmq.client.Channel

interface QueueChannelManager {
    fun create(queueName: String): Channel
}