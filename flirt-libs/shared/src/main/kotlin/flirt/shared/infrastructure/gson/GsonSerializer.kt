package flirt.shared.infrastructure.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import flirt.shared.domain.services.Serializer

class GsonSerializer : Serializer {
    override fun serialize(message: Any): ByteArray {
        return Gson().toJson(message).toByteArray(charset("UTF-8"))
    }

    override fun deserialize(message: ByteArray, java: Class<*>): Any {
        return Gson().fromJson(String(message, charset("UTF-8")), java)
    }
}