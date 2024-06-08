# Projet d'échecs en Java

Ce projet est une implémentation simple d'un jeu d'échecs en Java. Il utilise JavaFX pour l'interface utilisateur et suit les règles standard du jeu d'échecs.

## Caractéristiques

- Jeu d'échecs complet avec toutes les pièces et mouvements.
- Interface utilisateur graphique avec JavaFX.
- Les mouvements valides de chaque pièce sont mis en évidence lors de la sélection.
- Les pièces peuvent être déplacées en cliquant et en relâchant sur la case de destination.

## Installation

Ce projet utilise Maven pour la gestion des dépendances. Assurez-vous d'avoir installé [Maven](https://maven.apache.org/download.cgi) et [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) ou une version ultérieure.

Pour construire le projet, clonez le dépôt et utilisez Maven pour compiler et exécuter :

```bash
git clone https://github.com/RIBBE-Jules-23010523/chessjava
cd chessjava
mvn clean install
mvn exec:java