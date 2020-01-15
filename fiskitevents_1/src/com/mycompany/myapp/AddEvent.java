/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.NumericSpinner;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;

/**
 *
 * @author zomra
 */
public class AddEvent extends Form {
    public AddEvent(Resources theme){
        setTitle("AddEvent");
        
        Label titlel = new Label("Title :");
        TextField titlet = new TextField("", "title");
        
        Label descriptionl = new Label("Description :");
        TextField descriptiont = new TextField("", "Description");
        
        Label datel = new Label("Date :");
        Picker datep =new Picker();
        
        Label placel = new Label("Place :");
        TextField placet = new TextField("", "Place");
        
        Label vacanciesl = new Label("Vacancies :");
        TextField vacanciest = new TextField("", "Vacancies");
        Validator val = new Validator();
        val.addConstraint(vacanciest, new NumericConstraint(true));
        
        Label capacityl = new Label("Capacity :");
        TextField capacityt = new TextField("", "Capacity");
        val.addConstraint(capacityt, new NumericConstraint(true));
        
        val.setValidateOnEveryKey(true);
        
        
                
        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container cnttitle = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container cntdescription = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container cntdate = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container cntplace = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container cntvacancies = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container cntcapacity = new Container(new BoxLayout(BoxLayout.X_AXIS));
        
        cnttitle.add(titlel);
        cnttitle.add(titlet);
        
        cntdescription.add(descriptionl);
        cntdescription.add(descriptiont);
        
        cntdate.add(datel);
        cntdate.add(datep);
        
        cntplace.add(placel);
        cntplace.add(placet);
        
        cntvacancies.add(vacanciesl);
        cntvacancies.add(vacanciest);
        
        cntcapacity.add(capacityl);
        cntcapacity.add(capacityt);
        
        cnt.add(cnttitle);
        cnt.add(cntdescription);
        cnt.add(cntplace);
        cnt.add(cntvacancies);
        cnt.add(cntcapacity);
        cnt.add(cntdate);
        
        
        add(cnt);
        
              
    }
    
}
