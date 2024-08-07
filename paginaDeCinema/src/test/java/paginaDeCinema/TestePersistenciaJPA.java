package paginaDeCinema;

import java.util.Calendar;
import org.junit.Test;
import paginadecinema.modelo.*;
import paginadecinema.modelo.dao.PersistenciaJPA;
import java.util.GregorianCalendar;
import java.util.Arrays;

public class TestePersistenciaJPA {
      @Test
    public void testConexaoJPA() {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("conectou no BD via jpa ...");
            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");

        }
    } 
    
    @Test
    public void testPersistenciaCompleta() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            // Criação dos atores
            Atores ator1 = new Atores();
            ator1.setNomeAtor("Leonardo DiCaprio");
            ator1.setSexoAtor(SexoAtor.MASCULINO);

            Atores ator2 = new Atores();
            ator2.setNomeAtor("Michael J Fox");
            ator2.setSexoAtor(SexoAtor.MASCULINO);

            Atores ator3 = new Atores();
            ator3.setNomeAtor("Robert Downey Jr.");
            ator3.setSexoAtor(SexoAtor.MASCULINO);

            Atores ator4 = new Atores();
            ator4.setNomeAtor("Scarlett Johansson");
            ator4.setSexoAtor(SexoAtor.FEMININO);

            Atores ator5 = new Atores();
            ator5.setNomeAtor("Tom Hanks");
            ator5.setSexoAtor(SexoAtor.MASCULINO);

            // Criação dos diretores
            Diretores diretor1 = new Diretores();
            diretor1.setNomeDiretor("Steven Spielberg");
            diretor1.setTipoDiretor(TipoDiretor.DIRETOR_EXECUTIVO);

            Diretores diretor2 = new Diretores();
            diretor2.setNomeDiretor("Christopher Nolan");
            diretor2.setTipoDiretor(TipoDiretor.DIRETOR_EXECUTIVO);

            Diretores diretor3 = new Diretores();
            diretor3.setNomeDiretor("Martin Scorsese");
            diretor3.setTipoDiretor(TipoDiretor.DIRETOR_EXECUTIVO);

            Diretores diretor4 = new Diretores();
            diretor4.setNomeDiretor("Quentin Tarantino");
            diretor4.setTipoDiretor(TipoDiretor.DIRETOR_ARTE);

            Diretores diretor5 = new Diretores();
            diretor5.setNomeDiretor("James Cameron");
            diretor5.setTipoDiretor(TipoDiretor.DIRETOR_ARTE);

            // Criação dos roteiristas
            Roteiristas roteirista1 = new Roteiristas();
            roteirista1.setNomeRoteirista("Aaron Sorkin");

            Roteiristas roteirista2 = new Roteiristas();
            roteirista2.setNomeRoteirista("Christopher Nolan");

            Roteiristas roteirista3 = new Roteiristas();
            roteirista3.setNomeRoteirista("Quentin Tarantino");

            Roteiristas roteirista4 = new Roteiristas();
            roteirista4.setNomeRoteirista("Nora Ephron");

            Roteiristas roteirista5 = new Roteiristas();
            roteirista5.setNomeRoteirista("Charlie Kaufman");

            // Criação dos dublês
            Dubles dublê1 = new Dubles();
            dublê1.setNomeDuble("Dublê 1");
            dublê1.setAtor(ator1);

            Dubles dublê2 = new Dubles();
            dublê2.setNomeDuble("Dublê 2");
            dublê2.setAtor(ator2);

            Dubles dublê3 = new Dubles();
            dublê3.setNomeDuble("Dublê 3");
            dublê3.setAtor(ator3);

            Dubles dublê4 = new Dubles();
            dublê4.setNomeDuble("Dublê 4");
            dublê4.setAtor(ator4);

            Dubles dublê5 = new Dubles();
            dublê5.setNomeDuble("Dublê 5");
            dublê5.setAtor(ator5);

            // Criação dos filmes
            Filmes filme1 = new Filmes();
            filme1.setNomeFilme("Inception");
            filme1.setDataEstreia(new GregorianCalendar(2010, Calendar.JULY, 16));
            filme1.setNotaIMDb(8.8);
            filme1.setAtores(Arrays.asList(ator1, ator4));
            filme1.setDiretores(Arrays.asList(diretor2, diretor1));
            filme1.setRoteiristas(Arrays.asList(roteirista2));

            Filmes filme2 = new Filmes();
            filme2.setNomeFilme("Back to the future");
            filme2.setDataEstreia(new GregorianCalendar(1985, Calendar.JULY, 3));
            filme2.setNotaIMDb(8.5);
            filme2.setAtores(Arrays.asList(ator2));
            filme2.setDiretores(Arrays.asList(diretor3));
            filme2.setRoteiristas(Arrays.asList(roteirista1, roteirista2, roteirista3));

            Filmes filme3 = new Filmes();
            filme3.setNomeFilme("Avengers: Endgame");
            filme3.setDataEstreia(new GregorianCalendar(2019, Calendar.APRIL, 26));
            filme3.setNotaIMDb(8.4);
            filme3.setAtores(Arrays.asList(ator3, ator4));
            filme3.setDiretores(Arrays.asList(diretor5, diretor1));
            filme3.setRoteiristas(Arrays.asList(roteirista3, roteirista1));

            Filmes filme4 = new Filmes();
            filme4.setNomeFilme("Forrest Gump");
            filme4.setDataEstreia(new GregorianCalendar(1994, Calendar.JULY, 6));
            filme4.setNotaIMDb(8.8);
            filme4.setAtores(Arrays.asList(ator5, ator1));
            filme4.setDiretores(Arrays.asList(diretor1));
            filme4.setRoteiristas(Arrays.asList(roteirista4));

            Filmes filme5 = new Filmes();
            filme5.setNomeFilme("Pulp Fiction");
            filme5.setDataEstreia(new GregorianCalendar(1994, Calendar.OCTOBER, 14));
            filme5.setNotaIMDb(8.9);
            filme5.setAtores(Arrays.asList(ator3));
            filme5.setDiretores(Arrays.asList(diretor4));
            filme5.setRoteiristas(Arrays.asList(roteirista5));

            jpa.persist(ator1);
            jpa.persist(ator2);
            jpa.persist(ator3);
            jpa.persist(ator4);
            jpa.persist(ator5);
            jpa.persist(diretor1);
            jpa.persist(diretor2);
            jpa.persist(diretor3);
            jpa.persist(diretor4);
            jpa.persist(diretor5);
            jpa.persist(roteirista1);
            jpa.persist(roteirista2);
            jpa.persist(roteirista3);
            jpa.persist(roteirista4);
            jpa.persist(roteirista5);
            jpa.persist(dublê1);
            jpa.persist(dublê2);
            jpa.persist(dublê3);
            jpa.persist(dublê4);
            jpa.persist(dublê5);
            jpa.persist(filme1);
            jpa.persist(filme2);
            jpa.persist(filme3);
            jpa.persist(filme4);
            jpa.persist(filme5);

            System.out.println("Dados persistidos com sucesso!");

            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");
        }
    }
}