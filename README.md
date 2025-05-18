
# JavaSwingDatabaseApp

Projeto Java com Swing e conexão a banco de dados MySQL. Exibe os dados da tabela `usuarios` em uma interface gráfica.

## Requisitos

- Java JDK
- NetBeans
- MySQL
- Driver JDBC (MySQL Connector/J)

## Estrutura do Banco de Dados

```sql
CREATE DATABASE exemplo;

USE exemplo;

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100)
);

INSERT INTO usuarios (nome, email) VALUES
('João', 'joao@example.com'),
('Maria', 'maria@example.com');
```
