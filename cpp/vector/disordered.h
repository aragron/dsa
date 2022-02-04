//
// Created by admin on 2022/2/5.
//

#ifndef CPP_DISORDERED_H
#define CPP_DISORDERED_H

#endif //CPP_DISORDERED_H
#pragma once
#include "vector.h"

template<typename T>
int Vector<T>::disordered() const {
    int n = 0;
    for (int i = 1; i < _size; ++i)
        if (_elem[i - 1] > _elem) n++;
    return n;
}