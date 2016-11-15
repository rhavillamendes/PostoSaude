
package com.rhavilla.postossaude.rn;

import com.rhavilla.postossaude.dao.EspecialidadeDAO;
import com.rhavilla.postossaude.model.Especialidade;
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
