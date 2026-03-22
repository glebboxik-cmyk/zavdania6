package ex04;

import ex02.View;

public class GenerateConsoleCommand implements ConsoleCommand {
    private View view;

    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    public char getKey() { return 'g'; }

    public String toString() { return "'g'enerate"; }

    public void execute() {
        System.out.println("  ");
        view.viewInit();
        view.viewShow();
    }
}