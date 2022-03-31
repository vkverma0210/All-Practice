#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cin >> n;

    bool flag = false;

    int arr[12] = {4, 7, 44, 47, 74, 444, 447, 474, 477, 774, 744, 777};

    for (int i = 0; i < 12; i++)
        if (n % arr[i] == 0)
            flag = true;

    if (flag)
        cout << "YES\n";
    else
        cout << "NO\n";

    return 0;
}