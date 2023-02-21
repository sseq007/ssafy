package ssafy.com.lecture.day0221.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스도쿠 {
    static int[][] map;
    static ArrayList<Point> list = new ArrayList<>();
    static class Point{
        int r,c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];

        //입력 받기
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) {
                    //0이면 리스트에 저장
                    list.add(new Point(i,j));
                }
            }
        }

        //재귀로 돌리기
        // 0은 빈칸 후보의 idx(0번째부터)
        solve(0);

    }

//K : 빈칸 좌표 idx 
private static void solve(int k) {
    //basis part
    
    if(k==list.size()) {
    	for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
    	System.exit(0);
        return;
    }
    
    
    //inductive part : 1부터 9까지 값을 넣어봄
    int r = list.get(k).r;
    int c = list.get(k).c;
    
    for(int i=1;i<=9;i++) {
        
        //가지치기
        //값을 넣기 전에, 가로 세로 사각형 안에 중복되는 값이 있는지 
        if(check(r,c,i)) {
            map[r][c] = i;
            solve(k+1);
            //재귀 끝나면 원래 값인 0으로 채워줘야됨
            map[r][c] = 0;
        }
        
    }
}

//중복 되는 값이 없으면 true 있으면 false return

private static boolean check(int x, int y, int val) {
	
	for(int i=0;i<9;i++) {
		if(map[x][i]==val) return false;
	}
	for(int i=0;i<9;i++) {
		if(map[i][y]==val) return false;
	}
	
	int nx = (x/3)*3;
	int ny  = (y/3)*3;
	for(int i=nx;i<nx+3;i++) {
		for(int j=ny;j<ny+3;j++) {
			if(map[i][j]==val) return false;
		}
	}
	
	return true;
}
}