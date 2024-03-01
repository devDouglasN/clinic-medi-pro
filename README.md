# Sobre o projeto 
## 🏥 Clinic Med 
Clinic Med é uma API para uma clínica médica criada para para monitorar o cadastro de médicos, pacientes e agendamento de consultas. 
<br>

## 🎥  Assista ao vídeo do projeto  
### Vídeo detalhado do projeto onde cada recurso é explicado e demonstrado em ação! Veja abaixo:



https://github.com/devDouglasN/clinic-medi-pro/assets/122110326/8b917725-6c56-4d6e-adcb-0e3ae31fc7a5



<br>

## 🏁 Inicializando
### Foi realizado o deploy da API na AWS. Para testá-la, acesse a aplicação através do link abaixo:

http://54.88.105.4:8080/swagger-ui/index.html  

Abaixo estão as credenciais padrão de login para acesso à aplicação. Basta copiar e colar no campo da requisição para fazer login em autenticacao-controller:
```
{
  "login": "test@test.com",
  "senha": "123"
}
````
Após realizar a requisição de login, copie o token fornecido abaixo e cole-o na janela de diálogo do Swagger. Dessa forma, você terá acesso liberado a todas as requisições da aplicação.

<br>

## ⚡ Compilando  
Gerar os arquivos-fonte conforme o padrão de um projeto Maven.  
`mvn clean install`

http://localhost:8080/login  
http://localhost:8080/pacientes  
http://localhost:8080/medicos  
http://localhost:8080/consultas  

<br>

##  ![Trello](https://img.shields.io/badge/Trello-0052CC?style=for-the-badge&logo=trello&logoColor=white)



Acompanhe o progresso do projeto no [Trello](https://trello.com/b/g1wbZvCu/clinic-med).

<br>

## 🛠️ Tecnologias

<table>
  <tr>
    <td>Java</td>
    <td>Spring Boot</td>
    <td>Spring MVC</td>
    <td>Spring Security</td>
    <td>JPA</td>
    <td>Maven</td>
    <td>Lombok</td>
    <td>Auth0 JWT</td>
    <td>MySQL</td>
    <td>Flyway Core</td>
  </tr>
  <tr>
     <td>17</td>
    <td>3.1.0</td>
    <td>3.1.0</td>
    <td>3.1.0</td>
    <td>3.1.0</td>
    <td>3.9.6</td>
    <td>3.1.0</td>
    <td>4.2.1</td>
    <td>8.0</td>
     <td>9.21.1</td>
  </tr>
</table>

<br>

## ⚙️ Funcionalidades
+ CRUD de Consultas;
+ CRUD de Medicos;
+ CRUD de Pacientes;

<br>

## ⏳ Getting Started
### Você pode:
+ [Baixar o ZIP do projeto](https://github.com/devDouglasN/clinic-medi-pro/archive/refs/heads/main.zip) e abri-lo em uma IDE de sua preferência.

### OU 
- Clonar o repositório <span style="color: grey;">https://github.com/devDouglasN/clinic-medi-pro</span>
- Rodar <span style="color: grey;">mvn clean install</span> para instalar as dependências do projeto.
- Rodar <span style="color: grey;">mvn spring-boot:run</span> para subir a aplicação.
- A aplicação estará disponível na porta <span style="color: grey;">8080</span>.
- (Para alterar a porta, modifique o <span style="color: grey;">server.port</span> no arquivo <span style="color: grey;">application.properties</span>).

<br>

## 🔗 Endpoints

Você pode utilizar o Insomnia, Postman ou qualquer outra ferramenta de sua preferência para realizar as requisições.


### Consultas
POST ( Cadastrando uma consulta )
+ http://localhost:8080/consultas

```
 {
       "idMedico": "Digite o ID do médico",
       "idPaciente": "Digite o ID do paciente",
       "data": "Data para consulta. Ex: 2024-03-07T09:00"
}
````

GET ( Retornando lista de consultas )
+ http://localhost:8080/consultas

```
 {
   "id": "ID da Consulta a ser retornada: 1",
   "medicoId": "ID do Médico associado à consulta: 1",
   "pacienteId": "ID do Paciente associado à consulta: 1",
   "data": "Data e hora da consulta: 2024-02-28T09:00:00"
}

````

DELETE ( Cancelando uma consulta ) 
+ http://localhost:8080/consultas   
Abaixo estão listados os motivos pelos quais uma consulta pode ser cancelada:
  + PACIENTE_DESISTIU,   
  + MEDICO_CANCELOU,
  + EMERGENCIA_MEDICA,
  + PROBLEMAS_DE_AGENDAMENTO,
  + FALTA_DE_TRANSPORTE,
  + FALTA_DE_EQUIPAMENTO,
  + CONFLITO_DE_HORARIO,
  + CONDICAO_CLIMATICA,
	+ OUTROS;
+ Para cancelar uma consulta, é necessário fazê-lo com 24 horas de antecedência.
```
 {
        "idConsulta": "ID da Consulta a ser retornada:" Ex. 1,
        "motivo": "Ex: CONDICAO_CLIMATICA"
    },

````
GET ( Retornando lista de consultas canceladas)
+ http://localhost:8080/consultas/canceladas   


