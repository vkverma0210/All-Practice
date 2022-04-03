
#include <bits/stdc++.h>

using namespace std;

int numberOfAdjacentTripletUniqueCharacter(string s)
{
    int n = s.length();
    int result = 0;

    for (int i{1}; i < n - 1; i++)
    {
        if (s[i - 1] != s[i] and s[i] != s[i + 1] && s[i - 1] != s[i + 1])
            result++;
    }

    return result;
}

int main()
{
    string s;
    cin >> s;

    cout << numberOfAdjacentTripletUniqueCharacter(s) << endl;

    return 0;
}