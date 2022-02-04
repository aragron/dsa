//
// Created by admin on 2022/2/5.
//

#ifndef CPP_VECTOR_BRACKET_H
#define CPP_VECTOR_BRACKET_H

#endif //CPP_VECTOR_BRACKET_H

#include "vector.h"

#pragma once

template<typename T>
T &Vector<T>::operator[](Rank r) //重载下标操作符
{ return _elem[r]; } // assert: 0 <= r < _size

template<typename T>
const T &Vector<T>::operator[](Rank r) const //仅限于做右值
{ return _elem[r]; } // assert: 0 <= r < _size