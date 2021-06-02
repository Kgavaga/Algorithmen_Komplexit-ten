#pragma once
#include "SortingAlgorithm.h"

class HeapSort : public SortingAlgorithm {
public:
    int* sort(int* inputList, size_t len) override;
    int* buildMaxHeap(int* inputList, size_t len);
    int* heapify(int* inputList, size_t len, int index);

};