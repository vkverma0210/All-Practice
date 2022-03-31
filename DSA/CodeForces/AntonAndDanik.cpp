#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cin >> n;

    string s;
    cin >> s;

    int countA = 0;

    for (int i = 0; i < n; i++)
    {
        if (s[i] == 'A')
            countA++;
    }

    int countD = n - countA;
    if (countA > countD)
        cout << "Anton\n";
    else if (countA < countD)
        cout << "Danik\n";
    else
        cout << "Friendship\n";

    return 0;
}