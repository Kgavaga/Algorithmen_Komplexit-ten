#include <iostream>
#include "QuickSort.h"

int* QuickSort::sort(int* inputList, size_t len)
{
	std::cout << "Quick sort:\n";
	recursiveSort(inputList, 0, len - 1);
	return inputList;
}

int* QuickSort::recursiveSort(int* inputList, size_t begin, size_t end)
{
	if (end <= begin) return inputList;
	int pivotIndex = (begin + end) / 2;
	int pivotElement = inputList[pivotIndex];
	int left = begin;
	int right = end;

	while (right > left)
	{
		while (inputList[left] < pivotElement) left++;
		while (inputList[right] > pivotElement) right--;

		if (left <= right)
		{
			swap(&(inputList[left]), &(inputList[right]));
			left++;
			right--;
		}
	}
	if(begin < left)
		recursiveSort(inputList, begin, right);
	if(end > right)
		recursiveSort(inputList, left, end);
	return inputList;
}
