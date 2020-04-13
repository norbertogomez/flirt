package flirt.api.controllers

import flirt.users.application.find.FindUserByIdQuery
import flirt.users.application.handlers.UserResponse
import flirt.users.domain.User
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.Serializable

@RestController
class GetUsersController() {
    @Autowired
    lateinit var queryGateway: QueryGateway

    @GetMapping("/users/{userId}")
    fun findOrderById(@PathVariable("userId") userId: String): ResponseEntity<User> {
         val user : User = queryGateway.query(
            FindUserByIdQuery(userId),
            ResponseTypes.instanceOf(User::class.java)
         ).get()

        if (user == null) {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.ok(user)
    }
}