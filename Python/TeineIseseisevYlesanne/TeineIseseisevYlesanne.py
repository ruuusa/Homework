import sys
def programm():
    vastus="jah"
    while vastus=="jah":
        indeks=0
        indeks2=0
        indeks3=0
        lindudearv=0
        endlalinnud=0
        saadlinnud=0
        ratvalinnud=0
        parvedearv=input("Mitu haneparve on nähtud? ")
        parvenimed=[ ]
        liikmetearvud=[ ]
        
        while parvedearv.isdigit()==False:
            parvedearv=input("Mitu haneparve on nähtud? ")
        while indeks !=int(parvedearv):
            indeks+=1
            print("\tSisestage {}. haneparve ...".format(indeks))
            parvenimi=input("\t\t... nimi: ")
            while parvenimi.isnumeric()or parvenimi.isalnum()==False:
                 parvenimi=input("\t\t... nimi: ".format(indeks))
            liikmetearv=input("\t\t... liikmete arv: ".format(indeks))
            while liikmetearv.isdigit()==False:
                liikmetearv=input("\t\t... liikmete arv: ".format(indeks))
            parvenimed.append(parvenimi)
            liikmetearvud.append(liikmetearv)

           
        print("Lõunasse lähevad järgmised haneparved:")
        while indeks2!=indeks: 
            print("\t'{}' ({} hane)".format(parvenimed[indeks2],liikmetearvud[indeks2]))
            indeks2+=1

        liikmetearvud2=map(int,liikmetearvud)
        lindudearv=sum(liikmetearvud2)
        
        while indeks3!=indeks:
            endla=input("Mitu hane maandub '{}' parvest Endla järvele? ".format(parvenimed[indeks3]))
            while endla.isdigit()==False:
                endla=input("Mitu hane maandub '{}' parvest Endla järvele? ".format(parvenimed[indeks3]))
            while int(endla)>lindudearv:
                print("\tParves '{}' ei ole nii palju hanesid!".format(parvenimed[indeks3]))
                print("\tParves '{}' on {} hane!".format(parvenimed[indeks3],liikmetearvud[indeks3]))
                print("\tSisestage väiksem väärtus!")
                endla=input("Mitu hane maandub '{}' parvest Endla järvele? ".format(parvenimed[indeks3]))
            endlalinnud+=int(endla)
            lindudearv-=int(endla)
            print("\tEndla järvele maandus {} hane ja {} hane lendab edasi!".format(endla,int(liikmetearvud[indeks3])-int(endla)))

            saad=input("Mitu hane maandub '{}' parvest Saadjärvele? ".format(parvenimed[indeks3]))
            while saad.isdigit()==False:
                saad=input("Mitu hane maandub '{}' parvest Saadjärvele? ".format(parvenimed[indeks3]))
            while int(saad)>lindudearv:
                print("\tParves '{}' ei ole nii palju hanesid!".format(parvenimed[indeks3]))
                print("\tParves '{}' on {} hane!".format(parvenimed[indeks3],int(liikmetearvud[indeks3])-int(endla)))
                print("\tSisestage väiksem väärtus!")
                saad=input("Mitu hane maandub '{}' parvest Saadjärvele? ".format(parvenimed[indeks3]))
            saadlinnud+=int(saad)
            lindudearv-=int(saad)
            print("\tSaadjärvele maandus {} hane ja {} hane lendab edasi!".format(saad,int(liikmetearvud[indeks3])-int(endla)-int(saad)))

            ratva=input("Mitu hane maandub '{}' parvest Ratva järvele? ".format(parvenimed[indeks3]))
            while ratva.isdigit()==False:
                ratva=input("Mitu hane maandub '{}' parvest Ratva järvele? ".format(parvenimed[indeks3]))
            while int(ratva)>lindudearv:
                print("\tParves '{}' ei ole nii palju hanesid!".format(parvenimed[indeks3]))
                print("\tParves '{}' on {} hane!".format(parvenimed[indeks3],int(liikmetearvud[indeks3])-int(endla)-int(saad)))
                print("\tSisestage väiksem väärtus!")
                ratva=input("Mitu hane maandub '{}' parvest Ratva järvele? ".format(parvenimed[indeks3]))
            ratvalinnud+=int(ratva)
            lindudearv-=int(ratva)
            print("\tRatva järvele maandus {} hane ja {} hane lendab edasi!".format(ratva,int(liikmetearvud[indeks3])-int(endla)-int(saad)-int(ratva)))
            indeks3+=1
            
        print("""
Endla järvele on maandunud kokku {} hane!
Saadjärvele on maandunud kokku {} hane!
Ratva järvele on maandunud kokku {} hane!
Eesti järvedel ei peatunud {} hane!""".format(endlalinnud,saadlinnud,ratvalinnud,lindudearv))
        vastus=input("\nKas soovite jätkata (jah/ei)? ")
        if vastus=="jah":
            print("")
            return
        elif vastus!="jah":
            print("Programm läks kinni!")
            sys.exit()
x=True
while x==True:
    programm()
