import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;


public class DriverTest {
    
    // RNG test double
    public Random testDoubleRNG() {
        Random rand = new Random(1632);
        return rand;
    }
    
    // Tests the setter/getter method for driverLocation. This guarantees
    // that both our tests and source code works with intended functions
    // used both throughout tests and throughout source.
    @Test
    public void testSetterGetterDriverLocation() {
        Driver d = new Driver(0, testDoubleRNG());
        d.setDriverLocation(0);
        assertEquals(0, d.getDriverLocation());
        
        d.setDriverLocation(1);
        assertEquals(1, d.getDriverLocation());
        
        d.setDriverLocation(-1);
        assertEquals(-1, d.getDriverLocation());
        
        d.setDriverLocation(100);
        assertEquals(100, d.getDriverLocation());
    }
    
    @Test
    // Tests the setter/getter method for previousDriverLocation. This guarantees
    // that both our tests and source code works with intended functions
    // used both throughout tests and throughout source.
    public void testSetterGetterPreviousDriverLocation() {
        Driver d = new Driver(0, testDoubleRNG());
        d.setPreviousDriverLocation(0);
        assertEquals(0, d.getPreviousDriverLocation());
        
        d.setPreviousDriverLocation(1);
        assertEquals(1, d.getPreviousDriverLocation());
        
        d.setPreviousDriverLocation(-1);
        assertEquals(-1, d.getPreviousDriverLocation());
        
        d.setPreviousDriverLocation(100);
        assertEquals(100, d.getPreviousDriverLocation());
    }
    
    
    // Tests the setter/getter method for streetUsed. This guarantees
    // that both our tests and source code works with intended functions
    // used both throughout tests and throughout source.
    @Test
    public void testSetterGetterStreetUsed() {
        Driver d = new Driver(0, testDoubleRNG());
        d.setStreetUsed("Bill St.");
        assertTrue(d.getStreetUsed().equals("Bill St."));
        
        d.setStreetUsed("Phil St.");
        assertTrue(d.getStreetUsed().equals("Phil St."));
        
        d.setStreetUsed("Fifth Ave.");
        assertTrue(d.getStreetUsed().equals("Fifth Ave."));
        
        d.setStreetUsed("Fourth Ave.");
        assertTrue(d.getStreetUsed().equals("Fourth Ave."));
    }
    
    @Test
    public void testSetterGetterSennottVisits() {
        Driver d = new Driver(0, testDoubleRNG());
        d.setSennottVisits(0);
        assertEquals(0, d.getSennottVisits());
        
        d.setSennottVisits(1);
        assertEquals(1, d.getSennottVisits());
        
        d.setSennottVisits(5);
        assertEquals(5, d.getSennottVisits());
        
        d.setSennottVisits(10);
        assertEquals(10, d.getSennottVisits());
    }
    
    // This tests that at the end of a given Driver's journey,
    // the driver prints out a 5-hypen string at the end. This 
    // works by comparing the last "gathered" String from the
    // printDriverInfo() method.
    @Test
    public void testFunDashes() {
        Driver d = new Driver(0, testDoubleRNG());
        assertTrue(d.printDriverInfo().equals("-----"));
    }
    
    
    // This tests that if a driver exits via Fifth Ave. (at Sennott)
    // that they go outside the city. If they go outside the city,
    // then their current return String should return that they left
    // the city and headed to Cleveland.
    @Test
    public void testFunOutsideCityCleveland() {
        // Create a new Driver at Sennott
        Driver d = new Driver(0, testDoubleRNG());
        d.setDriverLocation(Locations.LOC_SENNOTT);
        // Advances the driver along Fifth Ave.
        d.nextDestination(0);
        // Checks to see if we are outside the city limits
        assertEquals(Locations.LOC_OUTSIDE_CITY, d.getDriverLocation());
        // Checks to see that our String that returns tells us we exited
        // to Cleveland.
        assertTrue(d.getPrintableExitString().equals("Driver 0 has gone to Cleveland!"));
    }
    
