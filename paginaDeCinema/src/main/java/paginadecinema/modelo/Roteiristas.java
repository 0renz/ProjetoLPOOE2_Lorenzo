package paginadecinema.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "tb_roteiristas")
public class Roteiristas implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoteirista;

    @Column(nullable = false, length = 155)
    private String nomeRoteirista;

    @ManyToMany(mappedBy = "roteiristas")
    private List<Filmes> filmes;

    public Integer getIdRoteirista() {
        return idRoteirista;
    }

    public void setIdRoteirista(Integer idRoteirista) {
        this.idRoteirista = idRoteirista;
    }

    public String getNomeRoteirista() {
        return nomeRoteirista;
    }

    public void setNomeRoteirista(String nomeRoteirista) {
        this.nomeRoteirista = nomeRoteirista;
    }

    public List<Filmes> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filmes> filmes) {
        this.filmes = filmes;
    }
}
