#pragma once
#include "SortingAlgorithm.h"

class InternalQuickSort : public SortingAlgorithm {
public:
    int* sort(int* inputList, size_t len) override;

};