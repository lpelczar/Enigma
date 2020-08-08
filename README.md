# Enigma

## Description

Diagram of project’s main functionality -- reading text from standard input, processing it (enciphering/deciphering) and printing the result to standard output:

![c1](https://raw.github.com/lpelczar/Enigma/master/docs/Enigma_UML.png)

This requires implementing:

- Enigma Services - implementations of chosen ciphers (http://practicalcryptography.com/ciphers/ or any other)
- Application itself: skeleton responsible for initializing all the other components, parsing command line arguments etc.
- Terminal Translator - a module responsible for the main functionality: reading text from standard input, processing it (enciphering/deciphering) and printing to standard output
- Service Repository to provide our application and its modules with implementations of EnigmaService

The program’s used should be as shown below:
- > java engima.Application  -e | -d (enciper/decipher) CIPHER [KEY]
- To start it in encrypting mode use -e option; -d to start in decrypting mode
- CIPHER says what kind of cipher we want to use and KEY is the optional KEY to be used with the CIPHER (if selected cipher requires a key)
- The program should take every line (a string of characters) from standard input and process it according to the options used. The result should be printed to the standard output.
- The user should be able to list all available (implemented) ciphers using -l option
- > java enigma.Application -l

## More info

Project made for [Codecool](https://codecool.com/) programming course.
