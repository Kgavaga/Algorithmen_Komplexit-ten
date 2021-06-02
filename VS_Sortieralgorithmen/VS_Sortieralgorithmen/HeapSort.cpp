#include <iostream>
#include <math.h>
#include "HeapSort.h"

int* HeapSort::sort(int* inputList, size_t len)
{
	std::cout << "Heap sort:\n";

	buildMaxHeap(inputList, len);
	for (int i = len-1; i >= 0; i--)
	{
		swap(&(inputList[i]), &(inputList[0]));
		heapify(inputList, i, 0);
	}
	return inputList;
}

int* HeapSort::buildMaxHeap(int* inputList, size_t len)
{
	for (int i = std::floor(len/2)-1; i >= 0; i--)
	{
		heapify(inputList, len, i);
	}
	return inputList;
}

int* HeapSort::heapify(int* inputList, size_t len, int index)
{
	int leftIndex = 2 * (index+1) -1;
	int rightIndex = 2 * (index+1);

	int maxIndex = index;
	if (leftIndex < len && inputList[leftIndex] > inputList[index]) // Es muss defintiv geprüft werden ob leftIndex < len
	{
		maxIndex = leftIndex;
	}

	if (rightIndex < len && inputList[rightIndex] > inputList[maxIndex])
	{
		maxIndex = rightIndex;
	}

	if (maxIndex != index)
	{
		swap(&(inputList[index]), &(inputList[maxIndex]));
		heapify(inputList, len, maxIndex);
	}
	return inputList;
}
