#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

#define PORT 5000
#define SERVER_IP "127.0.0.1"

int main() {
    int clientSocket;
    struct sockaddr_in serverAddr;
    char buffer[1024];

    // création de la socket TCP
    clientSocket = socket(AF_INET, SOCK_STREAM, 0);

    // initialisation de la structure de l'adresse du serveur
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(PORT);
    serverAddr.sin_addr.s_addr = inet_addr(SERVER_IP);

    // connexion au serveur
    connect(clientSocket, (struct sockaddr*)&serverAddr, sizeof(serverAddr));

    // envoi du message au serveur
    char messageUser[120];
    scanf("%s",messageUser); 
    strcpy(buffer, messageUser);
    send(clientSocket, buffer, strlen(buffer), 0);

    // réception de la réponse du serveur
    recv(clientSocket, buffer, 1024, 0);
    printf("Received from server: %s\n", buffer);

    // fermeture de la connexion avec le serveur
    close(clientSocket);

    return 0;
}
