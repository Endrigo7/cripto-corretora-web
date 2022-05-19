package school.cesar.criptocorretoraweb.controllers

import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql

@Sql("/data.sql")
class CriptoControllerTest : BaseTest() {

    @Test
    fun `cripto 1`() {
        Given {
            spec(requestSpecification)
        } When {
            get("/cripto/1")
        } Then {
            statusCode(HttpStatus.SC_OK)
            body(containsString("1"))
        }
    }
}
