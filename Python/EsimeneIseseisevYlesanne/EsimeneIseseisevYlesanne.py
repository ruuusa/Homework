#autor on ronald ruusa
import random #et kasutada random generatorit
#algrõhk
käsklus1=input("Süsteem on ülesse seatud - kas käivitada süsteem (jah/ei)? ")
if käsklus1=="jah": #kui vastus on jah, hakkab programm tööle
    print("\tSüvaveepump käivitus!")
    print("\t\tHüdrofoori rõhk:")
    rõhk=1.80
    while round(rõhk,2)<=2.85: #kuni rõhuni 2.85 bari rõhk tõuseb 0.15bar/s
        print("\t\t\t{:.2f}".format(rõhk), "bar") #2.85, kuna esineb +-0.5 bari
        rõhk=rõhk+0.15
    if round(rõhk,2)>2.80: #kui rõhk ületab 2.80 bari, siis esimene loop lõppeb
        print("\tSüvaveepump seiskus!")
        print("")
if käsklus1=="ei":
    print("Süsteemi ei võeta tööle!")

käsklus2=input("Kas keerata kraanid lahti (jah/ei)? ")
rõhk=rõhk-0.25
if käsklus2=="ei":
    print("Kraane lahti ei keeratud!")
if käsklus2=="jah":
    if round(rõhk)<2.80: #rõhk väiksem kui 2.80 annab märguande, et pump peab töötama
            süvaveepump=True
            süvaveepumbatööolek="[Töötab] "
    if round(rõhk)>2.80: #rõhk suurem kui 2.80 annab märguande, et pump lõpetaks töö
            süvaveepump=False
            süvaveepumbatööolek="[Seisab] "
    while käsklus2=="jah": #while loop, kuna all olev käsklus2 vastus toob siia tagasi
        while süvaveepump==True and round(rõhk)<=2.85: #kui pump töötab ning rõhk tõuseb, töötab see loop
            x=1,2 #random chice'ga lahendasin vee tarbimise juhuslikkuse
            veetarbimine=random.choice(x)
            if veetarbimine==1: 
                veetarvidus1=True
                veetarvidus2="[Tarbitakse] "
            if veetarbimine==2:
                veetarvidus1=False
                veetarvidus2="[Ei tarbita] "
            if süvaveepump==True: #süvaveepumba töötamise puhul alati rõhk tõuseb
                hüdrofoorirõhk="[Tõuseb] "
            if veetarvidus1==False: #vastavalt vee kasutamisele on rõhu väärtuse muutus suurem või väiksem
                rõhk=rõhk+0.15
                print ("\t"+süvaveepumbatööolek+veetarvidus2+hüdrofoorirõhk+": "+"{:.2f}".format(rõhk),"bar")
            if veetarvidus1==True:
                rõhk=rõhk+0.10
                print ("\t"+süvaveepumbatööolek+veetarvidus2+hüdrofoorirõhk+": "+"{:.2f}".format(rõhk),"bar")
                
        while süvaveepump==False and round(rõhk)>1.75: #kui pump ei tööta ehk rõhk langeb, töötab see loop
            x=1,2
            veetarbimine=random.choice(x)
            if veetarbimine==1:
                veetarvidus1=True
                veetarvidus2="[Tarbitakse] "
            if veetarbimine==2:
                veetarvidus1=False
                veetarvidus2="[Ei tarbita] "
            if süvaveepump==False and veetarvidus1==True: #kui pump ei tööta javett tarbitakse, siis rõhk langeb
                hüdrofoorirõhk="[Alaneb] "
            if süvaveepump==False and veetarvidus1==False: #kui pump ei tööta ja vett ei tarbita, siis rõhk seisab
                hüdrofoorirõhk="[Seisab] "
            if veetarvidus1==True: #vee kasutamisele vastavalt jällegi erinevad rõhu muutuse väärtused
                print ("\t"+süvaveepumbatööolek+veetarvidus2+hüdrofoorirõhk+": "+"{:.2f}".format(rõhk+0.15),"bar")
                rõhk=rõhk-0.05
            if veetarvidus1==False:
                print ("\t"+süvaveepumbatööolek+veetarvidus2+hüdrofoorirõhk+": "+"{:.2f}".format(rõhk+0.15),"bar")
                rõhk=rõhk
        print("")
        käsklus2=input("Kas soovite jätkata (jah/ei)? ") #sama käsklus2, kuid erinev tekst, et peale esimest loopi tuleks see küsimus, mitte "Kas keerata kraanid lahti"
        if käsklus2=="ei": #kui lõpuks ei vastata, siis ilmub ekraanile "Süsteem suleti"
            print ("Süsteem suleti!")      
