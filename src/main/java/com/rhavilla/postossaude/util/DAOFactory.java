package com.rhavilla.postossaude.util;

import com.rhavilla.postossaude.dao.AvaliacaoDAO;
import com.rhavilla.postossaude.dao.EnderecoDAO;
import com.rhavilla.postossaude.dao.EspecialidadeDAO;
import com.rhavilla.postossaude.dao.PostoSaudeDAO;
import com.rhavilla.postossaude.dao.TipoDAO;
import com.rhavilla.postossaude.dao.UsuarioDAO;

public class DAOFactory {

    public static AvaliacaoDAO obterPacienteDAO() {
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        avaliacaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return avaliacaoDAO;

    }

    public static EnderecoDAO obterEnderecoDAO() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return enderecoDAO;

    }

    public static EspecialidadeDAO obterEspecialidadeDAO() {
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        especialidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return especialidadeDAO;
    }

    public static PostoSaudeDAO obterPostoSaudeDAO() {
        PostoSaudeDAO postosaudeDAO = new PostoSaudeDAO();
        postosaudeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return postosaudeDAO;

    }

    public static TipoDAO obterTipoDAO() {
        TipoDAO tipoDAO = new TipoDAO();
        tipoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return tipoDAO;

    }

    public static UsuarioDAO obterUsuarioDAO() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return usuarioDAO;

    }

}
