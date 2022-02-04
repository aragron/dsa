//
// Created by admin on 2022/2/5.
//

//#ifndef CPP_VECTOR_QUICKSORT_H
//#define CPP_VECTOR_QUICKSORT_H
//
//#endif //CPP_VECTOR_QUICKSORT_H
//
//
//#pragma once
//#include "vector.h"
//
//
//#define Put( K, s, t ) { if ( 1 < (t) - (s) ) { K.push(s); K.push(t); } }
//#define Get( K, s, t ) { t = K.pop(); s = K.pop(); }
//
//template <typename T> //向量快速排序
//void Vector<T>::quickSort( Rank lo, Rank hi ) { //0 <= lo < hi <= size
//    Stack<Rank> Task; Put( Task, lo, hi );
//    while ( !Task.empty() ) {
//        Get( Task, lo, hi );
//        /* DSA */ //printf ( "\tQUICKsort: " ); for ( Rank i = 0; i < Task.size(); i+=2 ) printf ( " " ); printf ( " [%3d, %3d)\n", lo, hi );
//        Rank mi = partition( lo, hi ); //在[lo, hi)内构造轴点
//        if ( mi - lo < hi - mi ) {
//            Put( Task, mi+1, hi ); Put( Task, lo, mi );
//        } else {
//            Put( Task, lo, mi ); Put( Task, mi+1, hi );
//        }
//    } //大任务优先入栈（小任务优先出栈执行），可保证递归深度（空间成本）不过O(logn)
//}