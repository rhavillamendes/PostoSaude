
package com.rhavilla.postossaude.model;

import com.rhavilla.postossaude.dao.PostoSaudeDAO;
import com.rhavilla.postossaude.util.DAOFactory;
import java.util.List;


public class PostoSaudeRN {
    


    private PostoSaudeDAO postoSaudeDAO;

    public PostoSaudeRN() {
        postoSaudeDAO = DAOFactory.obterPostoSaudeDAO();
    }
    
    public void salvar(PostoSaude postoSaude) {
        Integer id = postoSaude.getId();
        
        if (id == null || id == 0) {
            postoSaudeDAO.salvar(postoSaude);
        } else {
            postoSaudeDAO.atualizar(postoSaude);
        }
    }
    
    public void excluir(PostoSaude postoSaude) {
        postoSaudeDAO.excluir(postoSaude);
    }
    
    public PostoSaude localizar(int id) {
        return postoSaudeDAO.localizar(id);
    }
    
    public List<PostoSaude> listar() {
        return postoSaudeDAO.listar();
    }
}

