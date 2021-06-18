#include <iostream>
#include <cmath>
#include <random>
#include <fstream>
#include "BubbleSort.h"
#include "SelectionSort.h"
#include "MergeSort.h"
#include "QuickSort.h"
#include "HeapSort.h"
#include "InternalQuickSort.h"

//-selection ../res/list_1000.txt ../res/Output.txt

constexpr auto INTEGER_LIMIT = 2147483647;;

int* getRandomArray(int lowerBound, int upperBound, const size_t len)
{
	int* numberList = new int[len];

	for (size_t i = 0; i < len; i++)
	{
		numberList[i] = (rand() % ((upperBound + 1) - lowerBound) + lowerBound);
	}
	return numberList;
}

int* getGoodArray(int len)
{
	int* numberList = new int[len];

	for (int i = 0; i < len; i++)
	{
		numberList[i] = i;
	}
	return numberList;
}

int* getBadArray(int len)
{
	int* numberList = new int[len];

	for (int i = len; i > 0; i--)
	{
		numberList[len - i] = i;
	}
	return numberList;
}

void printArray(int* inputList, size_t len)
{
	for (size_t i = 0; i < len; i++)
	{
		std::cout << inputList[i] << " ";
	}
	std::cout << std::endl;
}

void copyArray(int* a, int* b, size_t len)
{
	for (size_t i = 0; i < len; i++) {
		b[i] = a[i];
	}
}

int* cloneArray(const int* inputList, size_t len)
{
	int* result = new int[len];
	for (size_t i = 0; i < len; i++) {
		result[i] = inputList[i];
	}
	return result;
}

int* readFile(std::string path, int len)
{
	int* result = new int[len];

	std::ifstream inFile;
	inFile.open(path);
	if (!inFile) {
		std::cout << "Unable to open file!" << std::endl;
		exit(1); // terminate
	}

	std::string line;
	int i = 0;
	while (i < len && std::getline(inFile, line))
	{
		*(result + i) = std::stoi(line);
		i++;
	}
	inFile.close();

	return result;
}

void writeFile(std::string path, int* inputList, int len)
{
	std::ofstream outFile;
	outFile.open(path, std::ios::out);
	if (!outFile) {
		std::cout << "Unable to write to file!" << std::endl;
		exit(1); // terminate
	}

	for (int i = 0; i < len; i++)
	{
		outFile << inputList[i] << std::endl;
	}
	outFile.close();
}

long long getNumberOfLinesInFile(std::string path)
{
	long long result = 0;

	std::ifstream inFile;
	inFile.open(path);
	if (!inFile) {
		std::cout << "Unable to open file!" << std::endl;
		exit(1); // terminate
	}

	std::string line;
	while (std::getline(inFile, line))
	{
		result++;
	}
	inFile.close();

	return result;
}

void runAllAlgorithms(const int* inputList, size_t len, bool printArrays = true)
{
	BubbleSort* bubble = new BubbleSort();
	SelectionSort* selection = new SelectionSort();
	MergeSort* merge = new MergeSort();
	QuickSort* quick = new QuickSort();
	HeapSort* heap = new HeapSort();
	InternalQuickSort* internalQuick = new InternalQuickSort();
	SortingAlgorithm* algorithms[] = { internalQuick, heap, quick, merge, selection, bubble };

	for (size_t i = 0; i < std::size(algorithms); i++)
	{
		int* result = algorithms[i]->sortAndTime(cloneArray(inputList, len), len);
		if (printArrays) {
			std::cout << "Array: ";
			printArray(result, len);
		}
		std::cout << "Duration: " << algorithms[i]->getDuration() << std::endl;
		delete[] result;
	}
}

int main(int argc, char** argv)
{
	size_t arrayLen = 100;
	const bool printArrays = false;
	int* a;

	if (argc > 1)
	{
		std::string mode = "";
		std::string inputFilePath = "";
		std::string outputFilePath = "";

		mode = argv[1];
		inputFilePath = argv[2];
		outputFilePath = argv[3];

		SortingAlgorithm* algorithm = nullptr;
		if (mode == "-selection")
			algorithm = new SelectionSort();
		else if (mode == "-bubble")
			algorithm = new BubbleSort();
		else if (mode == "-merge")
			algorithm = new MergeSort();
		else if (mode == "-quick")
			algorithm = new QuickSort();
		else if (mode == "-heap")
			algorithm = new HeapSort();

		arrayLen = getNumberOfLinesInFile(inputFilePath);
		a = readFile(inputFilePath, arrayLen);

		if (printArrays)
		{
			std::cout << "Anfangs-Array:" << std::endl;
			printArray(a, arrayLen);
		}
		std::cout << std::endl;

		int* result = algorithm->sortAndTime(cloneArray(a, arrayLen), arrayLen);
		if (printArrays) {
			std::cout << "Array: ";
			printArray(result, arrayLen);
		}
		std::cout << "Duration: " << algorithm->getDuration() << std::endl;

		writeFile(outputFilePath, result, arrayLen);

		delete[] result;
	}
	else {
		//a = getRandomArray(1, 50, arrayLen);
		//a = getGoodArray(arrayLen);
		//a = getBadArray(arrayLen);

		for (size_t i = 0; i < 5; i++)
		{
			double len = std::pow(10, i+1);
			std::string path = "../res/list_" + std::to_string(static_cast<int>(len)) + "auf.txt";
			a = readFile(path, len);
			if (printArrays)
			{
				std::cout << "Anfangs-Array:" << std::endl;
				printArray(a, len);
			}
			std::cout << std::endl;

			runAllAlgorithms(a, len, printArrays);
			std::cout << std::endl;
		}
	}

	delete[] a;

	return 0;
}