    // This tests that if a driver exits via fifth avenue (at Union)
    // that they go outside the city. If they go outside the city,
    // then their current return String should return that they left
    // the city and headed to Philadelphia.
    @Test
    public void testFunOutsideCityPhiladelphia() {
        // Create a new Driver at Sennott
        Driver d = new Driver(0, testDoubleRNG());
        d.setDriverLocation(Locations.LOC_UNION);
        // Advances the driver along Fifth Ave.
        d.nextDestination(0);
        // Checks to see if we are outside the city limits
        assertEquals(Locations.LOC_OUTSIDE_CITY, d.getDriverLocation());
        // Checks to see that our String that returns tells us we exited
        // to Cleveland.
        assertTrue(d.getPrintableExitString().equals("Driver 0 has gone to Philadelphia!"));
    }
    
    // Test that our string (which we are sure will print)
    // prints correctly, as intended, for multiple different
    // outputs. This uses method stubs, as does testFunSennottEdges
    // and the methods at the end which test that street traversal works
    // as intended.
    @Test
    public void testFunSennottCount() {
        DriverStub0 test0 = new DriverStub0();
        DriverStub2 test2 = new DriverStub2();
        DriverStub3 test3 = new DriverStub3();
        DriverStub4 test4 = new DriverStub4();
        // Test each Driver class
        assertTrue(test0.getPrintableSennottVisits().equals("Driver 0 met with Professor Laboon 0 time(s)"));
        assertTrue(test2.getPrintableSennottVisits().equals("Driver 0 met with Professor Laboon 2 time(s)"));
        assertTrue(test3.getPrintableSennottVisits().equals("Driver 0 met with Professor Laboon 3 time(s)"));
        assertTrue(test4.getPrintableSennottVisits().equals("Driver 0 met with Professor Laboon 4 time(s)"));
        
    }
    
    
    // Tests that our string which is contingent on the amount of 
    // visits to Sennott is working as intended. 0 visits should
    // state that the driver missed out, 1-2 visits should return
    // an empty string, and 3 or more visits should print that
    // the student needed a lot of CS help.
    @Test
    public void testFunSennottEdges() {
        DriverStub0 test0 = new DriverStub0();
        DriverStub2 test2 = new DriverStub2();
        DriverStub3 test3 = new DriverStub3();
        DriverStub4 test4 = new DriverStub4();
        // Test each Driver class
        assertTrue(test0.getLaboonPrintableString().equals("That student missed out!"));
        assertTrue(test2.getLaboonPrintableString().isEmpty());
        assertTrue(test3.getLaboonPrintableString().equals("Wow, that driver needed lots of CS help!"));
        assertTrue(test4.getLaboonPrintableString().equals("Wow, that driver needed lots of CS help!"));
    }
    
    
    // This test will test that the starting locations are VALID. Does not mock, but
    // uses random testing in which we are practically guaranteed not to fail the test,
    // assuming the method works as intended.
    @Test
    public void testFunStartLoc() {
        boolean[] startedOn = new boolean[4]; // 4 locations - do not include City
        
        for(int i = 0; i < 4; i++) {
            startedOn[i] = false;
        }
        
        // We will create 1000 new Driver objects with a different RNG for each
        // This will make it so that we ge emulate normal program behavior and
        // guarantee that it covers the possibilities of all locations.
        for (int i = 0; i < 1000; i++) {
            
            // Create Driver object 
            Driver testDriver = new Driver(0, new Random());
            
            // Gather location
            int loc = testDriver.getDriverLocation();
            
            // Make sure location is legitimate
            if (loc > 3 || loc < 0) { // If location value is invalid
                fail(); // Fail this test immediately
                break; // Break from loop
            }
            
            // Mark that we started at this location
            startedOn[loc] = true;
       }
        
       // Make sure we've started at ALL valid locations at least once in the one
       // thousand tries. The chances of this program actually working as intended
       // (where each starting location is equally likely) and failing to work is 
       // very slim - just under 5 in 10^125. :)
       assertTrue(startedOn[0]);
       assertTrue(startedOn[1]);
       assertTrue(startedOn[2]);
       assertTrue(startedOn[3]);
    }
    
