#include <stdio.h>
#include <string.h>

#define MAX 100

/* function prototype */
int match(char[],char[]);


int main(void){
/*variables*/
    char text[MAX];
    int lengthText = 0; 
    int bestLocation; /*the best match */
/*inupt from the user*/
    printf("Hello :)\nPlease Enter string:\n");
    fgets(text, sizeof(text), stdin);
/* setup pattern[] array to be <= text[](length) */
    for(lengthText=0;text[lengthText] !='\0';lengthText++);
    char pattern[lengthText]; 
    printf("\nPlease enter a pattern:\n");
    fgets(pattern, sizeof(pattern), stdin); /* insert the input to pattern */ 
/* printing the input */
    printf("\nText: %s\nPattern: %s\n",text,pattern);
/*call the function match */
    bestLocation = match(text,pattern);
/*Printing the result from match  function*/
    printf("\nThe best position is: %d",bestLocation);
    printf("\n --END-- \n");
    return 0;
}

int match(char text[],char pattern[]){
/*variables */    
   int bestMatch = 0;
   int i,x;
   int index =0;
   int tempMax=0; 
   int lengthText , lengthPattern;
/*length of pattern and text */
    lengthText = strlen(text);
    lengthPattern = strlen(pattern);

/* finding the best match */
    for(i=0 ; i <(lengthText - lengthPattern) ; i++){
        for(x =0 ;x <lengthPattern ;x++){
            if(pattern[x] == text[x+i])
                tempMax++;
        }
        if(tempMax > bestMatch){
        bestMatch = tempMax;
        tempMax=0;
        index = i;
        }  
    }
    return index;
}
