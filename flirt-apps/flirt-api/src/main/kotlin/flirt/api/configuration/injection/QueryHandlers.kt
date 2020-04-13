package flirt.api.configuration.injection

import flirt.users.application.find.FindUserQueryHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryHandlers {
    @Bean
    fun getFindUserQueryHandler(): FindUserQueryHandler {
        return FindUserQueryHandler()
    }
}
