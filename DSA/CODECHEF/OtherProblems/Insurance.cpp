#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int x, y;
        cin >> x >> y;

        if (x <= y)
            cout << x << endl;
        else
            cout << y << endl;
    }

    return 0;
}