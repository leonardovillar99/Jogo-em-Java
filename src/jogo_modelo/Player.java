package jogo_modelo;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;



public class Player {
	
	private int px,py; // criando variáveis que serão responsáveis por armazenar as posições  x e y dos personagens;
	private int dx,dy; 
	private int mpx,mpy;
	private int sentido; // variável que vai receber o sentido/direção do personagem;
	private int score=0;
	private boolean start=false,jogo=true,G_over=false,G_win=false;
	private Image personagem; // criando uma váriavel do tipo "Image" que irá receber o icone do nosso personagem;
	private Image papel; // criando uma váriavel do tipo "Image" que irá receber o icone do lixo;
	private Image plastico; // criando uma váriavel do tipo "Image" que irá receber o icone do lixo;
	private Image banana; // criando uma váriavel do tipo "Image" que irá receber o icone do lixo;
	private Image sacoLixo;
	private Image parede;
	private Image portal;
	private Image pause;
	private Image game_over;
	private Image vitoria;
	private Image r1;
	private Image r2;
	private Image r3;
	private int width, height;
	
	int mp[][]={
			//0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18   19  20  21  22  23  24  25  26  27      
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  3, 18, 18, 18, 18, 18, 18, 18, 18, 18, 13, 18, 18, 18, 18},//0
	        {18, 18, 18,  0,  7,  0,  5,  0,  0,  0,  0,  0,  7,  5,  7,  0,  6,  0,  0,  5,  0,  0,  0,  7, 18, 18, 18, 18},//01
	        {18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//02
	        {18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//03
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//04
	        {18, 84,  6,  6, 18, 18, 18,  0,  6,  6,  7,  6,  0,  7,  0,  0,  6, 18, 18, 18, 18, 18, 18,  6,  0,  0, 10, 18},//05
	        {18,  0,  0,  0, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0,  0,  7, 77, 18},//06
	        {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//07
	        {18, 18, 18,  6, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18,  5, 18, 18, 18, 18},//08
	        {18, 18, 18,  0, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//09
	        {18, 18, 18,  6, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//10
	        {18, 18, 18,  0,  0,  0,  0,  0,  7,  0,  7,  0, 18, 18, 18, 18,  5, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//11
	        {18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//12
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//13
	        {18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//14
	        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//15
	        { 1,  0,  0,  7, 18, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18,  7,  0,  7,  0,  7,  0,  0,  5,  0,  6,  0,  2},//16
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//17
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  5, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//18
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//19
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//20
	        {11,  0,  5,  0,  6,  0,  6,  0,  6,  6,  0,  6, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  7,  0,  5,  0, 12},//21
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//22
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//23
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18},//24
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//25
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//26
	        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//27
	        {18, 77,  0,  7, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6,  0,  0, 85, 18},//28
	        {18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  8, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//29
	        {18, 18, 18,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  4,  9,  9,  9,  9,  9,  9,  9,  9,  9, 14,  9, 18, 18, 18}};//30

	
	public boolean getG_over() {
		return G_over;
	}
	public boolean getG_win() {
		return G_win;
	}
	
	public void setG_over(boolean g_over) {
		G_over = g_over;
	}
	public void setG_win(boolean g_win) {
		G_win = g_win;
	}
	public Image getPause() {
		return pause;
	}
	public Image getVitoria() {
		return vitoria;
	}
	public boolean getJogo() {
		return jogo;
	}
	public void setJogo(boolean game) {
		this.jogo = game;
	}
	public Image getBanana() {
		return banana;
	}
	public Image getGameOver() {
		return game_over;
	}
	public Image getR1() {
		return r1;
	}
	public Image getR2() {
		return r2;
	}
	public Image getR3() {
		return r3;
	}
	public Image getPapel() {
		return papel;
	}
	public Image getPlastico() {
		return plastico;
	}
	
	public Image getParede() {
		return parede;
	}
	
	public Image getPortal() {
		return portal;
	}
	public int getMpx() {
		return mpx;
	}

	public int getMpy() {
		return mpy;
	}
	
	public int getScore() {
		return score;
	}
	
	
	public void setScore(int score) {
		this.score = score;
	}
	public boolean getStart() {
		return start;
	}
	
	public void setStart(boolean start) {
		this.start=start;
	}
	
	
	public Image getPersonagem() {
		return personagem;
	}

	public int getPx() {
		return px;
	}

	public int getPy() {
		return py;
	}
	
	public Image getSacoLixo() {
		return sacoLixo;
	}
	
	// metodo construtor
	public Player(){	
		
		posicaoPlayer(); // chama o metodo de posicionar o jogador;	
	
	}
	
	public void posicaoPlayer() {
		
		personagem = vDown.getImage(); // personagem pegando a imagem do objeto "pInicial";
		height     = personagem.getHeight(null); // atribuindo altura para o personagem;
		width      = personagem.getWidth(null); // atribuindo largura para o personagem;
		// deifinindo a posição inicial do personagem no meio da tela;
		this.px = 1  * 27  + 9; // = 36 no eixo x;
		this.py = 28 * 20  + 9; // = 569 no eixo y;	
		
		// posição da matriz de acordo com a posição inicial do personagem na tela;
		this.mpx= (px - 9)/27; // = 1 na coluna
		this.mpy= (py - 9)/20; // = 28 na linha
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(px,py,width,height);
	}
	
	
	// Criando objetos que recebem as imagens de cada obejto do jogo;
	ImageIcon vLeft  	  =  new ImageIcon("res\\VassourinhaEsq.png");
	ImageIcon vRight   	  =  new ImageIcon("res\\VassourinhaDir.png");
	ImageIcon vUp    	  =  new ImageIcon("res\\VassourinhaCostas.png");
	ImageIcon vDown  	  =  new ImageIcon("res\\Vassourinha.png");
	ImageIcon bolaDePapel =  new ImageIcon("res\\PaperBall.png");
	ImageIcon garrafa	  =  new ImageIcon("res\\GarrafaPet.png");
	ImageIcon pontoS 	  =  new ImageIcon("res\\TrashBag.png");
	ImageIcon wall   	  =  new ImageIcon("res\\parede.png");
	ImageIcon portal1	  =  new ImageIcon("res\\portal.png");
	ImageIcon R1 		  =  new ImageIcon("res\\BlueR.png");
	ImageIcon R2 	 	  =  new ImageIcon("res\\RedR.png");
	ImageIcon R3 		  =  new ImageIcon("res\\GreenR.png");
	ImageIcon I_Banana	  =  new ImageIcon("res\\Banana.png");
	ImageIcon space 	  =  new ImageIcon("res\\pause.png");
	ImageIcon over 		  =  new ImageIcon("res\\game_over.png");
	ImageIcon win		  =  new ImageIcon("res\\vitoria.png");

	
	



	// metodo responsável gerar as imagens que serão carregadas na tela;
	public void load() { 
		
		papel      = bolaDePapel.getImage();
		height     = papel.getHeight(null);
		width      = papel.getWidth(null);
		
		game_over  = over.getImage();
		height     = game_over.getHeight(null);
		width      = game_over.getWidth(null);
			 
		vitoria    = win.getImage();
		height     = vitoria.getHeight(null);
		width      = vitoria.getWidth(null);
		
		plastico   = garrafa.getImage();
		height     = plastico.getHeight(null);
		width      = plastico.getWidth(null);
		
		sacoLixo   = pontoS.getImage();
		height	   = sacoLixo.getHeight(null);
		width      = sacoLixo.getWidth(null);
		
		parede     = wall.getImage();
		height     = parede.getHeight(null);
		width      = parede.getWidth(null);
		
		portal     = portal1.getImage();
		height     = portal.getHeight(null);
		width      = portal.getWidth(null);
		
		banana     = I_Banana.getImage();
		height     = banana.getHeight(null);
		width      = banana.getWidth(null);
		
		r1         = R1.getImage();
		height     = r1.getHeight(null);
		width      = r1.getWidth(null);
		
		r2         = R2.getImage();
		height     = r2.getHeight(null);
		width      = r2.getWidth(null);
		
		r3         = R3.getImage();
		height     = r3.getHeight(null);
		width      = r3.getWidth(null);
		
		pause      = space.getImage();
		height     = pause.getHeight(null);
		width      = pause.getWidth(null);
		
		
		personagem = vDown.getImage(); // personagem pegando a imagem do objeto "pInicial";
		height     = personagem.getHeight(null); // atribuindo altura para o personagem;
		width      = personagem.getWidth(null); // atribuindo largura para o personagem;
		

		
	}
	

	public void update() { // metodo responsável por atualizar a posição do personagem na tela;
		
		// variáveis de posição x e y, recebendo a direção x e y que o personagem está se movimentando de acorodo com o valor da variável "sentido";
		if(start) {
		switch(sentido) {
		case 0: // quando aperta o espaço
			
			dx=0; // zerando o valor da variável de eixo 'x', para que o personagem não se mova nos dois eixos ao mesmo tempo;
			dy=0; // atribuindo valor na variável de direção responsável pelo eixo 'y' (- = cima);
				
			
		break;
		case 8: // caso sentido seja "8" mover para cima
			if(mp[mpy][mpx] == 3){
				personagem = vUp.getImage(); // mudando a imagem da direção do personagem para cima;
				this.px = 13 * 	27 + 9; //mudando a posição do personagem no eixo x;
				this.py = 30  * 20 + 9; //mudando a posição do personagem no eixo y;		
				this.mpx= (px - 9)/27; //mudando a posição da matriz na "coluna";
				this.mpy= (py - 9)/20; //mudando a posição da matriz na "linha";
			
			}else if(mp[mpy][mpx] == 13){
				personagem = vUp.getImage(); // mudando a imagem da direção do personagem para cima;
				this.px = 23 * 27 + 9; //mudando a posição do personagem no eixo x;
				this.py = 30  * 20 + 9; //mudando a posição do personagem no eixo y;		
				this.mpx= (px - 9)/27; //mudando a posição da matriz na "coluna";
				this.mpy= (py - 9)/20; //mudando a posição da matriz na "linha";
			
			}else
			if(mp[mpy - 1][mpx] != 18) { // verificando se a posição seguinte da matriz na "linha-mpy" é diferente de 18 (parede), para o personagem se movimentar;
				
				personagem = vUp.getImage(); // mudando a imagem da direção do personagem para cima;
				width  = personagem.getWidth(null);
				height = personagem.getHeight(null);
				dx=0; // zerando o valor da variável de eixo 'x', para que o personagem não se mova nos dois eixos ao mesmo tempo;
				dy=-20; // atribuindo valor na variável de direção responsável pelo eixo 'y' (- = cima);
				mpy-=1; // movimentando a matriz 
				py = py + dy; // eixo y do personagem recebendo recebendo o valor de dx para "movimentar/mudar" a posição do personagem;

			}
			break;
		case 2: // caso sentido seja "2" mover para baixo
			if(mp[mpy][mpx] == 4){
				personagem = vDown.getImage(); // mudando a imagem da direção do personagem para baixo;
				this.px = 13 * 27 + 9; //mudando a posição do personagem no eixo x;
				this.py = 0  * 20 + 9; //mudando a posição do personagem no eixo y;		
				this.mpx= (px - 9)/27; //mudando a posição da matriz na "coluna";
				this.mpy= (py - 9)/20; //mudando a posição da matriz na "linha";
			
			}else  if(mp[mpy][mpx] == 14){
				personagem = vDown.getImage(); // mudando a imagem da direção do personagem para baixo;
				this.px = 23 * 27 + 9; //mudando a posição do personagem no eixo x;
				this.py = 0  * 20 + 9; //mudando a posição do personagem no eixo y;		
				this.mpx= (px - 9)/27; //mudando a posição da matriz na "coluna";
				this.mpy= (py - 9)/20; //mudando a posição da matriz na "linha";
			
			}else
			if(mp[mpy + 1][mpx] != 18) { // verificando se a posição seguinte da matriz na "linha-mpy" é diferente de 18 (parede), para o personagem se movimentar;
				
				personagem = vDown.getImage(); // mudando a imagem da direção do personagem para baixo;
				width  = personagem.getWidth(null);
				height = personagem.getHeight(null);	
				dx=0; // zerando o valor da variável de eixo 'x', para que o personagem não se mova nos dois eixos ao mesmo tempo;
				dy=+20; // atribuindo valor na variável de direção responsável pelo eixo 'y' (+ = baixo);
				mpy+=1;	// movimentando a matriz 
				
				py = py + dy; // eixo y do personagem recebendo recebendo o valor de dx para "movimentar/mudar" a posição do personagem;

			}
			break;
			
		case 6: // caso sentido seja "6" mover para direita
			if(mp[mpy][mpx] == 2){
				personagem = vRight.getImage(); // mudando a imagem da direção do personagem para direita;
				this.px = 0 * 27 + 9; //mudando a posição do personagem no eixo x;
				this.py = 16 * 20 + 9; //mudando a posição do personagem no eixo y;		
				this.mpx= (px - 9)/27; //mudando a posição da matriz na "coluna";
				this.mpy= (py - 9)/20; //mudando a posição da matriz na "linha";
			
			}else if(mp[mpy][mpx] == 12){
				personagem = vRight.getImage(); // mudando a imagem da direção do personagem para direita;
				this.px = 0 * 27 + 9; //mudando a posição do personagem no eixo x;
				this.py = 21 * 20 + 9; //mudando a posição do personagem no eixo y;		
				this.mpx= (px - 9)/27; //mudando a posição da matriz na "coluna";
				this.mpy= (py - 9)/20; //mudando a posição da matriz na "linha";
			
			}else
			if(mp[mpy][mpx + 1] != 18) { // // verificando se a posição seguinte da matriz na "coluna-mpx" é diferente de 18 (parede), para o personagem se movimentar;
				// verificando se o personagem entrou no portal da direita e posicionando ele no portal da esquerda; 
				
				personagem = vRight.getImage(); // mudando a imagem da direção do personagem para direita;
				width  = personagem.getWidth(null);
				height = personagem.getHeight(null);
				
				dy=0; // zerando o valor da variável de eixo 'y', para que o personagem não se mova nos dois eixos ao mesmo tempo;
				dx=+27; // atribuindo valor na variável de direção responsável pelo eixo 'x' (+ = direita);
				mpx+=1;	// movimentando a matriz 
				
				px = px + dx; // eixo x do personagem recebendo recebendo o valor de dx para "movimentar/mudar" a posição do personagem;

			}
			break;
			
		case 4: // caso sentido seja "4" mover para esquerda
			if(mp[mpy][mpx] == 1){ 
				personagem = vLeft.getImage(); // mudando a imagem da direção do personagem para esquerda;
				this.px = 27 * 27 + 9; //mudando a posição do personagem no eixo x;
				this.py = 16 * 20 + 9; //mudando a posição do personagem no eixo y;	
				this.mpx= (px - 9)/27; //mudando a posição da matriz na "coluna";
				this.mpy= (py - 9)/20; //mudando a posição da matriz na "linha";
				
			}else if(mp[mpy][mpx] == 11){ 
				personagem = vLeft.getImage(); // mudando a imagem da direção do personagem para esquerda;
				this.px = 27 * 27 + 9; //mudando a posição do personagem no eixo x;
				this.py = 21 * 20 + 9; //mudando a posição do personagem no eixo y;	
				this.mpx= (px - 9)/27; //mudando a posição da matriz na "coluna";
				this.mpy= (py - 9)/20; //mudando a posição da matriz na "linha";
				
			}else
			
			if(mp[mpy][mpx -1] != 18) { // verificando se a posição seguinte da matriz na "coluna-mpx" é diferente de 18 (parede), para o personagem se movimentar;
				// verificando se o personagem entrou no portal da esquerda e posicionando ele no portal da direita;
				
				personagem = vLeft.getImage(); // mudando a imagem da direção do personagem para esquerda;
				width  = personagem.getWidth(null);
				height = personagem.getHeight(null);
				
				dy=0; // zerando o valor da variável de eixo 'y', para que o personagem não se mova nos dois eixos ao mesmo tempo;
				dx=-27; // atribuindo valor na variável de direção responsável pelo eixo 'x' ( - = esqueda);
				mpx-=1;	// movimentando a matriz
				px = px + dx; // eixo x do personagem recebendo recebendo o valor de dx para "movimentar/mudar" a posição do personagem;					

			}
		default:
			break;
		}
	}
		
		
	}
	
	public void interacao() { // score + mudando valor na matriz
		
		if(start) {
			switch(mp[getMpy()][getMpx()]) {
				case 0: // papel 2 + pontos
					this.score = score + 2;
					mp[getMpy()][getMpx()] = 8; // muda o numero na matriz, para se possivel identificar qual era o numero anterior (8=0; 80=5; 81=6; 82=7; 83=10; 84=20; 85=30);
				break;
				case 5: // saco de lixo + 5 pontos
					this.score= score + 6;
					mp[getMpy()][getMpx()] = 80; 
				break;
				case 6: // garrafa pet + 3 pontos
					this.score=score + 3;
					mp[getMpy()][getMpx()] = 81;
				break;
				case 7: // casca de banana + 1 ponto
					this.score++;
					mp[getMpy()][getMpx()] = 82; 
				break;
				case 10:
					mp[getMpy()][getMpx()] = 83;
					mp[5][1]=20;
				break;
				case 20:
					mp[getMpy()][getMpx()] = 84;
					mp[28][26]=30;
				break;
				case 30:
					mp[getMpy()][getMpx()] = 85;
			default:
				break;
			}
	
		}
		
	}

	// método responsálve por atribuir os valore iniciais da matriz e o score;
	public void reiniciarFase() { 
		
		for(int i = 0; i < 28; i++) { 
			for(int j = 0; j < 31; j++) {
				switch(mp[j][i]) {
					case 8:
						mp[j][i]=0;
						break;
					case 80:
						mp[j][i]=5;
						break;
					case 81:
						mp[j][i]=6;
						break;
					case 82:
						mp[j][i]=7;
						break;
					case 83:
						mp[j][i]=10;
						break;
					default:
						break;
				}
			}
		}
		
		this.score = 0;
		this.start = false;
		posicaoPlayer();
		
	}
	
	

	public void keyPressed(KeyEvent e) { // método que identifica um "evento" de entrada do teclado, no caso do "keyPressed" ele informa qual tecla o usuário esta pressionando;
		
		int cod = e.getKeyCode(); // variável responsável por receber o código da tecla pressionada pelo usuário;
		
		if(jogo) { // só executa o evento de teclar espaço, quando o jogo for true;
			if(cod == KeyEvent.VK_SPACE) {
				sentido=0;
				if(start) {	
					this.start = false;
				}else
					this.start = true;
			}
		}	
		
		if(start == true && cod == KeyEvent.VK_UP && mp[mpy][mpx] != 18) { // verificando se o códgio da tecla pressionada é o evente da "seta para cima" e se posição da matriz é diferente de 18 (parede);
			
			
			sentido = 8; // cima
			
			
		}
		
		if(start == true && cod == KeyEvent.VK_DOWN && mp[mpy][mpx] != 18) { // verificando se o códgio da tecla pressionada é o evente da "seta para baixo" e se posição da matriz é diferente de 18 (parede);;
			
			if(mp[mpy][mpx] == 9) {
				sentido = 0;
			}else
			sentido = 2; // baixo

	
		}
		
		if(start == true && cod == KeyEvent.VK_RIGHT && mp[mpy][mpx] != 18) { // verificando se o códgio da tecla pressionada é o evente da "seta para direita" e se posição da matriz é diferente de 18 (parede);;
		
			sentido = 6; // direita
		
		}
		
		if(start == true && cod == KeyEvent.VK_LEFT && mp[mpy][mpx] != 18) { // verificando se o códgio da tecla pressionada é o evente da "seta para esquerda" e se posição da matriz é diferente de 18 (parede);;
			
			sentido = 4; // esquerda
			
		}
		
		if(jogo == false  && cod == KeyEvent.VK_ENTER) { // se jogo for false quer dizer que o player ganhou ou que ele perdeu o jogo; 
				
			// quando aperta "ENTER" as variáveis que indicam se o usuário perdeu ou não o jogo recebem false e o jogo recebe true, dessa maneira o jogo "recomeça"
			G_win=false;
			G_over=false;
			jogo=true;
		}
	}

	// Evento para quando o usuário soltar a tecla o personagem parar de andar, sem esse metodo o personagem fica em constante movimento;
	public void keyRelesed(KeyEvent e) { 
		
		int cod = e.getKeyCode();
		
		// quando o usuário soltar qualquer uma dessas teclas, o boneco ficará parado pois não tera movimentação no eixo x e nem no y;
		if(cod == KeyEvent.VK_UP) {
			sentido = 0;
			dy=0;		
		}
		if(cod == KeyEvent.VK_DOWN) {
			sentido = 0;
			dy=0;	
		}
		if(cod == KeyEvent.VK_RIGHT) {
			sentido = 0;
			dx=0;			
		}
		if(cod == KeyEvent.VK_LEFT) {
			sentido = 0;
			dx=0;
			
			
		}
		
		
	}


	
	

	
	
}


