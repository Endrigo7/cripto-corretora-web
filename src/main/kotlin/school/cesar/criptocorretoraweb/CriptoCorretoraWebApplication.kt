package school.cesar.criptocorretoraweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class CriptoCorretoraWebApplication

fun main(args: Array<String>) {
	runApplication<CriptoCorretoraWebApplication>(*args)
}
