#include <stdio.h> 
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <stdlib.h>
#include<arpa/inet.h>
#include<string.h>

/* Programme client */

int main(int argc, char *argv[]) {

  /* je passe en paramètre l'adresse de la socket du serveur (IP et
     numéro de port) */

  /* Je teste le passage de parametres. Le nombre et la nature des
     paramètres sont à adapter en fonction des besoins. Sans ces
     paramètres, l'exécution doit être arrétée, autrement, elle
     aboutira à des erreurs.*/
  if (argc != XXXXXX) //TODO
      {
    printf("On vous a dit que les paramètres étaient : %s ip_serveur port_serveur  faites un effort !!!! \n", argv[0]);
    exit(1);
    }

  /* Etape 1 : créer une socket */   
  int MaSocket = socket(XXXXXX);//TODO

  /* /!\ : Il est indispensable de tester les valeurs de retour de
     toutes les fonctions et agir en fonction des valeurs
     possibles. Voici un exemple */
  if (MaSocket == -1){
    perror("Client : pb creation socket , on arrête tout:");
    exit(1); // je choisis ici d'arrêter le programme car le reste
	     // dépendent de la réussite de la création de la socket.
  }
  
  /* Des traces, toujours des traces*/
  printf("Client : Youpi j'ai créé une socket pour le client\n");
  
  // Il Faut TOUJOURS tester chaque étape avant de faire la suivante
  
  /* Etape 2 :On nomme ici   la socket du client */
    
  
  /* Etape 3 :Il faut désigner la socket du Perroquet +Trace */
  
  /* Etape 4 : On envoie un seul message au perroquet +Trace (*/
  
  /* Etape 5 : On recoit le même message +Trace*/
  
  /* Etape 6 : On ferme la socket proprement pour éviter les erreurs*/
  
  
  printf("Client du perroquet  : Voilà c'est fini\n");//trace de fin
  return 0;
}
