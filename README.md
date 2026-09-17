Markdown

# To-Do List API

API REST de gestion de tâches développée avec Spring Boot, Spring Data JPA, H2 et Swagger UI.

## 🚀 Prérequis

- Java 21 ou supérieur
- Maven 3.8+
- PostgreSQL 15+

## 🛠️ Lancement de l'application

1. Cloner le projet :

   ```bash
   git clone <URL_DE_TON_DEPOT>
   cd todoList

    Compiler et exécuter l'application :
    Bash

    ./mvnw spring-boot:run

    (Ou exécuter la méthode main de TodoListApplication.java depuis votre IDE).

    L'application démarrera sur http://localhost:8085 .
   ```

📚 Documentation API (Swagger UI)

Une fois l'application démarrée, la documentation interactive est accessible à l'adresse :
👉 http://localhost:8085/swagger-ui/index.html

- **SGBD :** PostgreSQL
- **Nom de la base :** `todolistdb`
- **URL de connexion :** `jdbc:postgresql://127.0.0.1:5432/todolistdb`
- **Gestionnaire BDD conseillé :** pgAdmin ou DBeaver

📌 Endpoints principaux

    GET /api/tasks : Récupérer toutes les tâches (filtrage possible avec ?status=A_FAIRE)

    POST /api/tasks : Créer une nouvelle tâche

    PUT /api/tasks/{id} : Modifier une tâche (title, description, status)

    DELETE /api/tasks/{id} : Supprimer une tâche

🧪 Exemple de test via Curl
Bash

# Lister toutes les tâches

curl -X GET http://localhost:8085/api/tasks

# Créer une nouvelle tâche

curl -X POST http://localhost:8085/api/tasks \
 -H "Content-Type: application/json" \
 -d '{"title":"Réviser Spring Boot","description":"Revoir JPA","status":"A_FAIRE"}'

# Modifier le statut d'une tâche

curl -X PUT "http://localhost:8085/api/tasks/1?status=EN_COURS"

# Supprimer une tâche

curl -X DELETE http://localhost:8085/api/tasks/1
