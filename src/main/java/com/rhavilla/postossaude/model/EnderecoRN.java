
package com.rhavilla.postossaude.model;

import com.rhavilla.postossaude.dao.EnderecoDAO;
import com.rhavilla.postossaude.util.DAOFactory;
import java.util.List;



public class EnderecoRN {
    

    private EnderecoDAO enderecoDAO;

    public EnderecoRN() {
        enderecoDAO = DAOFactory.obterEnderecoDAO();
    }
    
    public void salvar(Endereco endereco) {
        Integer id = endereco.getId();
        
        if (id == null || id == 0) {
            enderecoDAO.salvar(endereco);
        } else {
            enderecoDAO.atualizar(endereco);
        }
    }
    
    public void excluir(Endereco endereco) {
        enderecoDAO.excluir(endereco);
    }
    
    public Endereco localizar(int id) {
        return enderecoDAO.localizar(id);
    }
    
    public List<Endereco> listar() {
        return enderecoDAO.listar();
    }
}
