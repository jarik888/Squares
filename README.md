# Squares
<br>
Creating an Executable jar File: <br>
1) cd Squares/src <br>
2) javac controller/Main.java model/Square.java service/TaskSolverService.java utils/SquaresParser.java <br>
3) jar cvfe Squares.jar controller/Main controller/Main.class model/Square.class service/TaskSolverService.class utils/SquaresParser.class <br>
<br>
Run programm: <br>
1) cd Squares <br>
2) java -jar Squares.jar test.txt
