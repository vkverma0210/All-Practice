#include <bits/stdc++.h>

using namespace std;

#define res cout << "Case #" << curr << ": "

string solve(string str)
{
    set<char> hash{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

    char ch = str[str.length() - 1];

    if (ch == 'y' || ch == 'Y')
    {
        return (str + " is ruled by nobody.");
    }
    else if (hash.find(ch) != hash.end())
    {
        return (str + " is ruled by Alice.");
    }
    else
    {
        return (str + " is ruled by Bob.");
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    for (int curr = 1; curr <= t; curr++)
    {
        string str;
        cin >> str;

        cout << "Case #" << curr << ": " << solve(str) << "\n";
    }

    return 0;
}