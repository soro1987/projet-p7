# Étape de déploiement du projet de bibliothèque municipale

## Prémière étape:
* Tout d'abord, il vous faut un Jre installer sur votre machine que vous pouvez télécharger ici :[Installez un JRE](https://www.java.com/fr/download/)


## Deuxième étape:
* Nous allons maintenant installer un SGBD je recommande MySql 


* Tous d'abord vous devez créer une base de donnée nommé par exemple base_test

## Troisième étape:
* Dans cette étape, nous allons d'abord récupérer le jar du serveur sur mon  github:[Telecharger le jar](https://github.com/soro1987/projet-p7/releases/download/v1.0.0/p7_server_1.0.0.jar)
 <br>
* Puis on exécuter le serveur sur le port 8080 en tapant cette commande dans le cmd:


<pre>
    <code>
         $ java -jar p7_server_1.0.0.jar --server.port=8080 --spring.datasource.url=jdbc:mysql://localhost:3306/base_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC  
    </code>
</pre>


## Quatrième étape:
* Même étape, cette fois-ci pour le jar du client ici:[Telecharger le jar](https://github.com/soro1987/Client-p7/releases/download/1.0.0/biblio-client.jar).
* Puis on exécuter le client sur le port 8081 en tapant cette commande dans le cmd:
<pre>
    <code>
         $ java -jar biblio-client.jar --server.port=8081
    </code>
</pre>


## Cinquième étape:
* Et enfin, le jar du batch ici:[Telecharger le jar](https://github.com/soro1987/batch/releases/download/1.0.0/batch.jar).
* Puis on exécuter le client sur le port 8082 en tapant cette commande dans le cmd:
<pre>
    <code>
         $ java -jar batch.jar --server.port=8082
    </code>
</pre>

## Derniere étape:
* Allez sur le navigateur puis pointer sur l'URL suivant.


-http://localhost:8081/accueil pour le client




## Les technologies utilisées:
* Java  1.8
* Spring boot 2.3.6
* Hibernate
* MYSQL 5
* Thymeleaf
* Bootstrap 4
* Eclipse IDE



