/* Nom :FAY
 Prénom : Corentin
 Numéro d'étudiant:22013398
 Nom de ma machine :0906
 Adresse IP de ma machine ::
 Port(s) utilisé(s) : 42540
 */

//je n'ai pas reussi a faire marcher mon code

#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <stdlib.h>
#include<arpa/inet.h>
#include<string.h>

/* Programme serveur */
int main(int argc, char *argv[]) {

  /* je passe en paramètre l'adresse de la socket du serveur (IP et
     numéro de port) si besoin est je modifie s'il y a besoin de plus de paramètres */

  /* Je teste le passage de parametres. Le nombre et la nature des
     paramètres sont à adapter en fonction des besoins.
   Sans ces paramètres, l'exécution doit être arrétée, autrement, elle
     aboutira à des erreurs. Les processus doivent aussi être fermés*/
    
  if (argc != 3) //TODO
      {
    printf("On vous a dit que les paramètres étaient : %s ip_serveur port_serveur  faites un effort !!!! \n", argv[0]);
    exit(1);
    }

  /* Etape 1 : créer une socket Serveur*/   
  int SocketServUDP = socket(AF_INET,SOCK_DGRAM,0);//TODO

  /* /!\: Il est indispensable de tester TOUTES les valeurs de retour de
     toutes les fonctions et agir en fonction des valeurs
     possibles.
   Voici un exemple */
      
  if (SocketServUDP == -1){
    perror("Serveur : pb creation socket , on arrête tout:");
    exit(1); // je choisis ici d'arrêter le programme car le reste
	     // est dépendant de la réussite de la création de la socket.
  }
  
  /* Des traces, toujours des traces*/
  printf("Serveur : Début du TP noté\n");
  
// Il Faut TOUJOURS tester chaque étape avant de faire la suivante
// J'écris en commentaires toutes les étapes qui correspondent à toutes les questions
//ETAPE 2 :
  struct sockaddr_in AdrCLientTP;//struct important pour les socket
 memset(&AdrCLientTP, 0, sizeof(AdrCLientTP));//initialiser les valeurs
 AdrCLientTP.sin_family = AF_INET;//addr ipv4
 AdrCLientTP.sin_addr.s_addr = htonl(INADDR_ANY);//adr local
 AdrCLientTP.sin_port = htons(0);//numero du port

//bind fonction qui relie une socket a une adress
if(bind(SocketServUDP,(struct sockaddr*)&AdrCLientTP,sizeof(AdrCLientTP))==-1){
   perror("Erreur la connection n'a pas pu etre établie");//affcihe une erreur 
   exit(1);//le int dans le exit c'est le boolean associer avec 1 = false 
}
  struct sockaddr_in AdrSErveurTP;
   memset(&AdrSErveurTP,0,sizeof(AdrSErveurTP));
   AdrSErveurTP.sin_family = AF_INET;//addr ipv4
   AdrSErveurTP.sin_port = htons(atoi(argv[2]));//numero du port
   
   if(inet_pton(AF_INET, argv[1], &AdrSErveurTP.sin_addr)==0){//on verifier qu'on a bien converti l'ip
      perror("erreur lors de la conversion de l'addresse IP");
      exit(1);
   }

  char* msg = "Cc le perroquet ";
  int taillemsg = strlen(msg);

  if(sendto(SocketServUDP, msg, taillemsg, 0, (struct sockaddr*)&AdrSErveurTP, sizeof(struct sockaddr)) == -1){
      //la connexion/socket, le message, sa taille, option, socket qui reçois, a copier jsp exactement
   perror("echec de l'envoie du msg");
   close(SocketServUDP);
   exit(1);
  }
  
  char buffer[1024];
  int tailleBuffer = sizeof(buffer);

  socklen_t tailleAdresse = sizeof(AdrSErveurTP);

  // On recoit le message avec la fonction recvfrom
  if (recvfrom(SocketServUDP, buffer, tailleBuffer, 0, (struct sockaddr*)&AdrSErveurTP, &tailleAdresse) == -1) {
    perror("Client : Erreur lors de la reception du message");
    close(SocketServUDP);
    exit(1);
  }

  
  /*On ferme la socket proprement pour éviter les erreurs*/
  close(SocketServUDP);
  
  printf("Client du TP noté : Voilà c'est fini, j'ai réussi \n");//trace de fin
  return 0;
}
