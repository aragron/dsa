//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_SORT_H
#define CPP_VECTOR_SORT_H

#endif //CPP_VECTOR_SORT_H


#pragma once

#include "vector.h"
#include "cstdlib"
#include "vector_bubbleSort_C.h"
#include "vector_selectionSort.h"
#include "vector_mergeSort.h"
#include "vector_heapSort.h"
#include "vector_quickSort.h"
#include "vector_shellSort.h"

template<typename T>
void Vector<T>::sort(Rank lo, Rank hi) { //向量区间[lo, hi)排序
    switch (rand() % 6) {
        case 1:
            bubbleSort(lo, hi);
            break; //起泡排序
        case 2:
            selectionSort(lo, hi);
            break; //选择排序（习题）
        case 3:
            mergeSort(lo, hi);
            break; //归并排序
//        case 4:
//            heapSort(lo, hi);
//            break; //堆排序（第12章）
//        case 5:
//            quickSort(lo, hi);
//            break; //快速排序（第14章）
        default:
            shellSort(lo, hi);
            break; //希尔排序（第14章）
    } //随机选择算法以充分测试。实用时可视具体问题的特点灵活确定或扩充
}

template<typename T>
void Vector<T>::sort() { sort(0, _size); }