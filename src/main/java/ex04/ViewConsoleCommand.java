package ex04;

import ex02.View;

public class ViewConsoleCommand implements ConsoleCommand {
    private View view;

    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    public char getKey() { return 'v'; }

    public String toString() { return "'v'iew"; }

    public void execute() {
        System.out.println("  ");
        view.viewShow();
    }
}