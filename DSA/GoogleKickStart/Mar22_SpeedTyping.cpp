#include <bits/stdc++.h>

using namespace std;

#define res cout << "Case #" << curr << ": "

int main()
{

    int t;
    cin >> t;

    for (int curr = 1; curr <= t; curr++)
    {
        string i, s;
        cin >> i >> s;

        int p1 = 0, p2 = 0;
        int ans = 0;
        while (p1 < i.length() && p2 < s.length())
        {
            if (i[p1] == s[p2])
            {
                p1++;
                p2++;
            }
            else
            {
                p2++;
                ans++;
            }
        }

        if (p1 != i.length())
        {
            res << "IMPOSSIBLE\n";
        }
        else
        {
            ans += s.length() - p2;
            res << ans << endl;
        }
    }

    return 0;
}