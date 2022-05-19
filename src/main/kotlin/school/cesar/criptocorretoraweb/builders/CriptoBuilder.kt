package school.cesar.criptocorretoraweb.builders

import org.springframework.stereotype.Component
import school.cesar.criptocorretoraweb.entidades.Cripto
import java.math.BigDecimal

@Component
class CriptoBuilder {

    private var criptoNumero: Long = 0

    fun buildCripto(nome: String, contacaoInicialEmDollar: BigDecimal): Cripto =
        Cripto(
            id = criptoNumero,
            nome = nome,
            cotacaoAtualEmDollar = contacaoInicialEmDollar
        )

    private fun calculaIdCripto(): Long =
        ++criptoNumero
}
