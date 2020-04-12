package flirt.api.config

data class DatabaseConfig(val host: String, val port: Int, val user: String, val password: String, val database: String, val poolSize: Int)
