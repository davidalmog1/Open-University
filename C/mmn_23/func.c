
#include "util.h"

int convertNumberToString(int num){
    //variabels 
    int lsd_digit,msd_digit;

    char *list_small[] = {"zero","one","two", "three", "four", "five", "six", "seven", "eight", "nine","\0"}; // 0 < x 9
    char *list_special[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen","\0"}; // 9 < x < 20
    char *list_big[]= {"placeolder","placeolder","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety","\0"}; //  <= x <=90


    if( num <= 9 ){
        printf(" %s",list_small[num]);
    }
    else if( (num > 9) && (num < 20)){
        printf(" %s",list_special[num-10]);
    }
    else
    {   
        if(num %10 == 0)
            printf(" %s",list_big[(num/10)]);
        else{
        lsd_digit = (num %10);
        msd_digit = (num = num / 10);
        printf(" %s %s",list_big[msd_digit],list_small[lsd_digit]);
        }
    }
    
    return EXIT_SUCCESS;

};

int insrtToFileConvertNumberToString(int num,FILE *outputfile){
    //variabels 
    int lsd_digit,msd_digit;

    char *list_small[] = {"zero","one","two", "three", "four", "five", "six", "seven", "eight", "nine","\0"}; // 0 < x 9
    char *list_special[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen","\0"}; // 9 < x < 20
    char *list_big[]= {"placeolder","placeolder","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety","\0"}; //  <= x <=90


    if( num < 9 ){
        fprintf(outputfile ,"\n %s",list_small[num] );
    }
    else if( (num > 9) && (num < 20)){
        fprintf(outputfile,"\n %s",list_special[num-10]);
    }
    else
    {   
        if(num %10 == 0)
            fprintf(outputfile,"\n %s",list_big[ (num/10) ] ) ;
        else{
        lsd_digit = (num %10);
        msd_digit = (num = num / 10);
       fprintf(outputfile,"\n %s %s",list_big[msd_digit],list_small[lsd_digit] );
        }
    }
    
    return EXIT_SUCCESS;
};
