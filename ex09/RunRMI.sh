mkdir -p build
pushd build
cmake .. && make
popd
pushd build/CMakeFiles/ex09.dir
rmiregistry -J-Dclasspath=build/ex09.jar
