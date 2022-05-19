package school.cesar.criptocorretoraweb.util

import org.springframework.stereotype.Component

@Component
class EmailUtil {

    private val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"

    fun isEmailValido(email: String): Boolean =
        EMAIL_REGEX.toRegex().matches(email)
}
