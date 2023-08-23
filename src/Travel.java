import java.io.*;
import java.util.ArrayList;
/* This Class is responsible for storing the all cities in a specific travel file and
  also responsible for calculating the possible distance for a single visit */
public class Travel {
    private ArrayList<City> travel;    // Default constructor for travel class which initiates empty array for cities
    public Travel() {
        this.travel = new ArrayList<>();
    }
    public Travel(ArrayList<City> copyTravel) {
        //For-each loop to iterate over all elements of the input array and add them to current travel list
        travel = new ArrayList<>();
        travel.addAll(copyTravel);
    }
    //  Constructor for travel class which will read from provided files and load all the data from it 
    public Travel(String fileName){ //fileName is the name of file from which data is to be loaded
        this(); // initialise default constructor
        this.populateCities(fileName); //load all data from file
    }
    //  function for reading file line by line and add city data in an linked list
    public void populateCities(String fileName){
        FileReader fileReader = null;
        try {
            File file=new File(fileName);    //creates a new file instance
            fileReader=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fileReader);  //creates a buffering character input stream
            String cityData = "";
       while((cityData=br.readLine())!=null)   {
            City city = new City(cityData);// call the city class constructor to parse read data and return city object            
                this.travel.add(city); // add returned object to list
            }
          fileReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error caused, File not found.");
        } catch (IOException ex) {
            System.out.println("Error caused, File not found.");
        }
    }
    public double getDistance() {  // function for calculating the distance for current travel configuration and return the total distance for current travel
        double distance = 0.0;
        for (int index = 0; index < travel.size(); index++) { //select the first index as starting point of travel and then on every iteration move one step ahead
            City starting = getCity(index);
            City destination; 
            if (index + 1 < travel.size()) {   //check if it is last index or not
                destination = getCity(index + 1);  // if not use next city as as destination
            } else {
                destination = getCity(0);  //otherwise use start as the end path
            }
            distance += starting.distanceToCity(destination);  // adding up the resulting distance
        }
        return distance;
    }
    public ArrayList<City> getCities(){
        return this.travel;
    }
    public int getCitiesCount(){
        return this.travel.size();
    }
    public City getCity(int index){
        return this.travel.get(index);   // function from getting city from travel list, index of city to be returned and then finally to return the city class object
    }
  // Function for printing current travel plan and return a string version of current travel
    public String toString() {
        return "Cities Travel sequence:\n" + travel;
    }
}