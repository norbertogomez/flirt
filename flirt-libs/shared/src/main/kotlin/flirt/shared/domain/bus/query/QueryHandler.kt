package flirt.shared.domain.bus.query

interface QueryHandler {
    fun <query:Query> handle ()
}