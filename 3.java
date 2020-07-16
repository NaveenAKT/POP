import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.*;

class project
{
	static
	{
		System.out.println("Welcome to BMS");
	}
	
	
	public static void main(String args[])
	{
		int i;
		String path="Movies/";
		String b="0";
		Scanner input=new Scanner(System.in);
		System.out.println("1.Book Ticket\n2.cancel ticket");
		System.out.printf("enter your choice : ");
		int num=input.nextInt();
		switch(num)
		{
		case 1:
			{
		int m,t,s;
		String m1,t1,s1;
		System.out.println("Choose any Option\n");
		System.out.println(" 1.Movie1\n 2.Movie2\n 3.Movie3\n 4.Movie4\n 5.Movie5\n 6.Exit\n");
		m=input.nextInt();
		switch(m)
		{
		case 1: m1="Movie1";path=path+m1+"/";break;
		case 2: m1="Movie2";path=path+m1+"/";break;
		case 3: m1="Movie3";path=path+m1+"/";break;
		case 4: m1="Movie4";path=path+m1+"/";break;
		case 5: m1="Movie5";path=path+m1+"/";break;
		}
		System.out.println("Choose any Option\n");
		System.out.println(" 1.Theatre1\n 2.Theatre2\n 3.Theatre3\n 4.Theatre4\n 5.Theatre5\n");
		t=input.nextInt();
		switch(t)
		{
		case 1: t1="Theatre1";path=path+t1+"/";break;
		case 2: t1="Theatre2";path=path+t1+"/";break;
		case 3: t1="Theatre3";path=path+t1+"/";break;
		case 4: t1="Theatre4";path=path+t1+"/";break;
		case 5: t1="Theatre5";path=path+t1+"/";break;
		}
		System.out.println("Choose any Option\n");
		System.out.println(" 1.Show1\n 2.Show2\n 3.Show3\n 4.Show4\n");
		s=input.nextInt();
		switch(s)
		{
		case 1: s1="Show1";path=path+s1+"/";break;
		case 2: s1="Show2";path=path+s1+"/";break;
		case 3: s1="Show3";path=path+s1+"/";break;
		case 4: s1="Show4";path=path+s1+"/";break;
		}
		path=path+"screen.txt";
		b=b+m+"/"+t+"/"+s+"/";

		try
		{
		File f = new File(path);
		String oldContent = "",newContent="";
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line = reader.readLine();
     
		int j=0;
		while (j<17) 
		{
			System.out.println(line);
			oldContent = oldContent + line + System.lineSeparator();
			line = reader.readLine();
			j++;
		}
		 while(line!=null)
		{
        oldContent = oldContent + line + System.lineSeparator();
        line = reader.readLine();
		}
		System.out.printf("Enter no. of tickets required : ");
		int n=input.nextInt();
		String seat[]=new String[n];
		System.out.printf("Enter no. of phone number : ");
		String ph=input.next();
		b=b+ph;
		System.out.println("Enter the required seat number : ");
		for(i=0;i<n;i++)
		{
		seat[i]=input.next(); 
		oldContent = oldContent.replaceAll(seat[i],"___");
		}
		newContent=oldContent;
		String names[]=new String[n];
		System.out.println("Enter the names of passengers respectively");
		for(i=0;i<n;i++)
		{
		names[i]=input.next();
		newContent=newContent+seat[i]+"-"+ph+" | "+names[i]+System.lineSeparator();
		}
		System.out.printf("Booking id : "+b);

     
		FileWriter writer = new FileWriter(f);

		writer.write(newContent);
     
		reader.close();
		writer.close();
		}
		
		catch(IOException e)
		{
		 System.out.println(e);
		}
		catch(NullPointerException e)
		{
		 System.out.println(e);
		}
		break;
			}




		case 2:
			{
		String m1,t1,s1;
		System.out.printf("enter your booking id number : ");
		b=input.next();
		String m=b.substring(1,2);
		String t=b.substring(3,4);
		String s=b.substring(5,6);
		String ph=b.substring(7,17);
		switch(m)
		{
		case "1": m1="Movie1";path=path+m1+"/";break;
		case "2": m1="Movie2";path=path+m1+"/";break;
		case "3": m1="Movie3";path=path+m1+"/";break;
		case "4": m1="Movie4";path=path+m1+"/";break;
		case "5": m1="Movie5";path=path+m1+"/";break;
		}
		switch(t)
		{
		case "1": t1="Theatre1";path=path+t1+"/";break;
		case "2": t1="Theatre2";path=path+t1+"/";break;
		case "3": t1="Theatre3";path=path+t1+"/";break;
		case "4": t1="Theatre4";path=path+t1+"/";break;
		case "5": t1="Theatre5";path=path+t1+"/";break;
		}
		switch(s)
		{
		case "1": s1="Show1";path=path+s1+"/";break;
		case "2": s1="Show2";path=path+s1+"/";break;
		case "3": s1="Show3";path=path+s1+"/";break;
		case "4": s1="Show4";path=path+s1+"/";break;
		}
		path=path+"screen.txt";
		String can[]=new String[100];
		int x=0,y=0;
		try
		{
			File f = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String line2="";
			for(i=0;i<17;i++)
			{
			line2=reader.readLine();
			}
			line2=reader.readLine();
			while(line2!=null)
			{
			String sub1=line2.substring(4,14);
			if(sub1.equals(ph)){
				can[x]=line2.substring(0,3);
				x=x+1;
				}
				line2=reader.readLine();
			}
			reader.close();
			}
		
			catch(IOException e)
			{
			 System.out.println(e);
			}
			catch(NullPointerException e)
			{
			System.out.println(e);
			}
		System.out.println("Canceled Seats:");
		while(y<x)
		{
		String q=can[y];
		System.out.println(can[y]);
		char r = q.charAt(0);
		int rn=Character.getNumericValue(r);
		rn=21-rn;
		int u1=Character.getNumericValue(q.charAt(1));
		int u2=Character.getNumericValue(q.charAt(2));
		int sn=((u1*10)+u2);
		String newContent1="",oldContent1="";
		try
		{
		File f = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line1="";
		for(i=0;i<rn-1;i++)
		{
		line1=reader.readLine();
		oldContent1=oldContent1 + line1 + System.lineSeparator();
		}
		line1=reader.readLine();
		int z1=(4*sn)-2;
		int z2=(4*sn)+1;
		line1=line1.substring(0,z1)+q+line1.substring(z2,63);
		oldContent1=oldContent1 + line1 + System.lineSeparator();
		for(i=0;i<17-rn;i++)
		{
		line1=reader.readLine();
		oldContent1=oldContent1 + line1 + System.lineSeparator();
		}
		line1=reader.readLine();
		while(line1!=null)
		{
			String sub=line1.substring(0,3);
			if(sub.equals(q)){
			line1=reader.readLine();}
			else{
			oldContent1=oldContent1 + line1 + System.lineSeparator();
			line1=reader.readLine();}
			}
			FileWriter writer = new FileWriter(f);
			newContent1=oldContent1;
			writer.write(newContent1);
			writer.close();
			reader.close();
			}
		
		catch(IOException e)
		{
		 System.out.println(e);
		}
		catch(NullPointerException e)
		{
		 System.out.println(e);
		}
		y=y+1;
		}
			break;
			}
		}
	}
}


