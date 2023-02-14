from dessins import *
from math import sqrt
from random import*
# from random import random
# from random import uniform


def distance(A,B):
    return sqrt((A[0]-B[0])**2+(A[1]-B[1])**2)

# A , B , C = (121 ,77) , (48 ,70) , (12 ,72)
# print ( distance (A , B ) , distance (A , C ) , distance (B , C ))

def aretes(P):
    listeTriplet =[]
    n = len(P)
    for i in range(n-1):
        for j in range(i+1,n):
            listeTriplet.append([i,j,distance(P[i],P[j])])
    return listeTriplet


def pointsAleatoires(n,x,y):
    listeA = []
    for i in range(n):
        # listeA.append([round(random.uniform(0.0,float(x)),2),round(random.uniform(0.0,float(y)),2)])
        listeA.append([random()+randint(0,x),random()+randint(0,y)])
    return listeA


def listesAdjacence(n,A):
    dico = {}

    for i in range(n):
        listeVoisin=[]
        for j in range(len(A)):
            if i==A[j][1]:
                listeVoisin.append(A[j][0])
            elif i==A[j][0]:
                listeVoisin.append(A[j][1])
        print(listeVoisin)
        dico[i] = listeVoisin
    return dico


# A = [(0 ,1) ,(0 ,2) ,(0 ,3) ,(1 ,2) ,(1 ,3) ,(2 ,3)]
# print ( listesAdjacence (4 , A ))

# P = [(6 ,20) ,(67 ,18) ,(96 ,4) ,(32 ,45)]
# print ( aretes ( P ))

# print ( pointsAleatoires (3 , 10 , 20))

# dessinPoints(pointsAleatoires(45,10,10))
dessinGraphe(pointsAleatoires(10,10,10),)