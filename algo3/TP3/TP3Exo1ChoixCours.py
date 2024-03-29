import matplotlib.pyplot as plt
from random import *
import time

###########################################

def CoursAuHasard(n):
    Cours=[]
    for i in range(n-1):
        HeureCours = randint(1,80)
        DureCours = randint(1,20)
        valeurCours = randint(1,10)
        Cours.append[HeureCours,HeureCours+DureCours,valeurCours]
    return Cours
    
def TriBullesCours(Cours):
    
    n= 0
    for j in range(len(Cours)-1):
        for i in range(0,len(Cours)-1-j):
            if Cours[i][1] >Cours[i+1][1]:
                Cours[i],Cours[i+1] = Cours[i+1],Cours[i]
    return Cours


def CalculPred(n,Cours):
    Cours = TriBullesCours(Cours)
    Pred=n*[-1]
    for i in range(n-1):
        if Cours[i][1]<= Cours[i+1][0]:
            Pred[i+1] = i
    
    return Pred

def ChoixMaxProgD(n,Cours,Pred):
    ValMax=n*[0]
    
    return ValMax[n-1]

def ChoixMaxRec(Cours,Pred,k):
    if k<0:
        return 0
    #
    # A COMPLETER
    #

def ChoixMaxProgDSol(n,Cours,Pred,Sol):
    ValMax=n*[0]
    Sol[0]=1
    #
    # A COMPLETER
    #
    return ValMax[n-1]

def CalculSolProgDyn(n,Cours,Pred,Sol):
    CoursChoisis=[]
    i=n-1
    #
    # A COMPLETER
    #
    return CoursChoisis


#######Programme Principal########

choix=int(input("Taper 1 pour un test sur l'exemple donné, 2 pour un ensemble de cours aléatoire: "))
if choix==1:
    Cours=[[76,78,10],[12,17,2],[13,15,1],[19,28,8],[12,20,7],[44,45,9],[43,45,5],[1,8,3]]
    n=8
    print("Test de calcul Pred = ",CalculPred(n,Cours))
else:
    n=int(input("Rentrer le nombre de cours voulus: "))
    Cours=CoursAuHasard(n)

print("Cours non triés: ",Cours,"\n")
TriBullesCours(Cours)
print("Cours tries par dates de fin croissantes: ",Cours,"\n")
Pred=CalculPred(n, Cours)
print("Calcul des prédécesseurs: ")
for i in range(0,n):
    print("Pred du cours",i,":",Pred[i]," / ",end='')
    if i%4==3:
        print()
print()
print("Valeur maximale d'un choix de cours en prog dyn: ",ChoixMaxProgD(n,Cours,Pred))
print()
print("Valeur maximale d'un choix de cours en récursif: ", ChoixMaxRec(Cours,Pred,n-1))
print()
Sol=n*[0]
print("Calcul d'une solution de valeur maximale d'un choix de cours en prog dyn: ")
print("Valeur maximale: ", ChoixMaxProgDSol(n,Cours,Pred,Sol))
print("Solution correspondante :", CalculSolProgDyn(n,Cours,Pred,Sol))
print("Test de calcul Pred = ",CalculPred(n,Cours))
print("test de Tri bulle cours = ",TriBullesCours(Cours))