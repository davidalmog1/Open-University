myprog: functions.o main.o
		gcc -g functions.o main.o -o myprog
functions.o: functions.c tools.h
		gcc -c functions.c -o functions.o
main.o: main.c tools.h
		gcc -c main.c -o main.o