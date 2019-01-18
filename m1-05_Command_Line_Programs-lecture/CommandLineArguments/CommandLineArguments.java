public class CommandLineArguments {

	/*
	 * String[] args contains arguments passed on the command like, for example, for 
	 * an application like git, if we typed git add -A, then git would be the program and 
	 * args would contain  args[0] = "add"  and args[1] = "-A".
	 * 
	 * This allows the user to give our program commands or feed it data from the terminal
	 * command line when they run it.
	 */
	
	public static void main(String[] args) {
		
		/*
		 * How could we display all the arguments passed into the args array?
		 */
		
		for (int i = 0; i < args.length; i++) {
			
			System.out.println(args[i]);
		}
		
		/*
		 * How could we use those arguments in our program?
		 */
		
		if (args.length > 0) {
			
			int x = 10; 
			int y = 20;
			
			if (args[0].equals("add")) {
				System.out.println("You selected to add " + (x + y));
			}
			if (args[0].equals("multiply")) {
				System.out.println("You selected to multiply " + (x * y));
			}
			else {
				System.out.println("Unknown command");
			}
			
			switch (args[0]) {
				case "add": 
					System.out.println("You selected to add " + (x + y));
					break;
				case "multiply": 
					System.out.println("You selected to multiply " + (x * y));
					break;
				default:
					System.out.println("Unknown command");
					break;
			}
		}
	}

}