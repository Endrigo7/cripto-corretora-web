package school.cesar.criptocorretoraweb.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import school.cesar.criptocorretoraweb.entidades.Cripto
import school.cesar.criptocorretoraweb.services.CriptoService

@RestController
@RequestMapping("/cripto")
class CriptoController(
    private val criptoService: CriptoService
) {

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Cripto>{
        val cripto = criptoService.buscarPorId(id)
        return ResponseEntity<Cripto>(cripto, HttpStatus.OK)
    }
}