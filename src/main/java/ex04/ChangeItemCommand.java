package ex04;

import ex01.Item2d;

public class ChangeItemCommand implements Command {
    private Item2d item;
    private double offset;

    public void setItem(Item2d item) { this.item = item; }
    public void setOffset(double offset) { this.offset = offset; }

    public void execute() {
        item.energy += offset;
    }
}