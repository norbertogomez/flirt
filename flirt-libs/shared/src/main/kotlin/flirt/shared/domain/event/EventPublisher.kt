package flirt.shared.domain.event

interface EventPublisher {
    fun publish(event: Event)
}