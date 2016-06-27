package Solve;

import java.util.Random;

import Solve.Box.Color;
import Solve.Box.Piece;
import Solve.Box.Square;

public class RandomCube {

	static Color[] squares= new Color[54];
	static Cube cube;
	
	public static void main(String[] args){
		Random colorRand=new Random();
		Random pieceRand=new Random();
		int count=0;
		
		int[][] colorCount= new int[6][9];

		int color;
		int piece;
		while(count<54){
			color=colorRand.nextInt(6);
			piece=pieceRand.nextInt(3);
			if(count==4 || count==13 || count==22 || count==31 || count==40 || count==49){
				switch(count){
				case 4: color=0; piece=2; 
					break;
				case 13: color=1; piece=2; 
					break;
				case 22: color=2; piece=2; 
					break;
				case 31: color=3; piece=2; 
					break;
				case 40: color=4; piece=2; 
					break;
				case 49: color=5; piece=2; 
					break;
				default:
				}
				colorCount[color][piece]++;
				squares[count]= getColor(color);
				count++;
			}else if(colorCount[color][piece]!=4 && piece!=2){
				squares[count]= getColor(color);
				colorCount[color][piece]++;
				count++;
			}
		}
		cube=new Cube(squares);
		cube.printSquares();
		cube.printGraphicCube();
	}

	public static Color getColor(int col){
		switch(col){
		case 0: return Color.White;
		case 1: return Color.Blue;		
		case 2: return Color.Green;		
		case 3: return Color.Orange;		
		case 4: return Color.Red;		
		case 5: return Color.Yellow;
		default: return null;
		}
	}
	
	public static Piece getPiece(int piece){
		switch(piece){
		case 0: return Piece.Corner;
		case 1: return Piece.Side;
		case 2: return Piece.Middle;
		default: return null;
		}
	}
}
