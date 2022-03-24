#include <bits/stdc++.h>

using namespace std;

int main()
{
    vector<int> v(4);

    for (int i = 0; i < 4; i++)
        cout << v[i] << " ";

    cout << endl;

    v[2] = 1;

    auto it = find(v.begin(), v.end(), 1);

    cout << distance(v.begin(), it) << endl;

    cout << *it << endl;
}