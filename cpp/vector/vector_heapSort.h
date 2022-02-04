//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_HEAPSORT_H
#define CPP_VECTOR_HEAPSORT_H

#endif //CPP_VECTOR_HEAPSORT_H

#include "vector.h"
#pragma once

template <typename T> void Vector<T>::heapSort ( Rank lo, Rank hi ) { //0 <= lo < hi <= size
    /*DSA*/ //printf ( "\tHEAPsort [%3d, %3d)\n", lo, hi );
    T* A = _elem + lo; Rank n = hi - lo; heapify( A, n ); //�����������佨��һ����ȫ����ѣ�O(n)
    while ( 0 < --n ) //������ժ�����Ԫ������������ĺ�׺��ֱ���ѿ�
    { swap( A[0], A[n] ); percolateDown( A, n, 0 ); } //�Ѷ���ĩԪ�ضԻ���������
}

