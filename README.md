# 📚 Application de Vente de Formations (Console Java)

## Description du projet

Ce projet est une application **Java en mode console** permettant la vente de formations.  
Elle a été développée selon une **architecture multicouche (Model / DAO / Service)**.

L’application permet :
- aux utilisateurs **non connectés** de consulter les formations
- aux utilisateurs **connectés** de gérer un panier et des commandes
- la persistance des données via une **base de données relationnelle**

---

## Objectifs pédagogiques

- Mettre en pratique l’architecture **DAO / Service**
- Implémenter des **use cases fonctionnels**
- Manipuler JDBC et une base de données SQL
- Structurer un projet Java proprement

---

## Types d’utilisateurs

### Utilisateur non connecté
- Afficher toutes les formations
- Rechercher des formations par mot-clé
- Filtrer les formations (présentiel, en ligne, mixte)
- Créer un compte utilisateur
- Se connecter

### Utilisateur connecté
- Consulter les formations
- Gérer son panier (ajout / suppression)
- Valider une commande
- Consulter l’historique de ses commandes
- Se déconnecter

---

## Fonctionnalités principales

- 📖 Affichage des formations
- 🔍 Recherche par mot-clé
- 🛒 Gestion du panier
- 🧾 Gestion des commandes
- 🔐 Authentification utilisateur

---

## Architecture du projet
```
database
│   ├── data.sql
│   ├── schema.sql
│
docs
│
src
    ├──training.sales.application
        │
        ├── model
        │   ├── Cart.java
        │   ├── Course.java
        │   ├── Customer.java
        │   ├── Order.java
        │   ├── OrderCourse.java
        │   ├── Person.java
        │   └── User.java
        │
        ├── dao
        │   ├── CartDAO.java
        │   ├── CourseDAO.java
        │   ├── DatabaseConnection.java
        │   ├── OrderDAO.java
        │   ├── OrderCourseDAO.java
        │   └── UserDAO.java
        │
        ├── service
        │   ├── CartService.java
        │   ├── CourseService.java
        │   ├── OrderService.java
        │   └── UserService.java
        │
        ├── Helper.java
        └── Main.java
│
config.properties

```

---

## Base de données

### Initialisation

Avant de lancer l’application, la base de données doit être initialisée avec les scripts fournis.

Dans votre terminal SQL :

```sql
source schema.sql;
source data.sql;
```
---
--- 

## Configuration de la base de données

Avant de lancer l'application, assurez-vous que le fichier `config.properties` est correctement configuré.  
Il contient les informations de connexion à la base de données :

```properties
db.url=jdbc:mysql://localhost:3306/training_sales_application
db.user=YOUR_USER
db.password=YOUR_PASSWORD
```
- db.url : URL de connexion à la base de données
- db.user : Nom de l'utilisateur de la base
- db.password : mot de passe associé
---

## Lancer l'application

1. Cloner le projet
2. Initialiser la base de données (schema + data)
3. Ajouter le fichier 'config.properties' pour la connection JCDB
4. Inclure le driver MariaDB (présent dans le fichier lib) dans le classpath lors de la compilation et l'execution
5. Lancer la classe Main

---
## Technologies utilisées

- Java
- JDBC
- SQL
- Architecture DAO
- UML 

---
## Documentation UML

- Diagramme de cas d'utilisation
- Diagrmame de classe
- Diagrammes de séquence
- MCD
- Fiches de description textuelle des use case

---

## Exemple d'utilisation

1. **Lancer l’application**

```bash
cd path/to/project
javac -d bin src/training/sales/application/*.java src/training/sales/application/model/*.java src/training/sales/application/dao/*.java src/training/sales/application/service/*.java
java -cp bin training.sales.application.Main
```

2. **Exemple d'affichage pour un utilisateur non conncté**

```yaml
[1] Afficher la liste de toutes les formations
[2] Afficher les formations en présentiel
[3] Afficher les formations en ligne
[4] Afficher les formations mixtes
[5] Rechercher les formations avec un mot-clé
[6] Se connecter
[7] Quitter

Quel est votre choix ? 1
La liste des formations :

| 1   | Java Débutant                  | Bases du langage Java et programmation orientée objet             | 5 jours    | mixte           | 1200.0 €   |
| 2   | Java Avancé                    | Approfondissement Java, collections, streams et bonnes pratiques  | 4 jours    | en présentiel   | 1500.0 €   |
| 3   | UML et Modélisation            | Diagrammes UML : cas d’utilisation, classes et séquences          | 3 jours    | en ligne        | 900.0 €    |
| 4   | Base de données relationnelles | Conception MCD, MLD et SQL avec MySQL/MariaDB                     | 4 jours    | mixte           | 1100.0 €   |
| 5   | Spring Boot                    | Création d’API REST avec Spring Boot                              | 5 jours    | en ligne        | 1800.0 €   |
| 6   | Git et gestion de versions     | Utilisation de Git et GitHub en équipe                            | 2 jours    | mixte           | 600.0 €    |
| 7   | Python Débutant                | Introduction au langage Python et aux bases de la programmation   | 5 jours    | mixte           | 1100.0 €   |
| 8   | Python Avancé                  | Programmation avancée, modules, virtualenv et bonnes pratiques    | 4 jours    | en ligne        | 1400.0 €   |

```

3. **Exemple d'affichage pour un utilisateur connecté**

```yaml
Bonjour John Doe

[1] Afficher la liste de toutes les formations
[2] Afficher votre panier
[3] Ajouter une formation dans votre panier
[4] Supprimer une formation dans votre panier
[5] Valider votre panier
[6] Afficher mes commandes
[7] Se déconnecter

Quel est votre choix ? 2
Votre panier :

| 4   | Base de données relationnelles | Conception MCD, MLD et SQL avec MySQL/MariaDB                     | 4 jours    | mixte           | 1100.0 €   |
| 5   | Spring Boot                    | Création d’API REST avec Spring Boot                              | 5 jours    | en ligne        | 1800.0 €   |
| 9   | JavaScript Fondamentaux        | Bases de JavaScript pour le développement web                     | 3 jours    | mixte           | 900.0 €    |


Quel est votre choix ? 3
La liste des formations :

| 1   | Java Débutant                  | Bases du langage Java et programmation orientée objet             | 5 jours    | mixte           | 1200.0 €   |
| 2   | Java Avancé                    | Approfondissement Java, collections, streams et bonnes pratiques  | 4 jours    | en présentiel   | 1500.0 €   |
| 3   | UML et Modélisation            | Diagrammes UML : cas d’utilisation, classes et séquences          | 3 jours    | en ligne        | 900.0 €    |

Saisissez l'id de la formation que vous souhaitez ajouter : 
1
Formation ajoutée à votre panier

```

---
#### Auteur 

Amandine Grard-Laurent


