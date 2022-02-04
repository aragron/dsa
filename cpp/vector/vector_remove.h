//
// Created by admin on 2022/2/4.
//
#include "vector_shrink.h"
#ifndef CPP_VECTOR_REMOVE_H
#define CPP_VECTOR_REMOVE_H

#endif //CPP_VECTOR_REMOVE_H

#include "vector.h"
#pragma once

template<typename T>
T Vector<T>::remove(Rank r) { //ɾ����������Ϊr��Ԫ�أ�0 <= r < size
    T e = _elem[r]; //���ݱ�ɾ��Ԫ��
    remove(r, r + 1); //��������ɾ���㷨����Ч�ڶ�����[r, r + 1)��ɾ��
    return e; //���ر�ɾ��Ԫ��
}

template<typename T>
int Vector<T>::remove(Rank lo, Rank hi) { //ɾ������[lo, hi)
    if (lo == hi) return 0; //����Ч�ʿ��ǣ����������˻����������remove(0, 0)
    while (hi < _size) //����[hi, _size)
        _elem[lo++] = _elem[hi++]; //˳��ǰ��hi - lo����Ԫ
    _size = lo; //���¹�ģ��ֱ�Ӷ���β��[lo, _size = hi)����
    shrink(); //���б�Ҫ��������
    return hi - lo; //���ر�ɾ��Ԫ�ص���Ŀ
}