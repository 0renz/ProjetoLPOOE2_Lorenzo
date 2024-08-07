package paginadecinema.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "tb_dubles")
public class Dubles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDuble;

    @Column(nullable = false, length = 155)
    private String nomeDuble;

    @OneToOne
    @JoinColumn(name = "idAtor")
    private Atores ator;

    public Integer getIdDuble() {
        return idDuble;
    }

    public void setIdDuble(Integer idDuble) {
        this.idDuble = idDuble;
    }

    public String getNomeDuble() {
        return nomeDuble;
    }

    public void setNomeDuble(String nomeDuble) {
        this.nomeDuble = nomeDuble;
    }

    public Atores getAtor() {
        return ator;
    }

    public void setAtor(Atores ator) {
        this.ator = ator;
    }
}
