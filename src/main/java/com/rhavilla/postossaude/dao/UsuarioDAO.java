package com.rhavilla.postossaude.dao;

import com.rhavilla.postossaude.model.Usuario;
import java.util.List;
import org.hibernate.Session;

public class UsuarioDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Usuario usuario) {
        this.session.save(usuario);    
    }

    public void excluir(Usuario usuario){
        this.session.delete(usuario);
    }
    
    public void atualizar(Usuario usuario){
        this.session.update(usuario);
    }
    
    public Usuario localizar(int id){
        return (Usuario) this.session.get(Usuario.class, id);
    }
    
    public List<Usuario> listar(){
        return this.session.createCriteria(Usuario.class).list();
    }
}
