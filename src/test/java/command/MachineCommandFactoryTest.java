package command;


        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

        import field.machines.Machine;
        import position.Alignment;

public class MachineCommandFactoryTest {
    private CommandFactory tested;
    private MachineMock mock;

    private class MachineMock implements Machine {
        private boolean advanced = false;
        private boolean right = false;
        private boolean left = false;

        @Override
        public void advance() {
            advanced = true;
        }

        @Override
        public void right() {
            right = true;
        }

        @Override
        public void left() {
            left = true;
        }

        @Override
        public Alignment getAlignment() {
            return null;
        }

    }

    @Before
    public void setUp() throws Exception {
        mock = new MachineMock();
        tested = MachineCommandFactory.init(mock);

    }

    @Test
    public void advanceCommand() {
        tested.runCommands("A");
        Assert.assertTrue(mock.advanced);
        Assert.assertFalse(mock.left);
        Assert.assertFalse(mock.right);
    }

    @Test
    public void leftCommand() {
        tested.runCommands("G");
        Assert.assertFalse(mock.advanced);
        Assert.assertTrue(mock.left);
        Assert.assertFalse(mock.right);
    }

    @Test
    public void rightCommand() {
        tested.runCommands("D");
        Assert.assertFalse(mock.advanced);
        Assert.assertFalse(mock.left);
        Assert.assertTrue(mock.right);
    }

}
