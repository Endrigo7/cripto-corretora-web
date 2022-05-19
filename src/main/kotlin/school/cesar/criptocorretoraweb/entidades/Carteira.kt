package school.cesar.criptocorretoraweb.entidades

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table
data class Carteira(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @OneToOne(mappedBy = "carteira")
    val usuario: Usuario,

    @ElementCollection
    @CollectionTable(name = "cripto_item_mapping")
    @MapKeyColumn(name = "cripto")
    @Column(name = "quantidade")
    val cripto: MutableMap<Cripto, BigDecimal> = mutableMapOf()
)
