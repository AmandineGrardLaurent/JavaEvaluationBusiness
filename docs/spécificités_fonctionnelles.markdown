# Spécifications Fonctionnelles – Application Vente de Formations

## 1. Acteurs
- **Utilisateur non connecté** : peut consulter les formations.
- **Utilisateur connecté** : peut gérer son panier, valider ses commandes et consulter son historique, en plus de consulter les formations.

## 2. Cas d'utilisation

### 2.1 Afficher les formations
- **Acteurs** : Utilisateur non connecté, Utilisateur connecté
- **Description** : Permet de visualiser la liste de toutes les formations.
- **Options** :
  - Filtrer par type : présentiel, en ligne ou mixte
  - Rechercher par mot-clé dans le titre ou la description

### 2.2 Se connecter
- **Acteur** : Utilisateur non connecté
- **Description** : Permet à un utilisateur de saisir son login et son mot de passe afin d'accéder aux fonctionnalités avancées.

### 2.3 Gérer son panier
- **Acteur** : Utilisateur connecté
- **Description** : Permet d’ajouter ou de retirer des formations avant validation.
- **Fonctionnalités** :
  - Afficher le contenu actuel du panier
  - Ajouter une formation par son identifiant
  - Supprimer une formation par son identifiant

### 2.4 Valider une commande
- **Acteur** : Utilisateur connecté
- **Description** : Permet de finaliser l’achat des formations présentes dans le panier.
- **Règles** :
  - Le panier ne doit pas être vide
  - Le montant total est calculé et la commande est enregistrée en base
  - Le panier est vidé après validation

### 2.5 Afficher ses commandes
- **Acteur** : Utilisateur connecté
- **Description** : Permet de consulter l’historique des commandes passées.
- **Détails affichés** :
  - Date de la commande
  - Montant total
  - Liste des formations commandées

### 2.6 Créer un compte
- **Acteur** : Utilisateur non connecté
- **Description** : Permet à l'utiloisateur de se connecter pour ensuite bénéficier des avantages d'un utilisateur connecté.


## 3. Règles fonctionnelles
1. Les actions de gestion du panier, de validation des commandes et d’affichage des commandes nécessitent une authentification.
2. La consultation des formations est accessible à tous les utilisateurs.
3. Le panier peut être modifié autant de fois que nécessaire avant validation.
4. Une commande ne peut être validée que si le panier contient au moins une formation.
5. Seul l’utilisateur ayant passé une commande peut consulter son historique.
