#include "util.h"



int main(int argc,char *argv[]){
//variables
    int case1_current_number;

    if(argc == 1){
            int num;
        char input[3];
        printf("\nEnter number: ");
            while(fgets(input,4,stdin) != NULL){
                if(sscanf(input,"%d",&num) == 0)
                    printf("\n  -- Error sscanf -- "); // Exception
                if(convertNumberToString(num) == EXIT_SUCCESS)
                    ;
                else
                    printf("\n --- Error convertNumberToString --\n"); //Exception
                printf("\nEnter number: ");
            }
    }else if(argc == 2){
        //varibales
        int line_count=0;
        int x;
        FILE *f = fopen(argv[1],"r");
        char buf[BUF];
            while(fgets(buf,BUF,f) != NULL){
                //printf("line [%d]: %s  ",line_count,buf);
                x = atoi(buf);
                printf("%d ",x);
                if(convertNumberToString(x) == EXIT_SUCCESS)
                    line_count++;
                else
                    printf("\n -- Error in convert ---");
                printf("\n");
            }
        fclose(f);
    }else if(argc == 3){
            //varibales
        int line_count=0;
        int x;
        FILE *inputfile = fopen(argv[1],"r");
        FILE *outputfile = fopen(argv[2],"w+");
        char buf[BUF];
            while(fgets(buf,BUF,inputfile) != NULL){
                x = atoi(buf);
                if(insrtToFileConvertNumberToString(x,outputfile) == EXIT_SUCCESS){
                        ;
                }else
                    printf("\n -- Error --\n converting numbers");
            }
        fputc('\n',outputfile);
        fputc('\0',outputfile);
        fclose(inputfile);
        fclose(outputfile);
    }else{ // -- Error -- in case the user enter motre then two arguments
    fprintf(stderr, "\n -- Error --\nThere are more than two arguments\n");
        exit(EXIT_FAILURE);
    }

    printf("\n\n -- Exit -- \n");
        return 0;
};
