
# Sobre o Desafio

Nesse desafio foi desenvolvida uma API fictícia para uma empresa de cursos de programação, onde utilizei o CRUD, para criação de cursos.

## Requisitos

#### A API deve conter as seguintes funcionalidades:
    - Criação de um novo curso
    - Listagem de todos os cursos
    - Atualização de um curso pelo `id`
    - Remover um curso pelo `id`

### Rotas e regras de negócio

Antes das rotas, vamos entender qual a estrutura (propriedades) que uma task deve ter:

- `id` - Identificador único de cada curso
- `name` - Nome do curso
- `category` - Categoria do curso
- `Active` - Define se o curso está ativo ou não
- `created_at` - Data de quando o curso foi criado.
- `updated_at` - Deve ser sempre alterado para a data de quando o curso for atualizada.

### Rotas:
- `POST - /cursos`

    Deve ser possível criar um curso no banco de dados, enviando os campos `name` e `category` por meio do `body` da requisição.
    
    Ao criar um curso, os campos: `id`, `created_at`   e `updated_at` devem ser preenchidos automaticamente, conforme a orientação das propriedades acima.

- `GET - /cursos`
    
    Deve ser possível listar todas os cursos salvos no banco de dados.
    
    Também deve ser possível realizar uma busca, filtrando os cursos pelo `name` e `category`
    
- `PUT - /cursos/:id`
    
    Deve ser possível atualizar um curso pelo `id`.
    
    No `body` da requisição, deve receber somente o `name` e/ou `category` para serem atualizados.
    
    Se for enviado somente o `name`, significa que o `category` não pode ser atualizado e vice-versa. Além disso `active` for informado nessa rota, ele deverá ser ignorado, pois a rota que deverá fazer essa atualização, é a de patch.

- `DELETE - /cursos/:id`
    
    Deve ser possível remover um curso pelo `id`.
    
- `PATCH - /cursos/:id/active`
    
    Essa rota servirá para marcar se o curso está ativo ou não, ou seja, um toggle entre true or false.
