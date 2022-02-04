//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_SELECTIONSORT_H
#define CPP_VECTOR_SELECTIONSORT_H

#endif //CPP_VECTOR_SELECTIONSORT_H
#pragma once
#include "vector.h"
#include <cstdio>

template <typename T> //����ѡ������
void Vector<T>::selectionSort ( Rank lo, Rank hi ) { //0 <= lo < hi <= size
    /*DSA*/printf ( "\tSELECTIONsort [%3d, %3d)\n", lo, hi );
    while ( lo < --hi )
        swap ( _elem[ maxItem ( lo, hi ) ], _elem[ hi ] ); //��[hi]��[lo, hi]�е�����߽���
}

template <typename T>
Rank Vector<T>::maxItem ( Rank lo, Rank hi ) { //��[lo, hi]���ҳ������
    Rank mx = hi;
    while ( lo < hi-- ) //����ɨ��
        if ( _elem[ hi ] > _elem[ mx ] ) //���ϸ�Ƚ�
            mx = hi; //������max�ж��ʱ��֤�������ȣ�������֤selectionSort�ȶ�
    return mx;
}

