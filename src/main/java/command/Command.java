package command;

import field.machines.Machine;

@FunctionalInterface
public interface Command {
    public void execute(Machine m);
}
