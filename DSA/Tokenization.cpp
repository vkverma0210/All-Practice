#include <bits/stdc++.h>

using namespace std;

int main()
{
    char s[1000] = "Today is very good day...!";

    char *ptr = strtok(s, " ");

    cout << ptr << endl;

    while (ptr != NULL)
    {
        ptr = strtok(NULL, " ");
        cout << ptr << endl;
    }

    return 0;
}