    // This tests that the print path method works as intended and returns a string
    // that we expect. This will fail if either the string method changes or if the below
    // (street/avenue) methods change.
    @Test
    public void testPrintablePath() {
        Driver d0 = new Driver(0, testDoubleRNG());
        d0.setDriverLocation(Locations.LOC_SENNOTT);
        d0.nextDestination(1);
        assertTrue(d0.getPrintablePath().equals("Driver 0 heading from Sennott to Presby via Bill St."));
        
        Driver d1 = new Driver(1, testDoubleRNG());
        d1.setDriverLocation(Locations.LOC_UNION);
        d1.nextDestination(0);
        assertTrue(d1.getPrintablePath().equals("Driver 1 heading from Union to Outside City via Fourth Ave."));
    }
    
    
    // -- TEST STREETS -- //
    
    // This tests whether Presby and Sennott connect together by the correct street.
    // Tests that streets are backwards-compatible (same streets traversed back-forth)
    // Also tests that the streets are ACTUALLY what they're supposed to be.
    // Presby > Sennott via Bill St.
    @Test
    public void testPresbySennott() {
        // Create new Driver
        Driver d = new Driver(0, testDoubleRNG());
        
        // Set Driver to start location of test, and confirm its being at the start location
        d.setDriverLocation(Locations.LOC_PRESBY);
        assertEquals(d.getDriverLocation(), Locations.LOC_PRESBY);
        
        // Assert that a failing condition is false via method stub
        DriverStubNextIsUnion stub = new DriverStubNextIsUnion();
        assertFalse(stub.nextDestination(0) == Locations.LOC_SENNOTT);
        
        // Confirm next destination is at the correct location via the right street
        assertEquals(d.nextDestination(1), Locations.LOC_SENNOTT);
        assertEquals("Bill St.", Locations.SENNOTT_STREET_TRAVERSAL[1]);
        
        // Ensure street-backwards compatibility
        assertEquals(d.getStreetUsed(), Locations.SENNOTT_STREET_TRAVERSAL[1]);
    }
    
    // This tests whether Sennott and Presby connect together by the correct street.
    // Tests that streets are backwards-compatible (same streets traversed back-forth)
    // Also tests that the streets are ACTUALLY what they're supposed to be.
    // Sennott > Presby via Bill St.
    @Test
    public void testSennottPresby() {
        // Create new Driver
        Driver d = new Driver(0, testDoubleRNG());
        
        // Set Driver to start location of test, and confirm its being at the start location
        d.setDriverLocation(Locations.LOC_SENNOTT);
        assertEquals(d.getDriverLocation(), Locations.LOC_SENNOTT);
        
        // Assert that a failing condition is false via method stub
        DriverStubNextIsUnion stub = new DriverStubNextIsUnion();
        assertFalse(stub.nextDestination(0) == Locations.LOC_PRESBY);
        
        // Confirm next destination is at the correct location via the right street
        assertEquals(d.nextDestination(1), Locations.LOC_PRESBY);
        assertEquals("Bill St.", Locations.SENNOTT_STREET_TRAVERSAL[1]);
        
        // Ensure street-backwards compatibility 
        assertEquals(d.getStreetUsed(), Locations.PRESBY_STREET_TRAVERSAL[1]);
    }
    
