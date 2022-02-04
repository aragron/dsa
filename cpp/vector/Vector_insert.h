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
//将e作为秩为r元素插入
Rank Vector<T>::insert(Rank r, T const &e) { //assert: 0 <= r <= size
    expand(); //若有必要，扩容
    for (int i = _size; i > r; i--) //自后向前，后继元素
        _elem[i] = _elem[i - 1]; //顺次后移一个单元
    _elem[r] = e;
    _size++; //置入新元素并更新容量
    return r; //返回秩
}


template<typename T>
void Vector<T>::put(Rank r, const T &e) {
    if (_size <= r)
        return;
    _elem[r] = e;
}
