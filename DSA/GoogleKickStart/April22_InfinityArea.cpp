#include <bits/stdc++.h>

using namespace std;

#define res cout << "Case #" << curr << ": "
#define PI 3.14159265358979323846

float solve(int r, int a, int b)
{
    float ans = 0;

    if (r == 0)
    {
        return ans;
    }

    ans = PI * r * r;

    int even = 0;

    while (r != 0)
    {
        if (even == 0)
        {
            r = r * a;
            ans += PI * r * r;
            even = 1;
        }

        if (r != 0 && even == 1)
        {
            r = (r) / b;
            ans += PI * r * r;
            even = 0;
        }
    }

    return ans;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    for (int curr = 1; curr <= t; curr++)
    {
        int r, a, b;
        cin >> r >> a >> b;
        res;

        cout << fixed << setprecision(6) << solve(r, a, b) << "\n";
    }

    return 0;
}