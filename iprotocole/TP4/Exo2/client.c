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
    serv_addr.sin_addr.s_addr = inet_addr("127.0.0.1");
    serv_addr.sin_port = htons(8080);

    // Affichage du numéro de port avant l'appel à connect()
    printf("Numéro de port avant connect() : %d\n", ntohs(serv_addr.sin_port));

    // Connexion à la socket du serveur
    if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {
        perror("Erreur lors de la connexion à la socket");
        exit(EXIT_FAILURE);
    }

    // Récupération du numéro de port réellement obtenu
    struct sockaddr_in local_addr;
    socklen_t len = sizeof(local_addr);
    if (getsockname(sockfd, (struct sockaddr *)&local_addr, &len) < 0) {
        perror("Erreur lors de la récupération du numéro de port");
        exit(EXIT_FAILURE);
    }

    // Affichage du numéro de port réellement obtenu
    printf("Numéro de port après connect() : %d\n", ntohs(local_addr.sin_port));

    // Fermeture de la socket
    close(sockfd);

    return 0;
}
