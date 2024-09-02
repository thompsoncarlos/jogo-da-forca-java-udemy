import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProjetoJogoDaForca {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> palavrasSecretas = new ArrayList<>(); // ArrayList que irá conter 3 palavras secretas
		palavrasSecretas.add("cobra"); // cobra está no índice 0 e tem 5 letras
		palavrasSecretas.add("elefante"); // elefante está no índice 1 e tem 8 letras
		palavrasSecretas.add("girafa"); // girafa está no índice 2 e tem 6 letras

		Random random = new Random();
		int tamanhoDoArrayList = palavrasSecretas.size();
		int indiceDaPalavraAleatoriaGerada = random.nextInt(tamanhoDoArrayList);
		String palavraSecreta = palavrasSecretas.get(indiceDaPalavraAleatoriaGerada); // Seleciona uma palavra secreta aleatoriamente

		ArrayList<Character> letrasDescobertas = new ArrayList<>(); // ArrayList ara armazenar as letras descobertas

		for(int i = 0; i < palavraSecreta.length(); i++) {
			letrasDescobertas.add('_'); // Inicializa com traços para cada letra
		}

		int tentativas = 6; // Número máximo de tentativas
		boolean palavraFoiDescoberta = false; // Adiciona uma flag para verificar se a palavra foi descoberta

		// Enquanto a palavraFoiDescoberta não for descoberta
		// ou ainda houver tentativas para descobrir o programa continuará
		while (!palavraFoiDescoberta && tentativas > 0) {
			System.out.println("Palavra: " + letrasDescobertas);
			System.out.print("Chute uma letra: ");
			char chute = scanner.next().charAt(0);

			boolean acertou = false;
			for (int i = 0; i < palavraSecreta.length(); i++) {
				// Vou passar por cada letra da palavra.
				if (palavraSecreta.charAt(i) == chute) { // Verifico cada letra da palavra secreta se é igual ao chute
					letrasDescobertas.set(i, chute); // Se for igual, eu coloco na lista de descobertas, na posicao certa
					acertou = true;
				}
			}

			if (!acertou) {
				tentativas--;
				System.out.println("Você tem mais " + tentativas + " tentativas.");
			}

			// Verifica se a palavra foi completamente descoberta
			palavraFoiDescoberta = !letrasDescobertas.contains('_');
		}

		if (palavraFoiDescoberta) {
			System.out.println("Parabéns, você acertou! A palavra era: " + palavraSecreta);
		} else {
			System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
		}
	}
}