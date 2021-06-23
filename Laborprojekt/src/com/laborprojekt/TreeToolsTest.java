package com.laborprojekt;
/******************************  TreeToolsTest.java  **************************/

/**
 * Test fuer die Klasse TreeTools
 */

public class TreeToolsTest {

	public static void main(String[] argv) {

		// Erzeuge einen Test-Baum
		LinkedTree a = new LinkedTree(new Character('A'));
		LinkedTree b = new LinkedTree(new Character('B'));
		LinkedTree m = new LinkedTree(a, new Character('*'), b);
		LinkedTree f = new LinkedTree(new Character('F'));
		LinkedTree p = new LinkedTree(f, new Character('+'), m);
		LinkedTree x = new LinkedTree(new Character('X'));
		LinkedTree y = new LinkedTree(new Character('Y'));
		LinkedTree n = new LinkedTree(x, new Character('-'), y);
		LinkedTree d = new LinkedTree(p, new Character('/'), n);

		// Testet treeHeight(), anzahlKnoten(),
		// printTreeInorderWithParenthesis(), printTreeLevelorder()
		// searchTreeSort()

		TreeTools.printTree(d);

		StdOut.println("Baumhoehe laut Methode (sollte 4 sein): " + TreeTools.treeHeight(d));

		StdOut.println("Anzahl Knoten laut Methode (sollte 9 sein): " + TreeTools.anzahlKnoten(d));

		StdOut.print("Ausdruck mit Klammerung: ");
		TreeTools.printTreeInorderWithParenthesis(d);
		StdOut.println();

		StdOut.print("Baum ebenenweise: ");
		TreeTools.printTreeLevelorder(d);
		StdOut.println();

		StdOut.println("Sortiere  6194283");
		int[] list = { 6, 1, 9, 4, 2, 8, 3 };
		list = TreeTools.searchTreeSort(list);
		StdOut.print("Ergebnis (sollte 1234689 sein): ");
		for (int i = 0; i < list.length; i++) {
			StdOut.print(list[i]);
		}

		StdOut.println("\n");
		
		StdOut.println("Gebe ein, wie viele Baeume generiert werden sollen.");
		int num1 = StdIn.readInt();
		StdOut.println("Gebe ein, wie viele Knoten jeder Baum besitzen soll.");
		int num2 = StdIn.readInt();
		evaluateAverageHeightOfTrees(num1, num2);
	}

	/**
	 * Generiert einen zufällige Suchbäume und rechnet die Höhe dieser aus.
	 * Am Ende mittelt es die Ergebnise zu einer durschnittlichen Höhe
	 * @param numberOfSearchTrees, numberOfKnots
	 * @return Tree
	 */
	private static void evaluateAverageHeightOfTrees(int numberOfSearchTrees, int numberOfKnots)
	{
		double average = 0;
		for (int i = 0; i < numberOfSearchTrees; i++) {
			//Größe eines zufällig generierten Baumes ermitteln
			int result = TreeTools.treeHeight(generateRandomSearchTree(numberOfKnots));
			StdOut.println("Hoehe Suchbaum " + i + ": " + result);
			average += result;
		}
		average /= numberOfSearchTrees;
		//Average soll bei der Ausgabe aufgerundet werden, deswegen der Cast.
		StdOut.println("Durchschnittliche Hoehe: " + (int)average + " (entspricht " + average/(Math.log(numberOfKnots)/Math.log(2)) + " * log(n))");
	}
	
	/**
	 * Generiert einen zufälligen Suchbaum mit numberOfKnots Knoten
	 * @param numberOfKnots - AnzahlKnoten
	 * @return Tree
	 */
	private static Tree generateRandomSearchTree(int numberOfKnots){
		SearchTree st = new SearchTree();
		int[] numberArray = generateNumberArray(numberOfKnots);
		StdRandom.shuffle(numberArray);
		for (int i = 0; i < numberOfKnots; i++) {
			st.insert(numberArray[i]); // Alle Elemente der numberArray einzeln in den Suchbaum einfügen
		}
		return st;
	}
	
	/**
	 * Generiert ein hochzählendes Array der Größe len
	 * @param len - Elementenanzahl
	 * @return int[]
	 */
	private static int[] generateNumberArray(int len) {
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = i;
		}
		return result;
	}
	
}
