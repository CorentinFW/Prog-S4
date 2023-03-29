#include <netinet/in.h>
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
  if (argc != 3) //TODO
      {
    printf("On vous a dit que les paramètres étaient : %s ip_serveur port_serveur  faites un effort !!!! \n", argv[0]);
    exit(1);
    }

  /* Etape 1 : créer une socket */   
  int MaSocket = socket(AF_INET,SOCK_DGRAM,0);//TODO

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
 struct sockaddr_in MonAdr;//struct important pour les socket
 memset(&MonAdr, 0, sizeof(MonAdr));//initialiser les valeurs
 MonAdr.sin_family = AF_INET;//addr ipv4
 MonAdr.sin_addr.s_addr = htonl(INADDR_ANY);//adr local
 MonAdr.sin_port = htons(0);//numero du port

//bind fonction qui relie une socket a une adress
if(bind(MaSocket,(struct sockaddr*)&MonAdr,sizeof(MonAdr))==-1){
   perror("Erreur la connection n'a pas pu etre établie");//affcihe une erreur 
   exit(1);//le int dans le exit c'est le boolean associer avec 1 = false 
}
  /* Etape 3 :Il faut désigner la socket du Perroquet +Trace */
  struct sockaddr_in PerAddr;
   memset(&PerAddr,0,sizeof(PerAddr));
   PerAddr.sin_family = AF_INET;//addr ipv4
   PerAddr.sin_port = htons(atoi(argv[2]));//numero du port
   
   if(inet_pton(AF_INET, argv[1], &PerAddr.sin_addr)==0){//on verifier qu'on a bien converti l'ip
      perror("erreur lors de la conversion de l'addresse IP");
      exit(1);
   }

  /* Etape 4 : On envoie un seul message au perroquet +Trace (*/
  char* msg = "Cc le perroquet ";
  int taillemsg = strlen(msg);

  if(sendto(MaSocket, msg, taillemsg, 0, (struct sockaddr*)&PerAddr, sizeof(struct sockaddr)) == -1){
   perror("echec de l'envoie du msg");
   close(MaSocket);
   exit(1);
  }
  
  /* Etape 5 : On recoit le même message +Trace*/
  char buffer[1024];
  int tailleBuffer = sizeof(buffer);

  socklen_t tailleAdresse = sizeof(PerAddr);

  // On recoit le message avec la fonction recvfrom
  if (recvfrom(MaSocket, buffer, tailleBuffer, 0, (struct sockaddr*)&PerAddr, &tailleAdresse) == -1) {
    perror("Client : Erreur lors de la reception du message");
    close(MaSocket);
    exit(1);
  }
  
  /* Etape 6 : On ferme la socket proprement pour éviter les erreurs*/
  close(MaSocket);
  
  
  
  printf("Client du perroquet  : Voilà c'est fini\n");//trace de fin
  return 0;
}
