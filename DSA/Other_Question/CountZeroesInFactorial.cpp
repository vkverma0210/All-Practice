#include<bits/stdc++.h>

using namespace std;

int countZeroes(int n){
    int count = 0;

    while(n > 0){
        n = n/5;
        count += n;

    }

    return count;
}

int main()
{
    int n;
    cin >> n;
    cout<< countZeroes(n) << endl;

    return 0;
}