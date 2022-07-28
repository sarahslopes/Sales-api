# Sales-api

# Sales-api

# API REST utilizando Spring Boot

A Sales simula um sistema de vendas completo acessado por meio de requisições rest mapeadas por módulos sendo eles Clientes, Produtos e pedidos. 

Recursos disponíveis para acesso via API:

* [**Clientes**]("/api/customer")
* [**Produtos**]("/api/product")
* [**Pedidios**]("/api/order")


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


# Group Autenticação - Autenticação básica

A Api utiliza do Spring Security Basic Authenticate para acesso autorizado conforme criação de usuário para acesso aos endpoints.

Para acessar os métodos através do Basic Authenticate você poderá utilizar do usuário cadastrado para testes com client_id` e `client_secret` listados abaixo:

username: userTest
password: 250709


# Documentação Swagger

A Api possui uma documentação personalizada com o swagger disponível na url: http://localhost:8070/swagger-ui/index.html que pode ser acessada com as credenciais de teste listadas no módulo anterior