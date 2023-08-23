// This Class is for storing individual city data and is also responsible for calculating Euclidean distance between two cities
public class City {
    private int cityId;
    private int x;
    private int y;
public City(int cityId, int x, int y) {
        this.cityId = cityId; // city id of city or the node
        this.x = x; // x-axis coordinate for city
        this.y = y; //  y-axis coordinate for city
    }
 public City(String cityData){     //function for the city class to parse through string information into city data in case of invalid data it returns default values
        cityData = cityData.trim();
        String [] data = cityData.split("\\s+");
        try{
            Integer cityId = Integer.parseInt(data[0]);
            Integer cityX  = Integer.parseInt(data[1]);
            Integer cityY  = Integer.parseInt(data[2]);
            this.cityId = cityId;
            this.x = cityX;
            this.y = cityY;
        }catch (NumberFormatException ex){
       }
   }
    public double distanceToCity(City city) {     // this function calculates Euclidean distance between two cities 
        int x = Math.abs(getX() - city.getX());
        int y = Math.abs(getY() - city.getY());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
   public int getCityId() {   //access for city id
        return cityId;
    }
    public void setCityId(int cityId) { //  cityId city id to be saved
        this.cityId = cityId;
    }
    public int getX() {       
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}