# Ecommerce

1. Intégration du Bocker KAFKA
2. Création d'un micro-service qui permet de produire aléatoirement des factures et de les publier dans un Topic KAFKA

3. Permettre au Micro-service déjà développé BILLING-SERVICE de consommer les factures publier dans le Topic KAFKA et de les enregistrer dans sa base de données


4. Créer un micro-service Data-Analytics-Service qui utilise l'API KAFKA Streams pour effectuer du Real Time Stream Processing en consommant le streams de facture publiées dans le Topic KAFKA

5. Créer une Page Frontend qui permet de présenter en temps réel les courbes qui montrent les résultats produits par le service du Data Analytics

<img width="1280" alt="bill-analytics" src="https://user-images.githubusercontent.com/57734887/213864754-3c2175c7-1d7a-461a-8f3a-59abde77e6a7.png">


6. Déployer l'ensemble des services de l'application en utilisant des conteneur Docker : Créer les images Docker pour chaque service et et le fichier Docker-compose.yml qui permet de déployer toute l'application
