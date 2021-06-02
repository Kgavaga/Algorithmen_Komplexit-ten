#include <iostream>
#include <stdlib.h>     /* qsort */
#include "InternalQuickSort.h"

int compare(const void* a, const void* b)
{
	return (*(int*)a - *(int*)b);
}

int* InternalQuickSort::sort(int* inputList, size_t len)
{
	std::cout << "Internal quick sort:\n";
	qsort(inputList, len, sizeof(int), compare);
	return inputList;
}
