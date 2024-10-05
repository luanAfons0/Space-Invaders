import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VersaoProf extends JFrame {
    public class Alienigena {
        private int x,y;
        private int largura = 40, altura = 20;
        private int velocidade = 2;

        public Alienigena(int inicioX, int inicioY){
            this.x = inicioX;
            this.y = inicioY;
        }

        public void mover(){
            x += velocidade;
            if(x <= 0 || x+largura >= 800){
                velocidade = -velocidade;
                y += altura;
            }
        }

        public void desenhar(Graphics g){
            g.setColor(Color.GREEN);
            g.fillRect(x, y, largura, altura);
        }

        public Rectangle getLimites(){
            return new Rectangle(x,y,largura,altura);
        }
    }

    public class Projetil{
        private int x,y;
        private int largura=50, altura=10;
        private int velocidade = 5;

        public Projetil(int inicioX, int inicioY){
            this.x = inicioX;
            this.y = inicioY;
        }

        public void mover(){
            y -= velocidade;
        }

        public void desenhar(Graphics g){
            g.setColor(Color.RED);
            g.fillRect(x, y, largura, altura);
        }

        public boolean foraDaTela(){
            return y + altura < 0;
        }

        public Rectangle getLimites(){
            return new Rectangle(x,y,largura,altura);
        }
    }

    public class Jogador {
        private int x,y;
        private int largura=50, altura=20;
        private int velocidade = 5;

        public Jogador(int inicioX, int inicioY){
            this.x = inicioX;
            this.y = inicioY;
        }

        public void moverEsquerda(){
            this.x -= this.velocidade;
            if(x< 0) x = 0;
        }

        public void moverDireita(int larguraDaTela){
            this.x += velocidade;
            if(x + largura > larguraDaTela) x = larguraDaTela - largura;
        }

        public void desenhar(Graphics g){
            g.setColor(Color.BLUE);
            g.fillRect(x, y, largura, altura);
        }

        public Rectangle getLimite(){
            return new Rectangle(x,y,largura,altura);
        }
    
        public int getX(){
            return x;
        }
    
        public int getY(){
            return y;
        }
    }

    public class PainelDoJogo extends JPanel implements Runnable{
        private boolean rodando = false;
        private Thread threadDoJogo;
    
        public PainelDoJogo(){
            iniciar();
        }
    
        public synchronized void iniciar(){
            this.rodando = true;
            threadDoJogo = new Thread(this);
            threadDoJogo.start();
        }
    
        @Override
        public void run(){
            while (this.rodando) {
                atualizar();
                repaint();
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void atualizar(){
            // Atualiza os objetos do jogo(nave, alienigenas, projeteis)
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            // Desenha a nave, alienigenas e projeteis aqui
        }
    }

    public VersaoProf(){
        this.setTitle("Invasão de aliens!");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.add(new GamePanel());
        this.setVisible(true);
    }

    public static void main(String[] args){
        new VersaoProf();
    }
}