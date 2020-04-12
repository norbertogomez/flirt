package flirt.shared.infrastructure.axon

import org.axonframework.eventhandling.EventBus
import org.axonframework.eventhandling.GenericEventMessage
import flirt.shared.domain.event.Event
import flirt.shared.domain.event.EventPublisher

class AxonEventPublisher(private val eventBus: EventBus) : EventPublisher {
    override fun publish(event: Event) {
        eventBus.publish(
            GenericEventMessage.asEventMessage<Event>(event)
        )
    }
}