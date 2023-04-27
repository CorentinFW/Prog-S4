import matplotlib.pyplot as plt

###########################################

def Init(n1,n2):
    """
    Initialisation du tableau E
    """
    E = [[0]*(n1+1) for i in range(n2+1)]
    for j in range(n1):
        E[0][j]=j
    for i in range(n2):
        E[i][0]=i
    return E

def DistanceEdition(S1,S2,E):
    m = len(S1)
    n = len(S2)
    E = Init(n1,n2)
    for i in range(1,m):
        for j in range(1,n):
            if S1[i-1] == S2[j-1]:
                e = 0
            else:
                e = 1
            E[i][j] = min(E[i-1][j]+1,E[i][j-1]+1,E[i-1][j-1]+e)
    return E[m-1][n-1]

def Alignement(S1,S2,E):
    i1=len(S1)
    i2=len(S2)
    i,j = i1,i2
    
    while i>0 and j>0:
        if E[i][j] == E[i-1][j-1] and S1[i-1] == S2[j-1]:
            i,j = i-1,j-1
        elif E[i][j] == E[i-1][j-1]+1:
            S1 = S1[:i-1] + '-' + S1[i-1:]
            S2 = S2[:j-1] + '-' + S2[j-1:]
            i,j = i-1,j-1
        elif E[i][j] == E[i-1][j]+1:
            S2 = S2[:j] + '-' + S2[j:]
            S1 = S1[:i-1] + '-' + S1[i-1:]
            i = i-1
        elif E[i][j] == E[i][j-1]+1:
            S1 = S1[:i] + '-' + S1[i:]
            S2 = S2[:j-1] + '-' + S2[j-1:]
            j = j-1
    while i>0:
        S2 = S2[:j] + '-' + S2[j:]
        S1 = S1[:i-1] + '-' + S1[i-1:]
        i = i-1
    while j>0:
        S1 = S1[:i] + '-' + S1[i:]
        S2 = S2[:j-1] + '-' + S2[j-1:]
        j = j-1
    return S1,S2        

#######Programme Principal########

S1=input("Entrer S1 la première chaine de caractères: ")
S2=input("Entrer S2 la seconde chaine de caractères: ")
print()

n1=len(S1)
n2=len(S2)
E = [[0 for i in range(0,n1+1)] for j in range(0,n2+1)]

print("Les deux chaines S1 et S2 sont à distance: ", DistanceEdition(S1, S2,E),'\n')

print("Tableau des distances partielles: ")
for i in range(0,n2+1):
    print(E[i])
print()

A,B=Alignement(S1, S2, E)
print("Alignement de S1 et S2:")
print(A)
print(B)


