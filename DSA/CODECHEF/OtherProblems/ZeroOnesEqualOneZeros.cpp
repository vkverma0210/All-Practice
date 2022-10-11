#include <bits/stdc++.h>

using namespace std;

#define ll long long

void solve()
{
    int x;
    cin >> x;

    string s = "";

    if (x % 2 == 0)
    {
        s += '1';
        for (int i = 0; i < x - 2; i++)
            s += '0';

        s += '1';

        cout << s << endl;
        return;
    }
    else
    {
        int a = x / 2;

        for (int i = 0; i < a; i++)
            s += '0';

        s += '1';

        for (int i = 0; i < a; i++)
            s += '0';

        cout << s << endl;
        return;
    }
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        solve();
    }

    return 0;
}