# Java-Games — Manual de Usuario (ES)

## Descripción
Java-Games es una colección de mini‑juegos en consola: Wordle, Basketball y 2048. Este manual explica cómo ejecutar la app y jugar cada juego.

## Requisitos
- Java (JDK 17+ recomendado)
- Maven 3.8+

## Cómo Ejecutar
1. Abre una terminal en la raíz del repositorio.
2. Compila y ejecuta:
   - `mvn compile`
   - `mvn exec:java -Dexec.mainClass="main.Main"`

## Menú Principal
- **1. Juego aleatorio**: Inicia un juego al azar.
- **2. Elegir juego**: Abre el menú de selección.
- **3. Salir**: Cierra la aplicación.

## Wordle
- **Objetivo**: Adivinar la palabra en 6 intentos.
- **Colores**:
  - Verde = letra correcta en posición correcta
  - Amarillo = letra correcta en otra posición
  - Rojo = letra no está en la palabra
- **Modos**:
  - **Amigos**: Un jugador ingresa la palabra secreta.
  - **Solitario**: El juego selecciona una palabra del diccionario.

## Basketball
- **Objetivo**: Sumar más puntos tras el número de rondas.
- Cada ronda tiene dos posesiones (una por jugador).
- **Ataque**: Tiro de 2 o 3 puntos.
- **Defensa**: Estándar o agresiva (más bloqueos, más faltas).

## 2048
- **Objetivo**: Unir fichas hasta llegar a 2048.
- **Controles**: `W` (arriba), `A` (izquierda), `S` (abajo), `D` (derecha).
- Si no hay movimientos disponibles, el juego termina.

## Capturas
Las capturas están en `docs/images/`.

![Wordle](images/wordle.png)
![Basketball](images/basketball.png)
![2048](images/2048.png)

## Solución de Problemas
- Si la entrada falla, presiona Enter y vuelve a intentar.
- Si el juego se cierra, reinicia desde el menú principal.
