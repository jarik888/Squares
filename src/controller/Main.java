package controller;

import model.Square;
import service.TaskSolverService;
import utils.SquaresParser;

public class Main {

    private static SquaresParser sp = new SquaresParser();
    private static TaskSolverService tss = new TaskSolverService();

    public static void main(String[] args) {

        if (args.length < 1 || args[0].equals("-h") || args[0].equals("--help")) {
            System.out.println("Fist programm argument(\"args[0]\") must be path to input file");
        } else {
            try {
                Square[] input = sp.parserInputFromFile(args[0]);
                Square[][] solution = tss.findSolution(input);
                System.out.println(sp.saveResult(input, solution));
            } catch (Exception e) {
                System.err.println("Programm error: \n" + e );
            }
        }

    }

}
