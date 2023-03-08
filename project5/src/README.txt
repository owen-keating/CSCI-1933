//  Written by Owen Keating, keati090

1. Name: Owen Keating

2. X500: keati090

3. I did not work with a partner for this assignment.

4. There are two total files that have to do with this submission, which includes
the README document as well as the HashTable.java class. As far as running the program,
the user should have the supplemental text files("gettysburg.txt" and "keywords.txt")
saved to the same location as the source code. The user should also have the NGen.java
file from Canvas downloaded to the folder as well. From there the user must run the code
through the terminal or command prompt rather than the IntelliJ studio. While the user
may be able to figure out how to configure the file locations so that IntelliJ can
recognize the text documents, I was not able to get this to work and had to resort to
outputting my code using the command prompt. Once the source files are in the correct
location, the user should navigate to the correct folder that holds the material and
enter the following commands. "javac HashTable.java" will compile the code. "java HashTable"
will run the program and display two hash tables and the corresponding collision statistics.

5. The program assumes that the user has access to the NGen.java class that is
listed on the Canvas page. This is important because the hash tables in the program
use chained indices. At each index, there may be multiple data values that need to
be stored. The NGen class is helpful because I was able to implement linked lists
at these indices. The user may also want to experiment with files other than the
two example files that I previously referred to. In order to do this, the user could
create a new HashTable object, call the read function, and then call the display
function. All of this would be implemented in the main function. In addition, if the
user wished to test the effectiveness of the other hash functions, they could navigate
to the lines 67-68 (if-else statement that checks the type variable) and change the
hash() call to a different function. For example, hash2() is called in the general
solution, but changing line 67 to "hash = hash1(item)" would test using the first
hash function and display the corresponding statistics.

6. There is no known bugs that I am aware of in the program. There is one thing that I
would like to make the user aware of however when they are compiling the program.
Whenever the source code compiles, the following note appears in the terminal:
HashTable.java uses unchecked or unsafe operations. I have consulted the discord, and
it appears that other students had this same message appearing on their screens. The
TA's said that this message does not have anything to do with the program's ability to
run, and for the purposes of this project it can be ignored. Finally, I did not consult
any outside sources for this assignment.

7. I certify that the information contained in this README file is complete and
accurate. I have both read and followed the course policies in the 'Academic Integrity -
Course Policy' section of the course syllabus.

8. Academic Integrity Signature: Owen Keating