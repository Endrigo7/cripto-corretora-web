package school.cesar.criptocorretoraweb.repositories

import org.springframework.stereotype.Repository
import school.cesar.criptocorretoraweb.entidades.Usuario

@Repository
class UsuarioRepository {

    private val usuarios = mutableListOf<Usuario>()

    fun add(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun buscarPorId(id: Long) =
        usuarios.firstOrNull { it.id == id }
}
