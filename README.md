# Application de Gestion d’une Agence Médiatrice de Vente de Voitures

Mini-projet Java réalisé dans le cadre du module **Programmation Orientée Objet en Java**.

## Description

Cette application console simule le fonctionnement d’une agence de médiation automobile.  
L’agence joue le rôle d’intermédiaire entre des vendeurs de voitures d’occasion et des acheteurs potentiels.

L’application permet de gérer les vendeurs, acheteurs, agents, voitures, annonces, demandes d’achat, rendez-vous de médiation et transactions.

## Fonctionnalités

- Gestion des personnes :
  - vendeurs
  - acheteurs
  - agents

- Gestion des voitures :
  - ajout d’une voiture
  - affichage des voitures disponibles
  - modification des informations
  - suppression
  - recherche multicritères

- Gestion des annonces :
  - création d’annonce
  - affichage
  - modification
  - désactivation
  - suivi de l’état de l’annonce

- Gestion des demandes d’achat :
  - création d’une demande
  - suivi par un agent
  - association avec des voitures correspondantes

- Module de médiation :
  - association entre acheteur et annonce
  - prise de contact
  - planification de rendez-vous

- Gestion des transactions :
  - création d’une transaction
  - finalisation ou annulation
  - calcul automatique des frais de médiation de 3 %

## Concepts POO utilisés

Ce projet applique plusieurs concepts fondamentaux de la programmation orientée objet :

- Encapsulation
- Héritage
- Polymorphisme
- Abstraction
- Classes abstraites
- Interfaces
- Énumérations

## Architecture du projet

Le projet est organisé en plusieurs packages :

```text
agence.enums        -> Énumérations représentant les états du système
agence.interfaces   -> Interfaces et contrats de comportement
agence.modele       -> Classes métier principales
agence.service      -> Logique métier et opérations CRUD
agence.main         -> Point d’entrée de l’application et menu console
