#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;
    cin.get();

    for (int x = 1; x <= t; x++)
    {
        string i;
        getline(cin, i);
        string s;
        getline(cin, s);
        bool flag = true;
        for (int j = 0; j < i.length(); j++)
        {
            char c = i[j];
            int pos = s.find(c);
            if (pos != s.length() and pos != -1)
            {
                s.erase(pos, 1);
            }
            else
            {
                cout << "Case #" << x << ": IMPOSSIBLE" << endl;
                flag = false;
                break;
            }
        }

        if (flag == true)
            cout << "Case #" << x << ": " << s.length() << endl;
    }

    return 0;
}