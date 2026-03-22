package ex05;

import java.util.concurrent.TimeUnit;
import ex01.Item2d;
import ex02.ViewResult;
import ex04.Command;

public class AvgCommand implements Command, Runnable {
    private double result = 0.0;
    private int progress = 0;
    private ViewResult viewResult;

    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public boolean running() {
        return progress < 100;
    }

    public void execute() {
        progress = 0;
        System.out.println("");
        result = 0.0;

        if (viewResult == null || viewResult.getItems().size() == 0) {
            progress = 100;
            return;
        }

        int idx = 1;
        int size = viewResult.getItems().size();

        for (Item2d item : viewResult.getItems()) {
            result = result + item.getY();
            progress = idx * 100 / size;

            if (size > 1 && idx % (size / 2) == 0) {
                System.out.println("Average " + progress + "%");
            }

            try {
                TimeUnit.MILLISECONDS.sleep(2000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            idx++;
        }

        System.out.println("Resultat: " + String.format("%.2f", result / size));
        progress = 100;
    }

    public void run() {
        execute();
    }
}
