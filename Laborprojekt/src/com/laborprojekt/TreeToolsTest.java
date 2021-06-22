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

		StdOut.println();

		int num1 = StdIn.readInt();
		int num2 = StdIn.readInt();
		while(true) {
			runTest(num1, num2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void runTest(int numberOfSearchTrees, int numberOfKnots)
	{
		double average = 0;
		for (int i = 0; i < numberOfSearchTrees; i++) {
			int result = TreeTools.treeHeight(generateRandomSearchTree(numberOfKnots));
			StdOut.println("Hoehe Suchbaum " + i + ": " + result);
			average += result;
		}
		average /= numberOfSearchTrees;
		StdOut.println("Durchschnittliche Hoehe: " + average + " (entspricht " + average/(Math.log(numberOfKnots)/Math.log(2)) + " * log(n))");
	}
	
	private static Tree generateRandomSearchTree(int numberOfKnots){
		SearchTree st = new SearchTree();
		int[] numberArray = generateNumberArray(numberOfKnots);
		StdRandom.shuffle(numberArray);
		for (int i = 0; i < numberOfKnots; i++) {
			st.insert(numberArray[i]);
		}
		return st;
	}
	
	private static int[] generateNumberArray(int len) {
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = i;
		}
		return result;
	}
	
}
