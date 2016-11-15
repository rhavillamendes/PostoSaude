package com.rhavilla.postossaude.dao;

import com.rhavilla.postossaude.model.Tipo;
import com.rhavilla.postossaude.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public class TipoDAO {
    
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Tipo tipo) {
        this.session.save(tipo);    
    }

    public void excluir(Tipo tipo){
        this.session.delete(tipo);
    }
    
    public void atualizar(Tipo tipo){
        this.session.update(tipo);
    }
    
    public Tipo localizar(int id){
        return (Tipo) this.session.get(Tipo.class, id);
    }
    
    public List<Tipo> listar(){
        return this.session.createCriteria(Tipo.class).list();
    }
    
}
