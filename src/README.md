# Blog API in Spring Boot

## Development

### Database Setup

#### MySQL

To login to MYSQL, run the following commands

```bash
mysql -u root #if root has no password
mysql -u root -p #if root has password
```
Create Database, user and password

```mysql
Create DATABASE blog;
CREATE USER 'blog_user'@'localhost' IDENTIFIED BY 'blog_password';
GRANT ALL PRIVILEGES ON blog.* TO 'blog_user'@'localhost';
```
Check it works by logging into the database:

```bash
mysql blog -u blog_user -p
```

#### PostgreSQL

1. Create Database, User and Password

Login to Postgres and run the following commands

   ```bash
   psql postgres # for MacOS
   sudo -u postgres psql postgres # for Linux
   ```
1. Create Database, User and Password

   Login to Postgres and run the following commands


   ```postgresql
         CREATE DATABASE blog;
         CREATE USER blog_user WITH ENCRYPTED PASSWORD 'blog_password';
         GRANT ALL PRIVILEGES ON DATABASE blog TO blog_user;   
   ```