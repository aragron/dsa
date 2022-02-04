cmake_minimum_required(VERSION 3.21)
project(cpp)

set(CMAKE_CXX_STANDARD 14)

add_executable(cpp main.cpp printDemo.cpp vector/vector.h vector/vector_insert.h vector/vector_expand.h vector/vector_traverse.h vector/vector_remove.h vector/vector_shrink.h vector/vector_constructor_by_copying.h vector/vector_find.h vector/vector_search.h vector/vector_assignment.h vector/vector_bracket.h vector/permute.h _share/util.h)
