import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Utilitarios {

	public void gravarArquivoMatriz(GrafoMatriz Gm) throws IOException {
		int[][] matriz = Gm.getMatriz();
		HashMap<String, Integer> hashMap = Gm.getHashMap();
		FileWriter arq = new FileWriter("src/Matriz.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.print(Gm.getMatriz().length);
		gravarArq.println();
		for (int i = 0; i < matriz.length; i++) {
			gravarArq.printf((String) getKeyFromValue(hashMap, i) + "|");
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == 1) {
					gravarArq.printf((String) getKeyFromValue(hashMap, j));
				}
			}
			gravarArq.println();

		}

		arq.close();

	}

	public void lerArquivoMatriz(String txt) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(txt));
		while (in.hasNextLine()) {
			String line = in.nextLine();
			System.out.println(line);
		}
	}

	public static Object getKeyFromValue(Map hm, Object value) {
		for (Object o : hm.keySet()) {
			if (hm.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}
}