<br>

### Pacientes
POST ( Cadastrando um paciente )
+ http://localhost:8080/pacientes

```
 {
        "nome": "Nome Completo",
        "email": "Endereço de Email",
        "telefone": "Número de Telefone",
        "dataNascimento": "DD/MM/AAAA no formato AAAA-MM-DDTHH:MM:SS.MMMZ",
        "genero": "Gênero (Masculino/Feminino/Outro)",
        "registroSaude": "Descrição do Registro de Saúde",
        "endereco": {
            "logradouro": "Nome da Rua/Avenida",
            "bairro": "Nome do Bairro",
            "cep": "CEP no formato 00000-000",
            "cidade": "Nome da Cidade",
            "uf": "Sigla do Estado (Ex: SP, RJ, MG)",
            "complemento": "Informações adicionais (Opcional)",
            "numero": "Número do Endereço"
  }
}
````
GET ( Retornando lista de pacientes )
+ http://localhost:8080/pacientes

```
 {
       "name": "Nome de paciente a ser retornado",
       "email": "Email a ser retornado",
       "telefone": "Telefone a ser retornado",
       "dataNascimento": "Data de nascimento a ser retornada",
       "genero": "Genero a ser retornado",
       "registroSaude": "Doença registrada do paciente a ser retornada",
    },

````

PUT (Atualizando pacientes)
http://localhost:8080/pacientes
```
{
       "nome": "Atualize o Nome Completo",
       "email": "Atualize o Endereço de Email",
       "telefone": "Atualize o Número de Telefone",
       "dataNascimento": "Atualize a Data de Nascimento no formato    AAAA-MM-DDTHH:MM:SS.MMMZ",
       "genero": "Atualize o Gênero (Masculino/Feminino/Outro)",
       "registroSaude": "Atualize a Descrição do Registro de Saúde",
       "endereco": {
           "logradouro": "Atualize o Nome da Rua/Avenida",
           "bairro": "Atualize o Nome do Bairro",
           "cep": "Atualize o CEP no formato 00000-000",
           "cidade": "Atualize o Nome da Cidade",
           "uf": "Atualize a Sigla do Estado (Ex: SP, RJ, MG)",
           "complemento": "Atualize as Informações Adicionais (Opcional)",
           "numero": "Atualize o Número do Endereço"
   }
}
````

DELETE ( Deletando um paciente ) 
+ http://localhost:8080/pacientes/{id}   
Basta adicionar o ID desejado na requisição.

<br>

GET (Retornando por ID )
+ http://localhost:8080/pacientes/{id}
Basta adicionar o ID desejado na requisição.   

<br>

### Médicos
POST ( Cadastrando um médico )
+ http://localhost:8080/medicos  

Abaixo estão as especialidades que podem ser utilizadas para o cadastro da profissão de médicos:
+ ORTOPEDIA,
+ CARDIOLOGIA,
+ GINECOLOGIA,
+ OTORRINOLARINGOLOGIA 
```
{
    "nome": "Nome Completo. Ex: César Filho",
    "email": "Endereço de Email. Ex: cesar.filho@medi.pro",
    "telefone": "Número de Telefone. Ex: 91122334455",
    "crm": "CRM. Ex: 96884/SP",
    "especialidade": "Especialidade. Ex: CARDIOLOGIA",
    "endereco": {
        "logradouro": "Nome da Rua/Avenida. Ex: rua 1",
        "bairro": "Nome do Bairro. Ex: bairro",
         "cep": "CEP. Ex: 12345678",
         "cidade": "Nome da Cidade. Ex: São Paulo",
         "uf": "UF. Ex: SP",
        "numero": "Número do Endereço. Ex: 1",
         "complemento": "Informações adicionais. Ex: complemento"
   }
}

````
GET ( Retornando lista de médicos )
+ http://localhost:8080/medicos

```
 {
   "id": 1,
   "nome": "Nome do médico a ser retornado: César Filho",
   "email": "Email do médico a ser retornada: cesar.filho@medi.pro",
   "crm": "CRM do médico a ser retornado: 96884/SP",
   "especialidade": "Especialidade do médico a ser retornada: CARDIOLOGIA"
}
,
````
PUT (Atualizando médico)
http://localhost:8080/medicos
```
{
   "id": "Atualize o ID",
   "nome": "Atualize o Nome Completo",
   "telefone": "Atualize o Número de Telefone",
   "endereco": {
       "logradouro": "Atualize o Nome da Rua/Avenida",
       "bairro": "Atualize o Nome do Bairro",
       "cep": "Atualize o CEP no formato 00000-000",
       "cidade": "Atualize o Nome da Cidade",
       "uf": "Atualize a Sigla do Estado (Ex: SP, RJ, MG)",
       "complemento": "Atualize as Informações Adicionais (Opcional)",
       "numero": "Atualize o Número do Endereço"
   }
}

````
DELETE ( Deletando um médico ) 
+ http://localhost:8080/medicos/{id}   
Basta adicionar o ID desejado na requisição.

<br>

GET (Retornando por ID )
+ http://localhost:8080/medicos/{id}
Basta adicionar o ID desejado na requisição. 
