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

getsystem: getsystem.c
		$(CC) getsystem.c -o getsystem

sec1: sec1.c
		$(CC) sec1.c -o sec1

sec2: sec2.c
		$(CC) sec2.c -o sec2

clean: 
	        rm vuln1 vuln2 getenvaddr getsystem exploiter sec1 sec2 && rm *.o

all: vuln1 vuln2 getenvaddr exploiter getsystem sec1 sec2
