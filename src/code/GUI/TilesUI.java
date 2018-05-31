package code.GUI;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import code.Model.Model;
import code.Tiles.Tiles;

public class TilesUI {
	
	private Tiles _tiles;
	private JPanel _panel;
	private Model _model;
	private int x;
	private int y;
	static int colorCount=0;
	
	
	public TilesUI(Tiles t, Model m, int x, int y){
		_tiles = t;
		_model = m;
		this.x = x;
		this.y = y;
		this.drawTile();
	}
	
	
	public void drawTile(){
		
		Color bg = new Color(11,72,107);
		Color fg = new Color(59,134,134);
		Color ffg = new Color(121,189,154);
		Color yellow = new Color(255,165,0);
		Color red = new Color(205,51,51);
		Color blue = new Color(65,105,225);
		Color green = new Color(34,139,34);
		
		
		_panel = new JPanel();
		_panel.setFocusable(true);
		_panel.setLayout(new GridLayout(3,3));
		_panel.setPreferredSize(new Dimension(125,125));
		_panel.setBackground(Color.black);
		
		for(int i=0;i<3;i++){
			
			for(int z=0;z<3;z++){
				
				JButton _j = new JButton();
				_j.setOpaque(true);
				_j.setFocusable(false);
				_j.setPreferredSize(new Dimension(125,125));
				_j.setBackground(ffg);
				
				if(i==1 && z==1){
					_j.setBackground(bg);
				}
				
				if(x!=10 || y!=10){
					if(i==1 && z==1){
							if (_model.pawns[0].getPositionX()==x && _model.pawns[0].getPositionY()==y) {
								_j.setBackground(yellow);
							}
							else if(_model.pawns[1].getPositionX()==x && _model.pawns[1].getPositionY()==y){
								_j.setBackground(red);
							}
							else if(_model.pawns[2].getPositionX()==x && _model.pawns[2].getPositionY()==y){
								_j.setBackground(blue);
							}
							else if(_model.pawns[3].getPositionX()==x && _model.pawns[3].getPositionY()==y){
								_j.setBackground(green);
							}
						else{
							_j.setBackground(bg);

						}
						if(_model.getBoard()[x][y].checkToken() && _model.getBoard()[x][y].hasToken){
							String temp = ""+_model.getBoard()[x][y].getToken().getValue();
							_j.setBorder(null);
							_j.setText(temp);
							}
						}
					}
				
				if(_tiles._north){
					if(i==0 && z==1)_j.setBackground(fg);
				}
				if(_tiles._east){
					if(i==1 && z==2)_j.setBackground(fg);
				}
				if(_tiles._south){
					if(i==2 && z==1)_j.setBackground(fg);
				}
				if(_tiles._west){
					if(i==1 && z==0)_j.setBackground(fg);
				}
				_panel.add(_j);
				
				
			}
		}
		
		
		
	}
	
	public JPanel returnPanel(){
		return _panel;
	}
	
}
