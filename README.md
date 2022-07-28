# Sales-api

# API REST utilizando Spring Boot

A Sales simula um sistema de vendas completo acessado por meio de requisições rest mapeadas por módulos.
Recursos disponíveis para acesso via API:

* [**Clientes**]("/api/customer")
* [**Produtos**]("/api/product")
* [**Pedidos**]("/api/order")


## Métodos
Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

## Requisições personalizadas
As ações de `listar` permitem o envio dos seguintes parâmetros:

| Parâmetro | Descrição |
|---|---|
| `filtro` | Filtra dados pelo id informado. |

As requisições por id seguem o padrão url base/método/{id}

## Respostas

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema.|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found).|
| `405` | Método não implementado.|
| `410` | Registro pesquisado foi apagado do sistema e não esta mais disponível.|
| `422` | Dados informados estão fora do escopo definido para o campo.|
| `429` | Número máximo de requisições atingido. (*aguarde alguns segundos e tente novamente*)|

# Configuração banco de dados

A api utiliza do banco de dados MySql, para utilizar o seu banco com usuário local basta  clonar o repositório na sua máquina, localizar o arquivo "application.properties" e mudar o user, nome do banco e senha. É necessário citado na classe de configuração esteja vazio para que o hibernate possa fazer a persistência dos dados pré-configurados na aplicação.

# Group Autenticação - Autenticação básica

A Api utiliza do Spring Security Basic Authenticate para acesso autorizado aos endpoints conforme criação de usuário, para requisições via navegador web uma página de login será exibida, para requisições via Postman é necessária a autenticação dentro do software na aba "Authenticate".

Para acessar os métodos você poderá utilizar do usuário cadastrado para testes com client_id`  e ` client_secret` listados abaixo:

username: userTest

password: 2022


# Documentação Swagger

Com o servidor embarcado startado, a documentação personalizada da Api com o Swagger ficará disponível na url: http://localhost:8070/swagger-ui/index.html para ser acessada após autenticação com as credenciais de teste listadas no módulo anterior. Na documentação estão listados todos os métodos detalhadamente com seus parâmetros requeridos bem como na Figura 1 abaixo.


![Screenshot 2022-07-28 at 10-47-05 Swagger UI](https://user-images.githubusercontent.com/92373290/181521506-be81485e-8f76-4d00-bba7-225b2a255930.png)
(Figura 1 -Página da documentação) 


