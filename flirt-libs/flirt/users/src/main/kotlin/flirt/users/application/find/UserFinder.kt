package flirt.users.application.find

import flirt.users.domain.User
import flirt.users.domain.UserId
import flirt.users.domain.exceptions.UserNotExist
import flirt.users.domain.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired

class UserFinder {
    @Autowired
    lateinit var userRepository: UserRepository

    @Throws(UserNotExist::class)
    fun find(id: UserId): User {
        return userRepository.search(id) ?: throw UserNotExist()
    }
}