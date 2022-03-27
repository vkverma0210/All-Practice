#include <bits/stdc++.h>

using namespace std;

int main()
{
    string s;
    cin >> s;

    vector<char> vowels = {'A', 'O', 'Y', 'E', 'U', 'I', 'a', 'o', 'y', 'e', 'u', 'i'};

    for (int i = 0; i < s.length(); i++)
    {
        if (find(vowels.begin(), vowels.end(), s[i]) != vowels.end())
        {
            s = s.replace(i, 1, "");
            i--;
        }
        else
        {
            s = s.replace(i, 0, ".");
            i++;
        }

        if (isupper(s[i]))
        {
            s[i] = tolower(s[i]);
        }
    }

    cout << s << endl;

    return 0;
}