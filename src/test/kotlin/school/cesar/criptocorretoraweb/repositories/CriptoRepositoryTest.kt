package school.cesar.criptocorretoraweb.repositories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import school.cesar.criptocorretoraweb.entidades.Cripto
import java.math.BigDecimal

@SpringBootTest
@Sql("/data.sql")
class CriptoRepositoryTest {

    @Autowired
    private lateinit var criptoRepository: CriptoRepository

    @Test
    fun `deve retorna cripto quando ela exister no banco`(){
        val resultadoEsperado = Cripto(1, "BIT", BigDecimal("10.00"))
        val resultadoObtido = criptoRepository.findById(1).get()

        Assertions.assertEquals(resultadoEsperado, resultadoObtido)
    }
}