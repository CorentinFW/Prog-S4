#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    // Création de la socket
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("Erreur lors de la création de la socket");
        exit(EXIT_FAILURE);
    }

    // Remplissage de la structure sockaddr_in avec l'adresse et le port du serveur
    struct sockaddr_in serv_addr;
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = INADDR_ANY;
    serv_addr.sin_port = htons(8080);

    // Attachement de la socket à l'adresse et au port du serveur
    if (bind(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {
        perror("Erreur lors de l'attachement de la socket");
        exit(EXIT_FAILURE);
    }

    // Mise en écoute de la socket
    if (listen(sockfd, 1) < 0) {
        perror("Erreur lors de la mise en écoute de la socket");
        exit(EXIT_FAILURE);
    }

    // Attente d'une connexion entrante
    struct sockaddr_in cli_addr;
    socklen_t len = sizeof(cli_addr);
    int newsockfd = accept(sockfd, (struct sockaddr *)&cli_addr, &len);
    if (newsockfd < 0) {
        perror("Erreur lors de l'acceptation de la connexion");
        exit(EXIT_FAILURE);
    }

    // Affichage des caractéristiques du client
    char *ip = inet_ntoa(cli_addr.sin_addr);
    printf("Client connecté depuis l'adresse IP %s et le port %d\n", ip, ntohs(cli_addr.sin_port));

    // Fermeture des sockets
    close(newsockfd);
    close(sockfd);

    return 0;
}
