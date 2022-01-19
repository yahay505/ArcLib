package yahay.ArcLib.TaskWaiters;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Timer;

public class WaitTime {
	private Timer timer;
	private double secondsToWait;

	public WaitTime(double secondsToWait) {
		timer = new Timer();
		timer.start();
	}

	public Supplier<Boolean> Done() {
		return () -> timer.hasElapsed(secondsToWait);
	}

}
