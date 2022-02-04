//
// Created by admin on 2022/2/4.
//

#ifndef CPP_VECTOR_CONSTRUCTOR_BY_COPYING_H
#define CPP_VECTOR_CONSTRUCTOR_BY_COPYING_H

#endif //CPP_VECTOR_CONSTRUCTOR_BY_COPYING_H

#include "vector.h"

#pragma once

template<typename T>
//TΪ�������ͣ��������ظ�ֵ������'='
void Vector<T>::copyFrom(T const *A, Rank lo, Rank hi) { //����������A[lo, hi)Ϊ������������
    _elem = new T[_capacity = 2 * (hi - lo)]; //����ռ�
    for (_size = 0; lo < hi; _size++, lo++) //A[lo, hi)�ڵ�Ԫ����һ
        _elem[_size] = A[lo]; //������_elem[0, hi - lo)
} //��c