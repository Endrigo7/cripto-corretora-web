package school.cesar.criptocorretoraweb.entidades

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name= "CRIPTO_MOEDAS")
data class Cripto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    val nome: String,

    @Column
    val cotacaoAtualEmDollar: BigDecimal
)
