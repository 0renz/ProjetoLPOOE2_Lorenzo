package paginadecinema.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "tb_atores")
public class Atores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtor;

    @Column(nullable = false, length = 155)
    private String nomeAtor;

    @Enumerated(EnumType.STRING)
    private SexoAtor sexoAtor;

    @ManyToMany(mappedBy = "atores")
    private List<Filmes> filmes;

    @OneToOne(mappedBy = "ator")
    private Dubles duble;

    public Integer getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Integer idAtor) {
        this.idAtor = idAtor;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }

    public SexoAtor getSexoAtor() {
        return sexoAtor;
    }

    public void setSexoAtor(SexoAtor sexoAtor) {
        this.sexoAtor = sexoAtor;
    }

    public List<Filmes> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filmes> filmes) {
        this.filmes = filmes;
    }

    public Dubles getDublê() {
        return duble;
    }

    public void setDuble(Dubles duble) {
        this.duble = duble;
    }
}
