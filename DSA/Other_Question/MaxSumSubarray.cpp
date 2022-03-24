#include <bits/stdc++.h>

using namespace std;

void maxSumSubarray1(int arr[], int n)
{
    int left = 0;
    int right = 0;
    int currSum = 0;
    int maxSum = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = i; j < n; j++)
        {
            currSum = 0;

            for (int k = i; k <= j; k++)
            {
                currSum += arr[k];

                if (currSum > maxSum)
                {
                    maxSum = currSum;
                    left = i;
                    right = j;
                }
            }
        }
    }

    for (int i = left; i <= right; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}

void maxSumSubarray2(int arr[], int n)
{
    int sumTillNow[n]{0};
    sumTillNow[0] = arr[0];
    int left = 0;
    int right = 0;
    int currSum = 0;
    int maxSum = 0;

    for (int i = 1; i < n; i++)
    {
        sumTillNow[i] = sumTillNow[i - 1] + arr[i];
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = i; j < n; j++)
        {
            currSum = sumTillNow[j] - sumTillNow[i - 1];

            if (currSum > maxSum)
            {
                maxSum = currSum;
                left = i;
                right = j;
            }
        }
    }

    for (int i = left; i <= right; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}

void kadaneAlgorithm(int arr[], int n)
{
    int maxSoFar = arr[0];
    int currMax = arr[0];
    int left = 0;
    int right = 0;

    for (int i = 1; i < n; i++)
    {
        currMax = max(arr[i], currMax + arr[i]);
        maxSoFar = max(currMax, maxSoFar);
    }

    cout << maxSoFar << endl;
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

    // maxSumSubarray1(arr, n);
    // maxSumSubarray2(arr, n);
    kadaneAlgorithm(arr, n);
}