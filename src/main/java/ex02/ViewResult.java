package ex02;

import ex01.Item2d;
import java.io.*;
import java.util.ArrayList;

public class ViewResult implements View {
    private ArrayList<Item2d> items = new ArrayList<Item2d>();
    private static final String FNAME = "items.bin";

    public void viewInit() {
        items.clear();
        for (int i = 0; i < 5; i++) {
            double m = Math.random() * 10;
            double v = Math.random() * 10;
            double h = Math.random() * 10;
            double res = (m * v * v) / 2 + (m * 9.81 * h); 
            items.add(new Item2d(m, v, h, res));
        }
    }

    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.close();
    }

    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
        for (Item2d it : items) {
            it.bin = Long.toBinaryString((long) it.energy);
        }
    }

    public void viewHeader() { System.out.println("Resultat"); }
    public void viewBody() {
        for (Item2d it : items) System.out.println(it);
    }
    public void viewFooter() { System.out.println("End"); }
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
    public ArrayList<Item2d> getItems() { return items; }
}
