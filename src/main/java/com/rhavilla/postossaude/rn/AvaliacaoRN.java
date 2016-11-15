package com.rhavilla.postossaude.rn;


import com.rhavilla.postossaude.dao.AvaliacaoDAO;
import com.rhavilla.postossaude.model.Avaliacao;
import com.rhavilla.postossaude.util.DAOFactory;
import java.util.List;


public class AvaliacaoRN {
    private AvaliacaoDAO avaliacaoDAO;

    public AvaliacaoRN() {
        avaliacaoDAO = DAOFactory.obterPacienteDAO();
    }
    
    public void salvar(Avaliacao avaliacao) {
        Integer id = avaliacao.getId();
        
        if (id == null || id == 0) {
            avaliacaoDAO.salvar(avaliacao);
        } else {
            avaliacaoDAO.atualizar(avaliacao);
        }
    }
    
    public void excluir(Avaliacao avaliacao) {
        avaliacaoDAO.excluir(avaliacao);
    }
    
    public Avaliacao localizar(int id) {
        return avaliacaoDAO.localizar(id);
    }
    
    public List<Avaliacao> listar() {
        return avaliacaoDAO.listar();
    }
}
