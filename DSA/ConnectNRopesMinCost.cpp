#include <bits/stdc++.h>

using namespace std;

struct MinHeap
{
    unsigned size;
    unsigned capacity;
    int *harr;
};

void swapMinHeapNode(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void minHeapify(struct MinHeap *minHeap, int idx)
{
    int smallest = idx;
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;

    if (left < minHeap->size && minHeap->harr[left] < minHeap->harr[smallest])
        smallest = left;

    if (right < minHeap->size && minHeap->harr[right] < minHeap->harr[smallest])
        smallest = right;

    if (smallest != idx)
    {
        swapMinHeapNode(&minHeap->harr[smallest], &minHeap->harr[idx]);
        minHeapify(minHeap, smallest);
    }
}

int isSizeOne(struct MinHeap *minHeap)
{
    return (minHeap->size == 1);
}

int extractMin(struct MinHeap *minHeap)
{
    int temp = minHeap->harr[0];
    minHeap->harr[0] = minHeap->harr[minHeap->size - 1];
    --minHeap->size;
    minHeapify(minHeap, 0);
    return temp;
}

void insertMinHeap(struct MinHeap *minHeap, int val)
{
    ++minHeap->size;
    int i = minHeap->size - 1;

    while (i && (val < minHeap->harr[(i - 1) / 2]))
    {
        minHeap->harr[i] = minHeap->harr[(i - 1) / 2];
        i = (i - 1) / 2;
    }

    minHeap->harr[i] = val;
}

void buildMinHeap(struct MinHeap *minHeap)
{
    int n = minHeap->size - 1;
    for (int i = (n - 1) / 2; i >= 0; i--)
        minHeapify(minHeap, i);
}

struct MinHeap *createMinHeap(unsigned capacity)
{
    struct MinHeap *minHeap = new MinHeap;
    minHeap->size = 0;
    minHeap->capacity = capacity;
    minHeap->harr = new int[capacity];

    return minHeap;
}

struct MinHeap *createAndBuildMinHeap(int len[], int n)
{
    struct MinHeap *minHeap = createMinHeap(n);

    for (int i = 0; i < n; i++)
        minHeap->harr[i] = len[i];
    minHeap->size = n;

    buildMinHeap(minHeap);

    return minHeap;
}

int minCost1(int len[], int n)
{
    int cost = 0;

    struct MinHeap *minHeap = createAndBuildMinHeap(len, n);

    while (!isSizeOne(minHeap))
    {
        int min = extractMin(minHeap);
        int sec_min = extractMin(minHeap);

        cost += (min + sec_min);

        insertMinHeap(minHeap, min + sec_min);
    }

    return cost;
}

int minCost2(int len[], int n)
{
    int cost = 0;

    priority_queue<int, vector<int>, greater<int>> pq(len, len + n);

    while (pq.size() > 1)
    {
        int first = pq.top();
        pq.pop();

        int second = pq.top();
        pq.pop();

        cost += first + second;

        pq.push(first + second);
    }

    return cost;
}

int main()
{
    int len[] = {4, 3, 2, 6};
    int size = sizeof(len) / sizeof(len[0]);

    cout << minCost2(len, size) << endl;

    return 0;
}