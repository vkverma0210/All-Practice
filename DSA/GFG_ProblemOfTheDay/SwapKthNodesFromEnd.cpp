#include <bits/stdc++.h>

using namespace std;

struct Node
{
    int data;
    struct Node *next;
    Node(int x)
    {
        data = x;
        next = NULL;
    }
};

void addressStore(Node **arr, Node *head)
{
    Node *temp = head;
    int i = 0;
    while (temp)
    {
        arr[i] = temp;
        i++;
        temp = temp->next;
    }
}

bool check(Node **before, Node **after, int num, int k)
{
    if (k > num)
        return 1;

    return (before[k - 1] == after[num - k] && before[num - k] == after[k - 1]);
}

Node *swapKthNode(Node *head, int n, int k)
{
    if (k > n || 2 * k - 1 == n)
        return head;

    if (k > n / 2)
        k = n - k + 1;

    Node *temp1 = head, *temp2 = head, *prev_temp1 = NULL, *prev_temp2 = NULL, *next_temp1 = NULL, *next_temp2 = NULL;

    int x = k;

    while (x > 1)
    {
        prev_temp1 = temp1;
        temp1 = temp1->next;
        x--;
    }

    x = k;
    while (n - x > 0)
    {
        prev_temp2 = temp2;
        temp2 = temp2->next;
        x++;
    }

    next_temp1 = temp1->next;
    next_temp2 = temp2->next;

    if (temp2->next == NULL)
    {
        temp2->next = next_temp1;
        prev_temp2->next = temp1;
        temp1->next = NULL;
        return temp2;
    }
    else if (temp1->next == temp2)
    {
        prev_temp1->next = temp2;
        temp2->next = temp1;
        temp1->next = next_temp2;
    }
    else
    {
        prev_temp1->next = temp2;
        temp2->next = next_temp1;
        prev_temp2->next = temp1;
        temp1->next = next_temp2;
    }

    return head;
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int n, k, firstdata;
        cin >> n >> k;

        int temp;
        cin >> firstdata;
        Node *head = new Node(firstdata);
        Node *tail = head;

        for (int i = 0; i < n - 1; i++)
        {
            cin >> temp;
            tail->next = new Node(temp);
            tail = tail->next;
        }

        Node *before[n];
        addressStore(before, head);

        head = swapKthNode(head, n, k);

        Node *after[n];
        addressStore(after, head);

        if (check(before, after, n, k))
            cout << 1 << endl;
        else
            cout << 0 << endl;
    }

    return 0;
}