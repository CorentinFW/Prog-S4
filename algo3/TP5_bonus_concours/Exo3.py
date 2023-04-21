N = int(input("Donne moi le nombre de liste = "))
L = input("donne moi leur longueur et sépare les d'un espace")
print(N)
print(L)
print(L.split())
S = L.split()
print(len(L.split()) == N)
if(len(S) != N):
    print("Erreur de taille")
    exit()
for i in range(N-1):
    if type(S[i]) != int:
        print("Erreur de typage")
        exit()
stam = 0
L = []
L.append(S)
for i in range(N-1):
    