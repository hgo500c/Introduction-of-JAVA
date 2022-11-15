class EnergyCalculator {

	
	public static void main(String[] arguments) {
		double mass = 50;
		double initialVelocity = 10;
		double finalVelocity = 20.0;
		double increasedEnergy = 0.5 * mass * Math.pow(finalVelocity, 2) - 
				0.5 * mass * Math.pow(initialVelocity, 2);
		
		 System.out.println("The object's increase in energy after speeding up from"
		 		+  + initialVelocity +
		" m/s to " + finalVelocity + "m/s is " + increasedEnergy + " Joules");
	}
}