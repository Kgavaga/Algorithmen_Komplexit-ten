#pragma once
#include "SortingAlgorithm.h"

class SelectionSort : public SortingAlgorithm {
public:
    int* sort(int* inputList, size_t len) override;
};