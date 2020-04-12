package flirt.shared.domain

import java.io.Serializable
import java.util.*

abstract class Identifier : Serializable {
    abstract var value: String

    constructor(value: String) {
        ensureValidUuId(value)

        this.value = value
    }

    @Throws(IllegalArgumentException::class)
    private fun ensureValidUuId(value: String) {
        UUID.fromString(value)
    }
}