package model;

import java.util.ArrayList;
import java.util.Iterator;

public class LPContainer {
    private ArrayList<LP> lp;
    private static LPContainer instance;
    private Iterator<LP> iterator;

    private LPContainer() {
        lp = new ArrayList<>();
    }

    public static LPContainer getInstance() {
        if (instance == null) {
            instance = new LPContainer();
        }
        return instance;
    }

    public boolean addLP(LP newLP) {
        boolean addedLP = false;
        if (newLP!=null) {
            lp.add(newLP);
            addedLP = true;
        }
        return addedLP;
    }

    public Iterator<LP> getIterator() {
        iterator = lp.iterator();
        return iterator;
    }

    public LP findLPByBarcode(int barcode) {
        LP foundLP = null;
        for (LP lp : lp) {
            if (lp.getBarcode() == barcode) {
                foundLP = lp;
            }
        }
        return foundLP;
    }
}