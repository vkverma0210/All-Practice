#include <bits/stdc++.h>

using namespace std;

void spiralPrint(int arr[][100], int m, int n)
{
    int startRow = 0;
    int startCol = 0;
    int endRow = m - 1;
    int endCol = n - 1;

    while (startRow <= endRow and startCol <= endCol)
    {
        for (int i = startCol; i <= endCol; i++)
        {
            cout << arr[startRow][i] << " ";
        }
        startRow++;

        for (int i = startRow; i <= endRow; i++)
        {
            cout << arr[i][endCol] << " ";
        }
        endCol--;

        if (endRow > startRow)
        {
            for (int i = endCol; i >= startCol; i--)
            {
                cout << arr[endRow][i] << " ";
            }
            endRow--;
        }

        if (endCol > startCol)
        {
            for (int i = endRow; i >= startRow; i--)
            {
                cout << arr[i][startCol] << " ";
            }
            startCol++;
        }
    }
}

int main()
{
    int n, m;
    cin >> n >> m;

    int arr[n][100];

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> arr[i][j];
        }
    }

    spiralPrint(arr, m, n);

    return 0;
}