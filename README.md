# java-project-poo
Trabalho de Java


Downloads:
---

Java (JDK 20) - https://www.oracle.com/java/technologies/downloads/#jdk20-windows

Netbeans 18 - https://netbeans.apache.org/download/index.html

Xampp 8.2.4 (MySQL) - https://www.apachefriends.org/pt_br/download.html

MySQL Connector 8.1.0 - https://dev.mysql.com/downloads/connector/j/

MySQL Workbench - https://dev.mysql.com/downloads/workbench/

Git (versionamento) - https://git-scm.com/download/win

---


Resumo:
---

O projeto é um software que faz o cálculo de orçamentos para um MEI no ramo da serralheria artesanal.

---

Tecnologias Utilizadas
---
- Linguagem de programação: Java
- Banco de Dados: MysQL
- IDE: Netbeans
- API(s): https://md-to-pdf.fly.dev
---

Geração de PDF:
---
Para a geração do PDF, utilizamos a biblioteca OkHttp para fazer as requisições e uma API REST (https://md-to-pdf.fly.dev) que recebe um markdown via Header HTTP. Recebemos a resposta da API em bytes, e posteriormente, transformamos em um PDF. 

---
