#include <iostream>
#include <chrono>
#include <random>
#include "SortingAlgorithm.h"

void SortingAlgorithm::printArray(int* inputList, size_t len)
{
    for (size_t i = 0; i < len; i++)
    {
        std::cout << inputList[i] << " ";
    }
    std::cout << std::endl;
}

int *SortingAlgorithm::sortAndTime(int *inputList, size_t len)
{
    startTime();
    int *result =  sort(inputList, len);
    stopTime();
    return result;
}

void SortingAlgorithm::swap(int *firstSlot, int *secondSlot)
{
    int temp = *firstSlot;
    *firstSlot = *secondSlot;
    *secondSlot = temp;
}

double SortingAlgorithm::getDuration()
{
    return static_cast<double>(std::chrono::duration_cast<std::chrono::milliseconds>(_stopTimeInMillis - _startTimeInMillis).count())/1000;
}

void SortingAlgorithm::startTime()
{
    _startTimeInMillis = std::chrono::system_clock::now();
}
void SortingAlgorithm::stopTime()
{
    _stopTimeInMillis = std::chrono::system_clock::now();
}