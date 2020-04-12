package flirt.users.application.find

import flirt.users.domain.User
import flirt.users.domain.UserId
import org.axonframework.queryhandling.QueryHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FindUserQueryHandler {
    @Autowired
    lateinit var finder: UserFinder

    @QueryHandler
    fun handle(query: FindUserByIdQuery): User {
        return finder.find(UserId(query.id))
    }
}