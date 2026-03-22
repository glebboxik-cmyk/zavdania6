package ex03;

import ex02.ViewResult;
import ex01.Item2d;

public class ViewTable extends ViewResult {
    private int width = 30;

    public ViewTable() {
        super();
    }

    public final void init(int width) {
        this.width = width;
        viewInit();
    }

    public void viewInit() {
        System.out.println(" ");
        super.viewInit();
    }

    private void line() {
        for (int i = 0; i < width; i++) System.out.print("-");
        System.out.println();
    }

    public void viewHeader() {
        line();
        System.out.printf("| %-10s | %-12s |\n", "Parametr", "Resultat");
        line();
    }

    public void viewBody() {
        for (Item2d it : getItems()) {
            System.out.printf("| %-12s | %-30s |\n", "Energiia:", it.energy);
        }
    }

    public void viewFooter() {
        line();
    }
}
