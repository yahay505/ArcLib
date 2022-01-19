package yahay.ArcLib;

import java.util.ArrayList;
import java.util.List;

public abstract class ArcBehaviour {
	private List<Task> generalTasks = new ArrayList<Task>();
	private List<Task> teleopTasks = new ArrayList<Task>();
	private List<Task> autoTasks = new ArrayList<Task>();

	public ArcBehaviour() {

	}

	// #region houseKeeping
	public final void TickGeneralTasks() {
		for (Task task : generalTasks) {
			if (task.ShouldRun.get()) {
				task.ToRun.get();
			}
		}
		generalTasks.removeIf(n -> {
			return n.IsDone();
		});
	}

	public final void TickTeleopTasks() {
		for (Task task : teleopTasks) {
			if (task.ShouldRun.get()) {
				task.ToRun.get();
			}
		}
		teleopTasks.removeIf(n -> {
			return n.IsDone();
		});
	}

	public final void TickAutoTasks() {
		for (Task task : autoTasks) {
			if (task.ShouldRun.get()) {
				task.ToRun.get();
			}
		}
		autoTasks.removeIf(n -> {
			return n.IsDone();
		});
	}

	public final void StartTask(Task task, TaskType type) {
		switch (type) {
			case general:
				generalTasks.add(task);
				break;
			case teleop:
				teleopTasks.add(task);

				break;
			case auto:
				autoTasks.add(task);

				break;
			case disabled:

				break;
			default:

				break;
		}
	}

	static enum TaskType {
		general,
		teleop,
		auto,
		disabled,

	}
	// #endregion

	public abstract void OnTick();

	public abstract void OnTeleopTick();

	public abstract void OnAutoTick();

	public abstract void OnTeleopStart();

	public abstract void OnAutoStart();

	public abstract void OnRobotStart();

}
