#include <bits/stdc++.h>

using namespace std;

class Car
{
public:
    string car_name;
    int x, y;

    Car(string n, int x, int y)
    {
        car_name = n;
        this->x = x;
        this->y = y;
    }

    int distance()
    {
        return x * x + y * y;
    }
};

bool compare(Car A, Car B)
{
    int dA = A.distance();
    int dB = B.distance();

    if (dA == dB)
        return A.car_name.length() < B.car_name.length();

    return dA < dB;
}

int main()
{
    int n;
    cin >> n;

    vector<Car> v;

    for (int i = 0; i < n; i++)
    {
        int x, y;
        string name;
        cin >> name >> x >> y;

        Car temp(name, x, y);
        v.push_back(temp);
    }

    sort(v.begin(), v.end(), compare);

    for (auto C : v)
    {
        cout << "Car " << C.car_name << " Distance " << C.distance() << " Location " << C.x << ", " << C.y << endl;
    }

    return 0;
}