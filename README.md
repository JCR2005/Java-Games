# Java-Games

A collection of mini-games developed in Java. This repository demonstrates object-oriented programming principles, modular software design, and console-based interaction.

## Included Games

- **Wordle:** An implementation of the popular word-guessing game. It features string manipulation, input validation logic, and console interaction.
- **Basketball:** A simple basketball simulation game. It demonstrates game logic, entity modeling through class structures, and event simulation.
- **2024:** A puzzle/logic game included as part of the `games` package, showcasing algorithmic thinking and numeric operations.

## Built With

- Java (OOP, modular packages)
- Maven (Build automation and dependency management)

## How to Run

This project uses Maven. The main entry point is the `main.Main` class, which initializes the game engine (`GameMotor`).

To compile and run the project:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="main.Main"
```

Alternatively, to build and run the packaged application:

```bash
mvn package
java -cp target/classes main.Main
```

## Documentation

- User Manual (EN): `docs/USER_MANUAL_EN.md`
- Technical Manual (EN): `docs/TECHNICAL_MANUAL_EN.md`

## Screenshots

Screenshots are stored in `docs/images/`.

![Wordle](docs/images/wordle.png)
![Basketball](docs/images/basketball.png)
![2048](docs/images/2048.png)

---

# Java-Games (Español)

Una colección de mini-juegos desarrollados en Java. Este repositorio demuestra principios de programación orientada a objetos, diseño modular de software y manejo de entrada/salida por consola.

## Juegos Incluidos

- **Wordle:** Una implementación del popular juego de adivinar palabras. Destaca por el manejo de cadenas de texto, lógica de validación de entradas e interacción por consola.
- **Basketball:** Un juego de simulación de baloncesto. Demuestra lógica de juego, modelado de entidades mediante estructura de clases y simulación de eventos.
- **2024:** Un juego de lógica y rompecabezas incluido en el paquete `games`, que muestra pensamiento algorítmico y operaciones numéricas.

## Tecnologías Utilizadas

- Java (POO, paquetes modulares)
- Maven (Automatización de compilación y empaquetado)

## Cómo Ejecutar

Este proyecto utiliza Maven. El punto de entrada principal es la clase `main.Main`, la cual inicializa el motor del juego (`GameMotor`).

Para compilar y ejecutar el proyecto:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="main.Main"
```

Alternativamente, para compilar y ejecutar directamente desde los archivos compilados:

```bash
mvn package
java -cp target/classes main.Main
```

## Documentación

- Manual de Usuario (ES): `docs/USER_MANUAL_ES.md`
- Manual Técnico (ES): `docs/TECHNICAL_MANUAL_ES.md`

## Capturas

Las capturas están en `docs/images/`.

![Wordle](docs/images/wordle.png)
![Basketball](docs/images/basketball.png)
![2048](docs/images/2048.png)
