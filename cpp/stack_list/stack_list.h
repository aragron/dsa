//
// Created by admin on 2022/2/5.
//

#ifndef CPP_STACK_LIST_H
#define CPP_STACK_LIST_H

#endif //CPP_STACK_LIST_H

#pragma once

#include "List/List.h" //���б�Ϊ���࣬������ջģ����
template <typename T> class Stack: public List<T> { //���б����/ĩ����Ϊջ��/��
public: //ԭ�нӿ�һ������
    void push ( T const& e ) { insertAsLast ( e ); } //��ջ����Ч�ڽ���Ԫ����Ϊ�б����Ԫ�ز���
    T pop() { return remove ( last() ); } //��ջ����Ч��ɾ���б����Ԫ��
    T& top() { return last()->data; } //ȡ����ֱ�ӷ����б����Ԫ��
};
