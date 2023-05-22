# Blog API in Spring Boot

## Development

### Database Setup

#### MySQL

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