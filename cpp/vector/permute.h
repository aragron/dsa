//
// Created by admin on 2022/2/5.
//

#ifndef CPP_PERMUTE_H
#define CPP_PERMUTE_H

#include <cstdlib>
#endif //CPP_PERMUTE_H

#include "vector.h"
#include "../_share/util.h"


#pragma once

template<typename T>
void permute(Vector<T> &V) { //随机置乱向量，使各元素等概率出现于各位置
    for (int i = V.size(); i > 0; i--) //自后向前
        swap(V[i - 1], V[rand() % i]); //V[i - 1]与V[0, i)中某一随机元素交换
}

