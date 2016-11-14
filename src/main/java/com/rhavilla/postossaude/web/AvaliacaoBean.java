
package com.rhavilla.postossaude.web;

import com.rhavilla.postossaude.model.Avaliacao;
import com.rhavilla.postossaude.model.AvaliacaoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class AvaliacaoBean {
    private Avaliacao avaliacao = new Avaliacao();
    private List<Avaliacao> lista;
    
    public String novo() {
        avaliacao = new Avaliacao();
        return "/public/avaliacao/new";
    }
    
    public String editar() {
        return "/public/avaliacao/new";
    }
    
    public String exibir() {
        return "/public/avaliacao/show";
    }
    
    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        AvaliacaoRN avalicaoRN = new AvaliacaoRN();
        avalicaoRN.salvar(avaliacao);
        
        return "index";
    }
    
    public String excluir() {
        AvaliacaoRN avaliacaoRN = new AvaliacaoRN();
        avaliacaoRN.excluir(avaliacao);
        lista = null;
        
        return null;
    }

    public List<Avaliacao> getLista() {
        if (lista == null) {
            AvaliacaoRN avaliacaoRN = new AvaliacaoRN();
            lista = avaliacaoRN.listar();
        }
        
        return lista;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setPaciente(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
}