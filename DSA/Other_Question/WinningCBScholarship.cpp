#include <bits/stdc++.h>

using namespace std;

int main()
{
    long long n, m, x, y;
    cin >> n >> m >> x >> y;

    long long remStudents = 0;
    long long leftCoupons = 0;
    long long studentGettingFull = m / x;

    if (n > studentGettingFull)
    {
        remStudents = n - studentGettingFull;
        leftCoupons = m % x;
    }
    else
    {
        cout << n << endl;
        return 0;
    }

    while (remStudents > 1)
    {
        leftCoupons += y;

        if (leftCoupons >= x)
        {
            long mediator = leftCoupons / x;
            if (mediator <= remStudents)
            {
                studentGettingFull += mediator;
                remStudents -= mediator;
                leftCoupons = leftCoupons % x;
            }
            else
            {
                studentGettingFull += remStudents - 1;
                break;
            }
        }

        remStudents--;
    }

    cout << studentGettingFull << endl;

    return 0;
}