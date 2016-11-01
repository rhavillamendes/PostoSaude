package com.rhavilla.postossaude.dao;

import com.rhavilla.postossaude.model.Avaliacao;
import java.util.List;
import org.hibernate.Session;


public class AvaliacaoDAO {
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Avaliacao avaliacao) {
        this.session.save(avaliacao);    
    }

    public void excluir(Avaliacao avaliacao){
        this.session.delete(avaliacao);
    }
    
    public void atualizar(Avaliacao avaliacao){
        this.session.update(avaliacao);
    }
    
    public Avaliacao localizar(int id){
        return (Avaliacao) this.session.get(Avaliacao.class, id);
    }
    
    public List<Avaliacao> listar(){
        return this.session.createCriteria(Avaliacao.class).list();
    }
}
