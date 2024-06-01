import java.util.Random;
import java.util.Scanner;
class TicTacToe1
{
static char[][] board; //DEclaration of board
    public TicTacToe1() //  this is a constructor and constructor have same name like class name
    {
       board=new char[3][3];
       intiBoard1();
    } 
    void intiBoard1()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                board[i][j]=' ';
            }
        }
    }
   static void dispBoard()
    {
        System.out.println("-------------");
        for(int i=0;i<board.length;i++)
        {
            System.out.print("| ");
            for(int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");

        }
    }
    static void placemark(int row,int col,char mark)
    {
       if(row >=0 && row<=2 && col>=0 && col<=2)
       {
        board[row][col]=mark;
       }
       else{
        System.out.println("Invalis position");
       }
    }
    static boolean checkColwin()
    {
        for(int j=0;j<=2;j++)
        {
            if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
            {
                return true;
            }
        }
        return false;
    }
    static boolean checkRowwin()
    {
        for(int i=0;i<=2;i++)
        {
            if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
            {
                return true;
            }
        }
        return false;
    }
    static boolean checkDigWin()
    {
        if(board[0][0]!=' ' && board[0][0] == board[1][1] && board[1][1]==board[2][2]  || board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            return true;
        }
        return false;
    }

    static boolean checkDraw()
    {
        for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
            {
                if(board[i][j]==' ')
                {
                    return false;
                }
            }
        }
        return true;
    }


}

abstract class Player
{
    String name;
    char mark;
    abstract void makeMove();
    boolean isvalidMove(int row,int col)
    {
        if(row>=0 && row<=2 && col>=0 && col<=2)
        {
           
            if(TicTacToe1.board[row][col]==' ')
            {
                return true;
            }
        }
        return false;
    }

}


class Humanplayer1 extends Player
{
    //String name;
    //char mark;
    Humanplayer1(String name,char mark)
    {
        this.name=name;
        this.mark=mark;
    }

    void makeMove()
    {
       Scanner scan=new Scanner(System.in);
       //System.out.println("enter the row and coloumn");
       int row;
       int col;
       do{
         System.out.println("enter the row and coloumn");
         row=scan.nextInt();
         col=scan.nextInt();
       // Random r = new Random();
       // row=r.nextInt(3);
       // col=r.nextInt(3);

       }while(!isvalidMove(row,col));
       TicTacToe1.placemark(row, col, mark);

    }
}


class Computer extends Player
{
   // String name;
    //char mark;
    Computer(String name,char mark)
    {
        this.name=name;
        this.mark=mark;
    }

    void makeMove()
    {
       Scanner scan=new Scanner(System.in);
       //System.out.println("enter the row and coloumn");
       int row;
       int col;
       do{
         //System.out.println("enter the row and coloumn");
         //row=scan.nextInt();
         //col=scan.nextInt();
       Random r = new Random();
       row=r.nextInt(3);
       col=r.nextInt(3);

       }while(!isvalidMove(row,col));
       TicTacToe1.placemark(row, col, mark);

    }


  
}




public class launchgame1 {
    public static void main(String args[])
    {
        TicTacToe1 t = new TicTacToe1(); //
       Humanplayer1 p1= new Humanplayer1("Leela",'X');
      // Humanplayer1 p2= new Humanplayer1("leela",'O');
       Computer p2 = new Computer("TAI",'O');

    Player cp;
    cp=p1; // An oject can have a multiple refernces
    while(true)
    {
       System.out.println(cp.name + " Turn");
       cp.makeMove();
       TicTacToe1.dispBoard();
       if(TicTacToe1.checkColwin() || TicTacToe1.checkRowwin() || TicTacToe1.checkDigWin())
       {
         System.out.println(cp.name+"has won");
       }
       else if(TicTacToe1.checkDraw())
       {
        System.out.println("Game is a Draw");
        break;
       }
       else{
        if(cp==p1)
        {
         cp=p2;
        }
        else{
            cp=p1;
        }
       }
    }



    }
    
}
