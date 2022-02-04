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
void Vector<T>::sort(Rank lo, Rank hi) { //��������[lo, hi)����
    switch (rand() % 6) {
        case 1:
            bubbleSort(lo, hi);
            break; //��������
        case 2:
            selectionSort(lo, hi);
            break; //ѡ������ϰ�⣩
        case 3:
            mergeSort(lo, hi);
            break; //�鲢����
//        case 4:
//            heapSort(lo, hi);
//            break; //�����򣨵�12�£�
//        case 5:
//            quickSort(lo, hi);
//            break; //�������򣨵�14�£�
        default:
            shellSort(lo, hi);
            break; //ϣ�����򣨵�14�£�
    } //���ѡ���㷨�Գ�ֲ��ԡ�ʵ��ʱ���Ӿ���������ص����ȷ��������
}

template<typename T>
void Vector<T>::sort() { sort(0, _size); }