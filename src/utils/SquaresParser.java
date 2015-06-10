package utils;

import model.Square;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SquaresParser {

    public Square[] parserInputFromFile(String fileLocation) {

        int squares[][] = readFromTXT(fileLocation);

        Square[] squareObjects = new Square[12];

        for (int i = 0; i < squares.length; i++) {
            squareObjects[i] = new Square(squares[i][0], squares[i][1], squares[i][2], squares[i][3]);
        }

        return squareObjects;
    }

    public String saveResult(Square[] input, Square[][] result) {

        String output = "";

        SimpleDateFormat dataFormat = new SimpleDateFormat("ddMMyy-hhmmss.SSS");
        String currentTimestamp = dataFormat.format(new Date());

        try {
            PrintWriter writer = new PrintWriter( "squares-result-" + currentTimestamp + ".txt", "UTF-8");
            writer.println("---Input--");

            for (Square s : input) {
                writer.println(s.toString());
            }

            writer.println("\n---Output---");

            if (result.length < 1) {
                output = "No result";
                writer.println("No result");
            }

            for (Square[] sArray : result) {
                for(Square s : sArray) {
                    output += s.toString() + "\n";
                    writer.println(s.toString());
                }
                output += "\n";
                writer.println();
            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return output;

    }

    private int[][] readFromTXT(String fileLocation) {

        int squares[][] = new int[12][4]; //12 squares with 4 corners
        int squareIndex = 0;

        try {
            InputStream input = new FileInputStream(new File(fileLocation));
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String line;

            while ((line = br.readLine()) != null) {
                String corners[] = line.split(" ");
                for (int i = 0; i < corners.length; i++) {
                    squares[squareIndex][i] = Integer.parseInt(corners[i]);
                }
                squareIndex++;
            }

        } catch (IOException e) {
            System.err.println("Txt file reading error!");
            e.printStackTrace();
            System.exit(1);
        } catch (NumberFormatException ne) {
            System.err.println("Wrong input file format!");
            System.exit(2);
        }

        return squares;
    }

}
