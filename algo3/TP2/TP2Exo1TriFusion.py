import matplotlib.pyplot as plt
from random import *
import time


###########################################

def TableauAuHasard(n):
    TabHasard=[]
    for i in range(n):
        TabHasard.append(randint(1,10000))
    return TabHasard

def TriFusion(T):
    if len(T)<=1:
        return T
        
    else:
        milieu=len(T)//2 
        T1= T[:milieu]
        T2 = T[milieu:]
        gauche = TriFusion(T1)
        droite = TriFusion(T2)
        return Fusion(gauche,droite)
        
    
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
def Fusion(T1, T2):
    i1 = 0
    i2 = 0
    S = []
    
    while i1<len(T1) and i2<len(T2) :
        if T1[i1]<T2[i2]:
            S.append(T1[i1])
            i1 += 1
        else:
            S.append(T2[i2])
            i2+=1
    while i1<len(T1):
        S.append(T1[i1])
        i1+=1
    while i2<len(T2):
        S.append(T2[i2])
        i2+=1

    # for j in range(n):
    #     if i1>=n:
    #         S.append(T2[i2])
    #         i2=+ 1
    #     elif i2>=n:
    #         S.append(T1[i1])
    #         i1=+1
    #     elif T1[i1]<T2[i2]:
    #         S.append(T1[i1])
    #         i1=+1
    #     else:
    #         S.append(T2[i2])
    #         i2 =+1
    return S

A = [21,2566,8,2,41]
print("mon test a me ",TriFusion(A))

def TriBulles(n,T):
    for i in range(n,0,-1):
        for j in range(i-1):
            if T[j]>T[j+1]:
                T[j],T[j+1] = T[j+1],T[j]
    return T


#######Programme Principal########

choix=int(input("Taper 1 pour un test sur le TriFusion, 2 pour un comparatif TriFusion/TriBulles: "))
if choix==1:
    Tab=[0]
    n=int(input("Entrez la taille du tableau à trier: "))
    Tab=TableauAuHasard(n)
    print("Tableau à trier: ",Tab)
    TabFusion=list(Tab)
    print("Après TriFusion: ",TriFusion(TabFusion))
    print("Après TriBulles: ",TriBulles(n, Tab))
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
        TriFusion(T2)
        tps2.append(time.time()-t)
    #Tracé
    plt.plot(abscisses, tps1)
    plt.plot(abscisses, tps2)
    plt.show()