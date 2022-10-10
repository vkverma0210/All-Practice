#include <bits/stdc++.h>

using namespace std;

int main()
{
    string str;
    cin >> str;

    int count = 1;

    for (int i = 1; i <= str.length(); i++)
    {
        if (str[i] == str[i - 1])
        {
            count++;

            if (count == 7)
            {
                cout << "YES \n";
                return 0;
            }
        }
        else
            count = 1;
    }

    cout << "NO \n";

    return 0;
}