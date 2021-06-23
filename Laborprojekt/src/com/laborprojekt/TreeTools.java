package com.laborprojekt;
/******************************  TreeTools.java  ******************************/

import java.util.Iterator;

/**
 * Tool-Klasse mit einigen Algorithmen fuer Baeume
 */

public class TreeTools {

	/**
	 * Ermittelt die Hoehe eines Baumes.
	 * Alle Pfade abgehen und den längsten Pfad zurückgeben (Anzahl Knoten)
	 * @param b der zu uebergebende Baum
	 * @return Hoehe des Baumes
	 */
	public static int treeHeight(Tree b) {
		if(b.empty()) return 0; // Fängt ab, dass left() oder right() keine RuntimeException ausgeben
		if(b.isLeaf()) return 1;
		return Math.max(treeHeight(b.left()), treeHeight(b.right())) + 1 ; // Das +1 zählt die Ebene
	}

	/**
	 * Ermittelt die Anzahl der Knoten eines Baumes.
	 * // Wieder Rekursion anwenden, nur hier alle Knoten zählen.
	 * @param b der zu uebergebende Baum
	 * @return Anzahl der Knoten des Baumes
	 */
	public static int anzahlKnoten(Tree b) {
		if (b.empty())return 0;
		if (b.isLeaf()) return 1; // Zählt das Blatt
		return anzahlKnoten(b.left()) + anzahlKnoten(b.right()) + 1; // Das +1 zählt den inneren Knoten
	}

	/**
	 * gibt den übergebenen Baum in Inorder-Traversierung mit Klammerung aus
	 * 
	 * @param b der zu uebergebende Baum
	 */
	public static void printTreeInorderWithParenthesis(Tree b) {
		if (b.empty()) return; // Fängt ab, dass left() oder right() keine RuntimeException ausgeben

		if (b.isLeaf()) {
			StdOut.print(b.value()); // Wenn es ein Blatt ist, einfach den Inhalt ausgeben.
			return;
		}
		StdOut.print("(");
		printTreeInorderWithParenthesis(b.left());
		StdOut.print(b.value()); // Hier erfolgt die Ausgabe der inneren Knoten
		printTreeInorderWithParenthesis(b.right());
		StdOut.print(")");
	}

	/**
	 * Gibt den übergebenen Baum in Levelorder-Traversierung aus
	 * 
	 * @param b der zu uebergebende Baum
	 */
	public static void printTreeLevelorder(Tree b) {
		// Erstellt eine Array aus Knoten (Teilbäume) mit der Größe, der vollständige Version
		// des Baumes (also max. Knoten)
		Tree knotsList[] = new Tree[(int) (Math.pow(2, anzahlKnoten(b)) - 1)];
		printTreeLevelorder(b, knotsList, 1);
		for (Tree k : knotsList) {
			if (k != null)
				StdOut.print(k.value() + " ");
		}
	}

	private static void printTreeLevelorder(Tree b, Tree[] knotsList, int index) {
		if (b.empty())return;

		knotsList[index - 1] = b; // -1 um den Index zu korrigieren, da die Array von 0 beginnt.

		if (!b.isLeaf()) {
			printTreeLevelorder(b.left(), knotsList, 2 * index);
			printTreeLevelorder(b.right(), knotsList, 2 * index + 1);
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
		for (int i : zahlen) {
			st.insert(i); // Nacheinander die Elemente der Array zahlen in den Suchbaum einfügen.
		}
		//printTree(st);
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
		if (b.empty())return;
		tree2SortedStack(b.left(), k);
		k.push(b.value()); // Hier wird der Knoten auf den Stack gepusht.
		tree2SortedStack(b.right(), k);
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
