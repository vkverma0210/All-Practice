#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int x;
        cin >> x;

        int a, b, c;
        cin >> a >> b >> c;

        if (x == 1)
        {
            if (a == 0 || b == 2 || c == 3)
                cout << "NO" << endl;
            else
                cout << "YES" << endl;
        }
        else if (x == 2)
        {
            if (a == 1 || b == 0 || c == 3)
                cout << "NO" << endl;
            else
                cout << "YES" << endl;
        }
        else if (x == 3)
        {
            if (a == 1 || b == 2 || c == 0)
                cout << "NO" << endl;
            else
                cout << "YES" << endl;
        }
    }

    return 0;
}