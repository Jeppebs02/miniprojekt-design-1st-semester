package model;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class LP {
    private int barcode;
    private String title;
    private String artist;
    private String publicationDate;
    private ArrayList<Copy> copies;
    private Iterator<Copy> iterator;

    public LP(int barcode, String title, String artist, String publicationDate) {
        this.barcode = barcode;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
        copies = new ArrayList<>();
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void printLPInfo() {
        System.out.println("Barcode: " + barcode);
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Publication Date: " + publicationDate);
    }
    
    //tilføj til systemudviklingsdiagramer
    public boolean addCopy(Copy newCopy) {
        boolean addedCopy = false;
        if (newCopy!=null) {
            copies.add(newCopy);
            addedCopy = true;
        }
        return addedCopy;
    }
    
    //tilføj til systemudviklingsdiagramer
    public Copy findCopyBySerialNumber(int serialNumber) {
        Copy foundCopy = null;
        for (Copy c : copies) {
            if (c.getSerialNumber() == serialNumber) {
                foundCopy = c;
            }
        }
        return foundCopy;
    }
    
    public Copy createCopy(int serialNumber, String purchaseDate, int purchasePrice){
        Copy c = new Copy(serialNumber,purchaseDate,purchasePrice);
        return c;
    }
}
