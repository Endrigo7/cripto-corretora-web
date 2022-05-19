package school.cesar.criptocorretoraweb.services

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class DollarService {

    fun pegarValorDollarAtual(): BigDecimal =
        BigDecimal((4..5).random())
}
