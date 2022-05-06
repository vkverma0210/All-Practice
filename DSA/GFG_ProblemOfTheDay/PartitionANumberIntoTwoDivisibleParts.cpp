#include <bits/stdc++.h>

using namespace std;

string stringPartition(string S, int a, int b)
{
    int n = S.length();

    if (n < 2)
        return "-1";

    vector<int> vec(n - 1, 0);

    vec[n - 2] = S[n - 1] - '0';

    for (int i = n - 2; i > 0; i--)
    {
        int num = (S[i] - '0') * pow(10, n - i - 1) + vec[i];
        vec[i - 1] = num;
    }

    int i = 0, val = 0;

    string ans;

    while (i < n - 1)
    {
        ans += S[i];
        val = (val * 10) + (S[i] - '0');

        if (!(val % a) && !(vec[i] % b))
        {
            ans += " ";
            ans += S.substr(i + 1);
            return ans;
        }

        i++;
    }

    return "-1";
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int a, b;
        string S;
        cin >> S >> a >> b;

        cout << stringPartition(S, a, b) << endl;
    }

    return 0;
}