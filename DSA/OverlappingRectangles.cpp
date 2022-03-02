#include <bits/stdc++.h>

using namespace std;

bool isRecatngleOverlap(vector<int> &rec1, vector<int> &rec2)
{
    if (rec1[2] <= rec2[0] || rec1[1] >= rec2[3] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1])
        return false;

    return true;
}

int main()
{
    vector<int> rec1;
    vector<int> rec2;

    for (int i = 0; i < 4; i++)
    {
        int x;
        cin >> x;
        rec1.push_back(x);
    }

    for (int i = 0; i < 4; i++)
    {
        int x;
        cin >> x;
        rec2.push_back(x);
    }

    cout << isRecatngleOverlap(rec1, rec2) << endl;
}