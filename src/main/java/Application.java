import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.dakusui.combinatoradix.Permutator;

/**
 * Created by brianelete on 2017. 04. 04
 */
public class Application {

    private List<Integer> numbers;
    private int combinationCount;
    private int maxCombinationCount;

    public Application() {
        numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        combinationCount = 0;
        maxCombinationCount = factorial(numbers.size());
    }

    private List<Integer> nextCombination() {
        Permutator permutator = new Permutator<>(numbers, numbers.size());
        if (combinationCount < maxCombinationCount) {
            //System.out.println(permutator.get(combinationCount));
            return permutator.get(combinationCount++);
        }
        System.out.println("Out of combinations!");
        return null;
    }

    private void testCubes() {
        boolean solutionFound = false;
        List<Integer> combination;
        do {
            combination = nextCombination();
            if (null != combination) solutionFound = testCube(combination);
        } while (null != combination && !solutionFound);
        if (!solutionFound) System.out.println("No solution found!");
    }


    private boolean testCube(List<Integer> combination) {
        Cube cube = new Cube(makeCubeParam(combination));
        if (cube.checkAllSidesDifferent()) {
            cube.buildCube();
            return true;
        }
        return false;
    }

    private int[][][] makeCubeParam(List<Integer> combinations) {
        return new int[][][]{{{combinations.get(0), 22, combinations.get(1)}, {22, 0, 22}, {combinations.get(2), 0, combinations.get(3)}},
                {{22, 0, 22}, {0, 0, 0}, {22, 0, 22}},
                {{combinations.get(4), 22, combinations.get(5)}, {22, 0, 22}, {combinations.get(6), 22, combinations.get(7)}}};
    }

    private int factorial(int number) {
        int factorial = 1;
        while (number >= 1) {
            factorial *= number;
            number--;
        }
        return factorial;
    }

    public void execute() {
        testCubes();
    }
}
