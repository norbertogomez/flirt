package flirt.users.infrastructure.repositories.hibernate

import flirt.users.domain.User
import flirt.users.domain.UserId
import flirt.users.domain.repositories.UserRepository

class CassandraUserRepository() : UserRepository {
    override fun search(id: UserId): User? {
        TODO("Not yet implemented")
    }
}
