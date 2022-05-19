package school.cesar.criptocorretoraweb.entidades

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name= "CRIPTO_MOEDAS")
data class Cripto(
    @Id
    val id: Long,

    @Column
    val nome: String,

    @Column
    val cotacaoAtualEmDollar: BigDecimal
)
