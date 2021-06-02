#include <iostream>
#include "SelectionSort.h"

int* SelectionSort::sort(int* inputList, size_t len)
{
    std::cout << "Selection sort:\n";

    for (size_t startIndex = 0; startIndex < len-1; startIndex++)
    {
        int smallestNumberIndex = startIndex;
        for (size_t i = startIndex; i < len; i++)
        {
            if (inputList[i] < inputList[smallestNumberIndex])
            {
                smallestNumberIndex = i;
            }
        }
        if (smallestNumberIndex != startIndex)
        {
            swap(&(inputList[smallestNumberIndex]), &(inputList[startIndex]));
        }
    }
    return inputList;
}
