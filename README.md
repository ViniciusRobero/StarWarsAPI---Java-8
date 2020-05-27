# API contendo informações sobre os planetas do universo Star Wars
Essa aplicação tem como objetivo criar uma api que alimente um banco de dados com informações sobre os planetas do universo de Star Wars. Ela irá permitir a inclusão de planetas (com seu clima, terreno e nome). E irá permitir ao usuário inserir, deletar e buscar a lista de todos os planetas salvos. Além disso o usuário pode buscar planetas específicos por Nome ou Id.

## Tecnologias
Para esse o desenvolvimento desse sistema, foram utilizados as tecnologias Java com Spring Boot e o banco de dados Mongodb.

# Listar todos os planetas salvos
Para listar todos os planetas salvos no banco de dados, basta fazer uma requisição GET para o caminho "https://*endereco-da-api*/api/planets".

# Listar todos os planetas salvos
Para inserir os planetas basta fazer uma requisição post para o caminho "https://*endereco-da-api*/api/planets", passando no body da requisição json com os dados de nome, clima e terreno. Ex:

```javascript
        {
	   "nome": "Alderaan",
           "clima": "Ameno",
           "terreno": "Rochoso"
	}
```

# Listar os planetas por Id ou por Nome
Para listar um planeta por Id, basta fazer uma requisição GET para o caminho "https://*endereco-da-api*/planets/", passando o Id do planeta após a barra. Ex:
"https://*endereco-da-api*/planets/123456"

Para listar os planetas por nome, basta fazer uma requisição GET para o caminho "https://*endereco-da-api*/planets/FindByName", passando o nome do planeta após a barra. Ex:
"https://*endereco-da-api*/planets/getByName/Alderaan"

# Deletar um planeta
Bastar fazer uma requisicao DELETE para o caminho "https://*endereco-da-api*/planets/", passando o Id do planeta após a barra. Ex:
"https://*endereco-da-api*/planets/123456"

