package school.cesar.criptocorretoraweb.services

import org.springframework.stereotype.Service
import school.cesar.criptocorretora.excecoes.UsuarioInvalidoException
import school.cesar.criptocorretoraweb.entidades.Usuario
import school.cesar.criptocorretoraweb.repositories.UsuarioRepository
import school.cesar.criptocorretoraweb.validadores.UsuarioValidator

@Service
class UsuarioService(
    private val usuarioValidator: UsuarioValidator,
    private val usuarioRepository: UsuarioRepository
) {

    fun adicionar(usuario: Usuario) {
        usuarioValidator.valida(usuario)
        usuarioRepository.add(usuario)
    }

    fun buscarPorId(id: Long): Usuario =
        usuarioRepository.buscarPorId(id)
            ?: throw UsuarioInvalidoException("Id Não encontrado")
}
