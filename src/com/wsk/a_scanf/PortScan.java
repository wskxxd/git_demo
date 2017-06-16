package com.wsk.a_scanf;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
public class PortScan extends JFrame {
    JPanel center=new JPanel();
    Box hBox0=Box.createHorizontalBox();
     Box hBox1= Box.createHorizontalBox();
     Box hBox2= Box.createHorizontalBox();
     Box hBox3= Box.createHorizontalBox();
    private JLabel state=new JLabel("�ر�");
    private JLabel HOST=new JLabel("������:");
    private JLabel PORT=new JLabel("�˿ں�:");
    private JLabel STATE=new JLabel("״̬��");
    private JButton btn1=new JButton("��ʼɨ��");
    private JButton reset=new JButton("����");
    private JTextField host=new JTextField(20);
    private JTextField port=new JTextField(7);
    Font f1=new Font("����",Font.PLAIN,15);
    public static void main(String[] args) {
        JFrame portscan=new PortScan();
        portscan.setVisible(true);
    }
    
    public PortScan(){
        setTitle("PortScanner");
        setSize(300, 200);
        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
         Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();//��ȡ��Ļ�ֱ���
          setLocation(screenSize.width/4,screenSize.height/4);//λ��
          state.setFont(f1);
          HOST.setFont(f1);
          PORT.setFont(f1);
          btn1.setFont(f1);
          reset.setFont(f1);
          STATE.setFont(f1);
         center.add(hBox0);
         center.add(Box.createRigidArea(new Dimension(10,20)));
         center.add(hBox1);
         center.add(Box.createRigidArea(new Dimension(2,20)));
         center.add(hBox2);
         center.add(Box.createRigidArea(new Dimension(2,20)));
         center.add(hBox3);
         hBox0.add(HOST);
         hBox0.add(host);
         hBox1.add(PORT);
         hBox1.add(port);
         hBox2.add(btn1);
         hBox2.add(reset);
         hBox3.add(STATE);
         hBox3.add(state);
         add(center);
         btn1.addActionListener(new MyActionListener());
         reset.addActionListener(new MyActionListener());
    }
    class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String post1=host.getText();
            int port1=Integer.parseInt(port.getText());
            if(e.getActionCommand()=="��ʼɨ��"){
            if(PortScannerByIP.scan(post1, port1)){
                state.setText("����");
            }else{
                state.setText("�ر�");
            }
                
            }
            if(e.getActionCommand()=="����"){
                host.setText("");
                port.setText("");
            }
        }
        
        
    }
}