import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author DARSH PATEL
 */
public class GamePanel extends JPanel implements ActionListener {
    
    static final int SCREEN_HIEGHT = 600;
    static final int SCREEN_WIDTH = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_HIEGHT*SCREEN_WIDTH)/UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 3;
    int applesEaten;
    int appleX;
    int appleY;
    JButton restartButton;
    Timer t;
    Random r;
    char direction = 'R';
    boolean running;
    
    GamePanel() {
        r = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HIEGHT));
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.addKeyListener(new MyKeyAdapter());
        for(int i = 0;i<GAME_UNITS;i++) {
            this.y[i] = SCREEN_WIDTH/2;
        }
        this.startGame();
        
        this.setLayout(null);
        restartButton = new JButton("Restart");
        restartButton.setFocusable(false);
        restartButton.setVisible(false); // Initially not visible
        restartButton.addActionListener(e -> restart());
        add(restartButton);
        restartButton.setBounds(SCREEN_WIDTH / 2 - 50, SCREEN_HIEGHT / 2 + 50, 100, 30);
    }
    
    public void startGame() {
        this.newApple();
        this.running = true;
        this.t = new Timer(DELAY,this);
        t.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }
    
    public void draw(Graphics g) {
        if(this.running) {
            // for developing purpose
//            for(int i = 0; i<SCREEN_HIEGHT/UNIT_SIZE; i++) {
//                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HIEGHT);
//                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
//            }
        
            // For Apple
            g.setColor(Color.red);
            g.fillOval(this.appleX, this.appleY, UNIT_SIZE, UNIT_SIZE);
        
            // For Snake
            for(int i = 0; i<this.bodyParts; i++) {
                if(i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(this.x[i], this.y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
//                    g.setColor(Color.green);
                    g.setColor(new Color(233,30,r.nextInt(255)));
                    g.fillRect(this.x[i], this.y[i], UNIT_SIZE, UNIT_SIZE);
                }   
            }
            
            // Display Score
            g.setColor(Color.white);
            g.setFont(new Font("Algerian",Font.BOLD,35));
            FontMetrics m = getFontMetrics(g.getFont());
            g.drawString("Score : "+this.applesEaten, (SCREEN_WIDTH-m.stringWidth("Score : "+this.applesEaten))/2, g.getFont().getSize());
        } else {
            this.gameOver(g);
        }
    }
    
    public void newApple() {
        this.appleX = r.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        this.appleY = r.nextInt((int)SCREEN_HIEGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    
    public void checkApples() {
        if((this.x[0] == this.appleX) && (this.y[0] == this.appleY)) {
            this.bodyParts++;
            this.applesEaten++;
            this.newApple();
        }
    }
    
    public void move() {
        for(int i = this.bodyParts; i>0; i--) {
            this.x[i] = this.x[i-1];
            this.y[i] = this.y[i-1];
        }
        
        switch(this.direction) {
            case 'U' -> this.y[0] -= UNIT_SIZE;
            case 'D' -> this.y[0] += UNIT_SIZE;
            case 'L' -> this.x[0] -= UNIT_SIZE;
            case 'R' -> this.x[0] += UNIT_SIZE;
        }
    }
    
    public void checkCollisions() {
        
        // When head touches body
        for(int i = this.bodyParts; i>0; i--) {
            if((this.x[0] == this.x[i]) && (this.y[0] == this.y[i])) {
                this.running = false;
            }
        }
        
        // when head touches up boundary
        if(this.y[0]<0) {
//            this.running = false;
            this.y[0] = SCREEN_HIEGHT;
        }
        
        // when head touches down boundary
        if(this.y[0]>SCREEN_HIEGHT) {
//            this.running = false;
            this.y[0] = 0;
        }
        
        // when head touches left boundary
        if(this.x[0]<0) {
//            this.running = false;
            this.x[0] = SCREEN_WIDTH;
        }
        
        // when head touches down boundary
        if(this.x[0]>SCREEN_WIDTH) {
//            this.running = false;
            this.x[0] = 0;
        }
        
        if(!this.running) {
            this.t.stop();
        }
    }
    
    public void gameOver(Graphics g) {
        // Game Over
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics m = getFontMetrics(g.getFont());
        g.drawString("Game Over!!", (SCREEN_WIDTH- m.stringWidth("Game Over!!"))/2, SCREEN_HIEGHT/2);

        // Display Score
        g.setColor(Color.white);
        g.setFont(new Font("Algerian",Font.BOLD,35));
        FontMetrics m1 = getFontMetrics(g.getFont());
        g.drawString("Score : "+this.applesEaten, (SCREEN_WIDTH-m1.stringWidth("Score : "+this.applesEaten))/2, g.getFont().getSize());
        
        restartButton.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.running) {
            this.move();
            this.checkApples();
            this.checkCollisions();
        }
        this.repaint();
    }

    public void restart() {
        // Reset game variables
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';
        running = true;

        // Reset snake position
        for (int i = 0; i < bodyParts; i++) {
            x[i] = SCREEN_WIDTH / 2;
            y[i] = SCREEN_HIEGHT / 2;
        }

        // Start a new game
        newApple();
        t.start();
        restartButton.setVisible(false); // Hide the restart button
        repaint();
    }
    
    class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_A -> {
                    if(direction != 'R') {
                        direction = 'L';
                    }
                }
                case KeyEvent.VK_D -> {
                    if(direction != 'L') {
                        direction = 'R';
                    }
                }
                case KeyEvent.VK_W -> {
                    if(direction != 'D') {
                        direction = 'U';
                    }
                }
                case KeyEvent.VK_S -> {
                    if(direction != 'U') {
                        direction = 'D';
                    }
                }
                case KeyEvent.VK_LEFT -> {
                    if(direction != 'R') {
                        direction = 'L';
                    }
                }
                case KeyEvent.VK_RIGHT -> {
                    if(direction != 'L') {
                        direction = 'R';
                    }
                }
                case KeyEvent.VK_UP -> {
                    if(direction != 'D') {
                        direction = 'U';
                    }
                }
                case KeyEvent.VK_DOWN -> {
                    if(direction != 'U') {
                        direction = 'D';
                    }
                }
            }
        }
    }
    
}
