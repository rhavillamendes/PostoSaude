
package com.rhavilla.postossaude.model;

import com.rhavilla.postossaude.dao.TipoDAO;
import com.rhavilla.postossaude.util.DAOFactory;
import java.util.List;

public class TipoRN {
    
    private TipoDAO tipoDAO;

    public TipoRN() {
        tipoDAO = DAOFactory.obterTipoDAO();
    }
    
    public void salvar(Tipo tipo) {
        Integer id = tipo.getId();
        
        if (id == null || id == 0) {
            tipoDAO.salvar(tipo);
        } else {
            tipoDAO.atualizar(tipo);
        }
    }
    
    public void excluir(Tipo tipo) {
        tipoDAO.excluir(tipo);
    }
    
    public Tipo localizar(int id) {
        return tipoDAO.localizar(id);
    }
    
    public List<Tipo> listar() {
        return tipoDAO.listar();
    }
}

