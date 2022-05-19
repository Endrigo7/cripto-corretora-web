package school.cesar.criptocorretoraweb.validadores

import org.springframework.stereotype.Component
import school.cesar.criptocorretora.excecoes.CriptoInvalidaException
import school.cesar.criptocorretoraweb.entidades.Cripto

@Component
class CriptoValidador {

    fun valida(cripto: Cripto) {
        validaCamposObrigatorios(cripto)
    }

    private fun validaCamposObrigatorios(cripto: Cripto) {
        if (cripto.nome.isBlank()) {
            throw CriptoInvalidaException("O campo nome deve ser preenchido")
        }
    }
}
