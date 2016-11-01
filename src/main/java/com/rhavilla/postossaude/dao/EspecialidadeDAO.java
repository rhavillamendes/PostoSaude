package com.rhavilla.postossaude.dao;

import com.rhavilla.postossaude.model.Especialidade;
import java.util.List;
import org.hibernate.Session;

public class EspecialidadeDAO {
   private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Especialidade especialidade) {
        this.session.save(especialidade);    
    }

    public void excluir(Especialidade especialidade){
        this.session.delete(especialidade);
    }
    
    public void atualizar(Especialidade especialidade){
        this.session.update(especialidade);
    }
    
    public Especialidade localizar(int id){
        return (Especialidade) this.session.get(Especialidade.class, id);
    }
    
    public List<Especialidade> listar(){
        return this.session.createCriteria(Especialidade.class).list();
    } 
}
