#include <iostream>
#include "BubbleSort.h"

int *BubbleSort::sort(int *inputList, size_t len)
{
    std::cout << "BubbleSort sort:\n";
    bool swapped = true;
    while (swapped == true)
    {
        swapped = false;

        for (size_t i = 0; i < len - 1; i++)
        {
            if (inputList[i] > inputList[i + 1])
            {
                swapped = true;
                swap(&(inputList[i]), &(inputList[i + 1]));
            }
        }
    }
    return inputList;
}