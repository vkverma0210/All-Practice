#include <bits/stdc++.h>

using namespace std;

vector<long> multipleOf9()
{
    vector<long> vec(10000000);
    long j = 1;

    for (int i = 0; i < vec.size(); i++)
    {
        long temp = 9 * j;
        vec.push_back(temp);
        j++;
    }

    return vec;
}

int main()
{
    vector<long> vec = multipleOf9();
    int t;
    cin >> t;

    for (int i = 1; i <= t; i++)
    {
        int n;
        cin >> n;

        if (n % 9)
        {
            cout << "Case #" << i << ": " << n << endl;
        }
        else
        {
        }
    }
}