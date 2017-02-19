
import java.util.Random;

public class Driver {
    
    private Random rand;
    
    private int driverNumber;
    
    private int driverLocation;
    private int previousDriverLocation;
    
    private String streetUsed;
    
    private int sennottVisits;
    
    public Driver(int driverNumber, Random rand) {
        // Assign driver number
        this.driverNumber = driverNumber;
        
        // Assign class passed in RNG
        this.rand = rand;
        
        // Create random starting location (indexes 0-3 are valid)
        this.driverLocation = this.rand.nextInt(4); // 0-3
    }
    
    
    public String beginAdventure() {
        while(driverLocation != Locations.LOC_OUTSIDE_CITY) {
            
            // Keep track of visits to Sennott Square
            if(driverLocation == Locations.LOC_SENNOTT)
                sennottVisits++;
            
            // Proceed to the next destination
            nextDestination(rand.nextInt());
            
            // Print out the path we just took
            System.out.println(getPrintablePath());
        }
        
        return printDriverInfo();
    }
    
    public String printDriverInfo() {
        // String will always print because it's in the logic right here V
        String lastStringPrintedOut = getPrintableExitString();
        System.out.println(lastStringPrintedOut);
        
        // Print out number of Laboon visits
        lastStringPrintedOut = getPrintableSennottVisits();
        System.out.println(lastStringPrintedOut);
        
        // Need Laboon visit check
        lastStringPrintedOut = getLaboonPrintableString();
        if(lastStringPrintedOut.length() > 0)
            System.out.println(lastStringPrintedOut);
        
        lastStringPrintedOut = getHyphenString();
        System.out.println(lastStringPrintedOut);
        
        // Newlines... :)
        System.out.println("\n\n");
        
        return lastStringPrintedOut;
    }
    
    public String getHyphenString() {
        return "-----";
    }

    public String getPrintableExitString() {
        String exitString;
        if (previousDriverLocation == Locations.LOC_UNION) {
            exitString = "Driver " + driverNumber + " has gone to Philadelphia!";
        } else {
            exitString = "Driver " + driverNumber + " has gone to Cleveland!";
        }
        return exitString;
    }
    
    public String getPrintablePath() {
        String pathS;
        
        // Concatenation should be exactly the same as in sample output
        pathS = "Driver " + driverNumber + " heading from " + Locations.LOCATION_NAMES[previousDriverLocation] + " to "
                + Locations.LOCATION_NAMES[driverLocation] + " via " + streetUsed;
        
        // Return path
        return pathS;
    }
    
    public String getLaboonPrintableString() {
        String laboonS = "";
        
        // Check whether or not we need to print something about Laboon
        if(getSennottVisits() == 0) {
            laboonS += "That student missed out!";
        } else if (getSennottVisits() > 2) {
            laboonS += "Wow, that driver needed lots of CS help!";
        }
        
        return laboonS;
    }
    
    public String getPrintableSennottVisits() {
        String sennottS;
        
        // Construct Sennott Visitation string
        sennottS = "Driver " + driverNumber + " met with Professor Laboon " + getSennottVisits() + " time(s)";
        return sennottS;
    }
    
    
    
    public int nextDestination(int randomValue) {
        // Although I know that I can use a Random.nextBoolean() call,
        // I prefer to use this method because I thought about the advantages
        // of using nextInt() vs nextBoolean() and, although nextBoolean() makes
        // perfect sense for this *specific* instance, had the program had an
        // option in which there were three choices, the nextBoolean() method
        // would make no sense. Therefore, for the sake of adaptable code, I 
        // chose to create a modulus integer out of a random integer passed into
        // the method that acts as a boolean (in their method instances).
        
        int boolInt = Math.abs(randomValue) % 2; // Even = true | Odd = false
        
        // Set previous location to be the current location.
        previousDriverLocation = driverLocation;
        
        // Determine where we have to go
        switch ( driverLocation ) {
            case Locations.LOC_PRESBY:
                return postPresbyDestination(boolInt);
            case Locations.LOC_UNION:
                return postUnionDestination(boolInt);
            case Locations.LOC_HILLMAN:
                return postHillmanDestination(boolInt);
            case Locations.LOC_SENNOTT:
                return postSennottDestination(boolInt);
            default:
                System.err.println("The program should have never attempted to get the next destination.");
                return -1;
        }
    }
    
    private int postPresbyDestination(int value) {
        // Get next location from random variable
        driverLocation = Locations.PRESBY_POST_LOC[value];
        
        // Get street used to get to the new location from
        streetUsed = Locations.PRESBY_STREET_TRAVERSAL[value];
        
        // Return testable driverLocation
        return driverLocation;
    }
    
    private int postUnionDestination(int value) {
        // Get next location from random variable
        driverLocation = Locations.UNION_POST_LOC[value];
        
        // Get street used to get to the new location from
        streetUsed = Locations.UNION_STREET_TRAVERSAL[value];
        
        // Return testable driverLocation
        return driverLocation;
    }
    
    private int postHillmanDestination(int value) {
        // Get next location from random variable
        driverLocation = Locations.HILLMAN_POST_LOC[value];
        
        // Get street used to get to the new location from
        streetUsed = Locations.HILLMAN_STREET_TRAVERSAL[value];
        
        // Return testable driverLocation
        return driverLocation;
    }
    
    private int postSennottDestination(int value) {
        // Get next location from random variable
        driverLocation = Locations.SENNOTT_POST_LOC[value];
        
        // Get street used to get to the new location from
        streetUsed = Locations.SENNOTT_STREET_TRAVERSAL[value];
        
        // Return testable driverLocation
        return driverLocation;
    }
    
    
    
    
    
    
    // Getters and setters...
    
    public int getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(int driverNumber) {
        this.driverNumber = driverNumber;
    }

    public int getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(int driverLocation) {
        this.driverLocation = driverLocation;
    }

    public int getPreviousDriverLocation() {
        return previousDriverLocation;
    }

    public void setPreviousDriverLocation(int previousDriverLocation) {
        this.previousDriverLocation = previousDriverLocation;
    }

    public String getStreetUsed() {
        return streetUsed;
    }

    public void setStreetUsed(String streetUsed) {
        this.streetUsed = streetUsed;
    }

    public int getSennottVisits() {
        return sennottVisits;
    }

    public void setSennottVisits(int sennottVisits) {
        this.sennottVisits = sennottVisits;
    }
    
}