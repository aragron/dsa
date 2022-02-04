//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_MERGESORT_H
#define CPP_VECTOR_MERGESORT_H

#endif //CPP_VECTOR_MERGESORT_H

#include "vector.h"
#include "vector_merge.h"
#pragma once

template <typename T> //�����鲢����
void Vector<T>::mergeSort ( Rank lo, Rank hi ) { //0 <= lo < hi <= size
    /*DSA*/ //printf ( "\tMERGEsort [%3d, %3d)\n", lo , hi );
    if ( hi - lo < 2 ) return; //��Ԫ��������Ȼ���򣬷���...
    int mi = ( lo + hi ) / 2; //���е�Ϊ��
    mergeSort ( lo, mi ); mergeSort ( mi, hi ); //�ֱ�����
    merge ( lo, mi, hi ); //�鲢
}