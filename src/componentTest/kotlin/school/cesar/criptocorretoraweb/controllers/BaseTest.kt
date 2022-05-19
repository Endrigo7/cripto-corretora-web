package school.cesar.criptocorretoraweb.controllers

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.jdbc.Sql

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest {

    @LocalServerPort
    var porta: Long = 8080

    companion object {
        lateinit var requestSpecification: RequestSpecification
    }

    @BeforeAll
    fun setup(){
        val logConfig = LogConfig.logConfig()
            .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
        val config = RestAssuredConfig.config().logConfig(logConfig)

        requestSpecification = RequestSpecBuilder()
            .setBaseUri("http://127.0.0.1:$porta")
            .setBasePath("/")
            .setContentType(ContentType.JSON)
            .setRelaxedHTTPSValidation()
            .setConfig(config)
            .build()
    }

    @AfterAll
    fun tearDown(){
        RestAssured.reset()
    }
}