#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <arpa/inet.h>

#define PORT 42540


int main(int argc, char const *argv[]) {
    int serverSocket, clientSocket, addrlen;
    struct sockaddr_in serverAddr, clientAddr;
    char buffer[1025];

    // création de la socket du serveur
    if ((serverSocket = socket(AF_INET, SOCK_STREAM, 0)) == 0) {
        perror("Erreur : création de la socket du serveur a échoué");
        exit(EXIT_FAILURE);
    }

    // configuration de la socket du serveur
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_addr.s_addr = INADDR_ANY;
    serverAddr.sin_port = htons(PORT);

    // attachement de la socket du serveur à l'adresse et au port spécifiés
    if (bind(serverSocket, (struct sockaddr*)&serverAddr, sizeof(serverAddr)) < 0) {
        perror("Erreur : attachement de la socket du serveur à l'adresse et au port spécifiés a échoué");
        exit(EXIT_FAILURE);
    }



    printf("Serveur TCP démarré sur le port %d\n", PORT);

    while (1) {
        addrlen = sizeof(clientAddr);

        // attente de la connexion d'un client
        if ((clientSocket = accept(serverSocket, (struct sockaddr*)&clientAddr, (socklen_t*)&addrlen)) < 0) {
            perror("Erreur : acceptation de la connexion d'un client a échoué");
            exit(EXIT_FAILURE);
        }

        printf("Connecté à un client %s:%d\n", inet_ntoa(clientAddr.sin_addr), ntohs(clientAddr.sin_port));

        // traitement des requêtes du client
        while (1) {
            ssize_t numBytes = recv(clientSocket, buffer, sizeof(buffer)-1, 0);

            if (numBytes < 0) {
                perror("Erreur : réception de données du client a échoué");
                break;
            } else if (numBytes == 0) {
                printf("Client %s:%d déconnecté\n", inet_ntoa(clientAddr.sin_addr), ntohs(clientAddr.sin_port));
                break;
            }

            buffer[numBytes] = '\0';

            // recherche de la séquence de fin de message
            char *endSequence = strstr(buffer, "\r\n");

            if (endSequence != NULL) {
                // fin de message trouvée
                *endSequence = '\0';

                // traitement du message
                printf("Reçu du client %s:%d : %s\n", inet_ntoa(clientAddr.sin_addr), ntohs(clientAddr.sin_port), buffer);

                // envoi de la réponse au client
                send(clientSocket, "OK\r\n", 5, 0);
            } else if (numBytes == sizeof(buffer)-1) {
                 // Le message est trop long pour le buffer
    printf("Message too long\n");
    close(clientSocket);
    continue;
}

// Ajouter le caractère de fin de chaîne
buffer[numBytes] = '\0';

// Afficher le message reçu
printf("Received message from client: %s\n", buffer);

// Envoyer une réponse au client
char response[] = "Message received by server";
if (send(clientSocket, response, sizeof(response), 0) == -1) {
    perror("send");
    close(clientSocket);
    exit(1);
}

// Fermer la connexion avec le client
close(clientSocket);
}

// Fermer la socket du serveur
close(serverSocket);

return 0;
}}
