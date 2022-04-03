#include <bits/stdc++.h>

using namespace std;

int main()
{
  int t;
  cin >> t;

  for (int i = 1; i <= t; i++)
  {
    int n, m;
    cin >> n >> m;

    cout << "Case #" << i << ":\n";
    // First Row
    cout << "..+";

    for (int i = 2; i <= m; i++)
    {
      cout << "-+";
    }
    cout << endl;

    cout << "..|";

    for (int i = 2; i <= m; i++)
    {
      cout << ".|";
    }
    cout << endl;

    cout << "+";
    for (int i = 1; i <= m; i++)
    {
      cout << "-+";
    }
    cout << endl;

    // Rest of Rows

    for (int i = 2; i <= n; i++)
    {
      cout << "|";
      for (int j = 1; j <= m; j++)
      {
        cout << ".|";
      }
      cout << endl;

      cout << "+";
      for (int j = 1; j <= m; j++)
      {
        cout << "-+";
      }
      cout << endl;
    }
  }

  return 0;
}