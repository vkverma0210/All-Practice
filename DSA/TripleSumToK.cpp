#include <bits/stdc++.h>

using namespace std;

void tripleSumK(int arr[], int n, int k)
{
    int j = 1;
    int h = n - 1;

    for (int i = 0; i < n - 3; i++)
    {
        while (j < h)
        {
            int curr_sum = arr[j] + arr[h];

            if (curr_sum > k)
                h--;
            else if (curr_sum < k)
                j++;
            else if (curr_sum == k)
            {
                cout << arr[j] << " and " << arr[h] << endl;
                j++;
                h--;
            }
        }
    }
}

int main()
{
    int n;
    cin >> n;

    int arr[n];

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    int k;
    cin >> k;

    tripleSumK(arr, n, k);
}