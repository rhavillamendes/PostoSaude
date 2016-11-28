package com.rhavilla.postossaude.web;

import com.rhavilla.postossaude.model.Endereco;
import com.rhavilla.postossaude.rn.EnderecoRN;
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
        return "/endereco/new";
    }

    public String editar() {
        return "/endereco/new";
    }

    public String exibir() {
        return "/endereco/show";
    }

    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        EnderecoRN enderecoRN = new EnderecoRN();
        enderecoRN.salvar(endereco);

        return "index";
    }

    public String excluir() {
        EnderecoRN enderecoRN = new EnderecoRN();
        enderecoRN.excluir(endereco);
        lista = null;

        return null;
    }

    public List<Endereco> getLista() {
        if (lista == null) {
            EnderecoRN enderecoRN = new EnderecoRN();
            lista = enderecoRN.listar();
        }

        return lista;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
