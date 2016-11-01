
package com.rhavilla.postossaude.dao;

import com.rhavilla.postossaude.model.PostoSaude;
import java.util.List;
import org.hibernate.Session;


public class PostoSaudeDAO {
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(PostoSaude postosaude) {
        this.session.save(postosaude);    
    }

    public void excluir(PostoSaude postosaude){
        this.session.delete(postosaude);
    }
    
    public void atualizar(PostoSaude postosaude){
        this.session.update(postosaude);
    }
    
    public PostoSaude localizar(int id){
        return (PostoSaude) this.session.get(PostoSaude.class, id);
    }
    
    public List<PostoSaude> listar(){
        return this.session.createCriteria(PostoSaude.class).list();
    }
}
