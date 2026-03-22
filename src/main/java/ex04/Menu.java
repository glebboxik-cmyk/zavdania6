package ex04;

import java.io.*;
import java.util.*;

public class Menu implements Command {
    private List<ConsoleCommand> menu = new ArrayList<ConsoleCommand>();

    public void add(ConsoleCommand command) {
        menu.add(command);
    }

    public void execute() throws Exception {
        String s = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\nMenu: " + this.toString());
            try {
                s = in.readLine();
            } catch (IOException e) {
                System.out.println("Pomylka");
            }

            if (s.equals("q")) {
                System.out.println("Exit.");
                break;
            }

            for (ConsoleCommand c : menu) {
                if (s.length() > 0 && s.charAt(0) == c.getKey()) {
                    try {
                        c.execute();
                    } catch (Exception e) {
                        System.out.println(" " + e.getMessage());
                    }
                }
            }
        }
    }

    public String toString() {
        String res = "Enter command \n";
        for (ConsoleCommand c : menu) {
            res += c.toString() + ", ";
        }
        return res + "'q'uit: ";
    }
}
