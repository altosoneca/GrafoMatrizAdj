import java.util.HashMap;

public class GrafoMatriz {
	int[][] matriz;
	HashMap<String, Integer> hashMap;

	public GrafoMatriz(int n) {
		matriz = new int[n][n];
		hashMap = new HashMap<String, Integer>();
	}

	public HashMap<String, Integer> getHashMap() {
		return hashMap;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void addAresta(String inicio, String destino) {
		if (hashMap.isEmpty()) {
			hashMap.put(inicio, hashMap.size());
		}
		if (!hashMap.containsKey(destino)) {

			hashMap.put(destino, hashMap.size());
		}
		if (hashMap.containsKey(inicio)) {
			int n = hashMap.get(inicio);
		} else {
			hashMap.put(inicio, hashMap.size());
		}
		if (hashMap.containsKey(destino)) {
			int n = hashMap.get(destino);
		} else {
			hashMap.put(destino, hashMap.size());
		}

		matriz[hashMap.get(inicio)][hashMap.get(destino)] = 1;

	}

	public void showMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			System.out.println();
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]);

			}
		}
	}

	public void valorAtribuidoArestas() {
		System.out.println(hashMap);
	}

	public boolean arcoExiste(String a, String b) {

		if (!hashMap.containsKey(a) || !hashMap.containsKey(b)) {
			return false;
		}
		int um = hashMap.get(a);
		int dois = hashMap.get(b);
		if (hashMap.containsKey(a)) {

			for (int i = 0; i < matriz[um].length; i++) {
				if (matriz[um][dois] == 1) {
					return true;
				}
			}

		} else if (hashMap.containsKey(b)) {
			for (int i = 0; i < matriz[dois].length; i++) {
				if (matriz[dois][um] == 1) {
					return true;
				}
			}
		}
		return false;

	}
}
