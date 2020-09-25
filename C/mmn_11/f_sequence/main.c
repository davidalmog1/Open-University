#include <stdio.h>
#define MAX_Length 100

/* function prototype */
void f_sequence(char[]);

int main(void){
    enum key { nl='\n',t='\t',e='\0',s=' '};
    enum key newline =nl;
    enum key tab = t;
    enum key end = e;
    enum key space = s;
    /* variables */
    char txt[100];
    int c;
    int i=0;
    printf("\nHello :)\nPlease entering a word:\n");
        while((c = getchar()) != EOF){
            if(c == tab || c ==space || c == end || c == newline)
                break;
            txt[i] = c;
            i++;
        }
            txt[i] = '\0'; /* adding end signed */
        f_sequence(txt); /* call the function f_sequence */
    printf("\nEnd of the program.\nthank you for your participation.\n\n"); /* finishing message */
return 0;
}

/* function */
void f_sequence(char txt []){ 
    printf("\nthe input is: %s\n",txt); /* print the input */
    /* variables */
    int up=0,down=0,equal=0;
    int i=0;
    int x=1; 
        while(txt[x] !='\0'){
            if(txt[i] > txt[x])
                ++down;
            else if(txt[i] < txt[x])
                ++up;
            else{
                ++equal;
                ++up;
            } 
            ++x;
            ++i;
        }
        if((up != 0) && (down !=0))
            printf("\nthe txt is: disorderly\n");
        else if(up >0 ){
            if((up > 0) && (equal >0) )
                printf("\nthe txt is: up\n");
            else
                printf("\nthe txt is: really up\n");
        }
        else{
            if((down > 0) && (equal >0) )
                printf("\nthe txt is: down\n");
            else
                printf("\nthe txt is: really down\n");
        }
}
