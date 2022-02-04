//
// Created by admin on 2022/2/4.
//


#ifndef CPP_VECTOR_EXPAND_H
#define CPP_VECTOR_EXPAND_H

#endif //CPP_VECTOR_EXPAND_H
#include "vector.h"
#pragma once

template<typename T>
void Vector<T>::expand() { //�����ռ䲻��ʱ����
    if (_size < _capacity) return; //��δ��Աʱ����������
    if (_capacity < DEFAULT_CAPACITY) _capacity = DEFAULT_CAPACITY; //��������С����
    T *oldElem = _elem;
    _elem = new T[_capacity <<= 1]; //�����ӱ�
    for (int i = 0; i < _size; i++)
        _elem[i] = oldElem[i]; //����ԭ�������ݣ�TΪ�������ͣ��������ظ�ֵ������'='��
    /*DSA*/ //printf("\n_ELEM [%x]*%d/%d expanded and shift to [%x]*%d/%d\n", oldElem, _size, _capacity/2, _elem, _size, _capacity);
    delete[] oldElem; //�ͷ�ԭ�ռ�
}