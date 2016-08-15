from time import strftime
import sys
import re

print("""L - Sademete lisamine andmebaasi.
M - Andmebaasis oleva sademe muutmine.
P - Andmebaasis asuvate sademete kuvamine.
E - Programmi sulgemine.""")

def valik():
#võtab sisendi valiku ning returnib vastuse
    vastused1=("L", "M", "P", "E")
    vastus1=input("""
Sisestage soovitud valik (L, M, P, E): """)
    vastus1=vastus1.upper()
    while vastus1 not in vastused1:
        vastus1=input("Sisestage soovitud valik (L, M, P, E): ")
        vastus1=vastus1.upper()
    return vastus1

def sademetelisamine():
#võimaldab sisestada sademed ning lisab andmed faili
#If zero or more characters at the beginning of string match the regular expression pattern,
#return a corresponding MatchObject instance.Return None if the string does not match the pattern;
#note that this is different from a zero-length match.
    b=input("""
\tFikseerige sade kujul [Identifikaator] [20] (C): """)
    if b=="C" or b=="c":
        return
    while re.match("^\[([a-zA-ZöäõüÕÄÖÜ]+)\] \[([0-9]+)\]$", b) is None:
        b=input("\tFikseerige sade kujul [Identifikaator] [20] (C): ")
        if b=="C" or b=="c":
            return
    if re.match("^\[([a-zA-ZöäõüÕÄÖÜ]+)\] \[([0-9]+)\]$", b) is not None:
        andmebaas=open("andmebaas.txt", "a", encoding="utf-8")
        andmebaas.write(strftime("%d.%m.%Y %H:%M:%S")+" - "+b+"\n")
        andmebaas.close()
        if b=="C" or b=="c":
            return
    print("\tSade fikseeritud!")
    return

def sademetemuutmine():
#võimaldab muuta sademeid sisendi järgi ning salvestab andmebaasi uued sademed
    print("""
\tAndmebaasis olevad andmed:""")
    andmebaas=open("andmebaas.txt", "r", encoding="utf-8")
    andmed=andmebaas.readlines()
    indeks=1
    for i in andmed:
        print("\t\t"+str(indeks)+". "+i.strip()[22:])
        indeks+=1
    andmebaas.close()
    c=input("""
\tSisestage sademe indeks, mida soovite muuta (C): """)
    if c=="C" or c=="c":
        return
    while c.isdigit() is False or int(c)>int(indeks)-1 or int(c)<=0:
        if c.isdigit() is True:
            print("\t\tSisestatud sademe indeksit ei eksisteeri andmebaasis!")
        c=input("\tSisestage sademe indeks, mida soovite muuta (C): ")
        if c=="C" or c=="c":
            return
    indeks2=int(c)-1
    andmed.pop(indeks2)
    d=input("\tFikseerige sade kujul [Identifikaator] [20] (C): ")
    if d=="C" or d=="c":
            return
    while re.match("^\[([a-zA-ZöäõüÕÄÖÜ]+)\] \[([0-9]+)\]$", d) is None:
        d=input("\tFikseerige sade kujul [Identifikaator] [20] (C): ")
        if d=="C" or d=="c":
            return
    d=str(strftime("%d.%m.%Y %H:%M:%S")+" - "+d+"\n")
    andmed.insert(indeks2, d)
    andmed="".join(andmed)
    andmebaas=open("andmebaas.txt", "w", encoding="utf-8")
    andmebaas.write(andmed)
    andmebaas.close()
    print("\tSademe kirje on uuendatud!")

def sademetekuva():
#kuvab sisendid
    print("""
\tAndmebaasi sisu:""")
    andmebaas=open("andmebaas.txt", "r", encoding="utf-8")
    andmed=andmebaas.readlines()
    andmebaas.close()
    indeks=0
    for i in andmed:
        indeks+=1
        print("\t\t"+i.strip())
        
    
        
def sulgemine():
#võtab sisendi ning kui vastus on jah, siis sulgeb programmi. kui vastus pole jah, siis läheb algusesse tagasi
    e=input("""
\tKas olete kindel, et soovite programmi sulgeda ('jah')? """)
    if e!="jah" and e!="JAH":
        return
    elif e=="jah" or e=="JAH":
        print("\tProgramm läks kinni!")
        sys.exit()

#esimese sisendi vastuse järgi käivitatakse uus funktsioon    
systeem=True
while systeem==True:
    vastus1=valik()
    if vastus1=="L":
        vastus1=sademetelisamine()
    elif vastus1=="M":
        vastus1=sademetemuutmine()
    elif vastus1=="P":
        vastus1=sademetekuva()
    elif vastus1=="E":
        vastus1=sulgemine()
