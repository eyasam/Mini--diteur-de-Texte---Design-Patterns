# Mini-Éditeur de Texte - TP2 OMD

## Description du Projet
Ce projet vise à développer un mini-éditeur de texte en appliquant des concepts de conception orientée objet et des **design patterns** standard pour améliorer la structure et la maintenabilité du code. Le projet est divisé en deux versions :

- **V1** : Implémentation des fonctionnalités de base d’édition (sélection, copier, couper, coller) en utilisant le **pattern Command**.
- **V2** : Ajout de fonctionnalités avancées comme l'annulation, la répétition et l'enregistrement des actions, en utilisant le **pattern Memento**.

## Fonctionnalités
### Version 1
- **Sélection de texte** : Permet à l'utilisateur de sélectionner une portion de texte.
- **Copier** : Copie la sélection dans le presse-papier.
- **Couper** : Copie la sélection dans le presse-papier puis l’efface du texte.
- **Coller** : Remplace la sélection actuelle par le contenu du presse-papier.

### Version 2
- **Défaire/Refaire** : Annule ou restaure les dernières actions, avec un historique basé sur le pattern Memento.
- **Enregistrement et Rejouer les actions** : Enregistre une séquence d’actions qui peut être rejouée ultérieurement.

## Conception et Design Patterns
### Version 1 - Pattern Command
Pour la version 1, nous avons choisi d'implémenter le **pattern Command** comme décrit dans [cette page](https://refactoring.guru/fr/design-patterns/command). Ce pattern permet d'encapsuler chaque action (comme Copier, Couper et Coller) en tant qu'objet de commande, ce qui simplifie l’extension et la modification des actions disponibles.

Les diagrammes ci-dessous illustrent la conception de la version 1 :
- **Diagramme de Cas d'Utilisation**
  
  [Diagramme de Cas d'Utilisation - Version 1](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/raw/main/Conception/V1/Use_Case_V1.png)

- **Diagramme de Classe** : 

  [Diagramme de Classe - Version 1](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V1/classe_V1.png)

    - EditeurBuffer contient un PressePapier pour stocker le texte.
    - InterfaceUtilisateur utilise une liste de Bouton pour permettre à l’utilisateur de déclencher des actions spécifiques dans l’éditeur.
    - Bouton possède un objet Command pour exécuter une action lorsqu'il est activé.
    - Chaque commande interagit directement avec le texte de l'éditeur.
    - Selection hérite de Command pour représenter des actions spécifiques de manipulation de la sélection.
    - Les classes Copier, Couper et Coller héritent de Command, ce qui leur permet d’exécuter des actions distinctes tout en suivant une interface commune définie par Command.
    - Les classes DeplacerSelectionGauche et DeplacerSelectionDroite héritent de Selection pour modifier la position de la sélection dans le texte, en la déplaçant respectivement vers la gauche ou la droite.

- Diagrammes de Séquence :

  - **Séquence Couper** : [Diagramme de séquence pour la fonctionnalité - Couper](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V1/couper_seq.png)
  - **Séquence Copier** : [Diagramme de séquence pour la fonctionnalité - Copier](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V1/copier_seq.png)
  - **Séquence Coller** : [Diagramme de séquence pour la fonctionnalité - Coller](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V1/coller_seq.png)


### Version 2 - Pattern Memento
Pour la version 2, nous avons introduit le **pattern Memento** pour gérer l'historique des actions, comme expliqué dans [cette page](https://refactoring.guru/fr/design-patterns/memento). Ce pattern permet de sauvegarder et de restaurer l'état de l'éditeur, facilitant la fonctionnalité d'annulation et de répétition des actions.

Les diagrammes ci-dessous illustrent la conception de la version 2 :
- **Diagramme de Cas d'Utilisation**

  [Diagramme de Cas d'Utilisation - Version 2](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V2/use_case_v2.png)

- **Diagramme de Classe** : 

  [Diagramme de Classe - Version 2](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V2/diag_classe_v2.png)

  Nous avons ajouté à la version V1 les classes suivantes :

  - **Classe Memento :** Stocke une instance de l'état de l'éditeur ce qui permet de restaurer un état précédent de l'éditeur.

  - **Classe Historique :** Utilise deux piles pour gérer les actions "annuler" et "rétablir" en enregistrant un état après chaque modification, ce qui permet de naviguer entre les états précédents et futurs de l’éditeur.



  - **Classe EnregistrerAction :** Sous-classe de Command qui permet d'enregistrer une séquence d'actions dans une liste pour les rejouer ultérieurement.

  - **Classe RejouerAction :** Sous-classe de Command pour exécuter automatiquement une séquence d'actions enregistrée dans EnregistrerAction.

  - **Classes DefaireAction et RefaireAction :** Gèrent l'annulation et la répétition des actions en utilisant la classe Historique.


- **Diagrammes de Séquence** :
  - **Défaire les actions** : [Diagramme de séquence pour la fonctionnalité  - Défaire les actions](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V2/defaire_seq.png)

  - *Refaire les actions* : [Diagramme de séquence pour la fonctionnalité - Refaire les actions](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V2/refaire_seq.png)

  - *Enregistrer les actions* : [Diagramme de séquence pour la fonctionnalité - Enregistrer les actions](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V2/enregistrer_seq.png)

  
  - *Rejouer les actions* : [Diagramme de séquence pour la fonctionnalité - Rejouer les actions](https://gitlab.istic.univ-rennes1.fr/esammari/tp2_omd_designpattern/-/blob/main/Conception/V2/rejouer_seq.png)



## Installation et Exécution
1. Clonez le dépôt : `git clone <lien_du_projet>`
2. Ouvrez le projet dans un IDE (Eclipse ou VSCode).
3. Exécutez la classe `Main` pour lancer chaque version.
4. Utilisez l’interface pour tester les commandes de copie, couper, coller, ainsi que les fonctionnalités d’annulation et d’enregistrement (voir demo).

## Technologies et Outils Utilisés
- **Java** : Langage de programmation.
- **PlantUML** : Outil pour la création des diagrammes UML.
- **draw.io** : Outil pour la création des diagrammes UML.
- **Eclips** : Environnements de développement intégrés pour l'implémentation du code en Java.
- **VSCode** : Editeur de code pour utiliser PlantUML.

## Auteurs
- **Eya SAMMARI** 
- **Mey CHERIF**


