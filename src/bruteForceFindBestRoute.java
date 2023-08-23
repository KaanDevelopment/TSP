import java.util.ArrayList;
/*  This Class calculates the shortest path for the given  travel plan. It uses Depth First Search (DFS) algorithm for finding the shortest path
  	and also uses the first city for the initial starting point for calculating shortest distance path. */
public class bruteForceFindBestRoute {
    private Travel travelPath;
    private ArrayList<City> bestPath;
    private double shortestDistance;
   													
    public bruteForceFindBestRoute(String filesName){ // filesName allows the user to pass in a file name.
    	// start with shortest Distance  as the maximum possible number
        shortestDistance = Double.MAX_VALUE;
        //then we add all cities in travel path
        travelPath = new Travel(filesName);
        bestPath = new ArrayList<>();
    }
 public void search() { // Overloaded version of the actual search function to provide access outside of the class
    	 City city = travelPath.getCities().remove(0); //Use the first city as a starting point 
         ArrayList<City> route = new ArrayList<>(); // create an array for storing the best possible path
         route.add(city); // add a starting point to the best possible path
         long time = System.nanoTime(); //calculating the run time of the algorithm
    	 search( route, travelPath.getCities());  //compute the shortest path for given route
    	 time = System.nanoTime() - time;
         System.out.println("Shortest Possible Path:"); // next few lines print out shortest possible path using a for each loop
         bestPath.forEach(cityData->{
          System.out.print(cityData.getCityId()+" -> ");
        });
         System.out.println(bestPath.get(0).getCityId());
         System.out.println("length of distance for optimal path = "+shortestDistance);
         System.out.println("\nTime elapsed for search: "+time +" ns.");
         System.out.println();
   }  
  /* Recursive implementation of DFS for traversing the path
      an array list is used to store current best path
      first city in travel is its initial member
      citiesNotInRoute is the list of cities which are not yet included in the route
   */
    @SuppressWarnings("unchecked")
	public void search(ArrayList<City> r, ArrayList<City> citiesNotInRoute)
    {
    	// if statement to verify if all cities have been visited or not
    if(!citiesNotInRoute.isEmpty()) {
        	// iterate over all remaining cities and add in the route and update data using recursive call
         for(int i = 0; i<citiesNotInRoute.size(); i++)
            {   // get next possible city for new path
                City justRemoved =
                        (City) citiesNotInRoute.remove(0);
                // add it to new route
                ArrayList<City> newRoute =
                        (ArrayList<City>) r.clone();
                newRoute.add(justRemoved);
                // call search to repeat the process until
                // all cities have been visited
                search(newRoute, citiesNotInRoute);
                citiesNotInRoute.add(justRemoved);
            }
        }
        else //Returning condition of recursion
        {
            if(isBestRoute(r)) // check if current route is best route or not
                bestPath = r; // if is then update new best path
        }

    }
   
 /*  function for calculating total distance for the current route
     the Array list of current route returns true if current distance is less than previous one */
    private boolean isBestRoute(ArrayList<City> r) {
        double distance = new Travel(r).getDistance();
        if(distance  <= shortestDistance){
        	// if the current distance is less than minimum then save it and return true
            shortestDistance = distance;
            return  true;
        }
        return false;
    }
}
