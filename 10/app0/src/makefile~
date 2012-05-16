CC=gcc

vuln1: vuln1.c
	        $(CC) vuln1.c -o vuln1 -z execstack
		chown root.users vuln1
		chmod +s vuln1

vuln2: vuln2.c
	        $(CC) vuln2.c -o vuln2 -z execstack
		chown root.users vuln2
		chmod +s vuln2

getenvaddr: getenvaddr.c
	        $(CC) getenvaddr.c -o getenvaddr

exploiter: exploiter.c
	        $(CC) exploiter.c -o exploiter

clean: 
	        rm vuln1 vuln2 getenvaddr exploiter && rm *.o

all: vuln1 vuln2 getenvaddr exploiter
