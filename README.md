## 💻 Sobre o projeto

Api criada para o Desafio Attornatus<br>

## Descrição do solicitado.

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir: <br>

• Criar uma pessoa<br>
• Editar uma pessoa<br>
• Consultar uma pessoa<br>
• Listar pessoas<br>
• Criar endereço para pessoa<br>
• Listar endereços da pessoa<br>
• Poder informar qual endereço é o principal da pessoa

## ⚙️ Funcionalidades
- [x] CRUD de pessoa;
- [x] CRUD de endereço;


## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[H2](http://localhost:8080/h2)**
- **[Hibernate](https://hibernate.org)**
- **[Lombok](https://projectlombok.org)**
- **[Junit](https://junit.org/junit4/)**
- **[Swagger](https://swagger.io/docs/)**
- **[Spring Security](https://docs.spring.io/spring-security/reference/index.html)**
- **[JWT auth0](https://jwt.io/)**


## Sobre o Desafio.<p>
    ## Informações da Api.

    # Pessoa

    - Cadastro de Pessoa: POST - localhost:8080/pessoas

    - Listar Pessoa: - GET - localhost:8080/pessoas

    - Atualizar Pessoa  - PUT localhost:8080/pessoas

    - Deletar Pessoa - DELETE localhost:8080/pessoas/id

    # Endereco

    - Cadastro de Endereco - POST - localhost:8080/endereco

    - Listar Endereco - localhost:8080/endereco

    - Atualizar Endereco - PUT localhost:8080/endereco

    - Deletar Endereco - DELETE - http://localhost:8080/endereco/id

    - Utilizado estrutura MVC e utilização da classe DTO Data Transfer Object.

    - Relacionamento de N-1 - 1-N utilizando o Spring.
    
    - Campo boleano para ativar endereço principal - Classe Endereço.
    
    - Implementado autenticação por token JWT, criado o arquivo data.sql com usuario e senha no formato Bcrypt.

    - Arquivo com as requisições json também em anexo ao projeto.