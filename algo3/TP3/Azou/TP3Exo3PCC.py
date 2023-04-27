from dessinsVilles import * 
import numpy as np

def Floyd_warshall(n,Adj,pcc,DernierPas):
    for i in range(0,n-1):
        for j in range(0,n-1):
            if Adj[i][j] != None or i == j:
                pcc[i][j] = Adj[i][j]
            else:
                pcc[i][j] = np.inf

    for k in range(0,n-1):
        for i in range(0,n-1):
            for j in range(0,n-1):
                if pcc[i][j] > pcc[i][k] + pcc[k][j]:
                    pcc[i][j] = pcc[i][k] + pcc[k][j]
                    DernierPas[i][j] = k
    return pcc

n=4
Adj=[[0,2,6,10],[np.inf,0,1,np.inf],[np.inf,np.inf,0,4],[np.inf,np.inf,7,0]]
DernierPas=[[-1]*n for i in range(n)]
pcc=[[0]*n for i in range(n)]

Floyd_warshall(n,Adj,pcc,DernierPas)
print("\n")
print("Matrice d'adjacence pondérée :")
for ligne in Adj:
    print(ligne)
print("\n")
print("Matrice des longueurs des pccs :")
for ligne in pcc:
    print(ligne)
print("\n")
print("Matrice des derniers pas :")
for ligne in DernierPas:
    print(ligne)
print("\n")

def reconstruction(i,j,P):
    Ch = [j]
    vcourant = j
    while vcourant != i:
        vcourant = P[i][int(vcourant)]
        if not np.isfinite(vcourant):
            return None
        Ch.append(vcourant)
    Ch.reverse()
    return Ch

dessinVilles(position,longueur,villes)

for i in range(n):
    for j in range(n):
        chemin = reconstruction(int(i),int(j),longueur)
        if chemin == None:
            print(f"Il n'y a pas de chemin de {i} à {j}")
        else:
            distance = longueur[i][j]
            print(f"Chemin de {i} à {j} : {chemin}, distance = {distance}")

print("Ville de départ : ")
print("Ville d'arrivée : ")
print("Distance totale : ")
print("Trajet : []")