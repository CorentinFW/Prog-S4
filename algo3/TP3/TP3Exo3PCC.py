from dessinsVilles import * 

def Floyd_warshall(n,Adj,pcc,DernierPas):
    #
    # A COMPLETER
    #
    pass #A SUPPRIMER



n=4
Adj=[[0,2,6,10],[np.inf,0,1,np.inf],[np.inf,np.inf,0,4],[np.inf,np.inf,7,0]]
DernierPas=[[-1]*n for i in range(n)]
pcc=[[0]*n for i in range(n)]

Floyd_warshall(n,Adj,pcc,DernierPas)

print("Matrice d'adjacence pondérée: ",Adj,"\n")
print("Matrice des longueurs des pccs: ",pcc,"\n")

print("Matrice des derniers pas: ",DernierPas,"\n")
