package school.cesar.criptocorretoraweb.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CriptoController {

    @GetMapping("/hello")
    fun sayHello(): String{
        return "Hello, End"
    }

}