package com.mycompany.Entite;

/**
 *
 * @author Amine Masmoudi
 */
public class Offer {
    private int Id_Offer;
    private int Id_Offer_Owner;
    private String Category;
    private String Subject;
    private String Description;
    private String Location;
    private String Budget;
    private String Date_Published;
    private String offerStatus;
    private String Attachment;

    public Offer() {
    }

    public Offer(String Category, String Subject, String Description, String Location, String Budget, String Attachment) {
        this.Category = Category;
        this.Subject = Subject;
        this.Description = Description;
        this.Location = Location;
        this.Budget = Budget;
        this.Attachment = Attachment;
    }

    public Offer(int Id_Offer, int Id_Offer_Owner, String Category, String Subject, String Description, String Location, String Budget, String Date_Published, String offerStatus, String Attachment) {
        this.Id_Offer = Id_Offer;
        this.Id_Offer_Owner = Id_Offer_Owner;
        this.Category = Category;
        this.Subject = Subject;
        this.Description = Description;
        this.Location = Location;
        this.Budget = Budget;
        this.Date_Published = Date_Published;
        this.offerStatus = offerStatus;
        this.Attachment = Attachment;
    }

    public int getId_Offer() {
        return Id_Offer;
    }

    public void setId_Offer(int Id_Offer) {
        this.Id_Offer = Id_Offer;
    }

    public int getId_Offer_Owner() {
        return Id_Offer_Owner;
    }

    public void setId_Offer_Owner(int Id_Offer_Owner) {
        this.Id_Offer_Owner = Id_Offer_Owner;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String Budget) {
        this.Budget = Budget;
    }

    public String getDate_Published() {
        return Date_Published;
    }

    public void setDate_Published(String Date_Published) {
        this.Date_Published = Date_Published;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }

    public String getAttachment() {
        return Attachment;
    }

    public void setAttachment(String Attachment) {
        this.Attachment = Attachment;
    }

    @Override
    public String toString() {
        return "Offer{" + "Id_Offer=" + Id_Offer + ", Id_Offer_Owner=" + Id_Offer_Owner + ", Category=" + Category + ", Subject=" + Subject + ", Description=" + Description + ", Location=" + Location + ", Budget=" + Budget + ", Date_Published=" + Date_Published + ", offerStatus=" + offerStatus + ", Attachment=" + Attachment + '}';
    }


    
}
