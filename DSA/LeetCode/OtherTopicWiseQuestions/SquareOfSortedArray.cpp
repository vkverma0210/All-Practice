#include <bits/stdc++.h>

using namespace std;

vector<int> sortedSquares(vector<int> vec)
{
    int start = 0;
    int end = vec.size() - 1;
    int k = vec.size() - 1;
    vector<int> ans(vec.size());

    int startSquare = 0, endSquare = 0;

    while (start <= end)
    {
        startSquare = vec[start] * vec[start];
        endSquare = vec[end] * vec[end];

        ans[k--] = max(startSquare, endSquare);

        if (startSquare > endSquare)
            start++;
        else
            end--;
    }

    return ans;
}

int main()
{
    int n;
    cin >> n;

    vector<int> vec;

    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        vec.push_back(x);
    }

    vector<int> ans = sortedSquares(vec);

    for (int i = 0; i < n; i++)
    {
        cout << ans[i] << " ";
    }

    cout << endl;

    return 0;
}