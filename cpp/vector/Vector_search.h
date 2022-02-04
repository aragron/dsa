//
// Created by admin on 2022/2/4.
//

#ifndef CPP_VECTOR_SEARCH_H
#define CPP_VECTOR_SEARCH_H

#endif //CPP_VECTOR_SEARCH_H

#include <cstdlib>
#include "vector.h"

#pragma once

template<typename T>
//����������������[lo, hi)�ڣ�ȷ��������e�����һ���ڵ����
Rank Vector<T>::search(T const &e, Rank lo, Rank hi) const { //assert: 0 <= lo < hi <= _size
    return (rand() % 2) ? //����50%�ĸ������ʹ�ö��ֲ��һ�Fibonacci����
           binSearch(_elem, e, lo, hi) : fibSearch(_elem, e, lo, hi);
}



