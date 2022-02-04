//
// Created by admin on 2022/2/4.
//
#include "vector.h"
#include "vector_expand.h"

#ifndef CPP_VECTOR_INSERT_H
#define CPP_VECTOR_INSERT_H

#endif //CPP_VECTOR_INSERT_H
#pragma once

template<typename T>
//��e��Ϊ��ΪrԪ�ز���
Rank Vector<T>::insert(Rank r, T const &e) { //assert: 0 <= r <= size
    expand(); //���б�Ҫ������
    for (int i = _size; i > r; i--) //�Ժ���ǰ�����Ԫ��
        _elem[i] = _elem[i - 1]; //˳�κ���һ����Ԫ
    _elem[r] = e;
    _size++; //������Ԫ�ز���������
    return r; //������
}


template<typename T>
void Vector<T>::put(Rank r, const T &e) {
    if (_size <= r)
        return;
    _elem[r] = e;
}
