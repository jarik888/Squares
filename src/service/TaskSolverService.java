package service;

import model.Square;

import java.util.ArrayList;

// Bruteforcer
public class TaskSolverService {

    private Square[] squares; // squares input array
    private ArrayList<int[]> solutions = new ArrayList<>(); // squares combinations

    public Square[][] findSolution(Square[] squares) {
        this.squares = squares;

        perm(12); // 12! = 479001600

        Square[][] result = new Square[solutions.size()][12];

        // covert from combinations to squares orders
        for (int i = 0; i < solutions.size(); i++) {
            for (int j = 0; j < solutions.get(i).length; j++) {
                result[i][j] = squares[solutions.get(i)[j]];
            }
        }

        return result;
    }

    //----------http://introcs.cs.princeton.edu/java/23recursion/PermutationsLex.java.html---------
    private void perm(int N) {
        // initialize permutation
        int[] a  = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }

        validatePermutation(a);
        while (hasNext(a)) {
            validatePermutation(a);
        }
    }

    private boolean hasNext(int[] a) {
        int N = a.length;

        // find rightmost element a[k] that is smaller than element to its right
        int k;
        for (k = N-2; k >= 0; k--) {
            if (a[k] < a[k+1]) {
                break;
            }
        }
        if (k == -1) {
            return false;
        }

        // find rightmost element a[j] that is larger than a[k]
        int j = N-1;
        while (a[k] > a[j]) {
            j--;
        }
        swap(a, j, k);

        for (int r = N-1, s = k+1; r > s; r--, s++) {
            swap(a, r, s);
        }
        return true;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //---------------------------------------------------------------------------------------------

    private void validatePermutation(int[] a) {

        if (checkGreenCorners(a) && checkYellowCorners(a)) {
            solutions.add(a.clone());
        }
    }

    private boolean checkGreenCorners(int[] perm) {
        // top
        if (squares[perm[0]].getBottomRight() + squares[perm[1]].getBottomLeft()
            + squares[perm[3]].getTopRight() + squares[perm[4]].getTopLeft() != 10) {
            return false;
        }
        // left
        if (squares[perm[2]].getBottomRight() + squares[perm[3]].getBottomLeft()
            + squares[perm[6]].getTopRight() + squares[perm[7]].getTopLeft() != 10) {
            return false;
        }
        // middle
        if (squares[perm[3]].getBottomRight() + squares[perm[4]].getBottomLeft()
            + squares[perm[7]].getTopRight() + squares[perm[8]].getTopLeft() != 10) {
            return false;
        }
        // right
        if (squares[perm[4]].getBottomRight() + squares[perm[5]].getBottomLeft()
            + squares[perm[8]].getTopRight() + squares[perm[9]].getTopLeft() != 10) {
            return false;
        }
        // bottom
        if (squares[perm[7]].getBottomRight() + squares[perm[8]].getBottomLeft()
            + squares[perm[10]].getTopRight() + squares[perm[11]].getTopLeft() != 10) {
            return false;
        }

        return true;
    }

    private boolean checkYellowCorners(int[] perm) {
        // top
        if (squares[perm[0]].getTopRight() + squares[perm[1]].getTopLeft() > 10) {
            return false;
        }
        // top-left
        if (squares[perm[0]].getBottomLeft() + squares[perm[2]].getTopRight() + squares[perm[3]].getTopLeft() > 10) {
            return false;
        }
        // top-right
        if (squares[perm[1]].getBottomRight() + squares[perm[4]].getTopRight() + squares[perm[5]].getTopLeft() > 10) {
            return false;
        }
        // left
        if (squares[perm[2]].getBottomLeft() + squares[perm[6]].getTopLeft() > 10) {
            return false;
        }
        // right
        if (squares[perm[5]].getBottomRight() + squares[perm[9]].getTopRight() > 10) {
            return false;
        }
        // bottom-left
        if (squares[perm[6]].getBottomRight() + squares[perm[7]].getBottomLeft() + squares[perm[10]].getTopLeft() > 10) {
            return false;
        }
        // bottom-right
        if (squares[perm[8]].getBottomRight() + squares[perm[9]].getBottomLeft() + squares[perm[11]].getTopRight() > 10) {
            return false;
        }
        // bottom
        if (squares[perm[10]].getBottomRight() + squares[perm[11]].getBottomLeft() > 10) {
            return false;
        }

        return true;
    }

}
