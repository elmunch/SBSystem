/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reporting;

import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author M.atallah
 */
public interface BaseReportingLocal {
    
    
    void reportBuilder(FacesContext facesContext, JasperPrint jasperPrint) throws Exception;

}
