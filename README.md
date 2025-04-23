🌍 [Leia em Português](README.pt-BR.md)

# Rpg Game Api

Api to manager the rpg game developed in java using spring.

## Technologies Used

- `Spring` - Framework to help in development
- `Java` - Language used to development.
- `Maven` - Automatizate builds.
- `H2 Database` - Database to input data.

## API Endpoints

Below is the general structure of the available API routes:

| Method | Route                   | Description                    |
| ------ | ----------------------- | ------------------------------ |
| GET    | `/api`                  | Get api description.           |
| GET    | `/api/characters`       | Get all characters.            |
| GET    | `/api/characters/{id}`  | Get character by id.           |
| GET    | `api/characters/filter` | Filter the character to get.   |
| POST   | `/api/characters`       | Creates a new character.       |
| PUT    | `/api/characters/{id}`  | Updates an existing character. |
| DELETE | `/api/characters/{id}`  | Delete a character.            |
| GET    | `/api/items`            | Get all items.                 |
| GET    | `/api/items/{id}`       | Get item by id.                |
| GET    | `api/items/filter`      | Filter the item to get.        |
| POST   | `/api/items`            | Creates a new item.            |
| PUT    | `/api/items/{id}`       | Updates an existing item.      |
| DELETE | `/api/items/{id}`       | Delete a item.                 |

## Steps to run

1. Clone the repository:

```bash
git clone https://github.com/felipeclarindo/rpg-game-api.git
```

2. Enter directory:

```bash
cd rpg-game-api
```

3. Run the file `App.java` located in `src/main/java/com/example/rpg_game_api/App.java`.

4. Api is avaible in:

- http://localhost:8080/api

## Contribution

Contributions are welcome! If you have suggestions for improvements, feel free to open an issue or submit a pull request.

## Author

**Felipe Clarindo**

- [LinkedIn](https://www.linkedin.com/in/felipeclarindo)
- [Instagram](https://www.instagram.com/lipethecoder)
- [GitHub](https://github.com/felipeclarindo)

## License

This project is licensed under the [GNU Affero License](https://www.gnu.org/licenses/agpl-3.0.html).
