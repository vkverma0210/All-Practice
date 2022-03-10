#include <bits/stdc++.h>

using namespace std;

int sumOfSubMatrix(int **arr, int m, int n)
{

    int sum = 0;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int tl = (i + 1) * (j + 1);
            int br = (m - i) * (n - j);
            sum += (tl * br) * arr[i][j];
        }
    }

    return sum;
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

    cout << sumOfSubMatrix(arr, m, n) << endl;

    return 0;
}