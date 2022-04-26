#include <bits/stdc++.h>

using namespace std;

#define res cout << "Case #" << curr << ": "
#define PI 3.14159265358979323846

int solve(int a)
{
    int count = 0;

    for (int i = 1; i <= a; i++)
    {
        if (a % i == 0)
        {
            string strin = to_string(i);

            // reversing the string
            reverse(strin.begin(), strin.end());

            // converting string to integer
            int j = stoi(strin);

            if (i == j)
            {
                count++;
            }
        }
    }
    return count;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    for (int curr = 1; curr <= t; curr++)
    {
        int a;
        cin >> a;
        res;

        cout << solve(a) << "\n";
    }

    return 0;
}