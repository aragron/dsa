//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_UNSORT_H
#define CPP_VECTOR_UNSORT_H

#endif //CPP_VECTOR_UNSORT_H
#include "vector.h"
#include "cstdlib"
#pragma once

template <typename T> void Vector<T>::unsort ( Rank lo, Rank hi ) { //等概率随机置乱区间[lo, hi)
    T* V = _elem + lo; //将子向量_elem[lo, hi)视作另一向量V[0, hi - lo)
    for ( Rank i = hi - lo; i > 0; i-- ) //自后向前
        swap ( V[i - 1], V[rand() % i] ); //将V[i - 1]与V[0, i)中某一元素随机交换
}

template<typename T>
void Vector<T>::unsort() {
    unsort(0, _size);
}

