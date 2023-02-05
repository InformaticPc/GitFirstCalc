
// VScode branch
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
	

public class OperativeCalc extends JFrame {
	public OperativeCalc() {
		setTitle("FlowLayouts");
		setBounds(500, 500, 500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyStreamPanel topPanel = new MyStreamPanel();
		add(topPanel);
		setVisible(true);
	}
}

class MyStreamPanel extends JPanel implements ActionListener{

	private JButton bStream = new JButton("0");
	private JButton bResult = new JButton("Result");
	private JPanel panelGrid;
	private boolean start=true; 
	
	private long n1=0;
	private long n2=0;
	//private long result=0; sabe the last result
	private boolean sum=false;//to know when make the sum
	private boolean times=false;//to know when make the multiplication
	private boolean div=false;//to know when make the multiplication
	private boolean substract=false;//to know when make the multiplication
	
	public MyStreamPanel() {
		
		
		setLayout(new BorderLayout());
		
		bStream.setEnabled(false);
		bStream.setBackground(Color.WHITE);
		add(bStream, BorderLayout.NORTH);
		
		bStream.add(bResult, BorderLayout.WEST);
		
		panelGrid=new JPanel(new GridLayout(4, 3));
		add(panelGrid, BorderLayout.CENTER);
		
		
		addButton("1");
		addButton("2");
		addButton("3");
		addButton("4");
		addButton("5");
		addButton("6");
		addButton("7");
		addButton("8");
		addButton("9");
		addButton("0");
		addButton("+");
		addButton("*");
		addButton("/");
		addButton("-");
		addButton("=");
		
		
	}
	
	private void addButton(String buttonName) {
		JButton button=new JButton(buttonName);
		panelGrid.add(button);
		button.addActionListener(this);
		/*
		 *   // creating buttons
        for(int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new JButton("789/456*123+c0=-".substring(i, i+1));
            buttons[i].addActionListener(this);
           // add them to the top panel
           top.add(buttons[i]);
        }
		*/
	}
	
	private Character isSimbol(char simbol) {
		switch (simbol) {
		case '+':
			return simbol;
			
		case '*':
			return simbol;
			
		case '=':
			return simbol;
		case '-':
			return simbol;
		case '/':
			return simbol;

		default:
			return (Character) null;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttPressed=(JButton)e.getSource();
		String stringOfButton=buttPressed.getText();
		Character operator=isSimbol(stringOfButton.charAt(0));
		
		
		if(start) {
			if(operator != null) {
				System.out.println("first press a number");
			}else {
				bStream.setText(stringOfButton);
				start=false;
				
			}
		}else {
			if(operator != null) {
				
				start=true;//if we press an operator we cant press it again in a row
				
				String stringOperator=operator.toString();//use for show the operator in setText
				
				switch ((char)operator) {
				case '+':
					
					if(!sum) {//condition true only for the first time of calculation or after '=' simbol
						
						sum=true;
						if(times) 
						{
							n2= Long.parseLong(bStream.getText());
							n1*=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							times=false;
						}
						else if(div)
						{
							n2= Long.parseLong(bStream.getText());
							n1/=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							div=false;
						}
						else if(substract)
						{
							n2= Long.parseLong(bStream.getText());
							n1-=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							substract=false;
						}
						else 
						{
							n1= Long.parseLong(bStream.getText());
							bStream.setText(stringOperator);
							
						}
					}else {//significa que antes tambien se hizo una suma
						
							n2= Long.parseLong(bStream.getText());
							n1+=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							sum=true;
					}
					break;
				case '*':
					if(!times) {//condition true only for the first time of calculation or after '=' simbol
						
						times=true;
						if(sum) 
						{
							n2= Long.parseLong(bStream.getText());
							n1+=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							sum=false;
						}
						else if(div)
						{
							n2= Long.parseLong(bStream.getText());
							n1/=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							div=false;
						}
						else if(substract)
						{
							n2= Long.parseLong(bStream.getText());
							n1-=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							substract=false;
						}
						else 
						{
							n1= Long.parseLong(bStream.getText());
							bStream.setText(stringOperator);
							
						}
					}else {//significa que antes tambien se hizo una multiplicacion
						
							n2= Long.parseLong(bStream.getText());
							n1*=n2;
							bResult.setText(String.valueOf(n1));
					}
					break;
				case '/': //if(a % b != 0) Log.v("result", "The result is a decimal");
						 //else Log.v("result", "The result is an integer");
					
					if(!div) {
						div=true;
						if(times) 
						{
							n2= Long.parseLong(bStream.getText());
							n1*=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							times=false;
						}
						else if(sum)
						{
							n2= Long.parseLong(bStream.getText());
							n1+=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							sum=false;
						}
						else if(substract)
						{
							n2= Long.parseLong(bStream.getText());
							n1-=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							substract=false;
						}
						else 
						{
							n1= Long.parseLong(bStream.getText());
							bStream.setText(stringOperator);
							
						}
					}else {//significa que antes tambien se hizo una divicion
						
						n2= Long.parseLong(bStream.getText());
						n1/=n2;
						bResult.setText(String.valueOf(n1));
					}
					break;
				case '-':
					if(!substract) {//condition true only for the first time of calculation or after '=' simbol
						
						substract=true;
						if(times) 
						{
							n2= Long.parseLong(bStream.getText());
							n1*=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							times=false;
						}
						else if(div)
						{
							n2= Long.parseLong(bStream.getText());
							n1/=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							div=false;
						}
						else if(sum)
						{
							n2= Long.parseLong(bStream.getText());
							n1+=n2;
							bResult.setText(String.valueOf(n1));
							bStream.setText(stringOperator);
							sum=false;
						}
						else 
						{
							n1= Long.parseLong(bStream.getText());
							bStream.setText(stringOperator);
							
						}
					}else {//significa que antes tambien se hizo una resta
						
						n2= Long.parseLong(bStream.getText());
						n1-=n2;
						bResult.setText(String.valueOf(n1));
					}
					break;
				case '=':
					if(times) 
					{
						n2= Long.parseLong(bStream.getText());
						n1*=n2;
						bResult.setText("Result");
						bStream.setText(String.valueOf(n1));
					}
					else if(sum)
					{
						n2= Long.parseLong(bStream.getText());
						n1+=n2;
						bResult.setText("Result");
						bStream.setText(String.valueOf(n1));
					}
					else if(div) 
					{
						n2= Long.parseLong(bStream.getText());
						n1/=n2;
						bResult.setText("Result");
						bStream.setText(String.valueOf(n1));
					}
					else //substract
					{
						n2= Long.parseLong(bStream.getText());
						n1-=n2;
						bResult.setText("Result");
						bStream.setText(String.valueOf(n1));
					}
					//reset everything
					n1=0;
					n2=0;
					times=false;
					substract=false;
					div=false;
					sum=false;
					start=true;
					break;

				default:
					break;
				}
			}else {
				bStream.setText(bStream.getText()+stringOfButton);
				
			}
			//testing change git
			
		}
		
	}
}
