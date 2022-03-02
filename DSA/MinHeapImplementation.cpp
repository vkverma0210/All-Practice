#include <bits/stdc++.h>

using namespace std;

class Heap
{
    vector<int> v;

    void heapify(int idx)
    {
        int smallest = idx;
        int last = v.size() - 1;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left <= last && v[left] < v[smallest])
            smallest = left;

        if (right <= last && v[right] < v[smallest])
            smallest = right;

        if (smallest != idx)
        {
            swap(v[idx], v[smallest]);

            heapify(smallest);
        }
    }

public:
    Heap(int default_size = 10)
    {
        v.reserve(default_size);
    }

    void push(int d)
    {
        v.push_back(d);
        int idx = v.size() - 1;
        int parent = idx / 2;

        while (idx > 0 && (v[idx] < v[parent]))
        {
            swap(v[idx], v[parent]);
            idx = parent;
            parent = parent / 2;
        }
    }

    int top()
    {
        return v[0];
    }

    void pop()
    {
        int last = v.size() - 1;
        swap(v[0], v[last]);
        v.pop_back();

        heapify(0);
    }

    bool empty()
    {
        return v.size() == 0;
    }
};

int main()
{
    Heap h;
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int no;
        cin >> no;
        h.push(no);
    }

    while (!h.empty())
    {
        cout << h.top() << " ";
        h.pop();
    }

    return 0;
}