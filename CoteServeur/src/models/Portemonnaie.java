package models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Portemonnaie")
public class Portemonnaie {
    private String id ;
    private int solde ;
    private Utilisateur utilisateur ;
    private ArrayList<Operation> historique = new ArrayList<>();

    public Portemonnaie(String id, int solde, Utilisateur user, ArrayList<Operation> historique){
        this.id = id;
        this.solde = solde;
        this.utilisateur = user;
        this.historique = historique;
    }

    public boolean initialiserPortemonnaie(){
        solde = 0 ;
        return false ;
    }

    public Utilisateur getUtilisateur(){ return this.utilisateur;}
    public void setUtilisateur(Utilisateur user){ utilisateur = user ;}

    public int getSolde(){ return solde;}
    public void setSolde(int solde){this.solde = solde;}

    public ArrayList<Operation> listerHistorique(){return this.historique ;}

    
    // FONCTIONNALITES DU PORTEMONNAIE
    
    public boolean ajouterOperation(Operation op){
        if(this.historique.add(op))
            return true ;
        return false ;
    }

    public boolean envoyerArgent(Utilisateur dest, int montant){
        // TODO: Implémenter fonctionnalités envoyer argent
        return false ;
    }

    public ArrayList<Operation> getHistorique(){
        // TODO: Implémenter l'historique des activités d'un compte donné
        return this.historique ;
    }
}