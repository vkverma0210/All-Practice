#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int x, y, z;
        cin >> x >> y >> z;

        bool xdiv = false, ydiv = false;

        if (z % x == 0)
            xdiv = true;

        if (z % y == 0)
            ydiv = true;

        if (xdiv and ydiv)
            cout << "ANY \n";
        else if (xdiv)
            cout << "CHICKEN \n";
        else if (ydiv)
            cout << "DUCK \n";
        else
            cout << "NONE \n";
    }
    return 0;
}