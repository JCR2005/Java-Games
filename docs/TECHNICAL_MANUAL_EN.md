# Java-Games — Technical Manual (EN)

## Overview
Java-Games is a console application built with Java and Maven. It exposes a main menu and three games: Wordle, Basketball, and 2048.

## Project Structure
```
src/main/java/
  game_motor/      # Entry point and main menu
  games/           # Game implementations
  utils/           # Shared utilities, posters, stats, dictionary
```

## Key Classes
- `main.Main` — Application entry point.
- `game_motor.GameMotor` — Menu flow and game routing.
- `games.Wordle` — Wordle logic and solo/friends mode.
- `games.Basketball` — Turn-based basketball simulation.
- `games.Game2048` — 2048 board and movement logic.
- `utils.Posters` — Console UI banners and menus.
- `utils.GameStats` — In-memory counters for statistics.
- `utils.DiccionaryWords` — Loads words from `utils/diccionary.txt`.

## Build & Run
- Compile: `mvn compile`
- Run: `mvn exec:java -Dexec.mainClass="main.Main"`

## Game Flow
1. `Main` calls `GameMotor.startGemaMotor()`.
2. `GameMotor` presents initial menu and routes to games.
3. Each game handles its own menus and flow.

## Wordle (Solo)
- `Wordle` reads the dictionary once via `DiccionaryWords`.
- A random 5‑letter word is selected.
- Attempts are tracked with `GameStats`.

## 2048
- `Game2048` stores the board as a 4x4 matrix.
- Movement uses line compression + merge logic.
- Win/lose is verified every move.

## Statistics
`GameStats` keeps all counters in memory. If persistence is required, create a storage layer (file or database) and update counters on app exit.

## Extending the Project
- Add a new game under `games/`.
- Expose it in `GameMotor` (menu + random selection).
- Add posters in `utils.Posters` for UI consistency.
- Register stats in `GameStats` if needed.
