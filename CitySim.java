
import java.util.InputMismatchException;
import java.util.Random;

public class CitySim {
    
    private int trials;
    
    private Random rand;
    
    public CitySim(int seed) {
        rand = new Random(seed);
    }
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("There must be an integer seed argument to run this program. Program exiting.");
            System.exit(0);
        }
        else if (args.length > 1) {
            System.out.println("This program requires only one argument: an integer value seed. Program exiting.");
            System.exit(2);
        }
        int seed = 0;
        try {
            seed = Integer.parseInt(args[0]);
        } catch (InputMismatchException e) {
            System.out.println("The argument must be an integer seed value. Program exiting.");
            System.exit(-1);
        }
        CitySim cs = new CitySim(seed);
        cs.run();
    }
    
    
    public int[] run() {
        // Test array we will return to verify both size and order of
        // our test.
        int[] test = new int[5];
        
        for(int i = 0; i < 5; i++) {
            
            // Rule of thumb for me is if I'm using variable arithmetic
            // more than once with the same operators, to create a variable
            // for them. (Not really that big of a deal in terms of performance)
            int driverNumber = i + 1;
            
            // Each Driver will be assigned numbers 1-n and
            // have a new Random number generator passed into
            // the constructor.
            Driver driver = new Driver(driverNumber, rand);
            
            // Obviously, we will be recording the driver numbers in order due to
            // the deterministic nature of a for-loop, but just to be consistent
            // in terms of testing, we should record each number.
            test[i] = driverNumber;
            
            // Thank Cthulu for for-loops
            driver.beginAdventure(); // Begin the voyage of a lifetime!
        }
        return test;
    }
    
}