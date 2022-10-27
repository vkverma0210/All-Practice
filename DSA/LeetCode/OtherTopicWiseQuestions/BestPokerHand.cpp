#include <bits/stdc++.h>

using namespace std;

string bestHand(vector<int> &ranks, vector<char> &suits)
{
    int count = 1;
    int maxCount = 1;
    sort(ranks.begin(), ranks.end());
    sort(suits.begin(), suits.end());

    for (int i = 1; i < 5; i++)
    {
        if (suits[i] == suits[i - 1])
        {
            count++;
            maxCount = max(maxCount, count);
        }
        else
            count = 1;
    }

    if (maxCount == 5)
        return "Flush";

    int countRank = 1;
    int maxCountRank = 1;
    for (int i = 1; i < 5; i++)
    {
        if (ranks[i] == ranks[i - 1])
        {
            countRank++;
            maxCountRank = max(maxCountRank, countRank);
        }
        else
            countRank = 1;
    }
    if (maxCountRank >= 3)
        return "Three of a Kind";
    else if (maxCountRank == 2)
        return "Pair";
    else
        return "High Card";
}

int main()
{

    vector<int> ranks(5);
    vector<char> suits(5);

    for (int i = 0; i < 5; i++)
    {
        cin >> ranks[i];
    }

    for (int i = 0; i < 5; i++)
    {
        cin >> suits[i];
    }

    cout << bestHand(ranks, suits) << endl;

    return 0;
}