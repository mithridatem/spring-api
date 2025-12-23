# spring-api
Projet de cours api spring boot java
## Procédure récupération et build
## récupérer le projet
```bash
# cloner le projet
git clone https://github.com/mithridatem/spring-api.git
# cloner depuis intellij avec le menu liste des projets
clone https://github.com/mithridatem/spring-api.git
```
## adapter vos informations de BDD (fichier application.properties)
```txt
# remplacer par vos valeurs (port Tomcat)
server.port=8080

# remplacer par vos valeurs (base H2)
spring.datasource.username=sa
spring.datasource.password=password

# remplacer par vos valeurs (Token JWT)
app.jwt.secret="#########################################################min32-CHARS"
app.jwt.expiration-minutes=60
```
## mettre en production
### Créer un nouveau fichier Créez src/main/resources/application-prod.properties :
### Editer comme ci-dessous :
```txt
spring.application.name=api
server.port=8080

# Logging production
logging.level.org.hibernate=ERROR
logging.level.org.springframework.boot.web.embedded.tomcat=WARN
logging.level.com.adrar.api=INFO
logging.level.org.springframework.security=WARN

# H2 désactivé en production
spring.h2.console.enabled=false

# Base de données (à configurer via variables d'environnement)
spring.datasource.url=${DB_URL}
spring.datasource.driver-class-name=${DB_DRIVER}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=${DB_DIALECT}
spring.jpa.properties.hibernate.format_sql=false

# JWT
app.jwt.secret=${JWT_SECRET}
```
## compiler le projet :
menu -> build -> build artifact

## Démarrer le projet en ligne de commande (projet build)
```bash
java -jar api.jar --spring.profiles.active=prod \
  -DDB_URL=jdbc:h2:file:/var/lib/api/db \
  -DDB_DRIVER=org.h2.Driver \
  -DDB_USERNAME=admin \
  -DDB_PASSWORD=secure_password \
  -JWT_SECRET=your-very-long-secret-at-least-32-chars

```

### Vous pouvez aussi créer un fichier .env ou utiliser des variables systèmes
avec les clés suivantes (*utiliser vos propres valeurs*) :
```env
DDB_URL=jdbc:h2:file:/var/lib/api/db
DDB_DRIVER=org.h2.Driver
DDB_USERNAME=admin
DDB_PASSWORD=secure_password
JWT_SECRET=your-very-long-secret-at-least-32-chars
```
