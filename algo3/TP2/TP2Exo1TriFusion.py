import matplotlib.pyplot as plt
from random import *
import time

###########################################

def TableauAuHasard(n):
    TabHasard=[]
    #
    # A COMPLETER
    #

def TriFusion(T):
    n = len(T)
    if n>1:
        n1=n//2 
        n2=n-n1 
        T1=TriFusion(T[0,(n//2)-1])
        T2=TriFusion(T[(n//2),n-1])
        return Fusion(n1,n2,T1,T2,T)
    
# Algorithme : Fusion(T1, T2)
# n1 ← taille(T1) ; n2 ← taille(T2)
# S ← tableau de taille n1 + n2
# i1 ← 0 ; i2 ← 0
# pour iS = 0 `a n1 + n2 − 1 faire
# si i1 ≥ n1 alors S[iS ] ← T2[i2] ; i2 ← i2 + 1 ;

# sinon si i2 ≥ n2 alors S[iS ] ← T1[i1] ; i1 ← i1 + 1 ;

# sinon si T1[i1] < T2[i2] alors S[iS ] ← T1[i1] ; i1 ← i1 + 1 ;
# sinon S[iS ] ← T2[i2] ; i2 ← i2 + 1 ;
# retourner S
def Fusion(n1, n2, T1, T2, T):
    i1 = 0
    i2 = 0
    i = 0
    S = []*(n1+n2)
    for j in range(S-1):
        if i1>n1:
            S[j] = T1[i2]
            i2=+ 1
        elif i2>=n2:
            S[j] = T1[i1]
            i1=+1
        elif T1[i1]<T2[i2]:
            S[j] =T1[i1]
            i1=+1
        elif S[j]<T2[i2]:
            i2 =+1
    return S

A = [21,2566,8,2,41]
TriFusion(len(A),A)

def TriBulles(n,T):
    pass
    #
    # A COMPLETER (et enlever pass)
    #

#######Programme Principal########

choix=int(input("Taper 1 pour un test sur le TriFusion, 2 pour un comparatif TriFusion/TriBulles: "))
if choix==1:
    Tab=[0]
    n=int(input("Entrez la taille du tableau à trier: "))
    #Tab=TableauAuHasard(n)
    print("Tableau à trier: ",Tab)
    TabFusion=list(Tab)
    TriFusion(n, TabFusion)
    print("Après TriFusion: ",TabFusion)
    TriBulles(n, Tab)
    print("Après TriBulles: ",Tab)
else:    
    #Valeurs de n choisies    
    abscisses = [n for n in range(1,1000,10)]
    #Temps de calcul
    tps1 = []
    tps2 = []
    for n in range(1,1000,10):
        T=TableauAuHasard(n)
        T2=list(T)
        t=time.time()
        TriBulles(n, T)
        tps1.append(time.time()-t)
        t=time.time()
        TriFusion(n, T2)
        tps2.append(time.time()-t)
    #Tracé
    plt.plot(abscisses, tps1)
    plt.plot(abscisses, tps2)
    plt.show()