/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.Entite.Offer;
import com.codename1.components.SpanLabel;
import com.mycompany.services.OfferServices;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;

/**
 *
 * @author Amine Masmoudi
 */
public class ShowOffer extends Form {
    Form f ;
    SpanLabel lb;
        public ShowOffer(){
            
            f = new Form();
            lb = new SpanLabel("");
            f.add(lb);
            OfferServices os = new OfferServices();
            lb.setText(os.getList2().toString());
        
        
    }
        
        public Form getF() {
            return f ;
        }
        public void setF(Form f){
            this.f = f;
        }
}
