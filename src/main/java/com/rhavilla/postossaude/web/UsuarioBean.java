package com.rhavilla.postossaude.web;

import com.rhavilla.postossaude.model.Usuario;
import com.rhavilla.postossaude.model.UsuarioRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class UsuarioBean {
    private Usuario usuario = new Usuario();
    private List<Usuario> lista;
    
    public String novo() {
        usuario = new Usuario();
        return "/public/usuario/new";
    }
    
    public String editar() {
        return "/public/usuario/new";
    }
    
    public String exibir() {
        return "/public/usuario/show";
    }
    
    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(usuario);
        
        return "index";
    }
    
    public String excluir() {
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.excluir(usuario);
        lista = null;
        
        return null;
    }

    public List<Usuario> getLista() {
        if (lista == null) {
            UsuarioRN usuarioRN = new UsuarioRN();
            lista = usuarioRN.listar();
        }
        
        return lista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
