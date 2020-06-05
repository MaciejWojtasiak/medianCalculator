package medianCalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.stream.*;
import javax.swing.*;

public class MedianFrame extends JFrame implements ActionListener {	
	
	ArrayList<Double> numbers;	
	Double number,mediana;
	JTextField textField;
	JButton addButton, medianButton;
	JLabel resultLabel, numbersLabel;	
	JPanel actionPanel, resultPanel;
	
	public MedianFrame() throws HeadlessException {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(380,150);
		this.setLayout(new GridLayout(2,1));
		
		numbers = new ArrayList<Double>();
		
		actionPanel = new JPanel(new FlowLayout(380));
		this.add(actionPanel, BorderLayout.PAGE_START);
		actionPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		textField = new JTextField(7);
		actionPanel.add(textField);
		
		addButton = new JButton("Dodaj");
		actionPanel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				String listString;
				try{
				     number = Double.parseDouble(textField.getText());
				     numbers.add(number);
					 Collections.sort(numbers);			 
					 listString = numbers.stream().map(Object::toString)
							 			.collect(Collectors.joining(", "));
					 numbersLabel.setText("Zbiór liczb:" + listString);
				}
				catch(NumberFormatException exception){
				     System.out.println("Wrong number format.");
				}
				textField.setText("");
			}
		});
		
		
		medianButton = new JButton("Mediana");
		actionPanel.add(medianButton);
		medianButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int arrayLength = numbers.size();						
				if(arrayLength%2 != 0) {
					mediana = numbers.get((arrayLength)/2);
					resultLabel.setText("=" + mediana);
				} else {
					mediana = (numbers.get(arrayLength/2) + numbers.get((arrayLength-1)/2))/2;
					resultLabel.setText("=" + mediana);
				}
					
				
			}
		});
		
		resultLabel = new JLabel("=",10);
		actionPanel.add(resultLabel);
		
		resultPanel = new JPanel(new FlowLayout(380));
		this.add(resultPanel, BorderLayout.PAGE_END);
		resultPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		numbersLabel = new JLabel("Zbiór liczb: ");
		resultPanel.add(numbersLabel);		
		
	}


	public static void main(String[] args) {
		MedianFrame frame = new MedianFrame();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
