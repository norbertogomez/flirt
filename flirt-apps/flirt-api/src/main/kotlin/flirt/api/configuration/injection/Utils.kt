package flirt.api.configuration.injection

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import flirt.shared.domain.services.Serializer
import flirt.shared.infrastructure.gson.GsonSerializer

@Configuration
class Utils {
    @Bean
    fun getSerializer() : Serializer {
        return GsonSerializer()
    }
}