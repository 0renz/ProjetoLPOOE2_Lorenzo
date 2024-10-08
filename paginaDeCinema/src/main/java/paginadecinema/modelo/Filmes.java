package paginadecinema.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tb_filmes")
public class Filmes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFilme;

    @Column(nullable = false, length = 155)
    private String nomeFilme;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataEstreia;
    
    @Column
    private Double notaIMDb;

    @ManyToOne
    @JoinColumn(name = "idRoteirista")
    private Roteiristas roteirista;

    @ManyToOne
    @JoinColumn(name = "idDiretor")
    private Diretores diretor;

    @ManyToMany
    @JoinTable(
        name = "tb_Filme_Ator",
        joinColumns = @JoinColumn(name = "idFilme"),
        inverseJoinColumns = @JoinColumn(name = "idAtor")
    )
    private List<Atores> atores;

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

    public Roteiristas getRoteirista() {
        return roteirista;
    }

    public void setRoteirista(Roteiristas roteirista) {
        this.roteirista = roteirista;
    }

    public Diretores getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretores diretor) {
        this.diretor = diretor;
    }

    public List<Atores> getAtores() {
        return atores;
    }

    public void setAtores(List<Atores> atores) {
        this.atores = atores;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataEstreia = getDataEstreia(); // Presumindo que isso retorna um Calendar.
        Date dataEstreiaComoDate = dataEstreia.getTime(); // Convertendo Calendar para Date.
        String dataString = sdf.format(dataEstreiaComoDate);
        return idFilme + ": " + nomeFilme + 
                "| Estreia: " + dataString +
                "| Nota IMDB: " + getNotaIMDb()+
                "| Diretor: " + diretor.getNomeDiretor()+ 
                "| Roteirista:" + roteirista.getNomeRoteirista();
    }
}
