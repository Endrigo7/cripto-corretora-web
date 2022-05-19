package school.cesar.criptocorretoraweb.services

import org.springframework.stereotype.Service
import school.cesar.criptocorretora.excecoes.CriptoInvalidaException
import school.cesar.criptocorretoraweb.builders.CriptoBuilder
import school.cesar.criptocorretoraweb.entidades.Cripto
import school.cesar.criptocorretoraweb.repositories.CriptoRepository
import school.cesar.criptocorretoraweb.validadores.CriptoValidador
import java.math.BigDecimal

@Service
class CriptoService(
    private val criptoBuilder: CriptoBuilder,
    private val criptoValidador: CriptoValidador,
    private val criptoRepository: CriptoRepository
) {
    fun add(nome: String, contacaoInicialEmDollar: BigDecimal) {
        val cripto = criptoBuilder.buildCripto(nome, contacaoInicialEmDollar)
        criptoValidador.valida(cripto)
        criptoRepository.save(cripto)
    }

    fun buscarPorId(id: Long): Cripto =
        criptoRepository.findById(id)
            .orElseThrow { throw CriptoInvalidaException("Id não existente") }

}
