
package com.rhavilla.postossaude.web;

import com.rhavilla.postossaude.model.Endereco;
import com.rhavilla.postossaude.model.EnderecoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class EnderecoBean {
    private Endereco endereco = new Endereco();
    private List<Endereco> lista;
    
    public String novo() {
        endereco = new Endereco();
        return "/public/endereco/new";
    }
    
    public String editar() {
        return "/public/endereco/new";
    }
    
    public String exibir() {
        return "/public/endereco/show";
    }
    
    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        EnderecoRN enderecoRN = new EnderecoRN();
        enderecoRN.salvar(endereco);
        
        return "index";
    }
    
    public String excluir() {
        EnderecRN enderecRN = new EnderecoRN();
        avaliacaoRN.excluir(avaliacao);
        lista = null;
        
        return null;
    }

    public List<Avaliacao> getLista() {
        if (lista == null) {
            AvaliacaoRN pacienteRN = new AvaliacaoRN();
            lista = pacienteRN.listar();
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