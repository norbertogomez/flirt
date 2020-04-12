package flirt.api.controllers

import flirt.users.application.find.FindUserByIdQuery
import flirt.users.application.handlers.UserResponse
import flirt.users.domain.User
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetUsersController() {
    @Autowired
    lateinit var queryGateway: QueryGateway

    @GetMapping("/users/{userId}")
    fun findOrderById(@PathVariable("userId") userId: String): UserResponse {
         val user : User = queryGateway.query(
            FindUserByIdQuery(userId),
            ResponseTypes.instanceOf(User::class.java)
         ).get()

        return UserResponse(user.id.value, user.name.value)
    }
}