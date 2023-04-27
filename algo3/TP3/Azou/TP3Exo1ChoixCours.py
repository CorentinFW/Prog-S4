import matplotlib.pyplot as plt
from random import *
import time

###########################################

def CoursAuHasard(n):
    Cours=[]
    for i in range(0,n):
        date=randint(1,90)
        durée=randint(1,10)
        Cours.append([date,durée])
    return Cours

def TriBullesCours(Cours):
    for i in range(len(Cours),0,-1):
        for j in range(0,i-1):
            if Cours[j][1]>Cours[j+1][1]:
                Cours[j],Cours[j+1]=Cours[j+1],Cours[j]
    print("Cours triés par dates de fin croissantes: \n",Cours)

def CalculPred(n,Cours):  
    Pred = [-1]*n
    Cours = TriBullesCours(Cours)
    for i in range(n):
        j = n-1
        while j >= 0:
            if Cours[j][1]<Cours[i][0] and Cours[j][2]<=Cours[i][2]:
                Pred[i] = j
                break
            j -= 1
    return Pred

def ChoixMaxProgD(n,Cours,Pred):
    C = TriBullesCours(Cours)
    ValMax=n*[-1]
    for k in range(1,n):
        for j in range(0,k-1):
            if C[j][1]<=C[k][0]:
                ValMax[k]=j
    M=n*[0]
    M[0]=C[0][0]
    for k in range (1,n):
        if ValMax[k]!=-1:
            M[k]=max(M[k-1],C[0][k]+M[ValMax[k]])
        else:
            M[k]=max(M[k-1],C[0][k])
    return M[n-1]

def ChoixMaxRec(Cours,Pred,k):
    if k<0:
        return 0
    M=k*[0]
    C = TriBullesCours(Cours)
    ValMax = -1
    for j in range(0, n-1):
        if C[j][1] <= C[n-1][0]:
            ValMax = j
    if ValMax != -1:
        M[n] = max(ChoixMaxRec(Cours,Pred,n-1),C[0][n-1]+ChoixMaxRec(Cours,Pred,ValMax+1))
    else:
        M[n] = max(ChoixMaxRec(Cours,Pred,n-1),C[0][n-1])
    return M[n]

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