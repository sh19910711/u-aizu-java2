mkdir -p build
pushd build
cmake .. && make
popd
java -Djava.security.policy=policy -cp build/ex09.jar ServerEnvClient
