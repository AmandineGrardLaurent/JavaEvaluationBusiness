# Fiches de Description des Use Cases – Application Vente de Formations

---

## Use Case 1 : Afficher les formations

- **Acteur principal** :  
  Utilisateur non connecté, Utilisateur connecté

- **Description** :  
  Permet à l’utilisateur de consulter les formations disponibles et de les filtrer selon différents critères.

- **Préconditions** :  
  - L’application est lancée.
  - La base de données est accessible.

- **Scénario nominal** :  
  1. L’utilisateur sélectionne l’option « Afficher les formations ».
  2. Le système récupère la liste des formations.
  3. Le système affiche la liste des formations disponibles.
  4. L’utilisateur peut appliquer un filtre (présentiel, en ligne, mixte) ou effectuer une recherche par mot-clé.
  5. Le système affiche la liste des formations correspondant aux critères sélectionnés.

- **Scénarios alternatifs / Exceptions** :  
  - **3a.** Aucune formation n’est disponible ou aucun résultat ne correspond aux critères :  
    → Le système affiche le message : *« Aucune formation trouvée »*.


---

## Use Case 2 : Se connecter

- **Acteur principal** : Utilisateur non connecté  
- **Description** : Permet à l’utilisateur de s’authentifier pour accéder aux fonctionnalités avancées (panier, commandes).  
- **Préconditions** : L’utilisateur possède un compte valide.  
- **Scénario principal** :  
  1. L’utilisateur saisit son login et mot de passe.  
  2. Le système vérifie les informations et authentifie l’utilisateur.  
  3. L’utilisateur accède aux options réservées aux utilisateurs connectés.  
- **Extensions / Exceptions** :  
  - Login ou mot de passe incorrect : le système affiche un message d’erreur et propose de ressaisir les informations.

---

## Use Case 3 : Gérer son panier

- **Acteur principal** : Utilisateur connecté  
- **Description** : Permet d'afficher le panier et d’ajouter ou retirer des formations avant de passer une commande.  
- **Préconditions** : L’utilisateur est authentifié.  
- **Scénario principal** :  
  1. L’utilisateur consulte son panier actuel.  
  2. L’utilisateur ajoute une formation en saisissant son identifiant.  
  3. L’utilisateur supprime une formation en saisissant son identifiant.  
- **Extensions / Exceptions** :  
  - Tentative d’ajout d’une formation inexistante : le système affiche un message d’erreur.  
  - Tentative de suppression d’une formation absente du panier : le système affiche un message d’erreur.

---

## Use Case 4 : Valider une commande

- **Acteur principal** : Utilisateur connecté  
- **Description** : Permet de finaliser l’achat des formations présentes dans le panier.  
- **Préconditions** : L’utilisateur est authentifié et le panier contient au moins une formation.  
- **Scénario principal** :  
  1. L’utilisateur choisit l’option de validation de commande.  
  2. Le système calcule le montant total et enregistre la commande.  
  3. Le panier est vidé après validation.  
- **Extensions / Exceptions** :  
  - Panier vide : le système empêche la validation et affiche un message d’erreur.

---

## Use Case 5 : Afficher ses commandes

- **Acteur principal** : Utilisateur connecté  
- **Description** : Permet à l’utilisateur de consulter l’historique de ses commandes passées.  
- **Préconditions** : L’utilisateur est authentifié 
- **Scénario principal** :  
  1. L’utilisateur choisit l’option « Afficher mes commandes ».  
  2. Le système affiche la liste des commandes avec la date, le montant total et les formations achetées.  
- **Extensions / Exceptions** :  
  - Aucune commande passée : le système affiche « Vous n’avez aucune commande ».

---

## Use Case 6 : Créer un compte utilisateur

- **Acteur principal :** Utilisateur non connecté

- **Description :** Permet à un utilisateur non connecté de créer un compte afin de pouvoir se connecter et passer des commandes.

- **Pré-condition :** L’utilisateur n’a pas de compte ou n’est pas connecté.

- **Post-condition :** Un compte utilisateur est créé avec un login et un mot de passe. L’utilisateur peut désormais se connecter pour gérer son panier et passer des commandes.

- **Scénario principal** :
    1. L’utilisateur sélectionne « Créer un compte » dans le menu.  
    2. Le système demande à l’utilisateur de saisir :  
        - Login  
        - Mot de passe  
        - Nom
        - Prénom   
    3. Le système vérifie que le login n’existe pas déjà.  
    4. Le compte est créé et l’utilisateur est informé de la réussite.  
    5. L’utilisateur peut maintenant se connecter.

- **Extensions / variantes**
    - Login déjà existant : 
        - Le système affiche un message d’erreur.  
        - L’utilisateur peut réessayer avec un autre login.  

    - Informations invalides ou manquantes :
        - Le système affiche un message d’erreur.  
        - L’utilisateur doit corriger les informations.
