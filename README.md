# Desafio Votação

Este projeto é uma API REST desenvolvida para gerenciar sessões de votação, incluindo registro de votos e contagem de resultados de pautas. A aplicação utiliza o **Spring Boot** com banco de dados **MongoDB**.

## Pré-requisitos

Certifique-se de ter os seguintes requisitos instalados na sua máquina antes de executar a aplicação:

- **Java 17** ou superior: Certifique-se de que o `JAVA_HOME` esteja configurado no seu ambiente.
- **Maven 3.8+**: Para gerenciamento de dependências e construção do projeto.
- **MongoDB**: Instância local ou em nuvem. A configuração do banco pode ser ajustada no arquivo `application.properties`.
- **Postman** (ou outra ferramenta para testar APIs REST): Para realizar requisições à API.

## Instalação e Configuração

1. **Clone o repositório:**
    
    ```bash
    git clone https://github.com/NatanMendes0/desafio-votacao.git
    cd desafio-votacao
    ```
    
2. **Configure o banco de dados MongoDB:**
    - No arquivo `src/main/resources/application.properties`, ajuste as configurações do MongoDB:
        
        ```
        spring.data.mongodb.uri=mongodb://localhost:27017/desafio-votacao        
        ```
        
3. **Compile o projeto:**
Utilize o Maven para compilar o código:
    
    ```bash
    mvn clean install    
    ```
    
4. **Execute a aplicação:**
Inicie o servidor local:
    
    ```bash
    mvn spring-boot:run
    ```
    
5. **Acesse a aplicação:**
A aplicação estará disponível em [http://localhost:8080](http://localhost:8080/).

## Endpoints Disponíveis

### **Pautas**

- **Cadastrar uma nova pauta**

  ```
  POST /api/pautas
  ```
  
  - **Body (JSON):**
    
    ```json
    {
      "titulo": "Título da Pauta",
      "descricao": "Descrição da Pauta"
    }
    ```

- **Contabilizar os votos de uma pauta**

  ```
  GET /api/pautas/{pautaId}/resultado
  ```
  
  Substitua `{pautaId}` pelo ID da pauta desejada.

- **Listar todas as pautas**

  ```
  GET /api/pautas
  ```

### **Sessões**

### **Sessões**

- **Abrir uma sessão de votação**

  ```
  POST /api/sessoes
  ```

  - **Body (JSON):**
    
    ```json
    {
      "pautaId": "ID_DA_PAUTA",
      "duracaoEmMinutos": 5
    }
    ```

    Observação: Se `duracaoEmMinutos` não for informado, o padrão será 1 minuto.

- **Listar sessões abertas**

  ```
  GET /api/sessoes
  ```

### **Votos**

- **Registrar um voto**
    
    ```
    POST /api/votos    
    ```
    
    - **Body (JSON):**
        
        ```json
        {
          "pautaId": "id_da_pauta",
          "associadoId": "id_do_associado",
          "voto": "Sim" // ou "Não"
        }
        
        ```
        
- **Consultar resultados**
    
    ```
    GET /api/votos/{pautaId}/resultado    
    ```

## Problemas Conhecidos

- Certifique-se de que a base de dados MongoDB esteja em execução antes de iniciar a aplicação.
- Caso ocorra um erro de `Pauta não encontrada`, verifique se o ID fornecido está correto e se a pauta foi previamente cadastrada.