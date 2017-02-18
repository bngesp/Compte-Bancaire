package Controleur;

import Modele.gestionBanque.MdlConnexion;
import Vue.Main;
import Vue.MainGui;
import Vue.VueConnexion;

import javax.swing.*;

/**
 * Created by bng on 2/16/17.
 */
public class CtlConnexion {
    private VueConnexion vue;
    private MdlConnexion model;

    public CtlConnexion(VueConnexion vue, MdlConnexion model) {
        this.vue = vue;
        this.model = model;
    }

    public void authentification()
    {
        if(model.authentifierAgent())
        {
            new Main();
            vue.setVisible(false);
            vue.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(vue, "Erreur d'authentification! veuillez ressayer");
        }
    }




}
