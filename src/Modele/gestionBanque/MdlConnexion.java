package Modele.gestionBanque;

import Modele.gestionBD.Gerant;

/**
 * Created by abdoulaye on 2/16/17.
 */
public class MdlConnexion {
    private String login;
    private String mdp;
    private String profil;

    public MdlConnexion(String login, String mdp, String profil) {
        this.login = login;
        this.mdp = mdp;
        this.profil = profil;
    }

    public MdlConnexion(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean authentifierAgent(){
        return Gerant.existeGerant(login, mdp, profil);
    }
}
