#include <bits/stdc++.h>

using namespace std;

bool solve(int a, int b, int c, int x, int y)
{
    bool ans = false;

    if (a >= x)
    {
        ans = true;
    }
    else if ((a + c) >= x)
    {
        c = c - (x - a);
        ans = true;
    }
    else
    {
        ans = false;
        return ans;
    }

    if (b >= y)
    {
        ans = true;
    }
    else if ((b + c) >= y)
    {
        c = c - (y - b);
        ans = true;
    }
    else
    {
        ans = false;
        return ans;
    }

    return ans;
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int a, b, c, x, y;
        cin >> a >> b >> c >> x >> y;
        bool ans = solve(a, b, c, x, y);

        if (ans)
            cout << "YES \n";
        else
            cout << "NO \n";
    }

    return 0;
}