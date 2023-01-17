package models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Operation")
public class Operation {
    private String id ;
    private Utilisateur expediteur ;
    private Utilisateur destinataire ;
    private int montant ;
    private Date dateOperation ;

    public Operation(){}
    public Operation(String id, Utilisateur expediteur, Utilisateur destinataire, int montant, Date dateOperation) {
        this.id = id;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.montant = montant;
        this.dateOperation = dateOperation;
    }

    public String getId() { return id; }
    public Utilisateur getDestinataire() { return destinataire; }
    public Utilisateur getExpediteur() { return expediteur; }
    public int getMontant(){ return this.montant; }
    public Date getDateOperation() { return dateOperation; }

    public void setId(String id){ this.id = id ;}
    public void setExpediteur(Utilisateur exp){ this.expediteur = exp ;}
    public void setDestinataire(Utilisateur dest){ this.destinataire = dest ;}
    public void setMontant(int montant){ this.montant = montant ;}
    public void setDateOperation(Date dateOp){ this.dateOperation = dateOp ;}
}