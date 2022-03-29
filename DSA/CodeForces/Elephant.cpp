#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int steps = 0;

    // while (n >= 5)
    // {
    //     steps += n / 5;
    //     n %= 5;
    // }

    // while (n >= 4)
    // {
    //     steps += n / 4;
    //     n %= 4;
    // }

    // while (n >= 3)
    // {
    //     steps += n / 3;
    //     n %= 3;
    // }

    // while (n >= 2)
    // {
    //     steps += n / 2;
    //     n %= 2;
    // }

    // while (n >= 1)
    // {
    //     steps += n / 1;
    //     n %= 1;
    // }

    steps = n / 5;

    if (n % 5 > 0)
        steps++;

    cout << steps << "\n";

    return 0;
}