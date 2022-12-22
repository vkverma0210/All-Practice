Input: [-3, -4, 5, -1, 2, -4, 6, -1]
arr1 =  [-3, -7, -2, -3, -1, -5, 1, 0]
arr2 = [0, 3, 7, 2, 3, 1, 5, -1]

ans = -2

select name, salary from employee order by salary desc limit = 1 ofset 3;
 

// 1st = arr[i];
// 2nd = arr[i] + sum[i- 1];
// 3rd = sum[i - 1];


// b = 4;

// Output: 8

// arr    i = 8
// if(i == 0)
//     {
//         pick = arr[0];
//         notPick = 0;
//         retun max(pick, notPick);
//     }

//     if(dp[i] != -1){
//         return dp[i];
//     }

//     sum = 0;
//     pick = arr[i] + f(arr, i - 1);
//     notpick = 0 + f(arr, i - 1);
    
//     sum += max(pick , notpick);
//     return dp[i] = sum;
// }