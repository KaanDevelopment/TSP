public class Main {
public static void computePath(String fileName){
    	bruteForceFindBestRoute bf = new bruteForceFindBestRoute(fileName);	// function that calls the bruteForceFindBestRoute file so files can be input from the main method
    	bf.search();
    }
    public static void main(String[] args) {
        computePath("test1tsp.txt"); // train problem 1
        computePath("test2atsp.txt"); // train problem 2
        computePath("test3atsp.txt");  // train problem 3
        computePath("test1-20.txt");  // test 1
        computePath("test2-20.txt");  // test 2
        computePath("test3-20.txt");  // test 3
        computePath("test4-20.txt");  // test 4
    }
}