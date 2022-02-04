//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_SEARCH_FIBONACCIAN_B_H
#define CPP_VECTOR_SEARCH_FIBONACCIAN_B_H

#endif //CPP_VECTOR_SEARCH_FIBONACCIAN_B_H

#include <cstdio>
#include "vector.h"
#pragma once

#include "../fibonacci/Fib.h" //����Fib������
// Fibonacci�����㷨���汾B��������������������[lo, hi)�ڲ���Ԫ��e��0 <= lo <= hi <= _size
template <typename T> static Rank fibSearch ( T* S, T const& e, Rank lo, Rank hi ) {
    /*DSA*/printf ( "FIB search (B)\n" );
    for( Fib fib ( hi - lo ); lo < hi;  ) { //Fib�����Ʊ���
        /*DSA*/ //for ( int i = 0; i < lo; i++ ) printf ( "     " ); if ( lo >= 0 ) for ( int i = lo; i < hi; i++ ) printf ( "....^" ); else printf ( "<<<<|" ); printf ( "\n" );
        while( hi - lo < fib.get() ) fib.prev(); //�Ժ���ǰ˳����ң���̯O(1)��
        Rank mi = lo + fib.get() - 1; //ȷ������Fib(k) - 1�����
        ( e < S[mi] ) ? hi = mi : lo = mi + 1; //�ȽϺ�ȷ������ǰ���[lo, mi)�����(mi, hi)
    } //�ɹ����Ҳ�����ǰ��ֹ
    /*DSA*/ //for( int i = 0; i < lo - 1; i++ ) printf ( "     " ); if ( lo > 0 ) printf ( "....|\n" ); else printf ( "<<<<|\n" );
    return --lo; //ѭ������ʱ��loΪ����e��Ԫ�ص���С�ȣ���lo - 1��������e��Ԫ�ص������
} //�ж������Ԫ��ʱ�����ܱ�֤������������ߣ�����ʧ��ʱ���ܹ�����ʧ�ܵ�λ��
