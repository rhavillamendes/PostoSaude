
package com.rhavilla.postossaude.web;

import com.rhavilla.postossaude.model.PostoSaude;
import com.rhavilla.postossaude.rn.PostoSaudeRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class PostoSaudeBean {
    private PostoSaude postoSaude = new PostoSaude();
    private List<PostoSaude> lista;
    
    public String novo() {
        postoSaude = new PostoSaude();
        return "/postoSaude/new";
    }
    
    public String editar() {
        return "/postoSaude/new";
    }
    
    public String exibir() {
        return "/postoSaude/show";
    }
    
    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        PostoSaudeRN postoSaudeRN = new PostoSaudeRN();
        postoSaudeRN.salvar(postoSaude);
        
        return "index";
    }
    
    public String excluir() {
        PostoSaudeRN postoSaudeRN = new PostoSaudeRN();
        postoSaudeRN.excluir(postoSaude);
        lista = null;
        
        return null;
    }

    public List<PostoSaude> getLista() {
        if (lista == null) {
            PostoSaudeRN postoSaudeRN = new PostoSaudeRN();
            lista = postoSaudeRN.listar();
        }
        
        return lista;
    }

    public PostoSaude getPostoSaude() {
        return postoSaude;
    }

    public void setPaciente(PostoSaude postoSaude) {
        this.postoSaude = postoSaude;
    }
}
