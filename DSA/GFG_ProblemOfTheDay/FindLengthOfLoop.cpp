#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    Node *next;

    Node(int val)
    {
        data = val;
        next = NULL;
    }
};

void loopHere(Node *head, Node *tail, int position)
{
    if (position == 0)
        return;

    Node *walk = head;
    for (int i = 1; i < position; i++)
        walk = walk->next;
    tail->next = walk;
}

int countNodesinLoop(struct Node *head)
{
    int ans = 0;

    if (!head->next || !head)
        return 0;

    Node *slow = head;
    Node *fast = head;

    do
    {
        slow = slow->next;
        fast = fast->next->next;
    } while (fast && fast->next && fast != slow);

    if (slow != fast)
        return 0;

    Node *temp = fast;
    fast = fast->next;

    while (temp != fast)
    {
        fast = fast->next;
        ans++;
    }
    return ans + 1;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, num;
        cin >> n;

        Node *head, *tail;
        cin >> num;
        head = tail = new Node(num);

        for (int i = 0; i < n - 1; i++)
        {
            cin >> num;
            tail->next = new Node(num);
            tail = tail->next;
        }

        int pos;
        cin >> pos;
        loopHere(head, tail, pos);

        cout << countNodesinLoop(head) << endl;
    }
    return 0;
}