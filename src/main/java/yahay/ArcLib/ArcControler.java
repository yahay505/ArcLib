package yahay.ArcLib;

import java.lang.reflect.ReflectPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import edu.wpi.first.wpilibj.TimedRobot;

public abstract class ArcControler extends TimedRobot {

	public ArcControler() {
	}

	public boolean robotInitCompleted = false;

	public List<ArcBehaviour> activeBehaviours = new ArrayList<ArcBehaviour>();

	public void robotPeriodic() {
		for (ArcBehaviour arcBehaviour : activeBehaviours) {
			try {
				arcBehaviour.OnTick();

			} catch (Exception e) {
				throw e;
				// TODO: handle exception
			}
			arcBehaviour.TickGeneralTasks();
		}
	}

	public void robotInit() {
		activeBehaviours.forEach(b -> {
			try {
				b.OnRobotStart();
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}

		});
		robotInitCompleted = true;
	}

	// #region auto

	public void autonomousInit() {
		activeBehaviours.forEach(b -> {
			try {
				b.OnAutoStart();
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}

		});
	}

	public void autonomousPeriodic() {
		activeBehaviours.forEach(b -> {
			try {
				b.OnAutoTick();
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}

		});
	}

	// #endregion
	// #region teleop
	public void teleopInit() {
	}

	public void teleopPeriodic() {
	}

	// #endregion
	public void disabledInit() {
	}

	public void disabledPeriodic() {
	}

	public void testInit() {
	}

	public void testPeriodic() {
	}

}
