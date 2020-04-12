package flirt.shared.infrastructure.rabbitmq

import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import flirt.shared.domain.queue.QueueReceiver

@RabbitListener(id = "job_batches_listener", queues = [])
class RabbitMQReceiver() : QueueReceiver {
    @RabbitHandler
    override fun receive(message: ByteArray) {

    }
}