package flirt.api.configuration.injection

import flirt.users.domain.repositories.UserRepository
import flirt.users.infrastructure.repositories.hibernate.CassandraUserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Repositories {
    @Bean
    fun getUserRepository(): UserRepository {
        return CassandraUserRepository()
    }
}
