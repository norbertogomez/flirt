package flirt.users.application.handlers

import flirt.shared.domain.bus.query.Response
import flirt.users.domain.User

data class UserResponse(
    private val id: String? = null,
    private val name: String? = null
) : Response {
    constructor(user: User) : this(user.id.value, user.name.value)
}