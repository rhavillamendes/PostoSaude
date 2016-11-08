
package com.rhavilla.postossaude.model;

import com.rhavilla.postossaude.dao.EspecialidadeDAO;
import com.rhavilla.postossaude.util.DAOFactory;
import java.util.List;


public class EspecialidadeRN {
    
   
    private EspecialidadeDAO especialidadeDAO;

    public EspecialidadeRN() {
        especialidadeDAO = DAOFactory.obterEspecialidadeDAO();
    }
    
    public void salvar(Especialidade especialidade) {
        Integer id = especialidade.getId();
        
        if (id == null || id == 0) {
            especialidadeDAO.salvar(especialidade);
        } else {
            especialidadeDAO.atualizar(especialidade);
        }
    }
    
    public void excluir(Especialidade especialidade) {
        especialidadeDAO.excluir(especialidade);
    }
    
    public Especialidade localizar(int id) {
        return especialidadeDAO.localizar(id);
    }
    
    public List<Especialidade> listar() {
        return especialidadeDAO.listar();
    }
}
