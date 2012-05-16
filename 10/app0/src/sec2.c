#include <stdio.h>

int main(int argc, char *argv[])
{
        char buffer[5];
        //strcpy(buffer, argv[1]);
        strncpy(buffer, argv[1], 4);
	buffer[4]='\0';
	puts(buffer);
	return 0;
}

