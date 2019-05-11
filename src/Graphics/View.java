package Graphics;

import internal.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A fo megjelenites. Osszefogja, kezeli es megjeleniti a grafikai elemeket.
 */
public class View extends JFrame {
    /**
     * A fo panel, minden ezen jelenik meg.
     */
    private JPanel mainPanel = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            for(int i = 0; i < drawables.size(); i++){
            	Drawable drawable = drawables.get(i);
                drawable.draw(g);

            }
        }
    };
    private ArrayList<Drawable> drawables = new ArrayList<>();

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public View(){
        this.setVisible(true);
        this.setSize(1540,640);
        this.setTitle("PandaPlaza");
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                if(SwingUtilities.isLeftMouseButton(e)){
                    Game.getInstance().leftMouseButtonPressed(mouseX, mouseY);
                }
                else{
                    Game.getInstance().rightMouseButtonPressed(mouseX, mouseY);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.add(mainPanel);
    }

    /**
     * Elkeri a leveltol a benne szereplo objektumokat es mindenkitol elkeri az o grafikus megjelenitoet.
     * @param level A kapott  level.
     */
    public void update(Level level){
        ArrayList<Thing> things = level.getThings();
        ArrayList<Animal> animals = level.getAnimals();
        ArrayList<Field> fields = level.getFields();
        try {
            for (Field field : fields) {
                drawables.add(field.getDrawable());
            }
            for (Thing thing : things) {
                drawables.add(thing.getDrawable());
            }
            for (Animal animal : animals) {
                drawables.add(animal.getDrawable());
            }
            drawables.add(new ScoreView(0,0));
        }
        catch (IOException e){
            System.out.println("Image cannot be loaded!");
            e.printStackTrace();
        }
        mainPanel.repaint();
    }
}
