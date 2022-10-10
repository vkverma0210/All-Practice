#include <bits/stdc++.h>

using namespace std;

#define ll long long

int main()
{
    int n, m;
    cin >> n >> m;

    vector<ll> a(n);

    for (ll i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    vector<ll> front, back;

    ll sum = 0;
    front.push_back(sum);
    for (ll i = 0; i < n - 1; i++)
    {
        ll temp = a[i] - a[i + 1];
        if (temp >= 0)
            sum += temp;

        front.push_back(sum);
    }

    reverse(a.begin(), a.end());
    sum = 0;
    back.push_back(sum);

    for (ll i = 0; i < n - 1; i++)
    {
        ll temp = a[i] - a[i + 1];
        if (temp >= 0)
            sum += temp;

        back.push_back(sum);
    }

    while (m--)
    {
        int s, t;
        cin >> s >> t;

        int temp = t - s;

        if (temp >= 0)
            cout << front[t - 1] - front[s - 1] << endl;
        else
            cout << back[n - t] - back[n - s] << endl;
    }

    return 0;
}