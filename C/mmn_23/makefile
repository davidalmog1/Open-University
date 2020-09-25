myprog: func.o main.o
	gcc -g func.o main.o -o myprog
functions.o: funct.c util.h
	gcc -c func.c -o func.o
main.o: main.c util.h
	gcc -c main.c -o main.o
