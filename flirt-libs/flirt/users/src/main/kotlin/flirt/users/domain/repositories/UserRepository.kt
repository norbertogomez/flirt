package flirt.users.domain.repositories

import flirt.users.domain.User
import flirt.users.domain.UserId

interface UserRepository {
    fun search(id: UserId): User?
}
