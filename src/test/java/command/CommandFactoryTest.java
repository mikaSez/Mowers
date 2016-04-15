package command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import field.machines.Machine;

public class CommandFactoryTest {
    private MachineCommandFactory tested;
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

    }

    @Before
    public void setUp() throws Exception {
	tested = MachineCommandFactory.init();
	mock = new MachineMock();
    }

    @Test
    public void advanceCommand() {
	tested.execute((int) 'A', mock);
	Assert.assertTrue(mock.advanced);
	Assert.assertFalse(mock.left);
	Assert.assertFalse(mock.right);
    }

    @Test
    public void leftCommand() {
	tested.execute((int) 'G', mock);
	Assert.assertFalse(mock.advanced);
	Assert.assertTrue(mock.left);
	Assert.assertFalse(mock.right);
    }

    @Test
    public void rightCommand() {
	tested.execute((int) 'D', mock);
	Assert.assertFalse(mock.advanced);
	Assert.assertFalse(mock.left);
	Assert.assertTrue(mock.right);
    }

}
