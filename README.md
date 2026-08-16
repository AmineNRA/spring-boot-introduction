# Spring Boot Introduction

Projet d'introduction à Spring Boot servant de support de cours et de pratique pour la prise en main de l'écosystème Spring en backend Java.

---

## À propos du projet

Ce dépôt contient l'implémentation des fonctionnalités de base d'un service backend RESTful. L'objectif est de structurer une application Java selon une architecture en couches (Controller, Service, Repository) et de gérer la persistance des données.

### Technologies utilisées

* **Java** : JDK 21
* **Framework** : Spring Boot (Spring Web, Spring Data JPA)
* **Outillage & Librairies** : Lombok, Maven
* **Base de données** : PostgreSQL
* **Tests d'API** : Postman / Insomnia

---

## Prérequis

Avant de démarrer le projet, assurez-vous d'avoir installé :

* Java JDK 21
* PostgreSQL (avec une base de données créée et configurée)
* Git
* Un IDE compatible (IntelliJ IDEA, Eclipse, VS Code)

---

## Configuration, installation et démarrage

1. **Cloner le projet**
   ```bash
   git clone git@github.com:AmineNRA/spring-boot-introduction.git
   cd spring-boot-introduction
   ```
2. **Properties**
   Vérifiez ou adaptez les paramètres de connexion PostgreSQL dans le fichier src/main/resources/application.properties
   server.port=5323

  spring.datasource.url=jdbc:postgresql://localhost:5432/votre_base_de_donnees
  spring.datasource.username=votre_utilisateur
  spring.datasource.password=votre_mot_de_passe

  3. **Lancer l'application**
     ```bash
     ./mvnw spring-boot:run
     ```
