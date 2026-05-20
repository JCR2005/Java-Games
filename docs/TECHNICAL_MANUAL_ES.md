# Java-Games — Manual Técnico (ES)

## Descripción General
Java-Games es una aplicación de consola en Java con Maven. Ofrece un menú principal y tres juegos: Wordle, Basketball y 2048.

## Estructura del Proyecto
```
src/main/java/
  game_motor/      # Punto de entrada y menú principal
  games/           # Implementaciones de los juegos
  utils/           # Utilidades, posters, estadísticas, diccionario
```

## Clases Clave
- `main.Main` — Punto de entrada de la aplicación.
- `game_motor.GameMotor` — Flujo de menús y enrutamiento de juegos.
- `games.Wordle` — Lógica de Wordle con modo solitario y amigos.
- `games.Basketball` — Simulación de baloncesto por turnos.
- `games.Game2048` — Lógica del tablero y movimientos en 2048.
- `utils.Posters` — UI de consola (banners y menús).
- `utils.GameStats` — Contadores en memoria para estadísticas.
- `utils.DiccionaryWords` — Carga palabras desde `utils/diccionary.txt`.

## Compilación y Ejecución
- Compilar: `mvn compile`
- Ejecutar: `mvn exec:java -Dexec.mainClass="main.Main"`

## Flujo de Juego
1. `Main` ejecuta `GameMotor.startGemaMotor()`.
2. `GameMotor` muestra el menú inicial y redirige a los juegos.
3. Cada juego administra su propio flujo.

## Wordle (Solitario)
- `Wordle` carga el diccionario una sola vez con `DiccionaryWords`.
- Selecciona una palabra de 5 letras de forma aleatoria.
- Los intentos se registran en `GameStats`.

## 2048
- `Game2048` guarda el tablero en una matriz 4x4.
- Los movimientos usan compresión + fusión.
- Victoria/derrota se valida tras cada movimiento.

## Estadísticas
`GameStats` mantiene los contadores en memoria. Para persistencia, se puede crear una capa de almacenamiento (archivo o base de datos).

## Extensiones
- Agregar un juego nuevo en `games/`.
- Integrarlo en `GameMotor` (menú + selección aleatoria).
- Añadir posters en `utils.Posters` para consistencia de UI.
- Registrar estadísticas en `GameStats` si aplica.
