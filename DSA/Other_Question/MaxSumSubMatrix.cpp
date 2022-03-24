#include <bits/stdc++.h>

using namespace std;

int maxSumSubMatrix(int **arr, int m, int n)
{
    for (int i = m - 1; i >= 0; i--)
    {
        for (int j = n - 2; j >= 0; j--)
        {
            arr[i][j] += arr[i][j + 1];
        }
    }

    for (int i = n - 1; i >= 0; i--)
    {
        for (int j = m - 2; j >= 0; j--)
        {
            arr[j][i] += arr[j + 1][i];
        }
    }

    int result = INT_MIN;

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            result = max(result, arr[i][j]);
        }
    }

    return result;
}

int main()
{
    int m, n;
    cin >> m >> n;

    int **arr = new int *[m];

    for (int i = 0; i < m; i++)
    {
        arr[i] = new int[n];
    }

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> arr[i][j];
        }
    }

    cout << maxSumSubMatrix(arr, m, n) << endl;

    return 0;
}