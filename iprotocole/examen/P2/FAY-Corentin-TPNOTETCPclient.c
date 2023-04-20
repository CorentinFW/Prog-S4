#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

#define PORT 5000

int main() {
    char buffer[1024];
    char message[1024];

    // création de la socket TCP
    int clientSocket = socket(AF_INET, SOCK_STREAM, 0);

    // initialisation de la structure de l'adresse du serveur
    struct sockaddr_in serverAddr;
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(PORT);
    serverAddr.sin_addr.s_addr = inet_addr("127.0.0.1");

    // connexion au serveur
    if(connect(clientSocket, (struct sockaddr*)&serverAddr, sizeof(serverAddr))== -1){
        perror("Erreur : connection a la socket a échouer");
        exit(EXIT_FAILURE);
    }

    while(1) {
        // lecture du message à envoyer
        printf("Enter message: ");
        fgets(message, 1024, stdin);

        // envoi du message au serveur avec un caractère de fin de message
        snprintf(buffer, sizeof(buffer), "%s\n", message);
        send(clientSocket, buffer, strlen(buffer), 0);

        // réception de la réponse du serveur
        recv(clientSocket, buffer, 1024, 0);
        printf("Received from server: %s", buffer);
    }

    // fermeture de la connexion avec le serveur
    close(clientSocket);

    return 0;
}
