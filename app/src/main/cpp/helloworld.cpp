//
// Created by zak on 2022/4/20.
//

#include<iostream>

using namespace std;


void test_arr() {
    int array[2][3] = {
        {0, 1, 2},
        {3, 4, 5}
    };
    // 输出的数组地址是连续的
    cout << &array[0][0] << " " << &array[0][1] << " " << &array[0][2] << endl;
    cout << &array[1][0] << " " << &array[1][1] << " " << &array[1][2] << endl;
}

/**
 * in mac os, run g++ -o outputName *.cpp to generate executable file to figure out the result.
 * outputName 生成的文件名称
 * * 表示希望编译的 cpp 文件
 */
int main() {
    cout << "Hello World!" << endl;

    test_arr();

    return 0;
}