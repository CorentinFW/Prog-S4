import matplotlib.pyplot as plt
from random import *
import time

###########################################
import random

def CoursAuHasard(n):
    cours = []
    for i in range(n):
        debut = random.randint(1, 80)
        duree = random.randint(1, 20)
        valeur = random.randint(1, 10)
        cours.append([debut, debut + duree, valeur])
    return cours

def TriBullesCours(cours):
    n = len(cours)
    for i in range(n):
        for j in range(n - 1 - i):
            if cours[j][1] > cours[j+1][1]:
                cours[j], cours[j+1] = cours[j+1], cours[j]

def CalculPred(cours):
    n = len(cours)
    pred = [-1] * n
    for i in range(n):
        j = i - 1
        while j >= 0 and cours[j][1] > cours[i][0]:
            j -= 1
        pred[i] = j
    return pred

def ChoixMaxProgD(cours):
    n = len(cours)
    TriBullesCours(cours)
    ValMax = [0] * n
    for i in range(n):
        ValMax[i] = cours[i][2]
        j = i - 1
        while j >= 0 and cours[j][1] > cours[i][0]:
            j -= 1
        if j >= 0:
            ValMax[i] += ValMax[j]
        if i > 0 and ValMax[i-1] > ValMax[i]:
            ValMax[i] = ValMax[i-1]
    return ValMax[n-1]

def ChoixMaxRec(Cours, Pred, k):
    if k == -1:
        return 0
    else:
        valeurMax = 0
        for i in range(k+1):
            if Pred[i] == -1:
                val = Cours[i][2] + ChoixMaxRec(Cours, Pred, i-1)
            else:
                val = Cours[i][2] + ChoixMaxRec(Cours, Pred, Pred[i])
            valeurMax = max(valeurMax, val)
        valeurMaxSansK = ChoixMaxRec(Cours, Pred, k-1)
        return max(valeurMax, valeurMaxSansK)

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