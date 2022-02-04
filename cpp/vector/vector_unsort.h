//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_UNSORT_H
#define CPP_VECTOR_UNSORT_H

#endif //CPP_VECTOR_UNSORT_H
#include "vector.h"
#include "cstdlib"
#pragma once

template <typename T> void Vector<T>::unsort ( Rank lo, Rank hi ) { //�ȸ��������������[lo, hi)
    T* V = _elem + lo; //��������_elem[lo, hi)������һ����V[0, hi - lo)
    for ( Rank i = hi - lo; i > 0; i-- ) //�Ժ���ǰ
        swap ( V[i - 1], V[rand() % i] ); //��V[i - 1]��V[0, i)��ĳһԪ���������
}

template<typename T>
void Vector<T>::unsort() {
    unsort(0, _size);
}