    // This tests whether Union and Hillman connect together by the correct street.
    // Tests that streets are backwards-compatible (same streets traversed back-forth)
    // Also tests that the streets are ACTUALLY what they're supposed to be.
    // Union > Hillman via Phil St.
    @Test
    public void testUnionHillman() {
        // Create new Driver
        Driver d = new Driver(0, testDoubleRNG());
        
        // Set Driver to start location of test, and confirm its being at the start location
        d.setDriverLocation(Locations.LOC_UNION);
        assertEquals(d.getDriverLocation(), Locations.LOC_UNION);
        
        // Assert that a failing condition is false via method stub
        DriverStubNextIsUnion stub = new DriverStubNextIsUnion();
        assertFalse(stub.nextDestination(0) == Locations.LOC_HILLMAN);
        
        // Confirm next destination is at the correct location via the right street
        assertEquals(d.nextDestination(1), Locations.LOC_HILLMAN);
        assertEquals("Phil St.", Locations.UNION_STREET_TRAVERSAL[1]);
        
        // Ensure street-backwards compatibility 
        assertEquals(d.getStreetUsed(), Locations.HILLMAN_STREET_TRAVERSAL[1]);
    }
    
    // This tests whether Hillman and Union connect together by the correct street.
    // Tests that streets are backwards-compatible (same streets traversed back-forth)
    // Also tests that the streets are ACTUALLY what they're supposed to be.
    // Hillman > Union via Phil St.
    @Test
    public void testHillmanUnion() {
        // Create new Driver
        Driver d = new Driver(0, testDoubleRNG());
        
        // Set Driver to start location of test, and confirm its being at the start location
        d.setDriverLocation(Locations.LOC_HILLMAN);
        assertEquals(d.getDriverLocation(), Locations.LOC_HILLMAN);
        
        // Assert that a failing condition is false via method stub
        DriverStubNextIsSennott stub = new DriverStubNextIsSennott();
        assertFalse(stub.nextDestination(0) == Locations.LOC_UNION);
        
        // Confirm next destination is at the correct location via the right street
        assertEquals(d.nextDestination(1), Locations.LOC_UNION);
        assertEquals("Phil St.", Locations.HILLMAN_STREET_TRAVERSAL[1]);
        
        // Ensure street-backwards compatibility 
        assertEquals(d.getStreetUsed(), Locations.UNION_STREET_TRAVERSAL[1]);
    }
    
    
    // -- END TEST STREETS -- //
    
    
    
    
    // -- TEST AVENUES -- //
    
    // This tests whether Presby and Union connect together by the correct avenue.
    // Also tests that the avenues are ACTUALLY what they're supposed to be.
    // Presby > Union via Fourth Ave.
    @Test
    public void testPresbyUnion() {
        // Create new Driver
        Driver d = new Driver(0, testDoubleRNG());
        
        // Set Driver to start location of test, and confirm its being at the start location
        d.setDriverLocation(Locations.LOC_PRESBY);
        assertEquals(d.getDriverLocation(), Locations.LOC_PRESBY);
        
        
        // Assert that a failing condition is false via method stub
        DriverStubNextIsSennott stub = new DriverStubNextIsSennott();
        assertFalse(stub.nextDestination(0) == Locations.LOC_UNION);
        
        // Confirm next destination is at the correct location via the right street
        assertEquals(d.nextDestination(0), Locations.LOC_UNION);
        assertEquals("Fourth Ave.", d.getStreetUsed());
    }
    
    // This tests whether Union and Outside City connect together by the correct avenue.
    // Also tests that the avenues are ACTUALLY what they're supposed to be.
    // Union > Outside via Fourth Ave.
    @Test
    public void testUnionOutsideCity() {
        // Create new Driver
        Driver d = new Driver(0, testDoubleRNG());
        
        // Set Driver to start location of test, and confirm its being at the start location
        d.setDriverLocation(Locations.LOC_UNION);
        assertEquals(d.getDriverLocation(), Locations.LOC_UNION);
        
        // Assert that a failing condition is false via method stub
        DriverStubNextIsUnion stub = new DriverStubNextIsUnion();
        assertFalse(stub.nextDestination(0) == Locations.LOC_OUTSIDE_CITY);
        
        // Confirm next destination is at the correct location via the right street
        assertEquals(d.nextDestination(0), Locations.LOC_OUTSIDE_CITY);
        assertEquals("Fourth Ave.", d.getStreetUsed());
    }
    
