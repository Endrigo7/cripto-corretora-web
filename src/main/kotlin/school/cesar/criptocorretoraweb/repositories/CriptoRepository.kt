package school.cesar.criptocorretoraweb.repositories

import org.springframework.stereotype.Repository
import school.cesar.criptocorretoraweb.entidades.Cripto

@Repository
class CriptoRepository {

    private val criptos = mutableListOf<Cripto>()

    fun add(cripto: Cripto) {
        criptos.add(cripto)
    }

    fun excluir(cripto: Cripto) {
        criptos.remove(cripto)
    }

    fun buscarPeloId(id: Long) =
        criptos.firstOrNull { it.id == id }

    fun buscarPeloNome(nome: String) =
        criptos.firstOrNull { it.nome == nome }
}
