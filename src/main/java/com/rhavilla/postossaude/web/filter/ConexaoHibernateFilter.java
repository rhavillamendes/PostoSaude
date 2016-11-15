package com.rhavilla.postossaude.web.filter;

import com.rhavilla.postossaude.util.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Lucivaldo Castro
 */
@WebFilter(urlPatterns = {"*.xhtml"})
public class ConexaoHibernateFilter implements Filter {

    private SessionFactory sf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Session currentSession = sf.getCurrentSession();
        
        Transaction transaction = null;
        
        try {
            transaction = currentSession.beginTransaction();
            chain.doFilter(request, response);
            transaction.commit();
            
            if (currentSession.isOpen()) {
                currentSession.close();
            }
        } catch (Throwable ex) {
            try {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
            
            throw new ServletException(ex);
        }
    }

    @Override
    public void destroy() {
        
    }
}
