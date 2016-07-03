package qiang.leetcode4;

import java.util.LinkedList;

public class DesignSnakeGame353 {

    class Position{
    	int x,y;
    	Position(int x,int y){
    		this.x = x;
    		this.y = y;
		}
	}
	int width ;
	int height;
	int [][]food;
	boolean boardFlag[][];
	LinkedList<Position> snake;
	int eatCount = 0;
	
	public  DesignSnakeGame353(int width, int height, int [][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		this.snake = new LinkedList<>();
		boardFlag = new boolean [width][height];
		this.snake.add(new Position(0,0));
		boardFlag[0][0] = true; 
    }

    /**
    * @param direction U = Up, L = Left, R = Right, D = Down
    * @return The game's score after the move. Return -1 if game over.
    */
    public int move(char direction) {
    	
    	Position first = this.snake.getFirst();
    	Position next = new Position(first.x,first.y);
    	switch(direction){
    	case 'U': 
    		next.y--;
    		break;
    	case 'L': 
    		next.x--;
    		break;
    	case 'R': 
    		next.x++;
    		break;
    	case 'D': 
    		next.y++;
    		break;
    	default : return -1;
    	}
    	if(next.x < 0 || next.x > width-1 || next.y< 0 || next.y > height-1) return -1;
    	if(this.boardFlag[next.x][next.y]) return -1;
    	if(this.eatCur(next.x, next.y)){ // 吃上了
    		this.boardFlag[next.x][next.y] = true;
    		snake.addFirst(next);
    		return ++this.eatCount;
    	}
    	// 没吃上
    	Position last = this.snake.getLast();
    	this.snake.removeLast();
    	this.boardFlag[last.x][last.y] = false;
    	this.snake.addFirst(next);
    	return this.eatCount;
    }
    boolean eatCur(int x,int y){
    	if(this.eatCount > this.food.length) return false;
    	if(food[eatCount][0] < 0 || food[eatCount][0] > width-1 || food[eatCount][1] < 0 ||food[eatCount][1]> height-1)return false;
    	if(x == food[eatCount][0] && food[eatCount][0] == y) return true;
    	return false;
    }
}
