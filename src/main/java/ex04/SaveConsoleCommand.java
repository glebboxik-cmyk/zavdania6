package ex04;

import ex02.View;

public class SaveConsoleCommand implements ConsoleCommand {
    private View view;

    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    public char getKey() { return 's'; }

    public String toString() { return "'s'ave"; }

    public void execute() throws Exception {
        System.out.println("  ");
        view.viewSave();
        System.out.println("Zberezheno");
    }
}