public class Locations {
    
    
    // Constants for identifying locations
    public static final int LOC_PRESBY        = 0;
    public static final int LOC_UNION         = 1;
    public static final int LOC_HILLMAN       = 2;
    public static final int LOC_SENNOTT       = 3;
    public static final int LOC_OUTSIDE_CITY     = 4;
    
    // Constant String of locations
    public static String[] LOCATION_NAMES = {
        "Presby",       // 0
        "Union",        // 1
        "Hillman",      // 2
        "Sennott",      // 3
        "Outside City"  // 4
    };
    
    
    // Possible locations you can go from a given location and via what street
    
    public static int[] PRESBY_POST_LOC = { LOC_UNION, LOC_SENNOTT };
    public static String[] PRESBY_STREET_TRAVERSAL = { "Fourth Ave.", "Bill St." };
    
    public static int[] UNION_POST_LOC = { LOC_OUTSIDE_CITY, LOC_HILLMAN };
    public static String[] UNION_STREET_TRAVERSAL = { "Fourth Ave.", "Phil St." };
    
    public static int[] HILLMAN_POST_LOC = { LOC_SENNOTT, LOC_UNION };
    public static String[] HILLMAN_STREET_TRAVERSAL = { "Fifth Ave.", "Phil St." };
    
    public static int[] SENNOTT_POST_LOC = { LOC_OUTSIDE_CITY, LOC_PRESBY };
    public static String[] SENNOTT_STREET_TRAVERSAL = { "Fifth Ave.", "Bill St." };
    
}