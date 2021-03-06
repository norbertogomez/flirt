package flirt.api.configuration.injection

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import flirt.shared.domain.services.Serializer
import flirt.shared.infrastructure.gson.GsonSerializer
import flirt.users.application.find.UserFinder

@Configuration
class Services {
    @Bean
    fun getUserFinder() : UserFinder {
        return UserFinder()
    }
}
