package Solve;

import java.lang.reflect.Array;
import java.util.Random;

public class Box {

	enum Color{Blue, Red, Green, Yellow, White, Orange};
	enum Piece{Corner, Side, Middle};

	Square[] squares;
	Color boxColor;

	public class Square{
		Color color;
		Color boxColor;
		Piece piece;
		String colorLetter;
		Square side1;
		Square side2;

		public Square(Color color, Color boxColor, Piece piece){ //, Color up, Color down, Color left, Color right){
			this.color=color;
			this.piece=piece;
			this.boxColor=boxColor;
			getColorLetter(color);
		}
		
		public void printSquare(){
			System.out.println("Box Color: "+boxColor+" Square Color: "+color+" Side One: "+side1+" Side Two: "+side2);
		}

		public void getColorLetter(Color color){
			switch(color){
			case White: colorLetter="W";
				break;
			case Blue: colorLetter="B";
				break;
			case Orange: colorLetter="O";
				break;
			case Green: colorLetter="G";
				break;
			case Red: colorLetter="R";
				break;
			case Yellow: colorLetter="Y";
				break;
			}
		}
	}

	public Box(Color[] colors){
		squares=new Square[9];
		for(int x=0; x<colors.length; x++){
			Color col=colors[x];
			squares[x]= new Square(col,colors[4],getPiece(x));
		}
		boxColor=colors[4];
	}
	
	public Piece getPiece(int loc){
		switch(loc){
		case 0: case 2: case 6: case 8: return Piece.Corner;
		case 1: case 3: case 5: case 7: return Piece.Side;
		case 4: return Piece.Middle;
		default: return null;
		}
	}

	public int[] getOppositeEdge(int[] edge){
		if(edge[1]==1){
			return new int[]{6,7,8};
		}else if(edge[1]==5){
			return new int[]{0,3,6};
		}else if(edge[1]==7){
			return new int[]{0,1,2};
		}else{
			return new int[]{2,5,8};
		}
	}
	
	public int[] getRandomEdge(int x){
		Random rand=new Random();
		int edge=rand.nextInt(4);
		if(x!=-1)
			edge=x;
		switch(edge){
		case 0: return new int[]{0,1,2};
		case 1: return new int[]{2,5,8};
		case 2: return new int[]{6,7,8};
		case 3: return new int[]{0,3,6};
		default: return null;
		}
	}
	
	public int[] getRightEdge(int[] edge){
		if(edge[1]==1){
			return new int[]{2,5,8};
		}else if(edge[1]==5){
			return new int[]{6,7,8};
		}else if(edge[1]==7){
			return new int[]{0,3,6};
		}else{
			return new int[]{0,1,2};
		}
	}

	public void setBoxOrientation(Box box, int side, int orientation){
		orientation(box,side);
		orientation(box,orientation);
	}
	
	public void orientation(Box box, int side){
		
		switch(side){
		case 0:
		case 1:box.squares=new Square[]{box.squares[2],box.squares[5], box.squares[8],
				box.squares[1],box.squares[4],box.squares[7],box.squares[0],box.squares[3], box.squares[6]};
		case 2:box.squares=new Square[]{box.squares[8],box.squares[7], box.squares[6],
				box.squares[5],box.squares[4],box.squares[3],box.squares[2],box.squares[1], box.squares[0]};
		case 3: box.squares=new Square[]{box.squares[6],box.squares[3], box.squares[0],
				box.squares[7],box.squares[4],box.squares[1],box.squares[8],box.squares[5], box.squares[2]};
		default:
		}
	}
	
	public Box[] getSides(){
		Color color=squares[4].boxColor;
		switch(color){
		case White:
			return new Box[]{Cube.blue, Cube.orange, Cube.green, Cube.red};
		case Yellow: 
			return new Box[]{Cube.blue, Cube.red, Cube.green, Cube.orange};
		case Red:
			return new Box[]{Cube.blue, Cube.white, Cube.green, Cube.yellow};
		case Blue:
			return new Box[]{Cube.orange, Cube.white, Cube.red, Cube.yellow};
		case Green:
			return new Box[]{Cube.orange, Cube.yellow, Cube.red, Cube.white};
		case Orange:
			return new Box[]{Cube.blue, Cube.yellow, Cube.green, Cube.white};
		default:
			return null;
		}
	}
}
