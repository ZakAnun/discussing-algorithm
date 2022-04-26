//
// Created by 李铭淋 on 2022/4/25.
//

#include "array.h"
#include<iostream>

using namespace std;

int main() {

    ArraySolution *as = new ArraySolution();

    // 二分查找测试
    vector<int> firstArr;
    for (int i = 0; i < 8; i++) {
        firstArr.push_back((i + 1) * 2);
    }
    cout << as->binarySearch(firstArr, 8) << endl;

    return 0;
}