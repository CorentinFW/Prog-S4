#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>

#define PORT 5000

int main() {
    int serverSocket, clientSocket;
    struct sockaddr_in serverAddr, clientAddr;
    char buffer[1024];
    socklen_t addr_size;

    // création de la socket TCP
    serverSocket = socket(AF_INET, SOCK_STREAM, 0);

    // initialisation de la structure de l'adresse du serveur
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(PORT);
    serverAddr.sin_addr.s_addr = INADDR_ANY;

    // attachement de la socket à l'adresse du serveur
    bind(serverSocket, (struct sockaddr*)&serverAddr, sizeof(serverAddr));

    // mise en écoute de la socket
    listen(serverSocket, 5);

    while(1) {
        // acceptation de la connexion entrante
        addr_size = sizeof(clientAddr);
        clientSocket = accept(serverSocket, (struct sockaddr*)&clientAddr, &addr_size);

        // réception du message du client
        recv(clientSocket, buffer, 1024, 0);
        printf("Received from client: %s\n", buffer);

        // envoi de la réponse au client
        strcpy(buffer, "Hello, client!");
        send(clientSocket, buffer, strlen(buffer), 0);

        // fermeture de la connexion avec le client
        close(clientSocket);
    }

    // fermeture de la socket du serveur
    close(serverSocket);

    return 0;
}
