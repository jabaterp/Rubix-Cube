package Solve;

import java.util.Arrays;
import java.util.Random;

import Solve.Box.Color;
import Solve.Box.Square;

public class Cube {

	public static Cube cube;
	public static Box green,blue,orange,white,red, yellow;public Box[] boxes=new Box[]{white, blue, orange, green, red, yellow};

	//Wrapped around starting with White on top
	//White Blue Yellow Green Red Orange

	public Cube(Color[] squares){
		white=new Box(Arrays.copyOfRange(squares,0,9));
		blue=new Box(Arrays.copyOfRange(squares,9,18));
		green=new Box(Arrays.copyOfRange(squares,18,27));
		red=new Box(Arrays.copyOfRange(squares,27,36));
		orange=new Box(Arrays.copyOfRange(squares,36,45));
		yellow=new Box(Arrays.copyOfRange(squares,45,54));
		connect();
	}

	public void connect(){
		Box[] wSides=white.getSides();
		Box[] ySides=yellow.getSides();
		int[] wSideEdge;
		for(int i=0;i<4;i++){
			wSideEdge=wSides[i].getRandomEdge(-1);
			int[] randomNextSideEdge;
			if(i==3){
				randomNextSideEdge=wSides[0].getRandomEdge(-1);
			}else{
				randomNextSideEdge=wSides[i+1].getRandomEdge(-1);
			}
			int[] rightEdge=wSides[i].getRightEdge(wSideEdge);
			snap(white,wSides[i],white.getRandomEdge(i),wSideEdge);
			if(i==3){
				snap(wSides[i],wSides[0],rightEdge,randomNextSideEdge);
			}else{
				snap(wSides[i],wSides[i+1],rightEdge,randomNextSideEdge);
			}
			snap(wSides[i],yellow,wSides[i].getOppositeEdge(wSideEdge),ySides[i].getRandomEdge(i));
		}
	}

	public void printSquares(){
		for(Square sq:white.squares){
			sq.printSquare();
		}
		for(Square sq:blue.squares){
			sq.printSquare();
		}
		for(Square sq:orange.squares){
			sq.printSquare();
		}
		for(Square sq:green.squares){
			sq.printSquare();
		}
		for(Square sq:red.squares){
			sq.printSquare();
		}
		for(Square sq:yellow.squares){
			sq.printSquare();
		}
	}

	public void printGraphicCube(){
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+white.squares[0].colorLetter+" || "+white.squares[1].colorLetter+" || "+white.squares[2].colorLetter+" |               ");
		System.out.println("                |___||___||___|               ");
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+white.squares[3].colorLetter+" || "+white.squares[4].colorLetter+" || "+white.squares[5].colorLetter+" |               ");
		System.out.println("                |___||___||___|               ");
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+white.squares[6].colorLetter+" || "+white.squares[7].colorLetter+" || "+white.squares[8].colorLetter+" |              ");
		System.out.println("                |___||___||___|               ");
		System.out.println(" ___  ___  ___   ___  ___  ___   ___  ___  ___ ");
		System.out.println("| "+red.squares[0].colorLetter+" || "+red.squares[1].colorLetter+" || "+red.squares[2].colorLetter+" | | "+blue.squares[0].colorLetter+" || "+blue.squares[1].colorLetter+" || "+blue.squares[2].colorLetter+" | | "+orange.squares[0].colorLetter+" || "+orange.squares[1].colorLetter+" || "+orange.squares[2].colorLetter+" |");
		System.out.println("|___||___||___| |___||___||___| |___||___||___|");
		System.out.println(" ___  ___  ___   ___  ___  ___   ___  ___  ___ ");
		System.out.println("| "+red.squares[3].colorLetter+" || "+red.squares[4].colorLetter+" || "+red.squares[5].colorLetter+" | | "+blue.squares[3].colorLetter+" || "+blue.squares[4].colorLetter+" || "+blue.squares[5].colorLetter+" | | "+orange.squares[3].colorLetter+" || "+orange.squares[4].colorLetter+" || "+orange.squares[5].colorLetter+" |");
		System.out.println("|___||___||___| |___||___||___| |___||___||___|");
		System.out.println(" ___  ___  ___   ___  ___  ___   ___  ___  ___ ");
		System.out.println("| "+red.squares[6].colorLetter+" || "+red.squares[7].colorLetter+" || "+red.squares[8].colorLetter+" | | "+blue.squares[6].colorLetter+" || "+blue.squares[7].colorLetter+" || "+blue.squares[8].colorLetter+" | | "+orange.squares[6].colorLetter+" || "+orange.squares[7].colorLetter+" || "+orange.squares[8].colorLetter+" |");
		System.out.println("|___||___||___| |___||___||___| |___||___||___|");
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+green.squares[0].colorLetter+" || "+green.squares[1].colorLetter+" || "+green.squares[2].colorLetter+" |               ");
		System.out.println("                |___||___||___|               ");
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+green.squares[3].colorLetter+" || "+green.squares[4].colorLetter+" || "+green.squares[5].colorLetter+" |               ");
		System.out.println("                |___||___||___|               ");
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+green.squares[6].colorLetter+" || "+green.squares[7].colorLetter+" || "+green.squares[8].colorLetter+" |               ");
		System.out.println("                |___||___||___|               ");
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+yellow.squares[0].colorLetter+" || "+yellow.squares[1].colorLetter+" || "+yellow.squares[2].colorLetter+" |               ");
		System.out.println("                |___||___||___|               ");
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+yellow.squares[3].colorLetter+" || "+yellow.squares[4].colorLetter+" || "+yellow.squares[5].colorLetter+" |               ");
		System.out.println("                |___||___||___|               ");
		System.out.println("                 ___  ___  ___                ");
		System.out.println("                | "+yellow.squares[6].colorLetter+" || "+yellow.squares[7].colorLetter+" || "+yellow.squares[8].colorLetter+" |               ");
		System.out.println("                |___||___||___|               ");
		
	}

	public void snap(Box box1, Box box2, int[] b1Edge, int[] b2Edge){
		for(int i=0; i<3 ; i++){
			if(box1.squares[b1Edge[i]].side1==null){
				box1.squares[b1Edge[i]].side1 = box2.squares[b2Edge[i]];
			}else{
				box1.squares[b1Edge[i]].side2 = box2.squares[b2Edge[i]];
			}
			if(box2.squares[b2Edge[i]].side1== null){
				box2.squares[b2Edge[i]].side1 = box1.squares[b1Edge[i]];
			}else{
				box2.squares[b2Edge[i]].side2 = box1.squares[b1Edge[i]];
			}
		}
	}
}
