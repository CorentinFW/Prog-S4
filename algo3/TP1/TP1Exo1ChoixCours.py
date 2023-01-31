from random import *
import operator

def CoursAuHasard(n):
    Cours=[]
    for i in range(0,n):
        debut = randint(1,90)
        duree = randint(1,10)
        Cours.append([debut,duree+debut])
    return Cours

def TriBulles(Cours):
    # n = len(Cours)
    # # Traverser tous les éléments du tableau
    # for i in range(n):
    #     for j in range(0, n-i-1):
    #         # échanger si l'élément trouvé est plus grand que le suivant
    #         if Cours[j] > Cours[j+1] :
    #             Cours[j], Cours[j+1] = Cours[j+1], Cours[j]
    # print("Cours triés par dates de fin croissantes: \n",Cours)
    n = len(Cours)
    for i in range(n,0,-1):
        for j in range(0,i-1):
            if Cours[j]>Cours[j+1]:
                Cours[j],Cours[j+1] = Cours[j+1],Cours[j]
    print("Tri a bulle = ",Cours)

def glouton(Cours):
    TriBulles(Cours)
    L = [Cours[0]]
    F = Cours[0][1]
    n = len(Cours)
    for i in range(2,n):
        if Cours[i][0] >= F:
            L.append(Cours[i])
            F = Cours[i][1] 
    return L

   
#=================================================================

alea=int(input('Taper 1 pour utiliser l\'exemple pré-rempli, taper 2 pour choisir une instance au hasard:'))
if alea==1:
    n=10
    Cours=[[76,78],[12,17],[13,15],[19,28],[12,20],[43,45],[44,45],[1,8],[68,78],[85,88]]    
else:
    n=int(input('Entrez le nombre de cours: '))
    Cours=CoursAuHasard(n)
print("Ensemble de cours disponibles: \n",Cours)
print("Choix de cours effectué :", glouton(Cours))

Cours = [[76 ,78] ,[12 ,17] ,[13 ,15] ,[19 ,28] ,[12 ,20] ,[43 ,45] ,[44 ,45] ,[1 ,8] ,[68 ,78] ,[85 ,88]]
print("test = ",glouton(Cours))