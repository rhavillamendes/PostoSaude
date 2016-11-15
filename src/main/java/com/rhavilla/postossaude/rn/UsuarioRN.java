
package com.rhavilla.postossaude.rn;

import com.rhavilla.postossaude.dao.UsuarioDAO;
import com.rhavilla.postossaude.model.Usuario;
import com.rhavilla.postossaude.util.DAOFactory;
import java.util.List;


public class UsuarioRN {
    

    private UsuarioDAO usuarioDAO;

    public UsuarioRN() {
        usuarioDAO = DAOFactory.obterUsuarioDAO();
    }
    
    public void salvar(Usuario usuario) {
        Integer id = usuario.getId();
        
        if (id == null || id == 0) {
            usuarioDAO.salvar(usuario);
        } else {
            usuarioDAO.atualizar(usuario);
        }
    }
    
    public void excluir(Usuario usuario) {
        usuarioDAO.excluir(usuario);
    }
    
    public Usuario localizar(int id) {
        return usuarioDAO.localizar(id);
    }
    
    public List<Usuario> listar() {
        return usuarioDAO.listar();
    }
}

