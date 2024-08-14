package paginadecinema.modelo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import paginadecinema.modelo.Atores;
import paginadecinema.modelo.Diretores;
import paginadecinema.modelo.Filmes;
import paginadecinema.modelo.Roteiristas;

public class PersistenciaJPA implements InterfacePersistencia {

    public EntityManagerFactory factory;    //fabrica de gerenciadores de entidades
    public EntityManager entity;            //gerenciador de entidades JPA

    public PersistenciaJPA() {

        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory = Persistence.createEntityManagerFactory("ProjetoLPOOE2_Lorenzo_paginaDeCinema_jar_1.0PU");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {

        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {

        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {

        return entity.find(c, id);//encontra um determinado registro              
    }

    @Override
    public void persist(Object o) throws Exception {

        entity.getTransaction().begin();// abrir a transacao.
        entity.persist(o); //realiza o insert ou update.
        entity.getTransaction().commit(); //comita a transacao (comando sql)                
    }

    @Override
    public void remover(Object o) throws Exception {

        entity.getTransaction().begin();// abrir a transacao.
        entity.remove(o); //realiza o delete
        entity.getTransaction().commit(); //comita a transacao (comando sql)                
    }
    
    public void merge(Object o) throws Exception {
    entity.getTransaction().begin();
    entity.merge(o);
    entity.getTransaction().commit();
}

    public List<Filmes> getFilmes() {
        return entity.createQuery("SELECT m FROM Filmes m", Filmes.class).getResultList();
    }
    
    public List<Roteiristas> getRoteiristas() {
        return entity.createQuery("SELECT m FROM Roteiristas m", Roteiristas.class).getResultList();
    }
    
    public List<Diretores> getDiretores() {
        return entity.createQuery("SELECT m FROM Diretores m", Diretores.class).getResultList();
    }
    
    public List<Atores> getAtores() {
        return entity.createQuery("SELECT m FROM Atores m", Atores.class).getResultList();
    }
}
