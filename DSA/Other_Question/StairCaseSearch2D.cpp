#include <bits/stdc++.h>

using namespace std;

void staircaes(int arr[100][100], int m, int n, int key)
{
    int startRow = 0;
    int endCol = n - 1;

    while (startRow < m && endCol >= 0)
    {
        if (key == arr[startRow][endCol])
        {
            cout << startRow << " " << endCol << endl;
            return;
        }
        if (key < arr[startRow][endCol])
            endCol--;
        else
            startRow++;
    }

    cout << "Number not present. " << endl;
}

int main()
{
    int n, m;
    cin >> n >> m;

    int arr[100][100];

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> arr[i][j];
        }
    }

    int key;
    cin >> key;

    staircaes(arr, m, n, key);

    return 0;
}