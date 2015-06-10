# Squares

Creating an Executable jar File:
1) cd Squares/src
2) javac controller/Main.java model/Square.java service/TaskSolverService.java utils/SquaresParser.java
3) jar cvfe Squares.jar controller/Main controller/Main.class model/Square.class service/TaskSolverService.class utils/SquaresParser.class

Run programm:
1) cd Squares
2) java -jar Squares.jar test.txt
