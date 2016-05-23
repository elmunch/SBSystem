/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reporting;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;

import org.springframework.stereotype.Service;

/**
 *
 * @author M.atallah
 */

@Service
public class BaseReporting implements BaseReportingLocal {

    @Override
    public void reportBuilder(FacesContext facesContext, JasperPrint jasperPrint) throws Exception {
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
        response.sendRedirect(request.getContextPath() + "/servlets/report/PDF");
        
        
        facesContext.responseComplete();
    }

   

}
