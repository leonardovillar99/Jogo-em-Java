package jogo_modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo {
	
	private int mmx,mmy,mgx,mgy; // posição dos inimigos na matriz;
	private int mmx2,mmy2,mgx2,mgy2; // posição dos inimigos na matriz;
	private int gx,gy; // eixo x e y do garbodor;
	private int mx,my; // eixo x e y do muk;
	private int gx2,gy2; // eixo x e y do garbodor;
	private int mx2,my2; // eixo x e y do muk;
	private int veloMx,veloMy,veloGx,veloGy; // variavel que incrementa no eixo x e y do muk;
	private boolean subir=false,descer=true,esquerda=false,direita=true,subir2=false,descer2=true,esquerda2=false,direita2=true;
	private int contG,contM,contG2,contM2; // variavel que incrementa no eixo x e y do muk;
	private Image ini_muk;
	private Image ini_garb;
	private Image ini_muk2;
	private Image ini_garb2;
	private int width, height;
	
	int mp[][]={
			//0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18   19  20  21  22  23  24  25  26  27      
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  4, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//0
	        {18, 18, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18, 18, 18, 18},//01
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//02
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//03
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//04
	        {18,  0,  0,  0, 18, 18, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18, 18, 18, 18, 18, 18,  0,  0,  0,  0, 18},//05
	        {18,  0,  0,  0, 18, 18, 18,  0,  8,  8,  8,  8,  8,  8,  8,  8,  0, 18, 18, 18, 18, 18, 18,  0,  0,  0,  0, 18},//06
	        {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//07
	        {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//08
	        {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//09
	        {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//10
	        {18, 18, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//11
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//12
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//13
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//14
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//15
	        { 1,  0,  0,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2},//16
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//17
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//18
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//19
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//20
	        {18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0,  0,  0,  0, 18},//21
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//22
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//23
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//24
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//25
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//26
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//27
	        {18,  8,  8,  8,  8, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0,  0,  0,  0, 18},//28
	        {18, 18, 18, 18,  8, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  8, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//29
	        {18, 18, 18, 18,  9,  9,  9,  9,  9,  9,  9, 18,  9,  9,  9,  9, 18,  9,  9,  9,  9,  9,  9, 18,  9, 18, 18, 18}};//30

	
	public int getGx() {
		return gx;
	}
	public int getGy() {
		return gy;
	}
	public int getMx() {
		return mx;
	}
	public int getMy() {
		return my;
	}
	public int getMmx() {
		return mmx;
	}
	public int getMmy() {
		return mmy;
	}
	public int getMgx() {
		return mgx;
	}
	public int getMgy() {
		return mgy;
	}
	public Image getGarbodor() {
		return ini_garb;
	}
	
	public Image getMuk() {
		return ini_muk;
	}
	public int getGx2() {
		return gx2;
	}
	public int getGy2() {
		return gy2;
	}
	public int getMx2() {
		return mx2;
	}
	public int getMy2() {
		return my2;
	}
	public int getMmx2() {
		return mmx2;
	}
	public int getMmy2() {
		return mmy2;
	}
	public int getMgx2() {
		return mgx2;
	}
	public int getMgy2() {
		return mgy2;
	}
	public Image getGarbodor2() {
		return ini_garb2;
	}
	
	public Image getMuk2() {
		return ini_muk2;
	}
	
	
	// metodo construtor 
	
	public Inimigo() {
		
		posicaoInimigo();
		
	}
	
	
	public void posicaoInimigo() {
		
		this.mx = 3  * 27  + 9; 
		this.my = 1  * 20  + 9; 	
		
		this.gx = 16 * 27  + 9; 
		this.gy = 29 * 20  + 9; 	
		
		this.mmx = (mx - 9)/27; // coluna
		this.mmy = (my - 9)/20; // linha
		
		this.mgx = (gx - 9)/27; // coluna
		this.mgy = (gy - 9)/20; // linha
		 
		// posição dos outors inimigos
		this.gx2 = 11  * 27  + 9; 
		this.gy2 = 29  * 20  + 9; 	
		
		this.mx2 = 23 * 27  + 9; 
		this.my2 = 1  * 20  + 9; 	
		
		this.mmx2 = (mx2 - 9)/27; // coluna
		this.mmy2 = (my2 - 9)/20; // linha
		
		this.mgx2 = (gx2 - 9)/27; // coluna
		this.mgy2 = (gy2 - 9)/20; // linha
		
	}
	
	
	public void load() {
		
	ImageIcon muk  =  new ImageIcon("res\\GrimerMuk_Maior.png");
	ImageIcon garb =  new ImageIcon("res\\Garbodor_Maior.png");
	
	ini_muk    = muk.getImage();
	height     = ini_muk.getHeight(null);
	width      = ini_muk.getWidth(null);
	
	ini_garb   = garb.getImage();
	height     = ini_garb.getHeight(null);
	width      = ini_garb.getWidth(null);
	
	ini_muk2    = muk.getImage();
	height     = ini_muk2.getHeight(null);
	width      = ini_muk2.getWidth(null);
	
	ini_garb2   = garb.getImage();
	height     = ini_garb2.getHeight(null);
	width      = ini_garb2.getWidth(null);
	
	
	}
	
	// criando metodos que retornam um retangulo com as posições x e y e altura/largura de cada inimigo;
	public Rectangle getBoundsGarb() {
		
		return new Rectangle(gx,gy,width,height);
	}
	
	public Rectangle getBoundsMuk() {
		
		return new Rectangle(mx,my,width,height);
	}
	
	public Rectangle getBoundsGarb2() {
		
		return new Rectangle(gx2,gy2,width,height);
	}
	
	public Rectangle getBoundsMuk2() {
		
		return new Rectangle(mx2,my2,width,height);
	}
	
	public void update() { // classe responsável por chamar todos os metodos de movimentação do inimigo
		
		descerInimigo();
		subirInimigo();
		esquerdaInimigo();
		direitaInimigo();
		descerInimigo2();
		subirInimigo2();
		esquerdaInimigo2();
		direitaInimigo2();

	}
	
	public void descerInimigo() {
	
			if(mp[mgy + 1][mgx] != 18 && descer == true) {
		
				veloGy=2; //"velocidade" do inimigo em pixels;
				veloGx=0;
				
				//this.mx=mx+ix;
				this.gx=gx+veloGx;

				//this.my= my+iy;
				this.gy= gy+veloGy;
	
				
				contG=contG+veloGy;
				
				if(contG==20) {
					mgy+=1;
					contG=0;
				}
			}else {

				descer = false;
				subir  = true;
			}
				
		
		
	}
	
	public void descerInimigo2() {
		
		if(mp[mgy2 + 1][mgx2] != 18 && descer2 == true) {
	
			veloGy=2; //"velocidade" do inimigo em pixels;
			veloGx=0;
			
			//this.mx=mx+ix;
			this.gx2=gx2+veloGx;
			//this.my= my+iy;
			this.gy2=gy2+veloGy;
			
			contG2=contG2+veloGy;
			
			if(contG2==20) {
				mgy2+=1;
				contG2=0;
			}
		}else {

			descer2 = false;
			subir2  = true;
		}
			
	
	
}
	
	
	public void subirInimigo(){
		
			if(mp[mgy - 1][mgx] != 18 && subir == true) {

				veloGy=2; // "velocidade" do inimigo em pixels;
				veloGx=0;
				
				//this.mx=mx+ix;
				this.gx=gx-veloGx;
				//this.my= my+iy;
				this.gy= gy-veloGy;
				
				contG=contG+veloGy; // cont recebe o valor da velocidade do perosnagem até cehgar em "20", que corresponde a +1 da posilção na matriz;
				
				if(contG==20) { // quando cont for igual a 20, quer dizer que ele andou uma casa na matriz;
					
					mgy-=1;
					contG=0;
				}
			
			}else {
				descer = true;
				subir  = false;
			}
				
		}
	
	public void subirInimigo2(){
		
		if(mp[mgy2 - 1][mgx2] != 18 && subir2 == true) {

			veloGy=2; // "velocidade" do inimigo em pixels;
			veloGx=0;
			
			//this.mx=mx+ix;
			this.gx2=gx2-veloGx;
			//this.my= my+iy;
			this.gy2=gy2-veloGy;
			
			contG2=contG2+veloGy; // cont recebe o valor da velocidade do perosnagem até cehgar em "20", que corresponde a +1 da posilção na matriz;
			
			if(contG2==20) { // quando cont for igual a 20, quer dizer que ele andou uma casa na matriz;
				
				mgy2-=1;
				contG2=0;
			}
		
		}else {
			descer2 = true;
			subir2  = false;
		}
			
	}
	
	public void direitaInimigo() {
	
			if(mp[mmy][mmx + 1] != 18 && direita == true) {
		
				veloMy=0; 
				veloMx=1; // "velocidade" do inimigo em pixels;
				
				this.mx=mx+veloMx;
				//this.gx=gx+ix;
				
				this.my=my+veloMy;
				//this.gy= gy+iy;
				
				contM=contM+veloMx;
				
				if(contM==27) {
					
					mmx+=1;
					contM=0;
				}
			}else {

				direita  = false;
				esquerda = true;
			}
				
		
		
	}
	
	public void direitaInimigo2() {
		
		if(mp[mmy2][mmx2 + 1] != 18 && direita2 == true) {
	
			veloMy=0; 
			veloMx=1; // "velocidade" do inimigo em pixels;
			
			this.mx2=mx2+veloMx;
			//this.gx=gx+ix;
			
			this.my2=my2+veloMy;
			//this.gy= gy+iy;
			
			contM2=contM2+veloMx;
			
			if(contM2==27) {
				
				mmx2+=1;
				contM2=0;
			}
		}else {

			direita2  = false;
			esquerda2 = true;
		}
			
	
	
}
	
	
	public void esquerdaInimigo(){
		
			if(mp[mmy][mmx - 1] != 18 && esquerda == true) {
			 
				veloMy=0; 
				veloMx=1; // "velocidade" do inimigo em pixels;
				
				this.mx=mx-veloMx;
				//this.gx=gx-ix;
				
				this.my= my-veloMy;
				//this.gy= gy-iy;
				
				contM=contM+veloMx; // cont recebe o valor da velocidade do perosnagem até cehgar em "20", que corresponde a +1 da posilção na matriz;
				
				if(contM==27) { // quando cont for igual a 20, quer dizer que ele andou uma casa na matriz;
					
					mmx-=1;
					contM=0;
				}
			
			}else {
				direita  = true;
				esquerda = false;
			}
				
		}
	
	public void esquerdaInimigo2(){
		
		if(mp[mmy2][mmx2 - 1] != 18 && esquerda2 == true) {
		 
			veloMy=0; 
			veloMx=1; // "velocidade" do inimigo em pixels;
			
			this.mx2=mx2-veloMx;
			//this.gx=gx-ix;
			
			this.my2=my2-veloMy;
			//this.gy= gy-iy;
			
			contM2=contM2+veloMx; // cont recebe o valor da velocidade do perosnagem até cehgar em "20", que corresponde a +1 da posilção na matriz;
			
			if(contM2==27) { // quando cont for igual a 20, quer dizer que ele andou uma casa na matriz;
				
				mmx2-=1;
				contM2=0;
			}
		
		}else {
			direita2  = true;
			esquerda2 = false;
		}
			
	}
	
		
	
}
