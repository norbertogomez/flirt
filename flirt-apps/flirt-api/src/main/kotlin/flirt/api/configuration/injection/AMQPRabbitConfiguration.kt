package flirt.api.configuration.injection

import com.rabbitmq.client.Channel
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource
import org.axonframework.config.DefaultConfigurer
import org.axonframework.config.EventHandlingConfiguration
import org.axonframework.config.EventProcessingConfiguration
import org.axonframework.serialization.Serializer
import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableRabbit
class AMQPRabbitConfiguration {
    @Autowired
    lateinit var springAMQPMessageSource: SpringAMQPMessageSource

    // Configuring processors to use the below message source
    @Autowired
    fun configure(configurer: DefaultConfigurer, eventProcessingConfiguration: EventProcessingConfiguration, eventHandlingConfiguration: EventHandlingConfiguration, rabbitMessageSource: SpringAMQPMessageSource) {
        eventProcessingConfiguration.registerSubscribingEventProcessor("flirt.api.handlers.event") { _ -> springAMQPMessageSource }
    }

    // Creating a MessageSource (that reads from rabbit) and sends received messages to axon
    @Bean
    fun myRabbitMessageSource(serializer: Serializer): SpringAMQPMessageSource {
        return object : SpringAMQPMessageSource(serializer) {
            @RabbitListener(queues = ["DomainEvents"])
            @Throws(Exception::class)
            override fun onMessage(message: Message, channel: Channel) {
                super.onMessage(message, channel)
            }
        }
    }

    // RABBIT SETUP
    // Creating an exchange
    @Bean
    fun fanout(): FanoutExchange {
        return FanoutExchange("Axon.EventBus")
    }

    // Creating the queue
    @Bean
    fun domainEventsQueue(): Queue {
        return Queue("DomainEvents", true, false, false)
    }

    // Creating a binding between the queue and the exchange
    @Bean
    fun bindingAxon(fanout: FanoutExchange, domainEventsQueue: Queue): Binding {
        return BindingBuilder.bind(domainEventsQueue).to(fanout)
    }
}
