#pragma once
#include <chrono>

class SortingAlgorithm{
public:
    void printArray(int* inputList, size_t len);

    int* sortAndTime(int* inputList, size_t len);
    void swap(int* firstSlot, int* secondSlot);

    virtual int* sort(int* inputList, size_t len) = 0;
    double getDuration();

private:
    std::chrono::system_clock::time_point _startTimeInMillis;
    std::chrono::system_clock::time_point _stopTimeInMillis;

    void startTime();
    void stopTime();
};