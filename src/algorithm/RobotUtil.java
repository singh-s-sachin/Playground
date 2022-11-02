package algorithm;

public class RobotUtil {

    public static int[] move(String path) {
        int x = 0, y = 0;
        for (char movement : path.toCharArray()) {
            switch (movement) {
                case 'U':
                case 'u': {
                    x--;
                    break;
                }
                case 'D':
                case 'd': {
                    x++;
                    break;
                }
                case 'R':
                case 'r': {
                    y++;
                    break;
                }
                case 'L':
                case 'l': {
                    y--;
                    break;
                }
                default: {
                    System.out.println("Unidentified move");
                }
            }
        }
        return new int[]{x, y};
    }
}
