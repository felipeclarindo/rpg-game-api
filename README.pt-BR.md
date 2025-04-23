🌍 [Read in English](README.md)

# Rpg Game Api

Api para gerenciar o jogo de rpg desenvolvido em java usando spring.

## Technologies Used

- `Spring` - Framework to help in development
- `Java` - Language used to development.
- `Maven` - Automatizate builds.
- `H2 Database` - Database to input data.

## API Endpoints

Below is the general structure of the available API routes:

| Method | Route                   | Description                        |
| ------ | ----------------------- | ---------------------------------- |
| GET    | `/api`                  | Get api description.               |
| GET    | `/api/characters`       | Get todos os personagens.          |
| GET    | `/api/characters/{id}`  | Get personagem por id.             |
| GET    | `api/characters/filter` | Fitro de personagem.               |
| POST   | `/api/characters`       | Criar um novo personagem.          |
| PUT    | `/api/characters/{id}`  | Atualizar um personagem existente. |
| DELETE | `/api/characters/{id}`  | Deletar um personagem.             |
| GET    | `/api/items`            | Get todos os itens.                |
| GET    | `/api/items/{id}`       | Get item por id.                   |
| GET    | `api/items/filter`      | Filtro de item.                    |
| POST   | `/api/items`            | Criar um novo item.                |
| PUT    | `/api/items/{id}`       | Atualizar um item existente.       |
| DELETE | `/api/items/{id}`       | Delete um item.                    |

## Passos para executar

1. Clone o repositorio:

```bash
git clone https://github.com/felipeclarindo/rpg-game-api.git
```

2. Entre no diretorio:

```bash
cd rpg-game-api
```

3. Execute o arquivo `App.java` localizado em `src/main/java/com/example/rpg_game_api/App.java`.

4. Api estara disponivel em:

- http://localhost:8080/api

## Contribuição

Contribuições são bem-vindas! Se você tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Autor

**Felipe Clarindo**

- [LinkedIn](https://www.linkedin.com/in/felipeclarindo)
- [Instagram](https://www.instagram.com/lipethecoder)
- [GitHub](https://github.com/felipeclarindo)

## Licença

Este projeto está licenciado sob a [GNU Affero License](https://www.gnu.org/licenses/agpl-3.0.html).
