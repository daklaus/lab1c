#include <stdio.h>

int main(int argc, char *argv[])
{
        char buffer[500];
        //strcpy(buffer, argv[1]);
	strncpy(buffer, argv[1], 499);
	buffer[499]='\0';
	puts(buffer);
        return 0;
}

