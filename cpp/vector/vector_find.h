//
// Created by admin on 2022/2/4.
//

#ifndef CPP_VECTOR_FIND_H
#define CPP_VECTOR_FIND_H

#endif //CPP_VECTOR_FIND_H

#include "vector.h"

#pragma once

template<typename T>
//����������˳����ң��������һ��Ԫ��e��λ�ã�ʧ��ʱ������lo - 1
Rank Vector<T>::find(T const &e, Rank lo, Rank hi) const { //assert: 0 <= lo < hi <= _size
    while ((lo < hi--) && (e != _elem[hi])); //�Ӻ���ǰ��˳�����
    return hi; //��hi < lo������ζ��ʧ�ܣ�����hi������Ԫ�ص���
}

template<typename T>
T Vector<T>::get(Rank r) {
    return _elem[r];
}

