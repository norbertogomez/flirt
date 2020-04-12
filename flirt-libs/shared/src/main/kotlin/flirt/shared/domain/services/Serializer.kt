package flirt.shared.domain.services

interface Serializer {
    fun serialize(message: Any): ByteArray
    fun deserialize(message: ByteArray, java: Class<*>): Any
}
