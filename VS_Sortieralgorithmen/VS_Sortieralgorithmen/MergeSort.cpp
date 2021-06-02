#include <iostream>
#include "MergeSort.h"

int* MergeSort::sort(int* inputList, size_t len)
{
	std::cout << "Merge sort:\n";
	return recursiveSort(inputList, len);
}

int* iterativeSort(int* inputList, size_t len)
{

}

int* MergeSort::recursiveSort(int* inputList, size_t len)
{
	if (len == 1)
	{
		return inputList;
	}
	else {
		int halfValue = len / 2;
		size_t firstListLen = halfValue;
		size_t secondListLen = len - halfValue;
		int* firstList = new int[firstListLen];
		int* secondList = new int[secondListLen];

		for (size_t i = 0; i < halfValue; i++)
		{
			firstList[i] = inputList[i];
		}
		for (size_t i = 0; i < secondListLen; i++)
		{
			secondList[i] = inputList[halfValue+i];
		}
		int* firstSortedList = recursiveSort(firstList, firstListLen);
		int* secondSortedList = recursiveSort(secondList, secondListLen);
		int* result = merge(firstSortedList, firstListLen, secondSortedList, secondListLen);
		
		if(firstList != firstSortedList) //Sometimes they are the same beacause sometime recursiveSort returns inputList
			delete[] firstList;
		if(secondList != secondSortedList)
			delete[] secondList;
		delete[] firstSortedList;
		delete[] secondSortedList;

		return result;
	}
}

int* MergeSort::merge(int* firstList, size_t len1, int* secondList, size_t len2)
{
	int* result = new int[len1 + len2];

	size_t firstIndex = 0;
	size_t secondIndex = 0;

	size_t max = len1 + len2;
	while (firstIndex + secondIndex < max)
	{
		if (firstIndex >= len1)
		{
			while (secondIndex < len2)
			{
				result[firstIndex + secondIndex] = secondList[secondIndex];
				secondIndex++;
			}
		}
		else if (secondIndex >= len2)
		{
			while (firstIndex < len1)
			{
				result[firstIndex + secondIndex] = firstList[firstIndex];
				firstIndex++;
			}
		}
		else if (firstList[firstIndex] <= secondList[secondIndex]) //Damit sollte es stabil sein
		{
			result[firstIndex + secondIndex] = firstList[firstIndex];
			firstIndex++;
		} 
		else if (firstList[firstIndex] > secondList[secondIndex])
		{
			result[firstIndex + secondIndex] = secondList[secondIndex];
			secondIndex++;
		}
	}
	return result;
}


