from dessins import *
from math import sqrt

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


P = [(6 ,20) ,(67 ,18) ,(96 ,4) ,(32 ,45)]
print ( aretes ( P ))