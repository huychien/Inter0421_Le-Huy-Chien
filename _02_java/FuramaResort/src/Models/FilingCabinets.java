package Models;

import java.util.Stack;

public class FilingCabinets {
    private Stack<Employee> stack;

    public FilingCabinets() {
    }

    public FilingCabinets(Stack<Employee> stack) {
        this.stack = stack;
    }

    public Stack<Employee> getStack() {
        return stack;
    }

    public void setStack(Stack<Employee> stack) {
        this.stack = stack;
    }
}
