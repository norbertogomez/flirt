package flirt.api.configuration.injection

import com.sksamuel.hoplite.ConfigLoader
import org.axonframework.eventhandling.EventBus
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import flirt.shared.infrastructure.rabbitmq.RabbitMQConnection
import flirt.api.config.RabbitMQConfig
import flirt.shared.domain.event.EventPublisher
import flirt.shared.domain.queue.QueueChannelManager
import flirt.shared.domain.queue.QueueConnection
import flirt.shared.infrastructure.axon.AxonEventPublisher
import flirt.shared.infrastructure.rabbitmq.RabbitMQQueueChannelManager

@Configuration
class Transporters {
    private val config = ConfigLoader().loadConfigOrThrow<RabbitMQConfig>("/rabbitmq.yaml")

    @Autowired
    lateinit var eventBus: EventBus

    @Bean
    fun getQueueConnection(): QueueConnection {
        return RabbitMQConnection(config.host)
    }

    @Bean
    fun getQueueChannelManager(): QueueChannelManager {
        return RabbitMQQueueChannelManager()
    }

    @Bean
    fun getEventPublisher(): EventPublisher {
        return AxonEventPublisher(eventBus)
    }

    @Bean
    fun getRabbitMQTemplate(): RabbitTemplate {
        return RabbitTemplate(getQueueConnection().factory())
    }
}