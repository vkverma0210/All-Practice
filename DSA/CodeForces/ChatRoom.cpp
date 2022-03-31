#include <bits/stdc++.h>

using namespace std;

int main()
{
    string str;
    cin >> str;

    string temp = "hello";

    int n = str.length();

    int i = 0, j = 0;

    while (i < n && j < 5)
    {
        if (str[i] == temp[j])
        {
            i++;
            j++;
        }
        else
            i++;
    }

    if (j == 5)
        cout << "YES\n";
    else
        cout << "NO\n";

    return 0;
}