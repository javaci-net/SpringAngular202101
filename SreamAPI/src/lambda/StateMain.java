package lambda;

public class StateMain {

	public static void main(String[] args) {
		int i = 5;
		
		StateOwner stateOwner = new StateOwner();

		stateOwner.addStateListener(new StateChangeListener() {
			private int eventCount = 0;
			public void onStateChange(State oldState, State newState) {
				System.out.println("Merhaba1");
				eventCount++;
			}
		});
		
		final int b = 5;
		stateOwner.addStateListener((State oldState, State newState) -> {
				System.out.println("Merhaba2" + i);
			});
		
		
		StateChangeListener scl = (oldState, newState) -> {
				System.out.println("Merhaba3");
			};
		
		stateOwner.addStateListener(scl);
		
		var scl2 = new StateChangeListener() {

			public void onStateChange(State oldState, State newState) {
				System.out.println("Merhaba1");
			}
		};
		

	}

}
