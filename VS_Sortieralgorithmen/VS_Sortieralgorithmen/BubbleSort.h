#pragma once
#include "SortingAlgorithm.h"

class BubbleSort : public SortingAlgorithm{
public:
    int* sort(int* inputList, size_t len) override;
};