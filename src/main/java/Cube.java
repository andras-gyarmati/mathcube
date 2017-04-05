import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by brianelete on 2017. 04. 05
 */
public class Cube {
    private int[][][] cube;
    private Set<Integer> sideSizes;

    public Cube(int[][][] cube) {
        this.sideSizes = new HashSet<>();
        this.cube = cube;
    }

    public void buildCube() {
        //int peakCount = 0;
        for (int i = 0; i < cube[0].length; i++) {
            for (int j = 0; j < cube[1].length; j++) {
                for (int k = 0; k < cube[2].length; k++) {
                    if ((0 == i || 2 == i) && (0 == j || 2 == j) && (0 == k || 2 == k)) {
                        //System.out.print("peak" + peakCount + ": " + cube[i][j][k] + "\n");
                        //peakCount++;
                        /* ha az egyik mar igaz akkor az eleg sot csak annyi kell szoval megnezzuk hogy csak az legyen
                        * egy a p -> p meg p==true volt csak bool es egyszerusitettem */
                    } else if (1 == Stream.of((1 == i), (1 == j), (1 == k)).filter(p -> p).count()) {
                        cube[i][j][k] = cube[i == 1 ? i + 1 : i][j == 1 ? j + 1 : j][k == 1 ? k + 1 : k] + cube[i == 1 ? i - 1 : i][j == 1 ? j - 1 : j][k == 1 ? k - 1 : k];
                        sideSizes.add(cube[i][j][k]);
                        //System.out.println(cube[i][j][k]);
                    }
                }
                //System.out.print("");
            }
            //System.out.print("");
        }
        //System.out.println("Number of sides with different sizes: " + sideSizes.size());
    }

    public boolean checkAllSidesDifferent() {
        buildCube();
        return 12 == sideSizes.size();
    }
}
