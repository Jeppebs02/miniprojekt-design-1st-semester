package control;
import model.LP;
import model.LPContainer;
import model.Copy;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class LPController {
    private LPContainer lpContainer;

    public LPController() {
        lpContainer = LPContainer.getInstance();
    }

    // Opret en ny LP og tilføj den til containeren
    public void createLP(int barcode, String title, String artist, String publicationDate) {
        LP newLP = new LP(barcode, title, artist, publicationDate);
        saveLP(newLP);
    }

    // Gem en ny LP i containeren
    public boolean saveLP(LP newLP) {
        return lpContainer.addLP(newLP);
    }

    // Find en LP med barcode
    public LP findLPByBarcode(int barcode) {
        return lpContainer.findLPByBarcode(barcode);
    }
    
    public Copy findCopyBySerialNumber(LP lp, int sn){
        LPContainer lpContainer= LPContainer.getInstance();
        return lpContainer.findCopyBySerialNumber(lp,sn);
    }
    
    public void createLPCopy(LP lp, int copySerialNumber, String copyPurchaseDate, int copyPurchasePrice){
        Copy lpCopy = new Copy(copySerialNumber, copyPurchaseDate, copyPurchasePrice);
        lp.addCopy(lpCopy);
    }
}
