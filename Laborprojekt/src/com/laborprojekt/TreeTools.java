package com.laborprojekt;
/******************************  TreeTools.java  ******************************/

import java.util.Iterator;

/**
 * Tool-Klasse mit einigen Algorithmen fuer Baeume
 */

public class TreeTools {

	/**
	 * Ermittelt die Hoehe eines Baumes
	 * 
	 * @param b der zu uebergebende Baum
	 * @return Hoehe des Baumes
	 */
	public static int treeHeight(Tree b) {
		return treeHeight(b, 0);
	}

	public static int treeHeight(Tree b, int counter) {
		// TODO
		// Alle Pfade abgehen und den lächsten Pfad zurückgeben (Anzahl Knoten)
		if (b.empty()) {
			return counter;
		}

		if (b.isLeaf()) {
			return ++counter;
		} else {
			counter++; // Zählt die Ebene auf der die Rekursion ist.
			int result1 = 0;
			int result2 = 0;
			try {
				result1 = treeHeight(b.left(), counter);
			} catch (RuntimeException re) {
			}
			try {
				result2 = treeHeight(b.right(), counter);
			} catch (RuntimeException re) {
			}
			return (result1 > result2) ? result1 : result2;
		}
	}

	/**
	 * Ermittelt die Anzahl der Knoten eines Baumes
	 * 
	 * @param b der zu uebergebende Baum
	 * @return Anzahl der Knoten des Baumes
	 */
	public static int anzahlKnoten(Tree b) {
		return anzahlKnoten(b, 0);
	}

	public static int anzahlKnoten(Tree b, int counter) {
		// TODO
		// Wieder Rekursion anwenden, nur hier alle Knoten zählen.
		if (!b.empty()) {
			counter++;
		}
		if (b.isLeaf()) {
			return counter;
		} else {
			try {
				counter = anzahlKnoten(b.left(), counter);
			} catch (RuntimeException re) {
			}
			try {
				counter = anzahlKnoten(b.right(), counter);
			} catch (RuntimeException re) {
			}
			return counter;
		}
	}

	/**
	 * gibt den übergebenen Baum in Inorder-Traversierung mit Klammerung aus
	 * 
	 * @param b der zu uebergebende Baum
	 */
	public static void printTreeInorderWithParenthesis(Tree b) {
		// TODO
		if (b.empty())
			return;

		if (b.isLeaf()) {
			StdOut.print(b.value());
			return;
		}

		StdOut.print("(");
		try {
			printTreeInorderWithParenthesis(b.left());
		} catch (RuntimeException re) {
		}
		StdOut.print(b.value());
		try {
			printTreeInorderWithParenthesis(b.right());
		} catch (RuntimeException re) {
		}
		StdOut.print(")");
	}

	/**
	 * gibt den übergebenen Baum in Levelorder-Traversierung aus
	 * 
	 * @param b der zu uebergebende Baum
	 */
	public static void printTreeLevelorder(Tree b) {
		Tree knotsList[] = new Tree[(int) (Math.pow(2, anzahlKnoten(b)) - 1)];
		printTreeLevelorder(b, knotsList, 1);
		for (Tree k : knotsList) {
			if (k != null)
				StdOut.print(k.value() + " ");
		}

	}

	public static void printTreeLevelorder(Tree b, Tree[] knotsList, int index) {
		// TODO
		if (b.empty())
			return;

		knotsList[index - 1] = b;

		if (b.isLeaf()) {
			return;
		} else {
			try {
				printTreeLevelorder(b.left(), knotsList, 2 * index);
			} catch (RuntimeException re) {
			}
			try {
				printTreeLevelorder(b.right(), knotsList, 2 * index + 1);
			} catch (RuntimeException re) {
			}
		}
	}

