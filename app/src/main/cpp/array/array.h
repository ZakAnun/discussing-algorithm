//
// Created by 李铭淋 on 2022/4/25.
//

#ifndef DISCUSSING_ALGORITHM_ARRAY_H
#define DISCUSSING_ALGORITHM_ARRAY_H

#include <vector>

using namespace std;

/**
 * 数组算法题
 */
class ArraySolution {
    public:
        /**
         * 二分查找
         */
        int binarySearch(vector<int>& nums, int target) {
            int left = 0;
            int right = nums.size() - 1;
            while (left <= right) {
                int middle = left + ((right - left) / 2);
                if (nums[middle] < target) {
                    left = middle + 1;
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    return middle;
                }
            }
            return -1;
        }
};



#endif //DISCUSSING_ALGORITHM_ARRAY_H
