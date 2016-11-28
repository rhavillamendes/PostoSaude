package com.rhavilla.postossaude.web;

import com.rhavilla.postossaude.model.Tipo;
import com.rhavilla.postossaude.rn.TipoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class TipoBean {
    private Tipo tipo = new Tipo();
    private List<Tipo> lista;
    
    public String novo() {
        tipo = new Tipo();
        return "/tipo/new";
    }
    
    public String editar() {
        return "/tipo/new";
    }
    
    public String exibir() {
        return "/tipo/show";
    }
    
    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        TipoRN tipoRN = new TipoRN();
        tipoRN.salvar(tipo);
        
        return "index";
    }
    
    public String excluir() {
        TipoRN tipoRN = new TipoRN();
        tipoRN.excluir(tipo);
        lista = null;
        
        return null;
    }

    public List<Tipo> getLista() {
        if (lista == null) {
            TipoRN tipoRN = new TipoRN();
            lista = tipoRN.listar();
        }
        
        return lista;
    }

    public Tipo getAvaliacao() {
        return tipo;
    }

    public void setPaciente(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
}
