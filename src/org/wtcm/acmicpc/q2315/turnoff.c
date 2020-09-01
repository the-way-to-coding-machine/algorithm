// note. this code can not run on intellij

#include <stdio.h>
#include <stdlib.h>

#define MIN(X,Y)  X > Y ? Y : X
#define N 1002
#define LEFT 0
#define RIGHT 1

int n, m, D[N], W[N], s[N], S, dp[N+1][N+1][2], i, j;

int main()
{
    scanf("%d %d", &n, &m);
    for(i = 1; i <= n; i++) {
        scanf("%d %d", &D[i], &W[i]);
        s[i] = s[i-1] + W[i];
    }

    S=s[n]; // total sum
    m=D[m];

    for(i = 1; i <= n; i++)
        dp[i][i][LEFT] = dp[i][i][RIGHT] = abs(D[i] - m) * S;

    for(i = 1; i < n; i++) {
        for(j = 1; j <= n-i; j++) {
            dp[j][j+i][LEFT] = MIN(dp[j+1][j+i][LEFT] + (D[j+1] - D[j])*(S-s[j+i]+s[j]), dp[j+1][j+i][RIGHT] + (D[j+i]-D[j])*(S-s[j+i]+s[j]));
            dp[j][j+i][RIGHT] = MIN(dp[j][j+i-1][LEFT] + (D[j+i]- D[j])*(S-s[j+i-1]+s[j-1]), dp[j][j+i-1][RIGHT] + (D[j+i]-D[j+i-1])*(S-s[j+i-1]+s[j-1]));
        }
    }

    printf("%d\n", MIN(dp[1][n][LEFT], dp[1][n][RIGHT]));
}
