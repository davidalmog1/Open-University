
/*
 Here are all the function that the main calls:
 1. Path: Find if there is a path form u to v..
 2. Input Matrix: Gets the values ​​(0,1) from the user.
 3. Print Matrices: Print the user matrix.
 */

#include "tools.h"

 kit path(adjmat matrix,int u ,int v){
//variables
    int i = 0;
    int j = v;
//check if the parameters are valid
    if( u >= N || u < 0 || v >= N || v <0)
        return FALSE;
    
    if(matrix[u][v] == 1){
        return TRUE;
    }

        while( i < N){
            if(matrix[i][j] ==1){
                if( i == u)
                    return TRUE;
                else
                {
                    j=i;
                    i=0;
                }
                
            }
            i++;
        }  
        return FALSE;
 };

void print_matrix(adjmat matrix){
//variables
    int i,j;

printf("\n");
     for(i=0;i<N;i++){
        for(j=0;j<N;j++){
            printf(" %d",matrix[i][j]);
        };
        printf("\n");
    };
};

void input_matrix(adjmat matrix){
   //variables
    int i,j;
printf("\nPlease enter the matrix values one value in each line (0 or 1):\n");
    for(i=0;i < N;i++){
        for(j=0;j < N;j++){
            scanf("%d",&matrix[i][j]);
        };
        putchar('\n');
    };
    getchar();
};