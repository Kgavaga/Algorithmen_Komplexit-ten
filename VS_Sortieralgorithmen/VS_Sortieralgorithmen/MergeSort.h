#pragma once
#include "SortingAlgorithm.h"

class MergeSort : public SortingAlgorithm {
public:
    int* sort(int* inputList, size_t len) override;

private:
    int* recursiveSort(int* inputList, size_t len);
    int* iterativeSort(int* inputList, size_t len);
    int* merge(int* firstList, size_t len1, int* secondList, size_t len2);

};