#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    for (int i = 1; i <= t; i++)
    {
        string n;
        cin >> n;

        int rem = 0;

        for (char c : n)
        {
            rem = (rem + (c - '0')) % 9;
        }

        int d = (9 - rem) % 9;
        int pos = (d == 0 ? 1 : 0);

        while (pos < n.size() && n[pos] - '0' <= d)
        {
            pos++;
        }

        n.insert(n.begin() + pos, (char)(d + '0'));
        cout << "Case #" << i << ": " << n << "\n";
    }

    return 0;
}