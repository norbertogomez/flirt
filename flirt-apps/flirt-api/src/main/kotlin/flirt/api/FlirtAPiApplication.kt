package flirt.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlirtAPiApplication

fun main(args: Array<String>) {
    runApplication<FlirtAPiApplication>(*args)
}
