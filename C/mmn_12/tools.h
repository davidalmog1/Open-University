

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef enum KIT { 
    TRUE ,
    FALSE ,
    N =11 // matrix lentgh NxN 
    }kit;

// matrix
typedef int adjmat [N][N]; 

// function prototype
kit path(adjmat,int ,int);
void input_matrix(adjmat matrix);
void print_matrix(adjmat);
