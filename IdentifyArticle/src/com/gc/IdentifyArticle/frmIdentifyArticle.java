package com.gc.IdentifyArticle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class frmIdentifyArticle extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JTextField textField;
	private JLabel label_1;
    private static frmIdentifyArticle frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new frmIdentifyArticle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private IIdentifyArticle GetIdentifie(int index)
	{
		if(index==1)
		{
			return new StringTokenizerEnglishSentence();
		}
		
		return new SplitEnglishSentence();
	}

	/**
	 * Create the frame.
	 */
	public frmIdentifyArticle() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u82F1\u6587\u5185\u5BB9\uFF1A");
		lblNewLabel.setBounds(14, 13, 105, 18);
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(120, 11, 468, 119);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("\u9009\u62E9\u8BC6\u522B\u65B9\u6CD5\uFF1A");
		label.setBounds(14, 146, 105, 18);
		contentPane.add(label);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Split\u65B9\u5F0F", "StringTokenizer\u65B9\u5F0F"}));
		comboBox.setBounds(120, 143, 327, 24);
		contentPane.add(comboBox);
		
		btnNewButton = new JButton("\u5206    \u6790");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				IIdentifyArticle identifier=GetIdentifie(comboBox.getSelectedIndex());
				String[] result=identifier.IdentifyArticle(textArea.getText());
				
				if(result.length==0)
				{
					textField.setText("输入的句子中没有英文冠词");
				}
				else
				{
					StringBuilder sb=new StringBuilder();
					sb.append("输入的句子中包含的冠词有：");
					for(int i=0;i<result.length;i++)
					{
						sb.append(result[i]);
						if(i!=result.length-1)
						{
							sb.append("、");
						}
					}
					
					textField.setText(sb.toString());
				}
			}
		});
		btnNewButton.setBounds(461, 143, 127, 27);
		contentPane.add(btnNewButton);
		
		label_1 = new JLabel("\u7ED3       \u679C\uFF1A");
		label_1.setBounds(14, 186, 105, 18);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(119, 180, 328, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u9000    \u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		button.setBounds(461, 177, 127, 27);
		contentPane.add(button);
	}
}
