/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reporting;

import com.Manager.Interfaces.IReport;
import com.Beans.EmpBean;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



/**
 *
 * @author M.atallah
 */
public abstract class SampleReporting implements IReport{

    BaseReportingLocal baseReportingLocal;

    public SampleReporting(BaseReportingLocal baseReportingLocal) {
        this.baseReportingLocal=baseReportingLocal;
    }
    
    

    public void generateEmployeesReport(HashMap reportParams, List<EmpBean> iReportBeans, FacesContext facesContext) {
        try {
            String report = facesContext.getExternalContext().getRealPath("/WEB-INF/jasper/report.jasper");
            JasperPrint jasperPrint;
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(iReportBeans);
            jasperPrint = JasperFillManager.fillReport(report, reportParams, beanCollectionDataSource);
            this.baseReportingLocal.reportBuilder(facesContext, jasperPrint);
        } catch (Exception ex) {
            Logger.getLogger(SampleReporting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
