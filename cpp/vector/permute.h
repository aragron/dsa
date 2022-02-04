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
void permute(Vector<T> &V) { //�������������ʹ��Ԫ�صȸ��ʳ����ڸ�λ��
    for (int i = V.size(); i > 0; i--) //�Ժ���ǰ
        swap(V[i - 1], V[rand() % i]); //V[i - 1]��V[0, i)��ĳһ���Ԫ�ؽ���
}

