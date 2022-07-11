#include <bits/stdc++.h>
using namespace std;
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string s;
        cin >> s;
        int cnt = 0;
        set<char> sc;
        for (int i = 0; i < s.size(); i++)
        {
            sc.insert(s[i]);
            if (sc.size() == 4)
            {
                cnt++;
                sc.clear();
                sc.insert(s[i]);
            }
        }
        if (!sc.empty())
            cnt++;
        cout << cnt << "\n";
    }
    return 0;
}