#include <bits/stdc++.h>

using namespace std;

#define res cout << "Case #" << curr << ": "
#define ll long long

ll dp[14][8][6][4][4][110][2][2][2];
string s;

ll gene(int two, int three, int five, int seven)
{
    ll num = 1;

    for (int i = 0; i < two; i++)
        num *= 2;

    for (int i = 0; i < three; i++)
        num *= 3;

    for (int i = 0; i < five; i++)
        num *= 5;

    for (int i = 0; i < seven; i++)
        num *= 7;

    return num;
}

ll fun(int pos, int two, int three, int five, int seven, int sum, bool zero, bool start, bool tight)
{
    if (pos >= s.size())
    {
        if (start == 0)
            return 0;

        if (zero)
            return 1;

        ll num = gene(two, three, five, seven);

        return (num % sum) == 0;
    }

    ll &ans = dp[pos][two][three][five][seven][sum][zero][start][tight];

    if (ans != -1)
        return ans;

    ans = 0;

    if (tight)
    {
        int c = s[pos] - '0';

        for (int i = 0; i <= c; i++)
        {
            int ntwo = two;
            int nthree = three;
            int nfive = five;
            int nseven = seven;
            int nzero = zero;

            int nsum = sum + i;

            if (start == 0 && i == 0)
            {
                ans += fun(pos + 1, ntwo, nthree, nfive, nseven, nsum, nzero, start, 0);
            }
            else
            {
                int ni = i;
                if (i == 0)
                    nzero = 1;
                else
                {
                    while (ni % 2 == 0)
                        ntwo++, ni /= 2;

                    while (ni % 3 == 0)
                        nthree++, ni /= 3;

                    while (ni % 5 == 0)
                        nfive++, ni /= 5;

                    while (ni % 7 == 0)
                        nseven++, ni /= 7;
                }

                ntwo = min(ntwo, 7);
                nthree = min(nthree, 5);
                nfive = min(nfive, 3);
                nseven = min(nseven, 3);

                ans += fun(pos + 1, ntwo, nthree, nfive, nseven, nsum, nzero, 1, i == c);
            }
        }
    }
    else
    {
        for (int i = 0; i <= 9; i++)
        {
            int ntwo = two;
            int nthree = three;
            int nfive = five;
            int nseven = seven;
            int nzero = zero;

            int nsum = sum + i;

            if (start == 0 && i == 0)
            {
                ans += fun(pos + 1, ntwo, nthree, nfive, nseven, nsum, nzero, start, 0);
            }
            else
            {
                int ni = i;
                if (i == 0)
                    nzero = 1;
                else
                {
                    while (ni % 2 == 0)
                        ntwo++, ni /= 2;

                    while (ni % 3 == 0)
                        nthree++, ni /= 3;

                    while (ni % 5 == 0)
                        nfive++, ni /= 5;

                    while (ni % 7 == 0)
                        nseven++, ni /= 7;
                }

                ntwo = min(ntwo, 7);
                nthree = min(nthree, 5);
                nfive = min(nfive, 3);
                nseven = min(nseven, 3);

                ans += fun(pos + 1, ntwo, nthree, nfive, nseven, nsum, nzero, 1, 0);
            }
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
        ll a, b;
        cin >> a >> b;

        memset(dp, -1, sizeof(dp));
        s = to_string(b);

        ll ans = fun(0, 0, 0, 0, 0, 0, 0, 0, 1);

        a--;
        memset(dp, -1, sizeof(dp));
        s = to_string(a);

        ans -= fun(0, 0, 0, 0, 0, 0, 0, 0, 1);

        res;
        cout << ans << "\n";
    }

    return 0;
}