## Lancer le projet

Prérequis : Docker Desktop

1. Créer un fichier `.env` à la racine :
   ```
   POSTGRES_USER=postgres
   POSTGRES_PWD=motdepasse
   POSTGRES_DB_NAME=club
   ```
2. Lancer :
   ```bash
   docker compose up -d --build
   ```
3. C'est prêt :
   - API : http://localhost:8088
   - Adminer : http://localhost:8081 (système PostgreSQL, serveur `db`, identifiants du `.env`)

Pour tout arrêter : `docker compose down`