    // This tests whether Hillman and Sennott connect together by the correct avenue.
    // Also tests that the avenues are ACTUALLY what they're supposed to be.
    // Hillman > Sennott via Fifth Ave.
    @Test
    public void testHillmanSennott() {
        // Create new Driver
        Driver d = new Driver(0, testDoubleRNG());
        
        // Set Driver to start location of test, and confirm its being at the start location
        d.setDriverLocation(Locations.LOC_HILLMAN);
        assertEquals(d.getDriverLocation(), Locations.LOC_HILLMAN);
        
        // Assert that a failing condition is false via method stub
        DriverStubNextIsUnion stub = new DriverStubNextIsUnion();
        assertFalse(stub.nextDestination(0) == Locations.LOC_SENNOTT);
        
        // Confirm next destination is at the correct location via the right street
        assertEquals(d.nextDestination(0), Locations.LOC_SENNOTT);
        assertEquals("Fifth Ave.", d.getStreetUsed());
    }
    
    // This tests whether Sennott and Outside City connect together by the correct avenue. 
    // Also tests that the avenues are ACTUALLY what they're supposed to be.
    // Sennott > Outside City via Fifth Ave.
    @Test
    public void testSennottOutsideCity() {
        // Create new Driver
        Driver d = new Driver(0, testDoubleRNG());
        
        // Set Driver to start location of test, and confirm its being at the start location
        d.setDriverLocation(Locations.LOC_SENNOTT);
        assertEquals(d.getDriverLocation(), Locations.LOC_SENNOTT);
        
        // Assert that a failing condition is false via method stub
        DriverStubNextIsUnion stub = new DriverStubNextIsUnion();
        assertFalse(stub.nextDestination(0) == Locations.LOC_OUTSIDE_CITY);
        
        // Confirm next destination is at the correct location via the right street
        assertEquals(d.nextDestination(0), Locations.LOC_OUTSIDE_CITY);
        assertEquals("Fifth Ave.", d.getStreetUsed());
    }
    
    
    // -- END TEST AVENUES -- //
    
    
    // Method Stubs are listed below
    // It was hard to find places to 
    // fit these, given I programmed
    // about halfway through making
    // tests. Still, they do stub methods
    // and are used in multiple unit tests.
    
    
    private class DriverStub0 extends Driver {
        public DriverStub0() {
            super(0, testDoubleRNG());
        }
        @Override
        public int getSennottVisits() {
            return 0;
        }
    }
    
    private class DriverStub2 extends Driver {
        public DriverStub2() {
            super(0, testDoubleRNG());
        }
        @Override
        public int getSennottVisits() {
            return 2;
        }
    }
    
    private class DriverStub3 extends Driver {
        public DriverStub3() {
            super(0, testDoubleRNG());
        }
        @Override
        public int getSennottVisits() {
            return 3;
        }
    }
    
    private class DriverStub4 extends Driver {
        public DriverStub4() {
            super(0, testDoubleRNG());
        }
        @Override
        public int getSennottVisits() {
            return 4;
        }
    }
    
    private class DriverStubNextIsSennott extends Driver {
        public DriverStubNextIsSennott() {
            super(0, testDoubleRNG());
        }
        @Override
        public int nextDestination(int throwaway) {
            return Locations.LOC_SENNOTT;
        }
    }
    private class DriverStubNextIsUnion extends Driver {
        public DriverStubNextIsUnion() {
            super(0, testDoubleRNG());
        }
        @Override
        public int nextDestination(int throwaway) {
            return Locations.LOC_UNION;
        }
    }
    
}