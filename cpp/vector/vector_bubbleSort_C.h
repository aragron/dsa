//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_BUBBLESORT_C_H
#define CPP_VECTOR_BUBBLESORT_C_H

#endif //CPP_VECTOR_BUBBLESORT_C_H

#pragma once
#include "vector.h"

template <typename T> //向量的起泡排序（跳跃版）
void Vector<T>::bubbleSort( Rank lo, Rank hi ) { //assert: 0 <= lo < hi <= size
    for( Rank last = --hi; lo < hi; hi = last )
        for( Rank i = last = lo; i < hi; i++ )
            if( _elem[i] > _elem[i + 1] ) //若逆序，则
                swap( _elem[ last = i ], _elem[ i + 1 ] ); //经交换使局部有序
}
