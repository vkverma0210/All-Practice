#include <bits/stdc++.h>
using namespace std;

int solve(vector<int> &arr, int N, int K)
{
    if (N == 0)
        return K == 0;

    int take = solve(arr, N - 1, K ^ arr[N - 1]);
    int leave = solve(arr, N - 1, K);
    return take + leave;
}

int subsetXOR(vector<int> arr, int N, int K)
{
    return solve(arr, N, K);
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin >> N;
        int K;
        cin >> K;
        vector<int> v;
        for (int i = 0; i < N; i++)
        {
            int x;
            cin >> x;
            v.push_back(x);
        }
        cout << subsetXOR(v, N, K) << endl;
    }
    return 0;
}