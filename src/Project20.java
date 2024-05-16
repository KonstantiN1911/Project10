
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Project20 {
    public static void main(String[] args) {

        try (BufferedReader reader =  new BufferedReader(new FileReader("data.txt"))) {
            Stream<String> segmentStreams = reader.lines();

            double maxLength = segmentStreams.mapToDouble(Project20::parseLineToLength)
                   .max()
                   .orElse(0);
            System.out.println("Длинна самого длинного отрезка " + maxLength);
        } catch (IOException e){
           e.printStackTrace();
        }
    }
    private static double parseLineToLength(String segment){
        String[] points = segment.split("\\)|\\(|,|:");
        double x1 = Double.parseDouble(points[2]);
        double y1 = Double.parseDouble(points[4]);
        double x2 = Double.parseDouble(points[7]);
        double y2 = Double.parseDouble(points[9]);
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}