#include <bits/stdc++.h>

using namespace std;

int getSum(int a, int b)
{
    while (b != 0)
    {
        int ans = a ^ b;
        int carry = ((unsigned)a & b) << 1;

        a = ans;
        b = carry;
    }

    return a;
}

int main()
{
    int a, b;
    cin >> a >> b;

    int ans = getSum(a, b);

    cout << ans << endl;

    return 0;
}