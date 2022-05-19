package school.cesar.criptocorretoraweb.entidades

import javax.persistence.*

@Entity
@Table(name = "USUARIO")
data class Usuario(
    @Id
    val id: Long,

    @Column
    val cpf: String,

    @Column
    val nome: String,

    @Column
    val email: String,

    @Column
    val senha: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "carteira_id", referencedColumnName = "id")
    val carteira: Carteira
)
