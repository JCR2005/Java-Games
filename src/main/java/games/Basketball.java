package games;

import java.util.Random;
import java.util.Scanner;

import utils.GameStats;
import utils.Posters;
import utils.Utils;

/**
 * Juego de Basketball por rondas con dos jugadores.
 * Controla el flujo de turnos, tiros, defensas y cálculo de puntos.
 */
public class Basketball {

	private final Posters posters = new Posters();
	private final Utils utils = new Utils();
	private final Scanner inputUser = new Scanner(System.in);
	private final Random random = new Random();

	private static final int MIN_ROUNDS = 1;
	private static final int MAX_ROUNDS = 10;

	/**
	 * Inicia el menú principal del juego Basketball.
	 */
	public void startBasketball() {

		GameStats.registerBasketballStart();
		while (true) {
			posters.showBasketballBanner();
			posters.showBasketballMenu();

			String option = inputUser.nextLine();

			switch (option) {
				case "1" -> showInstructions();
				case "2" -> playMatch();
				case "3" -> {
					return;
				}
				default -> posters.showMesageWarningMemu(inputUser);
			}
		}
	}

	/**
	 * Muestra las instrucciones del juego.
	 */
	private void showInstructions() {
		posters.showBasketballInstructions();
		inputUser.nextLine();
	}

	/**
	 * Ejecuta el ciclo principal del partido.
	 */
	private void playMatch() {
		utils.cleanScreem();

		String playerOne = requestPlayerName("Jugador 1");
		String playerTwo = requestPlayerName("Jugador 2");
		int rounds = requestRounds();

		int scoreOne = 0;
		int scoreTwo = 0;
		boolean playerOneStarts = random.nextBoolean();

		for (int round = 1; round <= rounds; round++) {
			posters.showBasketballRound(round, rounds);

			if (playerOneStarts) {
				scoreOne += playPossession(playerOne, playerTwo);
				scoreTwo += playPossession(playerTwo, playerOne);
			} else {
				scoreTwo += playPossession(playerTwo, playerOne);
				scoreOne += playPossession(playerOne, playerTwo);
			}

			posters.showBasketballScoreboard(playerOne, scoreOne, playerTwo, scoreTwo);
			posters.showBasketballContinue(inputUser);
			playerOneStarts = !playerOneStarts;
		}

		posters.showBasketballWinner(playerOne, scoreOne, playerTwo, scoreTwo, inputUser);
	}

	/**
	 * Solicita el nombre de un jugador y valida que no sea vacío.
	 *
	 * @param label etiqueta para mostrar al usuario
	 * @return nombre del jugador
	 */
	private String requestPlayerName(String label) {
		String name = "";

		do {
			posters.showBasketballInputPrompt("Ingrese nombre del " + label + ":");
			name = inputUser.nextLine().trim();

			if (name.isEmpty()) {
				posters.showMesageWarningMemu(inputUser);
			}
		} while (name.isEmpty());

		return name;
	}

	/**
	 * Solicita el número de rondas y valida el rango permitido.
	 *
	 * @return número de rondas
	 */
	private int requestRounds() {
		while (true) {
			posters.showBasketballInputPrompt("Digite el número de rondas (" + MIN_ROUNDS + "-" + MAX_ROUNDS + "):");
			String raw = inputUser.nextLine().trim();

			try {
				int rounds = Integer.parseInt(raw);
				if (rounds >= MIN_ROUNDS && rounds <= MAX_ROUNDS) {
					return rounds;
				}
			} catch (NumberFormatException ignored) {
			}

			posters.showMesageWarningMemu(inputUser);
		}
	}

	/**
	 * Ejecuta una posesión completa (tiro + defensa) y devuelve puntos.
	 *
	 * @param attacker jugador en ataque
	 * @param defender jugador en defensa
	 * @return puntos anotados por el atacante
	 */
	private int playPossession(String attacker, String defender) {
		
		ShotType shot = requestShotType(attacker);

		posters.showBasketballDefenseMenu(defender);
		DefenseType defense = requestDefenseType();

		return resolvePossession(attacker, defender, shot, defense);
	}

	/**
	 * Solicita el tipo de tiro al usuario.
	 *
	 * @return tipo de tiro seleccionado
	 */
	private ShotType requestShotType(String attacker) {
		while (true) {
            posters.showBasketballActionMenu(attacker);
			String option = inputUser.nextLine();
			switch (option) {
				case "1" -> {
					return ShotType.THREE_POINTER;
				}
				case "2" -> {
					return ShotType.TWO_POINTER;
				}
				default -> posters.showMesageWarningMemu(inputUser);
			}
		}
	}

	/**
	 * Solicita el tipo de defensa al usuario.
	 *
	 * @return tipo de defensa seleccionado
	 */
	private DefenseType requestDefenseType() {
		while (true) {
			String option = inputUser.nextLine();
			switch (option) {
				case "1" -> {
					return DefenseType.STANDARD;
				}
				case "2" -> {
					return DefenseType.AGGRESSIVE;
				}
				default -> posters.showMesageWarningMemu(inputUser);
			}
		}
	}

	/**
	 * Resuelve el resultado de una posesión según la defensa y el tipo de tiro.
	 *
	 * @param attacker jugador en ataque
	 * @param defender jugador en defensa
	 * @param shot tipo de tiro
	 * @param defense tipo de defensa
	 * @return puntos anotados
	 */
	private int resolvePossession(String attacker, String defender, ShotType shot, DefenseType defense) {
		double foulRoll = random.nextDouble();
		if (foulRoll < defense.foulChance) {
			posters.showBasketballFoul(attacker, defender);
			return takeFreeThrows(attacker);
		}

		double successChance = clamp(shot.baseSuccess - defense.blockPenalty, 0.1, 0.9);
		boolean scored = random.nextDouble() < successChance;

		if (scored) {
			posters.showBasketballShotMade(attacker, shot.points);
			return shot.points;
		}

		posters.showBasketballShotMissed(attacker);
		return 0;
	}

	/**
	 * Ejecuta los tiros libres y devuelve los puntos obtenidos.
	 *
	 * @param player jugador que lanza
	 * @return puntos anotados
	 */
	private int takeFreeThrows(String player) {
		int points = 0;
		for (int i = 0; i < 2; i++) {
			boolean scored = random.nextDouble() < 0.75;
			if (scored) {
				points++;
			}
		}

		posters.showBasketballFreeThrowResult(player, points);
		return points;
	}

	/**
	 * Ajusta un valor al rango indicado.
	 *
	 * @param value valor original
	 * @param min límite inferior
	 * @param max límite superior
	 * @return valor ajustado
	 */
	private double clamp(double value, double min, double max) {
		return Math.max(min, Math.min(max, value));
	}

	private enum ShotType {
		THREE_POINTER(3, 0.45),
		TWO_POINTER(2, 0.6);

		private final int points;
		private final double baseSuccess;

		ShotType(int points, double baseSuccess) {
			this.points = points;
			this.baseSuccess = baseSuccess;
		}
	}

	private enum DefenseType {
		STANDARD(0.0, 0.12),
		AGGRESSIVE(0.12, 0.28);

		private final double blockPenalty;
		private final double foulChance;

		DefenseType(double blockPenalty, double foulChance) {
			this.blockPenalty = blockPenalty;
			this.foulChance = foulChance;
		}
	}
}
