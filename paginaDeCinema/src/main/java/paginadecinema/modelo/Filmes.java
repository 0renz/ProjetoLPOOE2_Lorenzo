package paginadecinema.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table (name = "tb_filmes")
public class Filmes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFilme;

    @Column(nullable = false, length = 155)
    private String nomeFilme;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataEstreia;
    
    @Column(nullable = false)
    private Double notaIMDb;

    @ManyToMany
    @JoinTable(
        name = "tb_Filme_Roteirista",
        joinColumns = @JoinColumn(name = "idFilme"),
        inverseJoinColumns = @JoinColumn(name = "idRoteirista")
    )
    private List<Roteiristas> roteiristas;

    @ManyToMany
    @JoinTable(
        name = "tb_Filme_Ator",
        joinColumns = @JoinColumn(name = "idFilme"),
        inverseJoinColumns = @JoinColumn(name = "idAtor")
    )
    private List<Atores> atores;

    @ManyToMany
    @JoinTable(
        name = "tb_Filme_Diretor",
        joinColumns = @JoinColumn(name = "idFilme"),
        inverseJoinColumns = @JoinColumn(name = "idDiretor")
    )
    private List<Diretores> diretores;


    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public Calendar getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(Calendar dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    public Double getNotaIMDb() {
        return notaIMDb;
    }

    public void setNotaIMDb(Double notaIMDb) {
        this.notaIMDb = notaIMDb;
    }

    public List<Roteiristas> getRoteiristas() {
        return roteiristas;
    }

    public void setRoteiristas(List<Roteiristas> roteiristas) {
        this.roteiristas = roteiristas;
    }

    public List<Atores> getAtores() {
        return atores;
    }

    public void setAtores(List<Atores> atores) {
        this.atores = atores;
    }

    public List<Diretores> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<Diretores> diretores) {
        this.diretores = diretores;
    }
}
