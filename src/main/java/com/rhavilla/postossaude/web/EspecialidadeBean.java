
package com.rhavilla.postossaude.web;

import com.rhavilla.postossaude.model.Especialidade;
import com.rhavilla.postossaude.rn.EspecialidadeRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class EspecialidadeBean {
    private Especialidade especialidade = new Especialidade();
    private List<Especialidade> lista;
    
    public String novo() {
        especialidade = new Especialidade();
        return "/especialidade/new";
    }
    
    public String editar() {
        return "/especialidade/new";
    }
    
    public String exibir() {
        return "/especialidade/show";
    }
    
    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        EspecialidadeRN especialidadeRN = new EspecialidadeRN();
        especialidadeRN.salvar(especialidade);
        
        return "index";
    }
    
    public String excluir() {
        EspecialidadeRN enderecoRN = new EspecialidadeRN();
        enderecoRN.excluir(especialidade);
        lista = null;
        
        return null;
    }

    public List<Especialidade> getLista() {
        if (lista == null) {
            EspecialidadeRN especialidadeRN = new EspecialidadeRN();
            lista = especialidadeRN.listar();
        }
        
        return lista;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}