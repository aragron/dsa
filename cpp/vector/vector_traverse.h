//
// Created by admin on 2022/2/4.
//

#ifndef CPP_VECTOR_TRAVERSE_H
#define CPP_VECTOR_TRAVERSE_H

#endif //CPP_VECTOR_TRAVERSE_H

#include "vector.h"

#pragma once

template<typename T>
void Vector<T>::traverse(void ( *visit )(T &)) //借助函数指针机制
{ for (int i = 0; i < _size; i++) visit(_elem[i]); } //遍历向量

template<typename T>
template<typename VST>
//元素类型、操作器
void Vector<T>::traverse(VST &visit) //借助函数对象机制
{ for (int i = 0; i < _size; i++) visit(_elem[i]); } //遍历向量
