#pragma once
#include "SortingAlgorithm.h"

class QuickSort : public SortingAlgorithm {
public:
    int* sort(int* inputList, size_t len) override;

    int* recursiveSort(int* inputList, size_t begin, size_t end);

};
