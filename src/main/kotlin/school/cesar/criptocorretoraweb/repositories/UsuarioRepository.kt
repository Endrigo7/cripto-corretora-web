package school.cesar.criptocorretoraweb.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import school.cesar.criptocorretoraweb.entidades.Usuario

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long>
