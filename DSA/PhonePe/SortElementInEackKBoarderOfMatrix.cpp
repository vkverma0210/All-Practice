
#include <bits/stdc++.h>

using namespace std;

void sortElement(int arr[100][100], int m, int n)
{
    int i, k = 0, l = 0;
    int n_i, n_k = 0, n_l = 0, n_m = m, n_n = n;

    while (k < m && l < n)
    {
        vector<int> boundary;

        for (int i = l; i < n; i++)
        {
            boundary.push_back(arr[k][i]);
        }
        k++;

        for (i = k; i < m; i++)
        {
            boundary.push_back(arr[i][n - 1]);
        }
        n--;

        if (k < m)
        {
            for (i = n - 1; i >= l; i--)
            {
                boundary.push_back(arr[m - 1][i]);
            }
            m--;
        }

        if (l < n)
        {
            for (i = m - 1; i >= k; i--)
            {
                boundary.push_back(arr[i][l]);
            }
            l++;
        }

        sort(boundary.begin(), boundary.end());

        int ind = 0;

        for (i = n_l; i < n_n; i++)
        {
            arr[n_k][i] = boundary[ind++];
        }
        n_k++;

        for (i = n_k; i < n_m; i++)
        {
            arr[i][n_n - 1] = boundary[ind++];
        }
        n_n--;

        if (n_k < n_m)
        {
            for (i = n_n - 1; i >= n_l; i--)
            {
                arr[n_m - 1][i] = boundary[ind++];
            }

            n_m--;
        }

        if (n_l < n_n)
        {
            for (i = n_m - 1; i >= n_k; i--)
            {
                arr[i][n_l] = boundary[ind++];
            }

            n_l++;
        }
    }
}

int main()
{
    int n, m;
    cin >> n >> m;

    int arr[100][100];

    for (int i{}; i < n; i++)
    {
        for (int j{}; j < m; j++)
        {
            cin >> arr[i][j];
        }
    }

    for (int i{}; i < n; i++)
    {
        for (int j{}; j < m; j++)
        {
            cout << arr[i][j] << " ";
        }

        cout << endl;
    }

    sortElement(arr, n, m);

    for (int i{}; i < n; i++)
    {
        for (int j{}; j < m; j++)
        {
            cout << arr[i][j] << " ";
        }

        cout << endl;
    }

    return 0;
}