// Written by Owen Keating, keati090

1. Name: Owen Keating

2. X500: keati090

3. I did not work with a partner for this assignment.

4. The main function in the program is located in the Game.java file. In order
to compile the program, the user should have the src directory open in command
prompt and type the command 'javac Game.java' - after the code compiles, the
user can type the command 'java Game' any amount of times that they want to run
the program. Any time the user wants to rerun the code, they must either terminate
the current program or finish playing out the remainder of the game. When the
program is run, the command prompt will output a message asking the user for their
desired difficulty level and about if they would like to enter the debugging mode.
After these questions are answered, the player will be taken into a cycle of turns
until they are able to sink all the boats on the board. In order to sink the boats,
the user can utilize different commands including fire, missile, drone, and
submarine. I did my best to eliminate case-sensitive issues when a player is using
the command prompt. In addition, I did my best to remove issues with entering invalid
information - this includes accidentally bumping enter or inputting a letter instead
of an integer. In these situations, the command prompt should output an 'Invalid'
message and allow the user to retype a correct command. Once the player is able to
sink all the boats, the screen will display the total number of turns in the game.

5. The program assumes the player can navigate through the command prompt over the
course of several game turns. Each turn, a player view of the game grid will be
displayed to the screen. Rows are numbered down the right-hand side of the grid and
column numbers can be found along the bottom of the grid. During turns, the player
may be asked to enter a set of coordinates to fire at. In these circumstances, the
player should input their desired coordinates in one line - an input should consist
of two integers and a comma between them. The formatting for these inputs will be
displayed on the screen regularly. For the other commands, the player can just input
the first letter of their desired command and press enter. However, if an entire word
is entered, no errors will occur because the code is only checking the first letter.
If the user chooses to use the debugging feature, they should know that row and column
numbers are not displayed on the edges of the grid. This is to help prevent confusion
between the row/column numbers and the length digits that represent boat targets.
An example of a length digit would be a '4' displayed on the debugging view. The '4'
represents a cell target on a boat of length 4 that has not been hit yet.

6. There are no known bugs that I am aware of in the program. I also did not consult
any outside sources for this assignment.

7. I certify that the information contained in this README file is complete and
accurate. I have both read and followed the course policies in the 'Academic Integrity -
Course Policy' section of the course syllabus.

8. Academic Integrity Signature: Owen Keating