/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.converter;

import com.Entites.Tree.Codegenerator;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


/**
 *
 * @author m.atallah
 */

public class CodeGeneratorConverter implements Converter{

    private List<Codegenerator> codeGenerators;

    public CodeGeneratorConverter(List<Codegenerator> CodeGeneratorConverter) {
        this.codeGenerators = CodeGeneratorConverter;
    }
     
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for (Codegenerator codeGenerator : codeGenerators) {
            try {
                Long.parseLong(value);
            } catch (Exception e) {
                return null;
            }
            if (!value.equals("") && !value.equals(" ") && codeGenerator.getCodegeneratorid().longValue() == Long.parseLong(value)) {
                return codeGenerator;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       try {

            if (value != null && !value.equals("") && !value.equals(" ")) {
                if (((Codegenerator) value).getCodegeneratorid()!=null && ((Codegenerator) value).getCodegeneratorid().longValue() != 0) {
                    Codegenerator codegenerator = (Codegenerator) value;
                    return codegenerator.getCodegeneratorid().longValue() + "";
                } else {
                    return "";
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    }
    

