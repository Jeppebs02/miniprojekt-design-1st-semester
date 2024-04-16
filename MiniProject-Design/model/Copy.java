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

    public Copy(int serialNumber, String purchaseDate, int purchasePrice) {
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
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

    public void printCopyInfo() {
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println("Purchase Price: " + purchasePrice);
    }
    
    
}
