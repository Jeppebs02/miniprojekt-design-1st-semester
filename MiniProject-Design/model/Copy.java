package model;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class Copy {
    private int serialNumber;
    private String purchaseDate;
    private int purchasePrice;
    private boolean borrowed;

    public Copy(int serialNumber, String purchaseDate, int purchasePrice) {
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.borrowed = false;
    }
    
    public void setBorrowed(boolean borrowed){
        this.borrowed = borrowed;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
    
    public boolean isBorrowed(){
        return borrowed;
    }

    public void printCopyInfo() {
        System.out.println("Serienummer: " + serialNumber);
        System.out.println("Købsdato: " + purchaseDate);
        System.out.println("Købspris: " + purchasePrice);
        System.out.println("Udlånsstatus: " + borrowed);
    }
    
    
}