	/**
	 * Sortiert gegebene Zahlenfolge per Suchbaum
	 * 
	 * @param zahlen zu sortierende Zahlenfolge
	 * @return sortierte Folge
	 */
	public static int[] searchTreeSort(int[] zahlen) {
		SearchTree st = new SearchTree();
		// TODO
		for (int i : zahlen) {
			st.insert(i);
		}
		printTree(st);
		LinkedStack ls = new LinkedStack(); 
		tree2SortedStack(st, ls);
		int[] result = new int[zahlen.length];
		for (int i = zahlen.length-1; i >= 0; i--) {
			result[i] = (int) ls.top();
			ls.pop();
		} 
		return result;
	}

	/**
	 * Helfermethode zum sortieren von Elementen im SearchTree
	 * 
	 * @param b SearchTree mit zu sortierendem Inhalt
	 * @param k Stack in den der SearchTree Inhalt sortiert werden soll
	 */
	private static void tree2SortedStack(Tree b, Stack k) {
		if (b.empty())
			return;

		if (b.isLeaf()) {
			k.push(b.value());
			return;
		}

		try {
			tree2SortedStack(b.left(), k);
		} catch (RuntimeException re) {
		}
		k.push(b.value());
		try {
			tree2SortedStack(b.right(), k);
		} catch (RuntimeException re) {
		}

	}

	/**
	 * Druckt einen Baum auf der Konsole ebenenweise aus. Nutzt treeHeight(Tree),
	 * printLevel(Tree,int,int) und spaces(int).
	 * 
	 * @param b der zu druckende Baum
	 */
	public static void printTree(Tree b) {

		// Berechne die Hoehe des Baumes
		int resthoehe = treeHeight(b);

		// Gehe die Ebenen des Baumes durch
		for (int i = 0; i < resthoehe; i++) {
			// Drucke die Ebene, beruecksichtige Anzahl der Leerzeichen
			// fuer korrekte Einrueckung
			printLevel(b, i, spaces(resthoehe - i));
			StdOut.println();
			StdOut.println();
		}
	}

	/**
	 * Druckt eine Ebene eines Baumes aehnlich der Breitensuche. 0 ist dabei die
	 * Wurzel. Vor und nach jedem Element werden Leerzeichen eingefuegt.
	 * 
	 * @param b      der auszugebende Baum
	 * @param ebene  die gewuenschte Ebene beginnend bei 0
	 * @param spaces Anzahl von Leerzeichen vor und nach jedem Element
	 */
	public static void printLevel(Tree b, int level, int spaces) {

		// Wenn 0 erreicht, drucke Element mit Leerzeichen
		if (level == 0) {

			for (int i = 0; i < spaces; i++)
				StdOut.print(" ");
			if (b != null) {
				StdOut.print(b.value());
			} else { // Wenn Nullzeiger uebergeben wurde, ein Leerzeichen drucken
				StdOut.print(" ");
			}
			for (int i = 0; i <= spaces; i++)
				StdOut.print(" ");

		} else {

			// Steige rekursiv ab, betrachte Soehne als Teilbaeume und verringere
			// dabei die zu druckende Ebene. In endende Aeste wird mit dem Nullzeiger
			// gelaufen.
			if (b != null && !b.left().empty()) {
				printLevel(b.left(), level - 1, spaces);
			} else {
				printLevel(null, level - 1, spaces);
			}

			if (b != null && !b.right().empty()) {
				printLevel(b.right(), level - 1, spaces);
			} else {
				printLevel(null, level - 1, spaces);
			}
		}
	}

	/**
	 * Berechnet die Anzahl an benoetigten Leerzeichen fuer eine korrekte
	 * Einrueckung, also 0.5 * (2^(level) - 2).
	 * 
	 * @param level die Ebene, Blaetter sind Ebene 1, darueber aufsteigend
	 * @return Anzahl der Leerzeichen zur Elementtrennung
	 */
	private static int spaces(int level) {

		if (level == 1) {
			return 0;
		} else {
			// verdoppele die Leerzeichen gegenueber der Ebene darunter
			// und fuege ein weiteres Leerzeichen hinzu
			return 2 * spaces(level - 1) + 1;
		}
	}
}
