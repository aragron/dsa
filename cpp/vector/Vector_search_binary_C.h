//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_SEARCH_BINARY_C_H
#define CPP_VECTOR_SEARCH_BINARY_C_H

#endif //CPP_VECTOR_SEARCH_BINARY_C_H

#include <cstdio>
#include "vector.h"
#pragma once

// ���ֲ����㷨���汾C��������������������[lo, hi)�ڲ���Ԫ��e��0 <= lo <= hi <= _size
template <typename T> static Rank binSearch ( T* S, T const& e, Rank lo, Rank hi ) {
    /*DSA*/printf ( "BIN search (C)\n" );
    while ( lo < hi ) { //ÿ������������һ�αȽ��жϣ���������֧
        /*DSA*/ //for ( int i = 0; i < lo; i++ ) printf ( "     " ); if ( lo >= 0 ) for ( int i = lo; i < hi; i++ ) printf ( "....^" ); printf ( "\n" );
        Rank mi = ( lo + hi ) >> 1; //���е�Ϊ��㣨�����ȵ��۰룬��Ч�ڿ��֮��ֵ��ʾ�����ƣ�
        ( e < S[mi] ) ? hi = mi : lo = mi + 1; //���ȽϺ�ȷ������[lo, mi)��(mi, hi)
    } //�ɹ����Ҳ�����ǰ��ֹ
    /*DSA*/ //for ( int i = 0; i < lo - 1; i++ ) printf ( "     " ); if ( lo > 0 ) printf ( "....|\n" ); else printf ( "<<<<|\n" );
    return lo - 1; //ѭ������ʱ��loΪ����e��Ԫ�ص���С�ȣ���lo - 1��������e��Ԫ�ص������
} //�ж������Ԫ��ʱ������������ߣ�����ʧ��ʱ���ܹ�����ʧ�ܵ�λ��
