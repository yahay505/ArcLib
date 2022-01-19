package subsystems;

import java.util.Iterator;

import edu.wpi.first.wpilibj.Timer;
import yahay.ArcLib.ArcBehaviour;
import yahay.ArcLib.Task;
import yahay.ArcLib.TaskWaiters.WaitTime;

public class Demo extends ArcBehaviour {

	@Override
	public void OnTick() {
		System.out.print(".");

	}

	@Override
	public void OnTeleopTick() {
		System.out.print("₺");

	}

	@Override
	public void OnAutoTick() {
		System.out.print("@");

	}

	@Override
	public void OnTeleopStart() {
		System.out.print("TeleopStart");

	}

	@Override
	public void OnAutoStart() {
		System.out.print("Autonomous Start");
		// StartTask(task, type);

	}

	@Override
	public void OnRobotStart() {
		System.out.print("Hello from the other side");

	}

	Task AutonomousTask = new Task(true, () -> {
		System.out.print("Task Started! Starting 5sec timer");
		// here we start our motors and such

		// here goes code ...

		// we then wait for time or travel distance
		// in this case for 5 sec
		return new Task(new WaitTime(5).Done(), () -> {

			// after 5 sec we continiue execution
			// without loosing the function stack

			// now we may turn around, throw balls, stop the motors etc

			// here goes code ...

			System.out.print("timer Fired, have a nice Day!");

			return new Task(new WaitTime(5).Done(), () -> {

				// here goes code ...
				// here goes code ...
				System.out.print("after 10 sec");

				// to exit return null
				return null;
			});
		});
	});

	/**
	 * InnerDemo
	 */
	public class Longlived {
		int stt = 0;

		int run() {
			switch (stt) {
				case 0:

					break;

				default:
					break;
			}
			return 0;
		}
	}
}