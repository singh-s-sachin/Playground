import java.sql.Timestamp;
import java.time.Instant;

public class Run {
    public static void main(String args[]) throws Exception {
        Timestamp timestamp = Timestamp.from(Instant.now());
        SolutionImpl solutionTemp = new SolutionImpl();
        solutionTemp.main(args);
        System.out.println("Time elapsed : " + (Timestamp.from(Instant.now()).getTime() - timestamp.getTime()) + "ms");
    }
}
