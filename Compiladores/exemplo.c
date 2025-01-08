int globalVar;

int main(int arg1, int arg2) {
    int localVar;
    localVar = 10;
    globalVar = globalVar + localVar;

    if (arg1 > arg2) {
        return globalVar;
    } else {
        return localVar;
    }

    while (globalVar > 0) {
        globalVar -= 1;
        if (globalVar == 5) {
            break;
        }
    }

    return 0;
}
