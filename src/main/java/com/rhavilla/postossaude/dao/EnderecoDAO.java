package com.rhavilla.postossaude.dao;

import com.rhavilla.postossaude.model.Endereco;
import java.util.List;
import org.hibernate.Session;

public class EnderecoDAO 
{
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Endereco endereco) {
        this.session.save(endereco);    
    }

    public void excluir(Endereco endereco){
        this.session.delete(endereco);
    }
    
    public void atualizar(Endereco endereco){
        this.session.update(endereco);
    }
    
    public Endereco localizar(int id){
        return (Endereco) this.session.get(Endereco.class, id);
    }
    
    public List<Endereco> listar(){
        return this.session.createCriteria(Endereco.class).list();
    }
}
