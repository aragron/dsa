//
// Created by admin on 2022/2/3.
//

#ifndef CPP_PERSON_H
#define CPP_PERSON_H

#endif //CPP_PERSON_H


#include <string>
#include <iostream>

//类模板
template<class NameType, class AgeType>
class Person {
public:
    Person(NameType name, AgeType age) {
        this->mName = name;
        this->mAge = age;
    }

    void showPerson() {
        std::cout << "name: " << this->mName << " age: " << this->mAge << std::endl;
    }

public:
    NameType mName;
    AgeType mAge;
};