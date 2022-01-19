package yahay.ArcLib;

import java.util.function.Supplier;

public class Task {
	public Supplier<Boolean> ShouldRun;
	public Supplier<Task> ToRun;

	public boolean IsDone() {
		return this.ToRun == null;

	}

	public Task(Supplier<Boolean> waitTill, Supplier<Task> toRun) {
		ShouldRun = waitTill;
		ToRun = toRun;
	}

	public Task(boolean waitTill, Supplier<Task> toRun) {
		this(() -> waitTill, toRun);
	}

}
