package ex04;

import ex01.Item2d;
import ex02.View;
import ex02.ViewResult;

public class ChangeConsoleCommand extends ChangeItemCommand implements ConsoleCommand {
    private View view;

    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    public char getKey() { return 'c'; }

    public String toString() { return "'c'hange"; }

    public void execute() {
        double factor = Math.random() * 10.0;
        System.out.println("Zmina danyh: " + factor );

        for (Item2d it : ((ViewResult)view).getItems()) {
            super.setItem(it);
            super.setOffset(factor);
            super.execute();
        }
        view.viewShow();
    }
}