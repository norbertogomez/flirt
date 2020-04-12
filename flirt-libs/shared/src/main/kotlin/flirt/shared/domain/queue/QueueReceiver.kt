package flirt.shared.domain.queue

interface QueueReceiver {
    fun receive(message: ByteArray)
}