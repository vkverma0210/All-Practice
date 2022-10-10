#include <bits/stdc++.h>

using namespace std;

int main()
{
    string str;
    cin >> str;

    int countlow = 0, countup = 0;

    for (int i = 0; i < str.length(); i++)
    {
        if (islower(str[i]))
            countlow++;
        else
            countup++;
    }

    if (countlow >= countup)
        transform(str.begin(), str.end(), str.begin(), ::tolower);
    else
        transform(str.begin(), str.end(), str.begin(), ::toupper);

    cout << str << "\n";

    return 0;
}