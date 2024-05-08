
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;


public class Stream {
    public static void main(String[] args) {

        try {

           Optional<Double> max = Optional.of(new BufferedReader(new FileReader("data.txt")).lines()
                   .mapToDouble(Stream::parseLineToLength)
                   .max().orElse(0.0));
            System.out.println(max.orElseGet(() -> 0.0));
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }


    private static double parseLineToLength(String line){
        String[] points = line.split("data.txt");
        double x1 = Double.parseDouble(points[2]);
        double y1 = Double.parseDouble(points[4]);
        double x2 = Double.parseDouble(points[7]);
        double y2 = Double.parseDouble(points[9]);
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}
