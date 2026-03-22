package ex05;

import java.util.concurrent.TimeUnit;
import ex02.View;
import ex02.ViewResult;
import ex04.ConsoleCommand;

public class ExecuteConsoleCommand implements ConsoleCommand {
    private View view;

    public ExecuteConsoleCommand(View view) {
        this.view = view;
    }

    public char getKey() {
        return 'e';
    }

    public String toString() {
        return "'e'xecute";
    }

    public void execute() {
        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();

        AvgCommand avgCommand = new AvgCommand((ViewResult) view);

        System.out.println("");
        queue1.put(avgCommand);

        try {
            while (avgCommand.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue1.shutdown();
            queue2.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("Zrobleno");
    }
}
