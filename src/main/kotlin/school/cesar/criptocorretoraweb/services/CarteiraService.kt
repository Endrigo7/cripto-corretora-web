package school.cesar.criptocorretoraweb.services

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CarteiraService(
    private val usuarioService: UsuarioService,
    private val criptoService: CriptoService
) {

    fun comprar(idUsuario: Long, idCripto: Long, valor: BigDecimal) {
        val usuario = usuarioService.buscarPorId(idUsuario)
        val cripto = criptoService.buscarPorId(idCripto)

        val quantidadeCripto = valor / cripto.cotacaoAtualEmDollar
        usuario.carteira.cripto[cripto] = usuario.carteira.cripto[cripto]
            ?.plus(quantidadeCripto) ?: quantidadeCripto
    }

    fun consultarCarteira(idUsuario: Long) =
        usuarioService.buscarPorId(idUsuario)
            .carteira.cripto

    fun consultarCriptoNaCarteira(idUsuario: Long, idCripto: Long) =
        usuarioService.buscarPorId(idUsuario)
            .carteira.cripto.filter {
                it.component1().id == idCripto
            }
}
