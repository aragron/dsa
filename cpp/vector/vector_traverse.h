//
// Created by admin on 2022/2/4.
//

#ifndef CPP_VECTOR_TRAVERSE_H
#define CPP_VECTOR_TRAVERSE_H

#endif //CPP_VECTOR_TRAVERSE_H

#include "vector.h"

#pragma once

template<typename T>
void Vector<T>::traverse(void ( *visit )(T &)) //��������ָ�����
{ for (int i = 0; i < _size; i++) visit(_elem[i]); } //��������

template<typename T>
template<typename VST>
//Ԫ�����͡�������
void Vector<T>::traverse(VST &visit) //���������������
{ for (int i = 0; i < _size; i++) visit(_elem[i]); } //��������
