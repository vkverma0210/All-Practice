#include <bits/stdc++.h>

using namespace std;

int countAsterisks(string s)
{
    int n = s.length();

    if (n == 1)
        return (s[0] == '*');

    int count = 0;
    int ans = 0;

    for (int i = 0; i < n; i++)
    {
        if (s[i] == '|')
            count++;

        if (s[i] == '*')
        {
            if (count % 2 == 0)

                ans++;
        }
    }

    return ans;
}

int main()
{
    string s;

    cin >> s;

    int ans = countAsterisks(s);

    cout << ans << endl;

    return 0;
}