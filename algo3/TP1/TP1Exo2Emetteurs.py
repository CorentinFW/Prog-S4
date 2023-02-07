from random import *
from math import sqrt
from itertools import *
import matplotlib.pyplot as plt

def AfficheMaisons(Maison):
    n=len(Maison)
    plt.plot([m[0] for m in Maison],[m[1] for m in Maison],'bo',markersize =3,label='maison')
    plt.title(str(n)+' Maisons')
    plt.legend()
    plt.axis('equal')
    plt.show()

def AfficheEmetteurs(Maison,Emetteur,rayon):
    n=len(Maison)
    fig, ax = plt.subplots()
    for i in range(n):
        if Emetteur[i]==1:
            circle=plt.Circle(Maison[i],rayon, color='r')
            ax.add_artist(circle)
    AfficheMaisons(Maison)


def GenererMaisons(Maison,n):
    for i in range(0,n):
        X=randint(1,1000)
        Y=randint(1,1000)
        Maison.append((X,Y))
    # return Maison pas besoin dans ce cas la 

def Couvre(Maison,i,j):
    return sqrt((Maison[j][0]-Maison[i][0])**2+(Maison[j][1]-Maison[i][1])**2)<=rayon
    


def choixMaison(Maison,MaisonsRestantes):#MaisonsRestantes[i]=0 ssi i n'est pas couverte
    iMax = 0
    indince = 0
    for i in range(len(Maison)):
        i0=0
        
        for j in range(len(Maison)):
            if Couvre(Maison,i,j) and MaisonsRestantes[j] == 0:
                i0=+1
        if i0> iMax:
            iMax = i0
            indince = i
         
    return indince

#Approx gloutonne
def choixEmetteurGlouton(Maison):
    n=len(Maison)
    Emetteur=[0]*n
    MaisonsRestantes=[0]*n
    # test
    while 0 in MaisonsRestantes:
        x = choixMaison(Maison,MaisonsRestantes)
        Emetteur[x] = 1
        for i in range(n):
            if Couvre(Maison,x,i):
                MaisonsRestantes[i] = 1
    print(Emetteur)
    return Emetteur
    
def longueur(Emetteur):
    cpt=0
    for x in Emetteur:
        if x==1:
            cpt+=1
    return cpt
    
rayon=120 # rayon de l'émetteur
n=50 #nombre de maisons
Maison=[] #contient les coordonnees cartesiennes des maisons dans [1,1000]x[1,1000]
GenererMaisons(Maison,n)
AfficheMaisons(Maison)
Emetteur=choixEmetteurGlouton(Maison)
print("L'algo glouton place",longueur(Emetteur),"émetteurs")
AfficheEmetteurs(Maison,Emetteur,rayon)
