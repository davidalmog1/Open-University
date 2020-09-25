
#include "tools.h"

int main(int argc, char *argv[]){

//variables 
    adjmat matrix;
    int u,v; //index 

// input     
    input_matrix(matrix);

// print
    print_matrix(matrix);

// find path
      printf("\n Pleas  enter two index's (u and than v):\n");
          scanf("%d\n%d",&u,&v);
          putchar('\n');

//find path
    if(path(matrix,u,v) == TRUE)
        printf("\nPath result u:%d\tv:%d = True\n",u,v);
    else
        printf("\nPath result u:%d\tv:%d = False\n",u,v);


    printf("\n -- END --\n");
return 0;
};