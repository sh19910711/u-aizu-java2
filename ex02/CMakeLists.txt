cmake_minimum_required(VERSION 2.8)

find_package(Java REQUIRED)
include(UseJava)

project(ex02)
file(GLOB sources *.java)
add_jar(ex02 ${sources})

