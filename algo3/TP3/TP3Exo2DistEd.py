import matplotlib.pyplot as plt

###########################################

def Init(n1,n2):
    #E[i][j]
    E = [[0 for i in range(0,n1+1)] for j in range(0,n2+1)]
    for i in range(n2):
        E[i][0] = i
    for j in range(n1):
        E[0][j] = j


def DistanceEdition(S1,S2,E):
    n = len(S1)
    m = len(S2)
    E = [[0 for i in range(0,n1+1)] for j in range(0,n2+1)]
    bi = -1
    for i in range(1,n):
        for j in range(1,m):
            if S1[i-1] == S2[j-1]:
                bi = 1
            else : 
                bi = 0
            E[i][j] = min(E[i-1][j]+1,E[i][j-1]+1,E[i-1][j-1]+bi)
    return E[n-1][m-1]


    

def Alignement(S1,S2,E):
    n=len(S1)
    m=len(S2)
    
    # while i1>0 and i2>0:
    
    
    # while n>0:
    
    
    #while m>0:
    
    
    return S1,S2        
    
#######Programme Principal########

S1=input("Entrer S1 la première chaine de caractères: ")
S2=input("Entrer S2 la seconde chaine de caractères: ")
print()

n1=len(S1)
n2=len(S2)


print("Les deux chaines S1 et S2 sont à distance: ", DistanceEdition(S1, S2),'\n')

print("Tableau des distances partielles: ")
for i in range(0,n2+1):
    print(E[i])
print()

A,B=Alignement(S1, S2, E)
print("Alignement de S1 et S2:")
print(A)
print(B)