//
// Created by admin on 2022/2/4.
//

#ifndef CPP_VECTOR_ASSIGNMENT_H
#define CPP_VECTOR_ASSIGNMENT_H

#endif //CPP_VECTOR_ASSIGNMENT_H


#include "vector.h"

#pragma once

template<typename T>
Vector<T> &Vector<T>::operator=(Vector<T> const &V) { //���
    if (_elem) delete[] _elem; //�ͷ�ԭ������
    copyFrom(V._elem, 0, V.size()); //���帴��
    return *this; //���ص�ǰ��������ã��Ա���ʽ��ֵ
}