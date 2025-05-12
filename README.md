Examen Langages & Frameworks Backend 1 . 
Présenté par :  
Aly Dieng, INE: N01437520191, 
Mamadou Saliou Diallo, INE : N02231320191. 
Sujet : Gestion simplifiée d'une bibliothèque 
INTRODUCTION :  
Ce projet est une API REST développée en Spring Boot pour la gestion des **livres** et 
**auteurs**. Il permet de créer, consulter, modifier et supprimer des livres associés à leurs 
auteurs. 
1.  INSTRUCTIONS D'EXECUTION 
L'application démarre sur : http://localhost:8080 
Appels API pour auteurs : http://localhost:8080/api/auteurs dans mon navigateur et 
sur Postman. 
Appels API pour livres : http://localhost:8080/api/livres dans mon navigateur et sur 
Postman. 
Ajouter un auteurs 
POST /api/auteurs – corps (body … raw) : Postman 
{ 
} 
"nom": "Camara", 
"prenom": "Laye" 
Ajouter un livres 
POST /api/livres - corps (body … raw) : Postman 
{ 
"titre": "L'Enfant noir", 
"isbn": "978-2-1234-5678-9", 
"anneePublication": 1953, 
"auteur": { 
"id": 1 
} 
} 
Lister les livres 
GET /api/livres 
• Lister les auteurs 
GET /api/auteurs 
• Lister les livres d'un auteur 
GET /api/livres/auteur/{auteurId} 
2. FONCTIONNALITES IMPLEMENTEES 
• CRUD Auteurs 
• CRUD Livres 
• Association Livre ↔ Auteur 
• Recherche des livres par auteur 
3. STRUCTURE DU PROJET 
monappli 
➢ controller 
• LivreController.java,  
• AuteurController.java 
➢ model 
• Livre.java,  
• Auteur.java 
➢ repository 
• LivreRepository.java, 
•  AuteurRepository.java 
➢ service 
• LivreService.java,  
• AuteurService.java 
application.properties  
4. TECHNOLOGIES UTILISES  
Java 17 
Spring Boot 
Spring Data JPA 
H2 Database  
Maven 
5. PROBLEME RENCONTRER 
1. Lombok ne générait pas les getters/setters 
Problème : Les méthodes getId() ou autres générées par Lombok étaient soulignées ou non 
reconnues. 
Solution : 
Vérifier que la dépendance Lombok est bien dans le pom.xml : 
<dependency> 
<groupId>org.projectlombok</groupId> 
<artifactId>lombok</artifactId> 
<version>1.18.30</version> 
<scope>provided</scope> 
</dependency> 
Installer le plugin Lombok dans l'IDE (Eclipse) et activer l'annotation processing. 
2.   La réponse JSON d’un POST retournait {} au lieu des données enregistrées 
Problème : Lorsqu'on envoyait un auteur ou un livre via Postman, la réponse était vide. 
Solution : 
Corriger les annotations @Entity + @RestController 
Éviter les problèmes de sérialisation en supprimant les getters redondants ou en utilisant 
correctement @Data de Lombok. 
3.  Relation entre Livre et Auteur mal persistée 
Problème : Lorsqu’on ajoutait un livre avec un auteur, celui-ci n’était pas enregistré 
correctement. 
Solution : 
Lors de la création d’un livre, s’assurer que l’auteur existe déjà et est référencé par son id. 
Exemple correct de POST /api/livres : 
{ 
} 
"titre": "L'Enfant noir", 
"isbn": "1234567890123", 
"anneePublication": 1953, 
"auteur": { 
"id": 1 
} 
4. GET /api/livres ou /api/auteurs retourne [ ] vide 
Problème : Aucun résultat alors que des enregistrements ont été ajoutés. 
Solution : 
Vérifier que la base de données (H2) est bien persistée. 
Utiliser l'interface H2 Console (http://localhost:8080/h2-console) pour voir les données. 
Vérifier les annotations JPA et les relations (@OneToMany, @ManyToOne). 
6. BONUS REALISES 
❖ Utilisation de Lombok (@Data) pour réduire le code 
❖ Relation bidirectionnelle JPA entre Auteur et Livre 
❖ Cascade automatique lors de la suppression d’un auteur 
❖ Gestion des identifiants générés automatiquement 
❖ Support JSON avec Jackson pour les échanges API 
CONCLUSION 
Ce projet de gestion de livres et d’auteurs en Spring Boot constitue une base solide pour 
comprendre les relations entre entités, la sérialisation JSON, et l’utilisation d’un backend 
RESTful avec une base de données relationnelle. Malgré les quelques difficultés rencontrées 
(Lombok, persistance des relations, affichage des données), les solutions apportées ont permis 
de mettre en place un système fonctionnel, extensible et documenté.
